package ssosim.domain.model.processManagement;

import java.util.ArrayList;

import ssosim.domain.model.metaData.Journal;
import ssosim.domain.model.processManagement.scheduler.Scheduler;
import ssosim.domain.model.processManagement.scheduler.SchedulerFIFO;

public class ProcessManager {
	private int quantum = 1;
	private ArrayList<OSProcess> processes;
	private Scheduler scheduler;

	public ProcessManager(ArrayList<OSProcess> processes) {
		setProcesses(processes);
		this.scheduler = new SchedulerFIFO();
	}

	public Journal run() {
		Journal journalCPU = scheduler.run(processes);

		float turnAround = 0.0f;
		for (OSProcess process : processes) {
			turnAround += process.getFinishTime() - process.getArriveTime();
		}
		turnAround /= processes.size();

		journalCPU.setTurnAround(turnAround);

		return journalCPU;
	}

	public int getQuantum() {
		return quantum;
	}

	public ArrayList<OSProcess> getProcesses() {
		return processes;
	}

	public void setProcesses(ArrayList<OSProcess> processes) {
		this.processes = processes;
	}

	public Scheduler getScheduler() {
		return scheduler;
	}

}
