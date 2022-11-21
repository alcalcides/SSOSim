package ssosim.domain.model.scheduler;

import java.util.ArrayList;

import ssosim.domain.model.OSProcess;

public abstract class Scheduler {
	public abstract void run(ArrayList<OSProcess> processes);
}
