package ssosim.domain.model.scheduler;

import java.util.ArrayList;

import lombok.extern.slf4j.Slf4j;
import ssosim.domain.model.Process;

@Slf4j
public class SchedulerFIFO extends Scheduler {

	@Override
	public void run(ArrayList<Process> processes) {
		log.info(">> SchedulerFIFO running");

	}

}
