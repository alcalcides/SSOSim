package ssosim.domain.model.scheduler;

import java.util.ArrayList;

import lombok.extern.slf4j.Slf4j;
import ssosim.domain.model.metaData.Journal;
import ssosim.domain.model.processManagement.OSProcess;
import ssosim.domain.model.processManagement.ProcessManager;
import ssosim.domain.model.processManagement.ReadyQueue;

@Slf4j
public class SchedulerRoundRobin extends PreemptiveScheduler {
	private int time;
	private ReadyQueue ready;

	public SchedulerRoundRobin(int quantum) {
		super(quantum);
		ready = new ReadyQueue();
	}

	@Override
	public void run(ArrayList<OSProcess> processes, Journal journal) {
		log.info(">> SchedulerRR running");
		time = 0;
		Integer quantum = super.quantum;
		ready.enqueueArrivedProcesses(processes, time);

		while (ProcessManager.isNotAllFineshed(processes)) {
			if (ready.isEmpty()) {
				log.info(">>> [" + time + "] idle");
				journal.cpuReport("idle");

				time++;
				ready.enqueueArrivedProcesses(processes, time);
			} else {
				OSProcess process = ready.getNextProcess(processes);
				Integer timeSlice = 0;

				while (process.isNotFineshed() && timeSlice < quantum) {
					log.info(">>> [" + time + "] runing " + process.getId());
					process.run(time);
					journal.cpuReport(process.getId());
					timeSlice++;
					log.info(">> timeSlice = " + String.valueOf(timeSlice));

					time++;
					ready.enqueueArrivedProcesses(processes, time);

					if (timeSlice == quantum && process.isNotFineshed()) {
						log.info(">> process is coming back to ready queue");
						ready.enqueue(process);
					}

				}
			}
		}
	}

}