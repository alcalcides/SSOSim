package ssosim.domain.model;

import java.util.ArrayList;

import ssosim.domain.model.scheduler.Scheduler;
import ssosim.domain.model.scheduler.SchedulerFIFO;

public class ProcessManager {
	private int quantum = 1;
	private ArrayList<Process> processes;
	private Scheduler scheduler;

	public ProcessManager(ArrayList<Process> processes) {
		this.processes = processes;
		this.scheduler = new SchedulerFIFO();
	}

	public void run() {
		scheduler.run(processes);
	}

	public int getQuantum() {
		return quantum;
	}

	public ArrayList<Process> getProcesses() {
		return processes;
	}

	public void setProcesses(ArrayList<Process> processes) {
		this.processes = processes;
	}

	public Scheduler getScheduler() {
		return scheduler;
	}

}
