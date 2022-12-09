package ssosim.domain.model.processManagement;

import java.util.ArrayList;
import java.util.Collections;

import ssosim.domain.model.scheduler.ordination.SortByExecutionTime;

public class ReadyProcessQueue {
	private ArrayList<OSProcess> readyProcessQueue;

	public ReadyProcessQueue(ArrayList<OSProcess> processes, int time) {
		this.readyProcessQueue = new ArrayList<OSProcess>(processes);
		readyProcessQueue.removeIf(process -> process.isFineshed());
		readyProcessQueue.removeIf(process -> process.getArriveTime() > time);
	}

	public void sortByExecutionTime() {
		Collections.sort(readyProcessQueue, new SortByExecutionTime());
	}

	public OSProcess getNext() {
		return readyProcessQueue.get(0);
	}

	public boolean isEmpty() {
		return readyProcessQueue.isEmpty();
	}

}
