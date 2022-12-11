package ssosim.domain.model.scheduler;

import java.util.ArrayList;

import lombok.extern.slf4j.Slf4j;
import ssosim.domain.model.metaData.Journal;
import ssosim.domain.model.processManagement.OSProcess;

@Slf4j
public abstract class PreemptiveScheduler implements Scheduler {
	protected Integer quantum;

	public PreemptiveScheduler(int quantum) {
		this.quantum = quantum;
		log.info(">> quantum = " + String.valueOf(quantum));
	}

	@Override
	public abstract void run(ArrayList<OSProcess> processes, Journal journal);

	public int getQuantum() {
		return quantum;
	}

}
