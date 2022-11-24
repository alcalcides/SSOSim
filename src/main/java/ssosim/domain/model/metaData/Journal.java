package ssosim.domain.model.metaData;

import java.util.ArrayList;

public class Journal {
	private ArrayList<String> cpuSection = new ArrayList<>();
	
	public void cpuWrite(String data) {
		cpuSection.add(data);
	}
	
	public ArrayList<String> getJournal() {
		return cpuSection;
	}
	
}
