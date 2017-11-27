package ios.server.domain;

import java.util.ArrayList;
import java.util.List;

public class StudentList {

	private List<Student> students;

	
	public StudentList() { 
		this.students = new ArrayList<Student>();
	}


	public List<Student> getStudents() {
		return students;
	}


	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
}
