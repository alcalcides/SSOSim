package ssosim.domain.clientInterface;

import ssosim.domain.model.scheduler.Scheduler;
import ssosim.domain.model.scheduler.SchedulerFIFO;

public class SchedulerFactory {
	public static Scheduler getScheduler(String schedulerName) {
		if (schedulerName.equalsIgnoreCase("fifo")) {
			return new SchedulerFIFO();
		}
		return new SchedulerFIFO();
	}
}
