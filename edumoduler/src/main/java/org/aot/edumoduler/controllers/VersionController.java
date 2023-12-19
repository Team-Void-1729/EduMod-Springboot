package org.aot.edumoduler.controllers;


import org.aot.edumoduler.git.GSON;
import org.aot.edumoduler.git.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/version")
public class VersionController {
	
	GSON gson = new GSON();
	
	@GetMapping("/store")
	public String storeVersion()
	{
		User user = new User(3, "Tom", "European");
		gson.makeJsonFile(user);
		return "File written...";
	}
}
