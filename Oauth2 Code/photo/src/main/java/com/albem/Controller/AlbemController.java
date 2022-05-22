package com.albem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/albem")
public class AlbemController {

	@Autowired
	Environment env;
	
	@GetMapping
	public String getPhotos() {
		return "Photo"+" "+env.getProperty("local.server.port");
	}
}
