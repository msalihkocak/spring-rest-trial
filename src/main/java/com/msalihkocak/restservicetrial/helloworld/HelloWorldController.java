package com.msalihkocak.restservicetrial.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource source;
	
	@GetMapping("/hello-world")
	public String sayHelloToWorld() {
		return "Hello World";
	}
	
	@GetMapping("/hello-world-bean")
	public HelloWorld sayHelloToWorldWithBean() {
		return new HelloWorld(1264L, "Hello World");
	}
	
	@GetMapping("/hello-world-bean/path-var/{name}")
	public HelloWorld sayHelloToWorldWithInputParam(@PathVariable String name) {
		return new HelloWorld(1264L, "Hello World, sana da hello " + name);
	}
	
	@GetMapping("/hello-world-i18n")
	public String sayHelloToWorldI18n(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
		return source.getMessage("good.morning.message", null, locale);
	}
	
	@GetMapping("/hello-world-locale")
	public String sayHelloToWorldLocalized() {
		return source.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}
}
