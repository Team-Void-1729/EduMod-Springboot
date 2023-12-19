package org.aot.edumoduler.controllers;
import java.util.Optional;

import org.aot.edumoduler.models.*;
import org.aot.edumoduler.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/educator")
public class EducatorControllers {
	
	@Autowired
	private EducatorRepository educatorRepository;
	
	
    @PostMapping("/add") 
    public educator addEducator(@RequestBody educator edu)
    { 
        return educatorRepository.save(edu);
    }
    
    @GetMapping("/profile/{id}")
	public Optional<educator> viewEducator(@PathVariable String id)
	{
		return educatorRepository.findById(id);
	}
	
	@GetMapping("/profile/{email}")
	public Optional<educator> findEducator(@PathVariable String email)
	{
		return educatorRepository.findByEmail(email);
	}
    
	@PutMapping("/update/{id}")
    public ResponseEntity<educator> updateEducators(@RequestParam String id, @RequestBody educator e)
    {    	
    	Optional<educator> educator = educatorRepository.findById(id);
    	
        if (educator.isPresent()) {
            educator edu = educator.get();
            edu.setEduid(e.getEduid());
            edu.setName(e.getName());
            edu.setCollege(e.getCollege());    
            edu.setEmail(e.getEmail());
            edu.setPassword(e.getPassword());
            edu.setMobile(e.getMobile());
            edu.setAbout(e.getAbout());
            edu.setVerified(e.getVerified());
            edu.setRoles(e.getRoles());
            educator updatedEducator = educatorRepository.save(edu);
            return ResponseEntity.ok(updatedEducator);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
 // Update default value of 'verified'
    @PutMapping("/update/{newValue}")
    public ResponseEntity<String> updateVerifiedDefaultValue(@PathVariable boolean newValue) {
        Iterable<educator> educators = educatorRepository.findAll();
        for (educator edu : educators) {
            edu.setVerified(newValue);
            educatorRepository.save(edu);
        }
        return ResponseEntity.ok("Default value of 'verified' updated to: " + newValue);
    }

    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteEducator(@PathVariable String id)
    {
        Optional<educator> edu = educatorRepository.findById(id);
        if (edu.isPresent()) {
        	educatorRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}