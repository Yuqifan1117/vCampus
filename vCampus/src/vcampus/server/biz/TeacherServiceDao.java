package vcampus.server.biz;

import java.util.ArrayList;

import vcampus.server.exception.RecordAlreadyExistException;
import vcampus.server.exception.RecordNotFoundException;
import vcampus.server.exception.WrongPasswordException;
import vcampus.vo.CourseSelectNDrop;
import vcampus.vo.Teacher;

public interface TeacherServiceDao {

	Teacher login(String userID, String password) throws RecordNotFoundException,WrongPasswordException;
	Teacher register(String userID, String password) throws RecordAlreadyExistException;
	Teacher updatePassword(String userID, String newPassword) throws RecordNotFoundException;
	Teacher updateTeacherInfo(Teacher updatedTeacher) throws RecordNotFoundException;
	boolean destoryTeacher(String userID) throws RecordNotFoundException;
	
	boolean updateStudentGrades(ArrayList<CourseSelectNDrop> gradesSheet) throws RecordNotFoundException;
	ArrayList<CourseSelectNDrop> findAllTeachCourses(String teacherUserID);
}
