package ssosim.domain.model.processManagement;

public class OSProcess {
	private String id;
	private int executionTime;
	private int arriveTime;
	private int remainingTime;
	private int finishingTime;
	private boolean fineshed;

	public OSProcess(String id, int executionTime, int arriveTime) {
		this.id = id;
		this.executionTime = executionTime;
		this.arriveTime = arriveTime;
		setRemainingTime(executionTime);
	}

	public void run(int time) {
		setRemainingTime(remainingTime - 1);
		if (fineshed)
			finishingTime = time;
	}

	public void setRemainingTime(int remaingTime) {
		if (remaingTime <= 0) {
			this.remainingTime = 0;
			fineshed = true;
		} else {
			this.remainingTime = remaingTime;
			fineshed = false;
		}
	}

	// Normal Getters
	public String getId() {
		return id;
	}

	public int getExecutionTime() {
		return executionTime;
	}

	public int getArriveTime() {
		return arriveTime;
	}

	public int getRemainingTime() {
		return remainingTime;
	}

	public boolean isFineshed() {
		return fineshed;
	}

	public int getFinishTime() {
		return finishingTime;
	}

}
