package ssosim.domain.model;

public class OSProcess {
	private String id;
	private int executionTime;
	private int arriveTime;

	public OSProcess(String id, int executionTime, int arriveTime) {
		this.id = id;
		this.executionTime = executionTime;
		this.arriveTime = arriveTime;
	}

	// Getters and Setters
	public String getId() {
		return id;
	}

	public int getExecutionTime() {
		return executionTime;
	}

	public int getArriveTime() {
		return arriveTime;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setExecutionTime(int executionTime) {
		this.executionTime = executionTime;
	}

	public void setArriveTime(int arriveTime) {
		this.arriveTime = arriveTime;
	}

}
