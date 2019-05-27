package com.msalihkocak.restservicetrial.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersionController {

	@GetMapping("/v1/person")
	public PersonV1 getPersonV1() {
		return new PersonV1("Mehmet Salih");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 getPersonV2() {
		return new PersonV2(new Name("Mehmet", "Salih"));
	}
	
	@GetMapping(value = "/person/param", params = "version=1")
	public PersonV1 getPersonWithParamV1() {
		return new PersonV1("Mehmet Salih");
	}
	
	@GetMapping(value = "/person/param", params = "version=2")
	public PersonV2 getPersonWithParamV2() {
		return new PersonV2(new Name("Mehmet", "Salih"));
	}
	
	@GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
	public PersonV1 getPersonWithHeaderV1() {
		return new PersonV1("Mehmet Salih");
	}
	
	@GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 getPersonWithHeaderV2() {
		return new PersonV2(new Name("Mehmet", "Salih"));
	}
	
	@GetMapping(value = "/person/produces", produces = "application/rest-v1+json")
	public PersonV1 getPersonWithAcceptV1() {
		return new PersonV1("Mehmet Salih");
	}
	
	@GetMapping(value = "/person/produces", produces = "application/rest-v2+json")
	public PersonV2 getPersonWithAcceptV2() {
		return new PersonV2(new Name("Mehmet", "Salih"));
	}
}
