package ssosim.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import ssosim.domain.model.OperatingSystem;

@RestController
@RequestMapping("/api/turn-on")
@Api(description = "Trigger the Operating System")
@Slf4j
public class OperatingSystemTrigger {

	@PostMapping
	@ApiOperation("Deliver the processing technical report")
	public String turnOnOperatingSystem() {
		log.info(">> calling operating system");

		log.info(">> receive input data");
		// code!

		log.info(">> building OS");
		OperatingSystem operatingSystem = new OperatingSystem();

		log.info(">> running OS");
		operatingSystem.run();

		log.info("building response");
		// code!

		return String.format("working in progress!");
	}

}
