package ssosim.domain.clientInterface;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

public class OSProcessInput {
	@Pattern(regexp = "^\\w{1,3}$", message = "It's required a process have 1 to 3 characters title")
	public String id;

	@Min(value = 1, message = "Minimum value to execution time is 1")
	public int executionTime;

	@Min(value = 0, message = "Minimum value to arrive time is 0")
	public int arriveTime;

	public String getId() {
		return id;
	}

	public int getExecutionTime() {
		return executionTime;
	}

	public int getArriveTime() {
		return arriveTime;
	}

}
