package ssosim.domain.model.scheduler;

import java.util.ArrayList;

import ssosim.domain.model.metaData.Journal;
import ssosim.domain.model.processManagement.OSProcess;

public abstract class Scheduler {
	protected Journal journalCPU = new Journal();

	public abstract Journal run(ArrayList<OSProcess> processes);

}
