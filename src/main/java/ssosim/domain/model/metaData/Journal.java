package ssosim.domain.model.metaData;

import java.util.ArrayList;

public class Journal {
	private ArrayList<String> schedulerSection = new ArrayList<>();
	private float turnAroundSection = 0f;

	public void cpuReport(String data) {
		schedulerSection.add(data);
	}

	public void turnAroundReport(float turnAround) {
		this.turnAroundSection = turnAround;
	}

	public ArrayList<String> getSchedulerSection() {
		return schedulerSection;
	}

	public float getTurnAround() {
		return turnAroundSection;
	}

}
