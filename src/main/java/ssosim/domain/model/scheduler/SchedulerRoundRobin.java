package ssosim.domain.model.scheduler;

import java.util.ArrayList;

import lombok.extern.slf4j.Slf4j;
import ssosim.domain.model.metaData.Journal;
import ssosim.domain.model.processManagement.OSProcess;
import ssosim.domain.model.processManagement.ProcessManager;
import ssosim.domain.model.processManagement.ReadyProcessQueue;

@Slf4j
public class SchedulerRoundRobin extends PreemptiveScheduler {
	private ReadyProcessQueue readyProcessesQueue;
	private int time;

	public SchedulerRoundRobin(int quantum) {
		super(quantum);
	}

	@Override
	public void run(ArrayList<OSProcess> processes, Journal journal) {
		log.info(">> SchedulerRR running");
		time = 0;
		Integer quantum = super.quantum;


	}

}