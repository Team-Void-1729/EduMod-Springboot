package org.aot.edumoduler.controllers;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.aot.edumoduler.models.*;
import org.aot.edumoduler.repos.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/assessments")

public class AssessmentControllers {

	@Autowired
	private AssessmentRepository assessmentRepository;
	
	
	@PostMapping("/add") 			//add assessments
    public assessment addAssessment(@RequestBody assessment x) 
    { 
        return assessmentRepository.save(x);   
    } 
	
	@GetMapping("/details/{id}")	//view assessments
	public Optional<assessment> viewAssessments(@PathVariable String id)
	{
		return assessmentRepository.findById(id);
	}
	
	@DeleteMapping("/delete/{id}")	//delete assessments
    public ResponseEntity<Object> deleteAssessment(@PathVariable String id)
    {
        Optional<assessment> ass = assessmentRepository.findById(id);
        if (ass.isPresent()) {
        	assessmentRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}
