package ssosim.domain.model.scheduler;

import java.util.ArrayList;

import lombok.extern.slf4j.Slf4j;
import ssosim.domain.model.metaData.Journal;
import ssosim.domain.model.processManagement.OSProcess;
import ssosim.domain.model.processManagement.ProcessManager;
import ssosim.domain.model.processManagement.ReadyProcessQueue;

@Slf4j
public class SchedulerSJF implements Scheduler {
	private ReadyProcessQueue readyProcessesQueue;
	private int time;

	@Override
	public void run(ArrayList<OSProcess> processes, Journal journal) {
		log.info(">> SchedulerSJF running");
		time = 0;

		while (ProcessManager.isNotAllFineshed(processes)) {
			readyProcessesQueue = new ReadyProcessQueue(processes, time);
			if (readyProcessesQueue.isEmpty()) {
				log.info(">>> [" + time + "] idle");
				journal.cpuReport("idle");
				time++;
			} else {
				readyProcessesQueue.sortByExecutionTime();
				OSProcess process = readyProcessesQueue.getNext();
				while (!process.isFineshed()) {
					log.info(">>> [" + time + "] runing " + process.getId());
					process.run(time);
					journal.cpuReport(process.getId());
					time++;
				}
			}

		}
	}

}