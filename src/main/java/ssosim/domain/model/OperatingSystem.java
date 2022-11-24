package ssosim.domain.model;

import java.util.ArrayList;

import lombok.extern.slf4j.Slf4j;
import ssosim.domain.model.metaData.Journal;
import ssosim.domain.model.processManagement.OSProcess;
import ssosim.domain.model.processManagement.ProcessManager;

@Slf4j
public class OperatingSystem {
	public ProcessManager processManager;

	public OperatingSystem(ArrayList<OSProcess> processes) {
		log.info(">> creating operating system");

		processManager = new ProcessManager(processes);
	}

	public Journal run() {
		return processManager.run();
	}
}
