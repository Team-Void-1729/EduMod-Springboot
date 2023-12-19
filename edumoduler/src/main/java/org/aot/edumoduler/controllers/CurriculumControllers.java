package org.aot.edumoduler.controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import org.aot.edumoduler.models.*;
import org.aot.edumoduler.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/curriculum")
public class CurriculumControllers {
	@Autowired
	CurriculumRepository cur;
	
	@PostMapping("/add") 
    public curriculum addCurriculum(@RequestBody curriculum x) 
    { 
        return cur.save(x); 
    } 
    
    @GetMapping("/details/{id}")
	public Optional<curriculum> viewCurriculums(@PathVariable String id)
	{
		return cur.findById(id);
	}
    
	@PutMapping("/update/{id}")
    //Method
    public ResponseEntity<curriculum> updateCurriculum(@PathVariable String id, @RequestBody curriculum c)
    {
    	// fetch by id
    	
    	Optional<curriculum> curriculum = cur.findById(id);
        if (curriculum.isPresent()) {
            curriculum curri = curriculum.get();
            curri.setCurid(c.getCurid());
            curri.setBranch(c.getBranch());
            curri.setSemester(c.getSem());
            curri.setStatus(c.getStatus());    /*Published or Unpublished*/
            curri.setEducator(c.getEdu());
            curriculum updatedCurriculum = cur.save(curri);
            return ResponseEntity.ok(updatedCurriculum);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteCurriculum(@PathVariable String id)
    {
        Optional<curriculum> curriculum = cur.findById(id);
        if (curriculum.isPresent()) {
            cur.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
