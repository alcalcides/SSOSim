package ssosim.domain.model;

import ssosim.domain.model.metaData.Journal;
import ssosim.domain.model.processManagement.ProcessManager;
import ssosim.domain.model.scheduler.Scheduler;

public class OperatingSystem {
	private ProcessManager processManager;
	private Scheduler scheduler;

	public OperatingSystem(ProcessManager processManager, Scheduler scheduler) {
		this.processManager = processManager;
		this.scheduler = scheduler;
	}

	public Journal run() {
		return processManager.run(scheduler);
	}

}
