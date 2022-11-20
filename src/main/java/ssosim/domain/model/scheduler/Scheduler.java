package ssosim.domain.model.scheduler;

import java.util.ArrayList;

import ssosim.domain.model.Process;

public abstract class Scheduler {
	public abstract void run(ArrayList<Process> processes);
}
