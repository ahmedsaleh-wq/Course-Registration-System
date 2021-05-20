package application;

public class Lectrures {
	protected String TeachCourse;
	protected String LecName;
	protected String LecID;
	
	public Lectrures( String TeachCourse, String LecName, String LecID) {
		this.TeachCourse=TeachCourse;
		this.LecName=LecName;
		this.LecID=LecID;
	}
	
	
	//getters
	String GetTechCourse() {
		return TeachCourse;	
	}
	String GetLecName() {
		return LecName;	
	}
	String GetLecID() {
		return LecID;	
	}
	
	
	//setters
	void SetTechCourse(String TeachCourse) {
		this.TeachCourse = TeachCourse;	
	}
	void SetLecName(String LecName) {
		this.LecName = LecName;	
	}
	void SetLecID(String LecID) {
		this.LecID = LecID;	
	}
}
