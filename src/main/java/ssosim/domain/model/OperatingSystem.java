package ssosim.domain.model;

import java.util.ArrayList;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OperatingSystem {
	public ProcessManager processManager;

	public void run() {
		processManager.run();
	}

	public OperatingSystem() {
		log.info(">> creating operating system");

		ArrayList<OSProcess> processes = new ArrayList<>();
		processes.add(new OSProcess("1", 10, 0));
		processes.add(new OSProcess("2", 20, 0));

		processManager = new ProcessManager(processes);
	}

}
