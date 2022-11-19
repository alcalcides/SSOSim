package ssosim.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/hello-world")
@Api(description = "Just to debug")
@Slf4j
public class HelloWorld {
	
	@GetMapping
	@ApiOperation("Return \"Hello, World!\" to troubleshooting.")
	public String hello() {
		log.info("get /api/hello-world");
		return String.format("Hello, World!");
	}
}
