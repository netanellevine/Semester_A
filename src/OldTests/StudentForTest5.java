package OldTests;

public class StudentForTest5 {
	private String name;
	private String id;
	private CourseForTest5[] courseList;
	private int numOfCourses;
	
	public StudentForTest5(String n, String id) {
		this.name=n;
		this.id=id;
		this.courseList=new CourseForTest5[10];
	}
	
	public boolean addCourse(CourseForTest5 c1) {
		if(numOfCourses>=10) {return false;}
		this.courseList[numOfCourses]= new CourseForTest5(c1);
		numOfCourses++;
		return true;
		}
	
	public boolean setGrade(int grade,int courseNum) {
		if(grade<0 || grade>100 ) {return false;}
		for(int i=0; i<this.courseList.length;i++) {
			if(courseList[i].getNumOfCourse()==courseNum) {
				courseList[i].setFinalGrade(grade);
				return true;
			}
		}
		return false;
	}
}
