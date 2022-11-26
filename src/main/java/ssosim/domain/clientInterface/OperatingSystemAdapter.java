package ssosim.domain.clientInterface;

import ssosim.domain.model.OperatingSystem;
import ssosim.domain.model.processManagement.ProcessManager;
import ssosim.domain.model.scheduler.Scheduler;

public class OperatingSystemAdapter {
	private OperatingSystem operatingSystem;

	public OperatingSystem getOperatingSystem(InputInterface input) {
		ProcessManager processManager = new ProcessManager(new ProcessesAdapter().getProcesses(input.processes));
		Scheduler scheduler = SchedulerFactory.getScheduler(input.schedulerName);
		this.operatingSystem = new OperatingSystem(processManager, scheduler);
		return operatingSystem;
	}
}
