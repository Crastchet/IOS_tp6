package ios.server.database;

import java.util.ArrayList;
import java.util.List;

import ios.server.domain.Student;

public final class Database {

	private ArrayList<Student> students;
	private long lastId;
	
	
	private static Database INSTANCE;
	
	private Database() {
		this.students = new ArrayList<Student>();
		this.lastId = 0;
	}
	
	public static Database getInstance() {
		if(INSTANCE == null)
			INSTANCE = new Database();
		return INSTANCE;
	}
	

	public long getLastId() {
		return lastId;
	}
	
	
	public void addStudent(Student student) {
		if(this.students.contains(student)) {
			System.err.println("Tentative d'ajout d'un étudiant qui existe déjà");
			student.setId(-1);
			student.setFirstname(null);
			student.setLastname(null);
			return;
		}
		student.setId(++this.lastId);
		this.students.add(student);
	}
	
	public List<Student> getAllStudents() {
		return this.students;
	}
	
	public void updateStudent(Student student) {
		if(this.students.indexOf(student) == -1) {
			System.err.println("Tentative de modification d'un étudiant qui n'existe pas");
			student.setId(-1);
			student.setFirstname(null);
			student.setLastname(null);
			return;
		}
		
		/** Je sais que cette portion de code aurait suffi étant donné qu'ils ont le même Id 
		   et que les comparaisons sont faites seulement sur les Id : */
//		this.students.remove(student);
//		this.students.add(student);
		
		/** J'ai préféré jouer le jeu et réellement modifier l'objet student en question */
		Student studentToUpdate = this.students.get( this.students.indexOf(student) );
		studentToUpdate.setFirstname(student.getFirstname());
		studentToUpdate.setLastname(student.getLastname());
		studentToUpdate.setStudiesLevel(student.getStudiesLevel());
	}
	
	public void removeStudent(Student student) {
		if(this.students.indexOf(student) == -1) {
			System.err.println("Tentative de suppression d'un étudiant qui n'existe pas");
			student.setId(-1);
			student.setFirstname(null);
			student.setLastname(null);
			return;
		}
		
		this.students.remove(student);
	}

}
