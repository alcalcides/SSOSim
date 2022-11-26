package ssosim.domain.clientInterface;

import java.util.ArrayList;

import ssosim.domain.model.processManagement.OSProcess;

public class ProcessesAdapter {
	private ArrayList<OSProcess> processes;

	public ProcessesAdapter() {
		processes = new ArrayList<>();
	}

	public ArrayList<OSProcess> getProcesses(ArrayList<OSProcessInput> processesInput) {
		processesInput.forEach(processInput -> {
			processes.add(new OSProcess(processInput.id, processInput.executionTime, processInput.arriveTime));
		});

		return processes;
	}
}
