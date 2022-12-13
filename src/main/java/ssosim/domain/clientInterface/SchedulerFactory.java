package ssosim.domain.clientInterface;

import ssosim.domain.model.scheduler.Scheduler;
import ssosim.domain.model.scheduler.SchedulerEDF;
import ssosim.domain.model.scheduler.SchedulerFIFO;
import ssosim.domain.model.scheduler.SchedulerRoundRobin;
import ssosim.domain.model.scheduler.SchedulerSJF;

public class SchedulerFactory {
	public static Scheduler getScheduler(String schedulerName, int quantum) {
		if (schedulerName.equalsIgnoreCase("fifo")) {
			return new SchedulerFIFO();
		} else if (schedulerName.equalsIgnoreCase("sjf")) {
			return new SchedulerSJF();
		} else if (schedulerName.equalsIgnoreCase("rr")) {
			return new SchedulerRoundRobin(quantum);
		} else if (schedulerName.equalsIgnoreCase("edf")) {
			return new SchedulerEDF(quantum);
		}
		return new SchedulerFIFO();
	}
}
