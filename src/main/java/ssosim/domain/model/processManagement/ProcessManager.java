package ssosim.domain.model.processManagement;

import java.util.ArrayList;

import ssosim.domain.model.metaData.Journal;
import ssosim.domain.model.scheduler.Scheduler;

public class ProcessManager {
	private ArrayList<OSProcess> processes;
	private float turnAround;

	public ProcessManager(ArrayList<OSProcess> processes) {
		this.processes = processes;
	}

	public void run(Scheduler scheduler, Journal journal) {
		scheduler.run(processes, journal);
		setTurnAround();
		journal.setTurnAround(turnAround);
	}

	private void setTurnAround() {
		turnAround = 0f;

		for (OSProcess process : processes) {
			turnAround += process.getFinishTime() - process.getArriveTime();
		}

		turnAround /= processes.size();
	}

	public ArrayList<OSProcess> getProcesses() {
		return processes;
	}

}
