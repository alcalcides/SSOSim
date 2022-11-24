package ssosim.domain.model.processManagement;

import java.util.ArrayList;
import java.util.ListIterator;

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
		return scheduler.run(processes);
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

	public boolean isFineshed() {
		ListIterator<OSProcess> i = processes.listIterator();
		while (i.hasNext()) {
			if (i.next().isFineshed()) {
				i.remove();
			}
		}

		if (processes.isEmpty()) {
			return true;
		} else {
			return false;
		}

	}

}
