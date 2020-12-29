package vcampus.vo;

public class CourseSelectNDrop implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String courseID;
	private String courseName;
	private String studentID;
	private String teacherUserID;
	private String teacherName;
	private double score;

	public CourseSelectNDrop() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CourseSelectNDrop(String courseID, String studentID,String courseName,
			String studentUserName,String teacherUserID,String teacherName,double score) {
		super();
		this.courseID = courseID;
		this.studentID = studentID;
		this.courseName=courseName;
		this.teacherUserID=teacherUserID;
		this.teacherName=teacherName;
		this.score=score;
	}
	public String getTeacherUserID() {
		return teacherUserID;
	}
	public void setTeacherUserID(String teacherUserID) {
		this.teacherUserID = teacherUserID;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	
}
