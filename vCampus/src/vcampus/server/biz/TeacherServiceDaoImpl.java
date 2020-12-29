package vcampus.server.biz;

import java.util.ArrayList;

import vcampus.server.dao.CourseChooseDao;
import vcampus.server.dao.CourseChooseDaoImpl;
import vcampus.server.dao.TeacherDao;
import vcampus.server.dao.TeacherDaoImpl;
import vcampus.server.exception.RecordAlreadyExistException;
import vcampus.server.exception.RecordNotFoundException;
import vcampus.server.exception.WrongPasswordException;
import vcampus.vo.CourseSelectNDrop;
import vcampus.vo.Teacher;

public class TeacherServiceDaoImpl implements TeacherServiceDao {

	private TeacherDao td = new TeacherDaoImpl();
	private CourseChooseDao ccd = new CourseChooseDaoImpl();
	
	@Override
	public Teacher login(String userID, String password) throws RecordNotFoundException, WrongPasswordException {
		// TODO Auto-generated method stub
		try {
			Teacher teacher1 = td.findByID(userID);
			if(teacher1 == null) throw new RecordNotFoundException();
			if(teacher1.getPassword().equals(password)) {
				return teacher1;
			}
			else {
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
	
	
	@Override
	public Teacher register(String userID, String password) throws RecordAlreadyExistException {
		// TODO Auto-generated method stub
		
		try {
			if(td.insertByUserNameAndPassword(userID, password)) {
				Teacher newTeacher = td.findByID(userID);
				return newTeacher;
			}
			
		} catch (RecordAlreadyExistException e) {
			// TODO: handle exception
			throw new RecordAlreadyExistException();
		}
		
		
		return null;
	}
	
	
	
	@Override
	public Teacher updatePassword(String userID, String newPassword) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		try {
			if(td.updatePassword(userID, newPassword)) {
				Teacher teacher = td.findByID(userID);
				return teacher;
			}
			
		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}
		
		return null;
	}
	 
	
	@Override
	public Teacher updateTeacherInfo(Teacher updatedTeacher) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		try {
			if(td.updateSelfInformation(updatedTeacher)) {
				Teacher updatedTeacher1 = td.findByID(updatedTeacher.getId());
				return updatedTeacher1;
			}
			
		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}
		
		return null;
	}
	
	@Override
	public boolean destoryTeacher(String userID) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		try {
			if(td.deleteTeacher(userID)) return true;
		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}
		return false;
	}
	
	
	@Override
	public boolean updateStudentGrades(ArrayList<CourseSelectNDrop> gradesSheet) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		try {
			if(ccd.updateScoreByTeacher(gradesSheet)) {
				return true;
			}
		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}
		
		return false;
	}
	
	
	@Override
	public ArrayList<CourseSelectNDrop> findAllTeachCourses(String teacherUserID) {
		// TODO Auto-generated method stub
		if(ccd.courseQueryByTeacher(teacherUserID) != null){
			return ccd.courseQueryByTeacher(teacherUserID);
		}
		return null;
	}
	
}
