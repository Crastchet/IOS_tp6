package ios.client.domain;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StudentListCoteClient {

	private ArrayList<StudentCoteClient> students;

	
	public StudentListCoteClient() { 
		this.students = new ArrayList<StudentCoteClient>();
	}


	public ArrayList<StudentCoteClient> getStudents() {
		return students;
	}


	public void setStudents(ArrayList<StudentCoteClient> students) {
		this.students = students;
	}
	
}