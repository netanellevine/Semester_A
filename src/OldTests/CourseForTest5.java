package OldTests;

public class CourseForTest5 {
	private int numOfCourse;
	private String name;
	private int numOfPoints;
	private int finalGrade;
	
	public CourseForTest5(int n, String name,int nop, int fp) {
		this.numOfCourse=n;
		this.name=name;
		this.numOfPoints=nop;
		this.finalGrade=fp;
	}
	
	public CourseForTest5(CourseForTest5 other) {
		this.numOfCourse=other.numOfCourse;
		this.name=other.name;
		this.numOfPoints=other.numOfPoints;
		this.finalGrade=other.finalGrade;
	}
	
	public int getNumOfCourse() {
		return this.numOfCourse;
	}
	
	public void setFinalGrade(int grade) {
		this.finalGrade=grade;
	}
	
}
