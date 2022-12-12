package ssosim.domain.model.processManagement;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.stream.Collectors;

public class ReadyQueue {
	private Deque<String> ready;

	public ReadyQueue() {
		this.ready = new ArrayDeque<>();
	}

	public OSProcess getNextProcess(ArrayList<OSProcess> processes) {
		String nextProcessID = dequeue();
		OSProcess nextProcess =
				processes.stream()
				.filter(p -> p.getId() == nextProcessID)
				.collect(Collectors.toList())
				.get(0);
		return nextProcess;
	}

	public void enqueueArrivedProcesses(ArrayList<OSProcess> processes, int arriveTime) {
		processes.stream()
			.filter(p -> p.getArriveTime() == arriveTime)
			.forEach(p -> ready.add(p.getId()));
	}

	public void enqueue(OSProcess process) {
		ready.addLast(process.getId());
	}

	public String dequeue() {
		return ready.poll();
	}

	public boolean isEmpty() {
		return ready.isEmpty();
	}
}
