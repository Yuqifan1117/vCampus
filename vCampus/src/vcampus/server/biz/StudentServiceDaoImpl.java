package vcampus.server.biz;

import java.util.ArrayList;

import vcampus.server.dao.CourseChooseDao;
import vcampus.server.dao.CourseChooseDaoImpl;
import vcampus.server.dao.StudentDao;
import vcampus.server.dao.StudentDaoImpl;
import vcampus.server.exception.OutOfLimitException;
import vcampus.server.exception.RecordAlreadyExistException;
import vcampus.server.exception.RecordNotFoundException;
import vcampus.server.exception.WrongPasswordException;
import vcampus.vo.CourseSelectNDrop;
import vcampus.vo.Course;
import vcampus.vo.Student;

/**
 * @author
 *
 * @version 0.0
 * 
 */
public class StudentServiceDaoImpl implements StudentServiceDao {

	private StudentDao sd = new StudentDaoImpl();
	private CourseChooseDao ccd = new CourseChooseDaoImpl();

	/*
	 * (non-Javadoc)
	 * 
	 * @see vCampus.server.biz.StudentServiceDao#login(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Student login(String userID, String studentPassword) throws RecordNotFoundException, WrongPasswordException {
		// TODO Auto-generated method stub
		try {
			Student student1 = sd.findByID(userID);
			if (student1 == null)
				throw new RecordNotFoundException();
			if (student1.getPassword().equals(studentPassword)) {
				return student1;
			} else {
				throw new WrongPasswordException();
			}
		}

		catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}

		catch (WrongPasswordException e) {
			throw new WrongPasswordException();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vCampus.server.biz.StudentServiceDao#register(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Student register(String userID, String studentPassword) throws RecordAlreadyExistException {
		// TODO Auto-generated method stub
		try {
			if (sd.insertByUserNameAndPassword(userID, studentPassword)) {
				Student newStudent = sd.findByID(userID);
				return newStudent;
			}

		} catch (RecordAlreadyExistException e) {
			// TODO: handle exception
			throw new RecordAlreadyExistException();
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vCampus.server.biz.StudentServiceDao#updatePassword(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Student updatePassword(String userID, String newStudentPassword) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		try {
			if (sd.updatePassword(userID, newStudentPassword)) {
				Student student = sd.findByID(userID);
				return student;
			}

		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}

		return null;
	}

	@Override
	public Student updateStudentInfo(Student updatedStudent) throws RecordNotFoundException {
		// TODO Auto-generated method stub

		try {
			if (sd.updateSelfInformation(updatedStudent)) {
				Student updatedStudent1 = sd.findByID(updatedStudent.getId());
				return updatedStudent1;
			}

		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}

		return null;
	}

	@Override
	public boolean destroyStudent(String userID) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		try {
			if (sd.deleteStudent(userID))
				return true;
		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}
		return false;
	}

	@Override
	public Course findCourseInformation(String courseID) {
		// TODO Auto-generated method stub

		Course courseInformation = ccd.findCourse(courseID);
		if (courseInformation != null)
			return courseInformation;

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vCampus.server.biz.StudentServiceDao#findAllChosenCourses(java.lang.String)
	 */
	@Override
	public ArrayList<CourseSelectNDrop> findAllChosenCourses(String studentID) {
		// TODO Auto-generated method stub
		if (ccd.courseQueryByStudent(studentID) != null) {
			return ccd.courseQueryByStudent(studentID);
		}
		return null;
	}

	@Override
	public boolean addCourse(String studentID, String courseID)
			throws RecordNotFoundException, RecordAlreadyExistException, OutOfLimitException {
		// TODO Auto-generated method stub
		try {
			if (ccd.addCourseByStudent(studentID, courseID)) {
				return true;
			}
			return false;
		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}

		catch (RecordAlreadyExistException e) {
			// TODO: handle exception
			throw new RecordAlreadyExistException();
		}

		catch (OutOfLimitException e) {
			// TODO: handle exception
			throw new OutOfLimitException();
		}
	}

	@Override
	public boolean deleteCourse(String studentID, String courseID) throws OutOfLimitException, RecordNotFoundException {
		// TODO Auto-generated method stub
		try {
			if (ccd.deleteCourseByStudent(studentID, courseID)) {
				return true;
			}
			return false;
		} catch (RecordNotFoundException e) {
			// TODO: handle exception

			throw new RecordNotFoundException();

		} catch (OutOfLimitException e) {
			// TODO: handle exception
			throw new OutOfLimitException();
		}

	}

	@Override
	public Student findByUserID(String userID) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		if (sd.findByID(userID) != null) {
			return sd.findByID(userID);
		}
		return null;
	}

	@Override
	public ArrayList<Course> queryAllCourses() {
		// TODO Auto-generated method stub
		ArrayList<Course> allAvaiableCoureses = ccd.allCourses();
		if (allAvaiableCoureses != null) {
			return allAvaiableCoureses;
		}
		return null;
	}
}
