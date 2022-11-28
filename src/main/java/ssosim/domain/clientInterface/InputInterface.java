package ssosim.domain.clientInterface;

import java.util.ArrayList;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class InputInterface {
	@NotEmpty(message = "It is necessary, at least, 1 process")
	public ArrayList<OSProcessInput> processes;

	@NotBlank(message = "Define a scheduler: fifo, sjf, rr or edf")
	public String schedulerName;

	@Min(value = 1, message = "Minimum 'quantum' is 1")
	public int quantum;
}
