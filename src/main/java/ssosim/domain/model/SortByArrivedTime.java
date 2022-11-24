package ssosim.domain.model;

import java.util.Comparator;

public class SortByArrivedTime implements Comparator<OSProcess> {

	@Override
	public int compare(OSProcess o1, OSProcess o2) {
		return o1.getArriveTime() - o2.getArriveTime();
	}
	
}