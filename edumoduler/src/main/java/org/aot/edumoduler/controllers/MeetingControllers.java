package org.aot.edumoduler.controllers;
import java.util.Optional;
import org.springframework.format.annotation.DateTimeFormat;
import org.aot.edumoduler.models.*;
import org.aot.edumoduler.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/meeting")
public class MeetingControllers{
	
	@Autowired
	private MeetingRepository mr;
	
	
    @PostMapping("/add") 
    public meeting addMeeting(@RequestBody meeting x)
    {
        return mr.save(x);
    }
    
    @GetMapping("/profile/{id}")
	public Optional<meeting> viewMeeting(@PathVariable String meetingid)
	{
		return mr.findById(meetingid);
	}
	
	@PostMapping("/schedule")
    public ResponseEntity<Object> scheduleMeeting(@RequestParam("MeetingName") String name, @RequestParam("timestamp") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) String timestamp){
		
        return ResponseEntity.ok("Meeting '" + name + "' scheduled for " + timestamp);
    }
	
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteMeeting(@PathVariable String meetingid)
    {
        Optional<meeting> meet = mr.findById(meetingid);
        if (meet.isPresent()) {
        	mr.deleteById(meetingid);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}