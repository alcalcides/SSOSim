package ssosim.domain.model.scheduler;

import java.util.ArrayList;
import java.util.Collections;

import lombok.extern.slf4j.Slf4j;
import ssosim.domain.model.metaData.Journal;
import ssosim.domain.model.processManagement.OSProcess;
import ssosim.domain.model.scheduler.ordination.SortByArrivedTime;

@Slf4j
public class SchedulerFIFO extends Scheduler {

	@Override
	public Journal run(ArrayList<OSProcess> processes) {
		log.info(">> SchedulerFIFO running");
		Collections.sort(processes, new SortByArrivedTime());
		int time = 0;

		for (OSProcess process : processes) {
			while (!process.isFineshed()) {
				if (process.getArriveTime() <= time) {
					log.info(">>> [" + time + "] runing " + process.getId());
					process.run(time);
					journalCPU.cpuReport(process.getId());
				} else {
					log.info(">>> [" + time + "] idle");
					journalCPU.cpuReport("idle");
				}
				time++;
			}
		}

		return journalCPU;

	}

}
