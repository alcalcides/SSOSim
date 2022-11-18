package ssosim.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/hello-world")
@Api(description = "Just to debug")
public class HelloWorld {
	
	@GetMapping
	@ApiOperation("Return \"Hello, World!\" to troubleshooting.")
	public String hello() {
		return String.format("Hello, World!");
	}
}
