package ssosim.domain.model.processManagement;

import java.util.ArrayList;

import ssosim.domain.model.metaData.Journal;
import ssosim.domain.model.processManagement.scheduler.Scheduler;

public class ProcessManager {
	private ArrayList<OSProcess> processes;
	private Scheduler scheduler;

	public ProcessManager(ArrayList<OSProcess> processes, Scheduler scheduler) {
		this.processes = processes;
		this.scheduler = scheduler;
	}

	public Journal run() {
		Journal journal = scheduler.run(processes);

		float turnAround = 0.0f;
		for (OSProcess process : processes) {
			turnAround += process.getFinishTime() - process.getArriveTime();
		}
		turnAround /= processes.size();

		journal.setTurnAround(turnAround);

		return journal;
	}

	public ArrayList<OSProcess> getProcesses() {
		return processes;
	}

	public Scheduler getScheduler() {
		return scheduler;
	}

}
