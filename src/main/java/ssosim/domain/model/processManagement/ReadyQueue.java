package ssosim.domain.model.processManagement;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.stream.Collectors;

import ssosim.domain.model.scheduler.ordination.SortByDeadline;

public class ReadyQueue {
	private Deque<String> ready;

	public ReadyQueue() {
		this.ready = new ArrayDeque<>();
	}

	public OSProcess getNextProcess(ArrayList<OSProcess> processes) {
		String nextProcessID = dequeue();
		OSProcess nextProcess = processes.stream().filter(p -> p.getId() == nextProcessID).collect(Collectors.toList())
				.get(0);
		return nextProcess;
	}

	public void enqueueArrivedProcesses(ArrayList<OSProcess> processes, int arriveTime) {
		processes.stream().filter(p -> p.getArriveTime() == arriveTime).forEach(p -> ready.add(p.getId()));
	}

	public void enqueueArrivedProcessesSortedByDeadline(ArrayList<OSProcess> processes, int arriveTime) {
		processes.stream().filter(p -> p.getArriveTime() == arriveTime).sorted(new SortByDeadline())
				.forEach(p -> ready.add(p.getId()));
	}

	public void enqueue(OSProcess process) {
		ready.addLast(process.getId());
	}

	public void enqueueSortedByDeadline(OSProcess process, ArrayList<OSProcess> processes) {
		ArrayList<OSProcess> copy = new ArrayList<>(processes);
		copy.removeIf(p -> {
			String id = p.getId();
			return !ready.contains(id);
		});

		copy.sort(new SortByDeadline());
		ready.clear();

		copy.stream().forEach(p -> ready.addFirst(p.getId()));
	}

	public String dequeue() {
		return ready.poll();
	}

	public boolean isEmpty() {
		return ready.isEmpty();
	}
}
