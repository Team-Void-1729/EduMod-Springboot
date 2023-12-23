package org.aot.edumoduler.controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;

import org.aot.edumoduler.models.*;
import org.aot.edumoduler.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;

@RestController
@RequestMapping("/curriculum")
public class CurriculumControllers {
	@Autowired
	private CurriculumRepository curRepo;
	
	@PostMapping("/create")
    public ResponseEntity<Object> createCurriculum(@RequestBody curriculum curr) {
		
        curriculum curri = new curriculum();
        curri.setBranch(curr.getBranch());
        curri.setSem(curr.getSem());
        curri.setStatus(curr.getStatus());
        
        curRepo.save(curri);
        
        return ResponseEntity.ok("Curriculum created: " + curri);
    }
	
	@PostMapping("/add") 
    public curriculum addCurriculum(@RequestBody curriculum x) 
    { 
        return curRepo.save(x); 
    } 
    
    @GetMapping("/details/{id}")
	public Optional<curriculum> viewCurriculums(@PathVariable String id)
	{
		return curRepo.findById(id);
	}
    
	@PutMapping("/update/{id}")
    public ResponseEntity<curriculum> updateCurriculum(@PathVariable String id, @RequestBody Map<String, Object> fields)
    {
    	curriculum curri = curRepo.findById(id).orElseGet(null);
        if (curri != null) {
        	fields.forEach((key, value)-> {
        		Field field = ReflectionUtils.findRequiredField(curriculum.class, key);
        		field.setAccessible(true);
        		ReflectionUtils.setField(field, curri, value);
        		
        		curRepo.save(curri);
        	});
            return ResponseEntity.ok(curri);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteCurriculum(@PathVariable String id)
    {
        curriculum curr = curRepo.findById(id).orElseGet(null);
        if (curr != null) {
            curRepo.deleteById(id);
            
            return "Curriculum Deleted.";
        } else {
        	return "Curriculum not Found.";
        }
    }
}
