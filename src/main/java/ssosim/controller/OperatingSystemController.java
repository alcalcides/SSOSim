package ssosim.controller;

import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import ssosim.domain.clientInterface.InputInterface;
import ssosim.domain.clientInterface.OperatingSystemAdapter;
import ssosim.domain.model.OperatingSystem;
import ssosim.domain.model.metaData.Journal;

@RestController
@RequestMapping("/api/scheduler")
@Api(description = "Simulates operating system algorithms")
@Slf4j
@Validated
public class OperatingSystemController {

	@PostMapping
	@ApiOperation("Simulates an operating system running processes")
	public ResponseEntity<Journal> powerOnOperatingSystem(@Valid @RequestBody InputInterface input) {
		log.info(">> calling operating system with scheduler FIFO");

		log.info(">> validate input data");

		log.info(">> building OS");
		OperatingSystem operatingSystem = new OperatingSystemAdapter().getOperatingSystem(input);

		log.info(">> running OS");
		operatingSystem.run();

		log.info(">> building response");
		// code!

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		return new ResponseEntity<Journal>(operatingSystem.getJournal(), headers, HttpStatus.ACCEPTED);
	}

}
