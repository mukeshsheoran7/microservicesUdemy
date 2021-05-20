package com.sheoran.rest.webservices.springbootwebservices.HelloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@GetMapping(path="/hello-world")
	public String hellowWorld() {
		return "Hello World !!!";
	}

	@GetMapping(path="/hello-world-bean")
	public HelloWorldbean hellowWorldBean() {
		return new HelloWorldbean("Hello World !!!");
	}

	@GetMapping(path="/hello-world-bean/path-varible/{name}")
	public HelloWorldbean hellowWorldPathVar(@PathVariable String name) {
		return new HelloWorldbean("Hello World, "+name +"!!!");
	}
}
