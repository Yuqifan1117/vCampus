package vcampus.server.dao;

import vcampus.vo.Admin;
import vcampus.vo.Student;
import vcampus.vo.Teacher;

import java.util.ArrayList;

import vcampus.server.exception.*;

public interface AdminDao {	
	/**
	 * 传入admin参数，返回Admin对象，未查询成功将返回null
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
	 * 传入userID参数，返回银行余额，未查询到账户(老师/学生)则将返回-1
	 * @param String
	 * @return double
	 */
	public double queryAccountByUserID(String userID);
	
	/**
	 * 传入adminID,password,若userName已经存在抛出异常,SQL异常返回false
	 * @param String
	 * @return boolean
	 * @throws RecordAlreadyExistException
	 */
	public boolean insertAdmin(String adminID,String password)throws RecordAlreadyExistException;
	
	/**
	 * 传入adminID,password,若userName不存在抛出异常,SQL异常返回false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 */
	public boolean updatePassword(String adminID,String password)throws RecordNotFoundException;
	
	/**
	 * 传入adminID,若userName不存在抛出异常,SQL异常返回false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 */
	public boolean deleteAdmin(String adminID)throws RecordNotFoundException;
}

