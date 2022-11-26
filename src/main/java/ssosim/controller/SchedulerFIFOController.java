package ssosim.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/api/scheduler/FIFO")
@Api(description = "Operates FIFO on processes")
@Slf4j
public class SchedulerFIFOController {

	@PostMapping
	@ApiOperation("Sort processes according the algorithm FIFO")
	public ResponseEntity<Journal> powerOnSchedulerFIFO(@RequestBody InputInterface input) {
		log.info(">> calling operating system with scheduler FIFO");

		log.info(">> validate input data");

		log.info(">> building OS");
		OperatingSystem operatingSystem = new OperatingSystemAdapter().getOperatingSystem(input);

		log.info(">> running OS");
		Journal report = operatingSystem.run();

		log.info(">> building response");
		// code!

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		
		return new ResponseEntity<Journal>(report, headers, HttpStatus.ACCEPTED);
	}

}
