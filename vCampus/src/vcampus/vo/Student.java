package vcampus.vo;

import vcampus.vo.User;

public class Student extends User{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String studentID;// ѧ��
	String major;
	String grade;
	int age;
	String academy;//ѧԺ	
	String birth;
	String date;//��ѧ���
	int schyear;//ѧ��

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String studentID, String major, String grade, int age, String academy,
			String birth, String date, int schyear) {
		super();
		this.studentID = studentID;
		this.major = major;
		this.grade = grade;
		this.age=age;
		this.academy=academy;
		this.birth=birth;
		this.date=date;
		this.schyear=schyear;
	}
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAcademy() {
		return academy;
	}
	public void setAcademy(String academy) {
		this.academy = academy;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getSchyear() {
		return schyear;
	}
	public void setSchyear(int schyear) {
		this.schyear = schyear;
	}
	
}
