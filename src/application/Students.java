package application;

public class Students {
	protected String StudentName;
	protected String StudentID;
	protected double GPA;
	protected String  Degree;
	protected int  Year;
	
	
	public Students( String StudentName, String StudentID, double GPA ,String  Degree,int year) {
		this.StudentName=StudentName;
		this.StudentID=StudentID;
		this.GPA=GPA;
		this. Degree = Degree;
		this.Year=year;
	}
	
	

	
	
	//setters
	void SetStudentName(String StudentName) {
		this.StudentName = StudentName;	
	}
	void SetStudentID(String StudentID) {
		this.StudentID = StudentID;	
	}
	void SetGPA(double GPA) {
		this.GPA = GPA;	
	}
	void SetStudentDegree(String  Degree) {
		this. Degree = Degree;
	}
	void SetStudentYear(int year) {
		this.Year=year;
	}
	
	//getters
	String GetStudentName() {
		return StudentName;	
	}
	String GetStudentID() {
		return StudentID;	
	}
	double GetGPA() {
		return GPA;	
	}
	String GetStudentDegree() {
		return Degree;	
	}
	int GetStudentYear() {
		return Year;	
	}
}
