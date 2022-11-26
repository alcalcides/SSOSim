package ssosim.domain.model.scheduler.ordination;

import java.util.Comparator;

import ssosim.domain.model.processManagement.OSProcess;

public class SortByArrivedTime implements Comparator<OSProcess> {

	@Override
	public int compare(OSProcess o1, OSProcess o2) {
		return o1.getArriveTime() - o2.getArriveTime();
	}
	
}