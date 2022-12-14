package ssosim.domain.model.scheduler;

import java.util.ArrayList;

import lombok.extern.slf4j.Slf4j;
import ssosim.domain.model.metaData.Journal;
import ssosim.domain.model.processManagement.OSProcess;

@Slf4j
public class SchedulerFIFO implements Scheduler {

	@Override
	public void run(ArrayList<OSProcess> processes, Journal journal) {
		log.info(">> SchedulerFIFO running");
		int time = 0;

		for (OSProcess process : processes) {
			while (process.isNotFineshed()) {
				if (process.getArriveTime() <= time) {
					log.info(">>> [" + time + "] runing " + process.getId());
					process.run(time);
					journal.cpuReport(process.getId());
				} else {
					log.info(">>> [" + time + "] idle");
					journal.cpuReport("idle");
				}
				time++;
			}
		}
	}

}
