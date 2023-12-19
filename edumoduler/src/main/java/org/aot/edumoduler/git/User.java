package org.aot.edumoduler.git;

public class User {
	  int id;
	  String name;
	  String nationality;

    public User(int id, String name, String nationality) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
    }
    
    public User(int id, String name) {
        this(id, name, null);
    }
}
