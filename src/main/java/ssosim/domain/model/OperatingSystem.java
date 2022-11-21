package ssosim.domain.model;

import java.util.ArrayList;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OperatingSystem {
	public ProcessManager processManager;

	public OperatingSystem(ArrayList<OSProcess> processes) {
		log.info(">> creating operating system");

		processManager = new ProcessManager(processes);
	}

	public void run() {
		processManager.run();
	}
}
