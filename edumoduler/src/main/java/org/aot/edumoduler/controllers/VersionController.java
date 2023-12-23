package org.aot.edumoduler.controllers;


import org.aot.edumoduler.git.GSON;
import org.aot.edumoduler.git.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/version")
public class VersionController {
	
	GSON gson = new GSON();
	
	@PostMapping("/store")
	public String storeVersion(@RequestBody User user)
	{
		GSON gson = new GSON();
		
		gson.makeJsonFile(user);
		
		return "File Written";	
	}
}
