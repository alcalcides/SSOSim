package ssosim.domain.model.processManagement;

import java.util.ArrayList;
import java.util.Collections;

import ssosim.domain.model.metaData.Journal;
import ssosim.domain.model.scheduler.Scheduler;
import ssosim.domain.model.scheduler.ordination.SortByArrivedTime;

public class ProcessManager {
	private ArrayList<OSProcess> processes;
	private float turnAround;

	public ProcessManager(ArrayList<OSProcess> processes) {
		this.processes = processes;
		sortProcessesByArriveTime(processes);
	}

	private void sortProcessesByArriveTime(ArrayList<OSProcess> processes) {
		Collections.sort(processes, new SortByArrivedTime());
	}

	public void run(Scheduler scheduler, Journal journal) {
		scheduler.run(processes, journal);
		setTurnAround();
		journal.turnAroundReport(turnAround);
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
