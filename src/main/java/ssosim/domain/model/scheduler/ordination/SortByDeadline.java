package ssosim.domain.model.scheduler.ordination;

import java.util.Comparator;

import ssosim.domain.model.processManagement.OSProcess;

public class SortByDeadline implements Comparator<OSProcess> {

	@Override
	public int compare(OSProcess o1, OSProcess o2) {
		return o1.getDeadline() - o2.getDeadline();
	}

}