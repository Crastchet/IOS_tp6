package ios.server;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ios.server.database.Database;
import ios.server.domain.Student;
import ios.server.domain.StudentList;

@Path("/student")
public class StudentResource {
	
	private static final Database BDD = Database.getInstance();

	
	@POST
	@Path("/addstudent")
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Student addStudent(Student student) {
		//student.setId(BDD.getLastId() + 1);
		BDD.addStudent(student);
		return student;
	}
	
	@GET
	@Path("/allstudents")
	@Produces("application/json")
	public StudentList allStudents() {
		StudentList students = new StudentList();
		students.setStudents(BDD.getAllStudents());
		return students;
	}

	@PUT
	@Path("/modstudent")
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Student modifyStudent(Student student) {
		BDD.updateStudent(student);
		return student;
	}
	
	@DELETE
	@Path("/delstudent")
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteStudent(Student student) {
		BDD.removeStudent(student);
		return "->- Student deleted";
	}
	
}
