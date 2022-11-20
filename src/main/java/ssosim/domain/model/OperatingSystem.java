package ssosim.domain.model;

import java.util.ArrayList;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OperatingSystem {
	public ProcessManager processManager;

	public void run(ArrayList<Process> process) {
		processManager.run();
	}

	public OperatingSystem() {
		log.info("creating operating system");

		ArrayList<Process> processes = new ArrayList<>();
		processes.add(new Process(10));
		processes.add(new Process(20));

		processManager = new ProcessManager(processes);
	}

	public void run() {
		processManager.run();
	}

}
