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
import org.springframework.http.ResponseEntity;
  
@RestController
@RequestMapping("/courses")
public class CourseControllers {

	@Autowired
	CourseRepository cou;
	
	
	@PostMapping("/add") 
    public course addCourse(@RequestBody course x) 
    { 
        return cou.save(x);   
    } 
    
    @GetMapping("/details/{id}")
	public Optional<course> viewCourse(@PathVariable String id)
	{
		return cou.findById(id);
	}
    
	@PutMapping("/update/{id}")
    //Method
    public ResponseEntity<course> updateCourses(@PathVariable String id, @RequestBody course co)
    {
    	// fetch by id
    	
    	Optional<course> course = cou.findById(id);
        if (course.isPresent()) {
            course c = course.get();
            c.setCourseid(co.getCourseid());
            c.setType(co.getType());
            c.setTitle(co.getTitle());
            c.setCode(co.getCode());    /*Published or Unpublished*/
            c.setCredits(co.getCredits());
            c.setStream(co.getStream());
            c.setSem(co.getSem());
            c.setTime(co.getTime());
            c.setEdu(co.getEdu());
            course updatedCourse = cou.save(c);
            return ResponseEntity.ok(updatedCourse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteCourse(@PathVariable String id)
    {
        Optional<course> course = cou.findById(id);
        if (course.isPresent()) {
        	cou.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
