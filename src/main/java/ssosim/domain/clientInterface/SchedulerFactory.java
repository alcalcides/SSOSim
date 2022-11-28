package ssosim.domain.clientInterface;

import ssosim.domain.model.scheduler.Scheduler;
import ssosim.domain.model.scheduler.SchedulerFIFO;
import ssosim.domain.model.scheduler.SchedulerSJF;

public class SchedulerFactory {
	public static Scheduler getScheduler(String schedulerName) {
		if (schedulerName.equalsIgnoreCase("fifo")) {
			return new SchedulerFIFO();
		} else if (schedulerName.equalsIgnoreCase("sjf")) {
			return new SchedulerSJF();
		}
		return new SchedulerFIFO();
	}
}
