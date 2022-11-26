package ssosim.domain.model.metaData;

import java.util.ArrayList;

public class Journal {
	private ArrayList<String> schedulerSection = new ArrayList<>();
	private float turnAround = 0f;

	public void cpuReport(String data) {
		schedulerSection.add(data);
	}

	public void setTurnAround(float turnAround) {
		this.turnAround = turnAround;
	}

	public ArrayList<String> getSchedulerSection() {
		return schedulerSection;
	}

	public float getTurnAround() {
		return turnAround;
	}

}
