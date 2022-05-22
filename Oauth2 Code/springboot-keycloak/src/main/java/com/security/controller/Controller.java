package com.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class Controller {
	
	@Autowired
	Environment env;
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/check")
	@Secured(value = {"ROLE_user"})
	public String testing(@AuthenticationPrincipal Jwt jwt) {
		return jwt.getTokenValue()+" "+env.getProperty("local.server.port");
	}
	
	@Secured(value = {"ROLE_user"})
	@DeleteMapping("/{id}")
	public String deleteCheck(@PathVariable String id) {
		return "Delete Value"+" "+id;
	}

}
