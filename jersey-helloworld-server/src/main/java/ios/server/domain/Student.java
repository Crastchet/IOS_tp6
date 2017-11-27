package ios.server.domain;

import ios.server.database.Database;

public class Student {

	private long id;
	private String firstname;
	private String lastname;
	private String studiesLevel;
	
	
	public Student() { }

	public Student(String firstname, String lastname, String studiesLevel) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.studiesLevel = studiesLevel;
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getStudiesLevel() {
		return studiesLevel;
	}

	public void setStudiesLevel(String studiesLevel) {
		this.studiesLevel = studiesLevel;
	}

	
	@Override
	public String toString() {
		return "[" + this.firstname + "," + this.lastname + "," + this.studiesLevel + "]";
	}
	
	@Override
	public boolean equals(Object o) {
		return this.id == ((Student) o).getId();
	}
}
