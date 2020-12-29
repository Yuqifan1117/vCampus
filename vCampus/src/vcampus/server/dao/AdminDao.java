package vcampus.server.dao;

import vcampus.vo.Admin;
import vcampus.vo.Student;
import vcampus.vo.Teacher;

import java.util.ArrayList;

import vcampus.server.exception.*;

public interface AdminDao {	
	/**
	 * ����admin����������Admin����δ��ѯ�ɹ�������null
	 * @param String
	 * @return admin
	 */
	public Admin selectAdmin(String adminID);
	
	
	public ArrayList<Student> queryAllStudent();
	public ArrayList<Student> queryStudentByMajor(String major);
	public ArrayList<Student> queryStudentByDate(String date);
	public ArrayList<Student> queryStudentByGrade(String grade);
	public ArrayList<Student> queryStudentByAcademy(String academy);
	public ArrayList<Student> queryStudentByStudentID(String studentID);
	
	public ArrayList<Teacher> queryAllTeacher();
	public ArrayList<Teacher> queryTeacherByWorkplace(String workplace);
	public ArrayList<Teacher> queryTeacherByWorkplaceProfessionalTitle(String professionalTitle);
	/**
	 * ����userID����������������δ��ѯ���˻�(��ʦ/ѧ��)�򽫷���-1
	 * @param String
	 * @return double
	 */
	public double queryAccountByUserID(String userID);
	
	/**
	 * ����adminID,password,��userName�Ѿ������׳��쳣,SQL�쳣����false
	 * @param String
	 * @return boolean
	 * @throws RecordAlreadyExistException
	 */
	public boolean insertAdmin(String adminID,String password)throws RecordAlreadyExistException;
	
	/**
	 * ����adminID,password,��userName�������׳��쳣,SQL�쳣����false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 */
	public boolean updatePassword(String adminID,String password)throws RecordNotFoundException;
	
	/**
	 * ����adminID,��userName�������׳��쳣,SQL�쳣����false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 */
	public boolean deleteAdmin(String adminID)throws RecordNotFoundException;
}

