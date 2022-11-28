package ssosim.domain.clientInterface;

import java.util.ArrayList;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.validation.annotation.Validated;

@Validated
public class InputInterface {
	@NotEmpty(message = "It is necessary, at least, 1 process")
	public ArrayList<@Valid OSProcessInput> processes;

	@NotBlank(message = "Define a scheduler: 'fifo', 'sjf', 'rr' or 'edf'")
	@Pattern(regexp = "(?i)(?:fifo)|(?:sjf)|(?:edf)|(?:rr)?", message = "Only FIFO, SJF, EDF or RR")
	public String schedulerName;

	@Min(value = 1, message = "Minimum 'quantum' is 1")
	public int quantum;

	public ArrayList<OSProcessInput> getProcesses() {
		return processes;
	}

	public String getSchedulerName() {
		return schedulerName;
	}

	public int getQuantum() {
		return quantum;
	}

}
