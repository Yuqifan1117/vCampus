package vcampus.vo;


public class Course implements java.io.Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String courseID;
	String courseName;
	String deptName;
	String teacherUserID;
	String teacherName;
	int courseHour;
	double credit;
	int courseDay;
	int courseOrder;
	String coursePlace;
	int numberLimit;
	int currentNumber;
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course(String courseID, String courseName, String deptName, String teacherUserID, String teacherName, int courseHour,
			double credit, 	int courseDay, int courseOrder, String coursePlace, int numberLimit, int currentNumber) {
		super();
		this.courseID = courseID;
		this.courseName = courseName;
		this.deptName = deptName;
		this.teacherUserID=teacherUserID;
		this.teacherName = teacherName;
		this.courseHour = courseHour;
		this.credit = credit;
		this.courseDay = courseDay;
		this.courseOrder=courseOrder;
		this.coursePlace = coursePlace;
		this.numberLimit = numberLimit;
		this.currentNumber = currentNumber;
	}
	public int getCourseDay() {
		return courseDay;
	}
	public void setCourseDay(int courseDay) {
		this.courseDay = courseDay;
	}
	public int getCourseOrder() {
		return courseOrder;
	}
	public void setCourseOrder(int courseOrder) {
		this.courseOrder = courseOrder;
	}
	public String getTeacherUserID() {
		return teacherUserID;
	}
	public void setTeacherUserID(String teacherUserID) {
		this.teacherUserID = teacherUserID;
	}
	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public int getCourseHour() {
		return courseHour;
	}
	public void setCourseHour(int courseHour) {
		this.courseHour = courseHour;
	}
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	public String getCoursePlace() {
		return coursePlace;
	}
	public void setCoursePlace(String coursePlace) {
		this.coursePlace = coursePlace;
	}
	public int getNumberLimit() {
		return numberLimit;
	}
	public void setNumberLimit(int numberLimit) {
		this.numberLimit = numberLimit;
	}
	public int getCurrentNumber() {
		return currentNumber;
	}
	public void setCurrentNumber(int currentNumber) {
		this.currentNumber = currentNumber;
	}
	
	
}
