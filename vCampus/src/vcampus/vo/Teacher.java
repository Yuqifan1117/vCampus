package vcampus.vo;

import vcampus.vo.User;

public class Teacher extends User implements java.io.Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String teacherID;
	String birth; //��������
	String workplace;//��������
	String professionalTitle;// ְ��

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teacher(String professionalTitle,String teacherID,String birth,String workplace) {
		super();
		this.professionalTitle = professionalTitle;
		this.teacherID=teacherID;
		this.birth=birth;
		this.workplace=workplace;
	}
	
	public String getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}
	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getWorkplace() {
		return workplace;
	}

	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}
	public String getProfessionalTitle() {
		return professionalTitle;
	}

	public void setProfessionalTitle(String professionalTitle) {
		this.professionalTitle = professionalTitle;
	}
	
	
}
