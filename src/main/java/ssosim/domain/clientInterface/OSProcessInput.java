package ssosim.domain.clientInterface;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class OSProcessInput {
	@Pattern(regexp = "^\\w{1,3}$", message = "It's required a process have 1 to 3 characters title")
	@NotNull
	public String id;

	@Min(value = 1, message = "Minimum value to execution time is 1")
	@NotNull
	public int executionTime;

	@Min(value = 0, message = "Minimum value to arrive time is 0")
	@NotNull
	public int arriveTime;

	@Min(value = 1, message = "Minimum value to deadline is 1")
	public int deadline;

	public String getId() {
		return id;
	}

	public int getExecutionTime() {
		return executionTime;
	}

	public int getArriveTime() {
		return arriveTime;
	}

	public int getDeadline() {
		return deadline;
	}
}
