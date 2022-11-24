package ssosim.domain.model.processManagement.scheduler;

import java.util.ArrayList;
import java.util.Collections;

import lombok.extern.slf4j.Slf4j;
import ssosim.domain.model.metaData.Journal;
import ssosim.domain.model.processManagement.OSProcess;
import ssosim.domain.model.processManagement.ordination.SortByArrivedTime;

@Slf4j
public class SchedulerFIFO extends Scheduler {

	@Override
	public Journal run(ArrayList<OSProcess> processes) {
		log.info(">> SchedulerFIFO running");
		Collections.sort(processes, new SortByArrivedTime());
		processes.forEach(process -> {
			while(!process.isFineshed()) {
				log.info(">>> runing " + process.getId());
				process.run();
				journalCPU.cpuWrite(process.getId());
			}
		});
		return journalCPU;

	}

}
