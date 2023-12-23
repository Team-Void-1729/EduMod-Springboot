package org.aot.edumoduler.controllers;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.aot.edumoduler.models.*;
import org.aot.edumoduler.repos.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;

  
@RestController
@RequestMapping("/courses")
public class CourseControllers {

	@Autowired
	CourseRepository courseRepository;
	
	@PostMapping("/add")
    public course createCourse(@RequestBody course cou) {
		return courseRepository.save(cou);
	}

	@GetMapping("/details")
	public List<course> viewAllCourse()
	{
		return courseRepository.findAll();
	}
    
    @GetMapping("/details/{title}")
	public Optional<course> viewCourse(@PathVariable String title)
	{
		return courseRepository.findByTitle(title);
	}
    
	@PatchMapping("/update/{id}")
    public String updateCourses(@PathVariable String id, @RequestBody Map<String, Object> fields)
    {    	
    	course cou = courseRepository.findById(id).orElseGet(null);
    	
        if (cou != null) {
        	fields.forEach((key, value)-> {
        		Field field = ReflectionUtils.findRequiredField(course.class, key);
        		field.setAccessible(true);
        		ReflectionUtils.setField(field, cou, value);
        		
        		courseRepository.save(cou);
        	});
            
            return "Course Updated.";
        } else {
            return "Course not Found";
        }
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteCourse(@PathVariable String id)
    {
        course cou = courseRepository.findById(id).orElseGet(null);
        
        if (cou != null) {
        	courseRepository.deleteById(id);
        	
            return "Course Deleted.";
        } else {
        	return "Course not Found.";
        }
    }
}
