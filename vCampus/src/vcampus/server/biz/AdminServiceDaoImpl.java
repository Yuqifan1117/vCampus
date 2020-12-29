package vcampus.server.biz;



import java.util.ArrayList;

import vcampus.server.dao.AdminDao;
import vcampus.server.dao.AdminDaoImpl;
import vcampus.server.dao.CourseChooseDao;
import vcampus.server.dao.CourseChooseDaoImpl;
import vcampus.server.exception.RecordAlreadyExistException;
import vcampus.server.exception.RecordNotFoundException;
import vcampus.server.exception.WrongPasswordException;
import vcampus.vo.Admin;
import vcampus.vo.CourseSelectNDrop;
import vcampus.vo.Course;


public class AdminServiceDaoImpl implements AdminServiceDao{

	private AdminDao ad = new AdminDaoImpl();
	private CourseChooseDao ccd = new CourseChooseDaoImpl();
	
	
	@Override
	public Admin register(String ID, String password) throws RecordAlreadyExistException {
		// TODO Auto-generated method stub
		try {
			if(ad.insertAdmin(ID, password)) {
				Admin newAdmin = ad.selectAdmin(ID);
				return newAdmin;
			}
			
		} catch (RecordAlreadyExistException e) {
			// TODO: handle exception
			throw new RecordAlreadyExistException();
		}
		return null;
	}
	
	
	
	
	@Override
	public Admin login(String ID, String password) throws RecordNotFoundException, WrongPasswordException {
		// TODO Auto-generated method stub
		try {
			Admin admin = ad.selectAdmin(ID);
			if(admin == null) throw new RecordNotFoundException();
			
			if(admin.getPassword().equals(password)) {
				return admin;
			}
			
			else throw new WrongPasswordException();
			
		} 
		catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}
		
		catch (WrongPasswordException e) {
			// TODO: handle exception
			throw new WrongPasswordException();
		}
		
	}
	
	
	
	
	@Override
	public Admin updatePassword(String ID, String password) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		try {
			if(ad.updatePassword(ID, password)) {
				return ad.selectAdmin(ID);
			}
			
		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}
		
		return null;
	}
	
	
	
	
	@Override
	public boolean destroy(String ID) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		try {
			if(ad.deleteAdmin(ID)) return true;
		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}
		return false;
	}
	
	
	
	/* (non-Javadoc)
	 * @see vCampus.server.biz.AdminServiceDao#courseQueryAdmin(java.lang.String)
	 */
	@Override
	public ArrayList<CourseSelectNDrop> courseQueryAdmin(String courseID) {
		// TODO Auto-generated method stub
		ArrayList<CourseSelectNDrop> res = ccd.courseQueryByCourse(courseID);
		if(res != null) return res;
		return null;
	}
	
	
	
	/* (non-Javadoc)
	 * @see vCampus.server.biz.AdminServiceDao#addCoursebyAdmin(vCampus.vo.CourseInformation)
	 */
	@Override
	public boolean addCoursebyAdmin(Course newCourse)
			throws RecordNotFoundException, RecordAlreadyExistException {
		// TODO Auto-generated method stub
		try {
			if(ccd.addCourseByAdmin(newCourse)) {
				return true;
			}
		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}
		
		catch (RecordAlreadyExistException e) {
			// TODO: handle exception
			throw new RecordAlreadyExistException();
		}
		return false;
	}
	
	
	
	/* (non-Javadoc)
	 * @see vCampus.server.biz.AdminServiceDao#updateCoursebyAdmin(vCampus.vo.CourseInformation)
	 */
	@Override
	public boolean updateCoursebyAdmin(Course updatedCourse) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		try {
			if(ccd.updateCourseByAdmin(updatedCourse)) {
				return true;
			}
		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}
		return false;
	}
	
	
	
	/* (non-Javadoc)
	 * @see vCampus.server.biz.AdminServiceDao#deleteCoursebyAdmin(java.lang.String)
	 */
	@Override
	public boolean deleteCoursebyAdmin(String courseID) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		try {
			if(ccd.deleteCourseByAdmin(courseID)) {
				return true;
			}
		} catch (RecordNotFoundException e) {
			// TODO: handle exception
			throw new RecordNotFoundException();
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see vCampus.server.biz.AdminServiceDao#queryAccountByUserName(java.lang.String)
	 */
	@Override
	public double queryAccountByUserID(String userID) {
		// TODO Auto-generated method stub
		return ad.queryAccountByUserID(userID);
		
	}
	
}
