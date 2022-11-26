package ssosim.domain.model;

import ssosim.domain.model.metaData.Journal;
import ssosim.domain.model.processManagement.ProcessManager;
import ssosim.domain.model.scheduler.Scheduler;

public class OperatingSystem {
	private ProcessManager processManager;
	private Scheduler scheduler;
	private Journal journal;

	public OperatingSystem(ProcessManager processManager, Scheduler scheduler) {
		this.processManager = processManager;
		this.scheduler = scheduler;
		this.journal = new Journal();
	}

	public void run() {
		processManager.run(scheduler, journal);
	}

	public Journal getJournal() {
		return journal;
	}

}
