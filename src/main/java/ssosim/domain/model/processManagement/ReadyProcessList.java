package ssosim.domain.model.processManagement;

import java.util.ArrayList;
import java.util.Collections;

import ssosim.domain.model.scheduler.ordination.SortByExecutionTime;

public class ReadyProcessList {
	private ArrayList<OSProcess> readyProcessList;

	public ReadyProcessList(ArrayList<OSProcess> processes, int time) {
		this.readyProcessList = new ArrayList<OSProcess>(processes);
		readyProcessList.removeIf(process -> process.isFineshed());
		readyProcessList.removeIf(process -> process.getArriveTime() > time);
	}

	public void sortByExecutionTime() {
		Collections.sort(readyProcessList, new SortByExecutionTime());
	}

	public OSProcess getNext() {
		return readyProcessList.get(0);
	}

	public boolean isEmpty() {
		return readyProcessList.isEmpty();
	}

}
