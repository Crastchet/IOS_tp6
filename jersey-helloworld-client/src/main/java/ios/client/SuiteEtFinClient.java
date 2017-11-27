package ios.client;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import ios.client.domain.StudentCoteClient;
import ios.client.domain.StudentListCoteClient;

public class SuiteEtFinClient {

	private WebResource service;
	
	
	public SuiteEtFinClient() {
		Client client = Client.create(new DefaultClientConfig());
		this.service = client.resource("http://localhost:8080/jersey-helloworld-server/webresources/student");
	}
	
	
	public StudentCoteClient addStudent(StudentCoteClient student) {
		return this.service
				.path("/addstudent")
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.type(MediaType.APPLICATION_JSON_TYPE)
				.post(StudentCoteClient.class, student);
	}
	
	public StudentListCoteClient allStudents() {
		return this.service
				.path("/allstudents")
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.get(StudentListCoteClient.class);
	}
	
	public StudentCoteClient modStudent(StudentCoteClient student) {
		return this.service
				.path("/modstudent")
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.type(MediaType.APPLICATION_JSON_TYPE)
				.put(StudentCoteClient.class, student);
	}
	
	public String delStudent(StudentCoteClient student) {
		return this.service
				.path("/delstudent")
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.type(MediaType.APPLICATION_JSON_TYPE)
				.delete(String.class, student);
	}
	
	
	public static void main(String[] args) {
		SuiteEtFinClient clienSuiteEtFin = new SuiteEtFinClient();
		
		
		/**_____AJOUT_____**/
		StudentCoteClient student1 = (clienSuiteEtFin.addStudent(new StudentCoteClient("Thibault", "Coilliaux", "M1")));
		StudentCoteClient student2 = (clienSuiteEtFin.addStudent(new StudentCoteClient("Antoine", "Coilliaux", "L3")));
		
		
		/**_____RECUP_____**/
		System.out.println("\nListe des étudiants après ajout :");
		for(StudentCoteClient student : clienSuiteEtFin.allStudents().getStudents())
			System.out.println(student);
		
		
		/**_____MODIF_____**/
		student1.setStudiesLevel("M2");
		clienSuiteEtFin.modStudent(student1);
		
		System.out.println("\nListe des étudiants après modif :");
		for(StudentCoteClient student : clienSuiteEtFin.allStudents().getStudents())
			System.out.println(student);
		
		
		/**_____SUPPR_____**/
		clienSuiteEtFin.delStudent(student2);
		
		System.out.println("\nListe des étudiants après suppr 1 :");
		for(StudentCoteClient student : clienSuiteEtFin.allStudents().getStudents())
			System.out.println(student);
		
		clienSuiteEtFin.delStudent(student1);
		
		System.out.println("\nListe des étudiants après suppr 2 :");
		for(StudentCoteClient student : clienSuiteEtFin.allStudents().getStudents())
			System.out.println(student);
		
	}
}
