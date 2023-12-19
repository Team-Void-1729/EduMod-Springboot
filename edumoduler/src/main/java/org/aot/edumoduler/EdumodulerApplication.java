package org.aot.edumoduler;

import org.aot.edumoduler.git.VersionControl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EdumodulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdumodulerApplication.class, args);
		System.out.println("Application started....");	
		
//		try {
//			VersionControl versionControl = new VersionControl();
//			versionControl.cloneRepo();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

}
