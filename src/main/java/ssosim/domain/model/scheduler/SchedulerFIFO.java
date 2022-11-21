package ssosim.domain.model.scheduler;

import java.util.ArrayList;

import lombok.extern.slf4j.Slf4j;
import ssosim.domain.model.OSProcess;

@Slf4j
public class SchedulerFIFO extends Scheduler {

	@Override
	public void run(ArrayList<OSProcess> processes) {
		log.info(">> SchedulerFIFO running");

	}

}
