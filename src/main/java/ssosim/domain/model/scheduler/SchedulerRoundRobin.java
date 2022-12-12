package ssosim.domain.model.scheduler;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import ssosim.domain.model.metaData.Journal;
import ssosim.domain.model.processManagement.OSProcess;
import ssosim.domain.model.processManagement.ProcessManager;

@Slf4j
public class SchedulerRoundRobin extends PreemptiveScheduler {
	private int time;
	private Deque<String> ready;

	public SchedulerRoundRobin(int quantum) {
		super(quantum);
		ready = new ArrayDeque<>();
	}

	@Override
	public void run(ArrayList<OSProcess> processes, Journal journal) {
		log.info(">> SchedulerRR running");
		time = 0;
		Integer quantum = super.quantum;
		loadFromArrived(processes, time);

		while (ProcessManager.isNotAllFineshed(processes)) {
			if (ready.isEmpty()) {
				log.info(">>> [" + time + "] idle");
				journal.cpuReport("idle");

				time++;
				loadFromArrived(processes, time);
			} else {
				OSProcess process = getNextProcess(processes);
				Integer timeSlice = 0;

				while (process.isNotFineshed() && timeSlice < quantum) {
					log.info(">>> [" + time + "] runing " + process.getId());
					process.run(time);
					journal.cpuReport(process.getId());
					timeSlice++;
					log.info(">> timeSlice = " + String.valueOf(timeSlice));

					time++;
					loadFromArrived(processes, time);

					if (timeSlice == quantum && process.isNotFineshed()) {
						log.info(">> process is coming back to ready queue");
						enqueue(process);
					}

				}
			}
		}
	}

	private OSProcess getNextProcess(ArrayList<OSProcess> processes) {
		String nextProcessID = dequeue();
		OSProcess process = processes.stream()
				.filter(p -> p.getId() == nextProcessID)
				.collect(Collectors.toList())
				.get(0);
		return process;
	}

	private void enqueue(OSProcess process) {
		ready.addLast(process.getId());
	}

	private String dequeue() {
		return ready.poll();
	}

	private void loadFromArrived(ArrayList<OSProcess> processes, int time) {
		processes.stream()
			.filter(p -> p.getArriveTime() == time)
			.forEach(p ->
				ready.add(p.getId()
			));
	}

}