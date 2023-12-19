package org.aot.edumoduler.git;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class GSON {
	
	public GSON() {	}
	
	public void makeJsonFile(User user){
		String directoryName = "/jgit";
	    
	    File directory = new File(directoryName);
	    if(!directory.exists()) {
	    	directory.mkdir();
	    }
	    	    
	    try{
	    	Gson gson = new Gson();	
	    	FileWriter fw = new FileWriter(directoryName + "/" + "output.json");
	    	gson.toJson(user, fw);
	    	fw.close();
	    }
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
