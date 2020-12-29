package vcampus.server.biz;


import java.util.ArrayList;

import vcampus.server.exception.RecordAlreadyExistException;
import vcampus.server.exception.RecordNotFoundException;
import vcampus.server.exception.WrongPasswordException;
import vcampus.vo.Admin;
import vcampus.vo.CourseSelectNDrop;
import vcampus.vo.Course;

public interface AdminServiceDao {
	Admin register(String ID,String password) throws RecordAlreadyExistException;
	Admin login(String ID,String password) throws RecordNotFoundException,WrongPasswordException;
	Admin updatePassword(String ID, String password) throws RecordNotFoundException;
	boolean destroy(String ID) throws RecordNotFoundException;
	
	ArrayList<CourseSelectNDrop> courseQueryAdmin(String courseID);
	boolean addCoursebyAdmin(Course newCourse) throws RecordNotFoundException,RecordAlreadyExistException;
	boolean updateCoursebyAdmin(Course updatedCourse) throws RecordNotFoundException;
	boolean deleteCoursebyAdmin(String courseID) throws RecordNotFoundException;
	
	/**
	 * ����userID����������������δ��ѯ���˻�(��ʦ/ѧ��)�򽫷���-1
	 * @param String
	 * @return double
	 */
	public double queryAccountByUserID(String userID);
}
