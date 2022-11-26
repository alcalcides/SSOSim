package ssosim.domain.model.scheduler;

import java.util.ArrayList;

import ssosim.domain.model.metaData.Journal;
import ssosim.domain.model.processManagement.OSProcess;

public interface Scheduler {
	public abstract void run(ArrayList<OSProcess> processes, Journal journal);

}
