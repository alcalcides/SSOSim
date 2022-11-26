package ssosim.domain.model.scheduler;

import java.util.ArrayList;
import java.util.Collections;

import lombok.extern.slf4j.Slf4j;
import ssosim.domain.model.metaData.Journal;
import ssosim.domain.model.processManagement.OSProcess;
import ssosim.domain.model.scheduler.ordination.SortByArrivedTime;

@Slf4j
public class SchedulerFIFO implements Scheduler {

	@Override
	public void run(ArrayList<OSProcess> processes, Journal journal) {
		log.info(">> SchedulerFIFO running");
		Collections.sort(processes, new SortByArrivedTime());
		int time = 0;

		for (OSProcess process : processes) {
			while (!process.isFineshed()) {
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
