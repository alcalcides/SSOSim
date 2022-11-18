package ssosim.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/hello-world")
public class HelloWorld {
	
	@GetMapping
	@ApiOperation("Return \"Hello, World!\" for troubleshooting.")
	public String hello() {
		return String.format("Hello, World!");
	}
}
