package ssosim.domain.model.scheduler;

import java.util.ArrayList;

import lombok.extern.slf4j.Slf4j;
import ssosim.domain.model.metaData.Journal;
import ssosim.domain.model.processManagement.OSProcess;
import ssosim.domain.model.processManagement.ProcessManager;
import ssosim.domain.model.processManagement.ReadyProcessList;

@Slf4j
public class SchedulerSJF implements Scheduler {
	private ReadyProcessList readyProcessesList;
	private int time;

	@Override
	public void run(ArrayList<OSProcess> processes, Journal journal) {
		log.info(">> SchedulerSJF running");
		time = 0;

		while (ProcessManager.isNotAllFineshed(processes)) {
			readyProcessesList = new ReadyProcessList(processes, time);
			if (readyProcessesList.isEmpty()) {
				log.info(">>> [" + time + "] idle");
				journal.cpuReport("idle");
				time++;
			} else {
				readyProcessesList.sortByExecutionTime();
				OSProcess process = readyProcessesList.getNext();
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