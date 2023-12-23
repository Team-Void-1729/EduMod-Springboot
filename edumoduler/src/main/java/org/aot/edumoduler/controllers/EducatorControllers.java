package org.aot.edumoduler.controllers;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;

import org.aot.edumoduler.dto.LoginDto;
import org.aot.edumoduler.models.*;
import org.aot.edumoduler.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
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
    
    @PostMapping("/login")
    public ResponseEntity<Object> loginEducator(@RequestBody LoginDto loginDto) {
    	educator edu = educatorRepository.findByEmail(loginDto.getEmail()).orElseGet(null);
    	
    	if(edu != null) {
    		if(edu.getPassword().matches(loginDto.getPassword())) {    			
    			return ResponseEntity.ok(edu);
    		}
    		else {
    			return ResponseEntity.badRequest().build();
    		}
    	}
    	return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/profile/{id}")
	public Optional<educator> viewEducator(@PathVariable String id)
	{
		return educatorRepository.findById(id);
	}
    
	@PatchMapping("/update/{id}")
    public String updateEducators(@PathVariable String id, @RequestBody Map<String, Object> fields)
    {    	
    	educator edu = educatorRepository.findById(id).orElseGet(null);
    	
        if (edu != null){
        	fields.forEach((key, value)-> {
        		Field field = ReflectionUtils.findRequiredField(educator.class, key);
        		field.setAccessible(true);
        		ReflectionUtils.setField(field, edu, value);
        		
        		educatorRepository.save(edu);
        	});
    		
            
            return "Educator updated successfully.";
        } 
        else {
        	return "Educator not Found.";
        }
    }

    
    @DeleteMapping("/delete/{id}")
    public String deleteEducator(@PathVariable String id)
    {
        educator edu = educatorRepository.findById(id).orElseGet(null);
        if (edu != null) {
        	educatorRepository.deleteById(id);
            
        	return "Educator account Deleted.";
        } else {
        	return "Educator not Found.";
        }
    }
}