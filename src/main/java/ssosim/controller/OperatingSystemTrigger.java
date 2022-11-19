package ssosim.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/turn-on")
@Api(description = "Trigger the Operating System")
public class OperatingSystemTrigger {
	
	@PostMapping
	@ApiOperation("Deliver the processing technical report")
	public String turnOnOperatingSystem() {
		return String.format(">>turn on operating system");
	}

}
