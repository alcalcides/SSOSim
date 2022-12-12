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

	public SchedulerRoundRobin(int quantum) {
		super(quantum);
	}

	@Override
	public void run(ArrayList<OSProcess> processes, Journal journal) {
		log.info(">> SchedulerRR running");
		time = 0;
		Integer quantum = super.quantum;

		Deque<String> ready = new ArrayDeque<>();
		processes.stream()
			.filter(p -> p.getArriveTime() == 0)
			.forEach(p -> ready.add(p.getId()));

		while (ProcessManager.isNotAllFineshed(processes)) {
			if (ready.isEmpty()) {
				log.info(">>> [" + time + "] idle");
				journal.cpuReport("idle");
				
				time++;
				processes.stream().filter(p -> p.getArriveTime() == time).forEach(p -> {
					ready.add(p.getId());
				});
			} else {
				String nextProcessID = ready.poll();
				OSProcess process = processes.stream()
						.filter(p -> p.getId() == nextProcessID)
						.collect(Collectors.toList())
						.get(0);

				Integer timeSlice = 0;
				while (process.isNotFineshed() && timeSlice < quantum) {
					log.info(">>> [" + time + "] runing " + process.getId());
					process.run(time);
					journal.cpuReport(process.getId());
					timeSlice++;
					log.info(">> timeSlice = " + String.valueOf(timeSlice));

					time++;
					processes.stream()
						.filter(p -> p.getArriveTime() == time)
						.forEach(p -> {
							ready.add(p.getId());
						});

					if (timeSlice == quantum && process.isNotFineshed()) {
						log.info(">> process is coming back to ready queue");
						ready.addLast(process.getId());
					}

				}
			}
		}
	}

}