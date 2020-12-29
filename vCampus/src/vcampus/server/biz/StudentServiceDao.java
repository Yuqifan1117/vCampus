package vcampus.server.biz;

import java.util.ArrayList;

import vcampus.server.exception.OutOfLimitException;
import vcampus.server.exception.RecordAlreadyExistException;
import vcampus.server.exception.RecordNotFoundException;
import vcampus.server.exception.WrongPasswordException;
import vcampus.vo.CourseSelectNDrop;
import vcampus.vo.Course;
import vcampus.vo.Student;

	/**
	 * @author Yuqifan
	 *
	 * @version 0.0
	 * 
	 */
public interface StudentServiceDao {
	Student findByUserID(String userID) throws RecordNotFoundException;
	Student register(String userID, String studentPassword) throws  RecordAlreadyExistException; 
	Student login(String userID, String studentPassword) throws RecordNotFoundException, WrongPasswordException;
	Student updatePassword(String userID, String newStudentPassword) throws RecordNotFoundException;
	Student updateStudentInfo(Student updatedStudent) throws  RecordNotFoundException;
	boolean destroyStudent(String userID) throws RecordNotFoundException;
		
	ArrayList<Course> queryAllCourses(); 
	Course findCourseInformation(String courseID);
	ArrayList<CourseSelectNDrop> findAllChosenCourses(String studentID);
	boolean addCourse(String studentID,String courseID) throws RecordNotFoundException, RecordAlreadyExistException, OutOfLimitException;
	boolean deleteCourse(String studentID,String courseID) throws OutOfLimitException, RecordNotFoundException;		
}

