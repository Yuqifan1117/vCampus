package vcampus.server.dao;

import java.util.ArrayList;

import vcampus.server.exception.*;
import vcampus.vo.CourseSelectNDrop;
import vcampus.vo.Course;


public interface CourseChooseDao {
	/**
	 * 传入courseID参数,返回Course对象,未查询成功将返回null
	 * @param String
	 * @return course
	 */
    public Course findCourse(String courseID);
    
	/**
	 * 获取所有课程信息,返回ArrayList<Course>,未查询成功将返回null
	 * @param null
	 * @return ArrayList<course>
	 */
    public ArrayList<Course> allCourses();
    
    /**
	 * 传入studentID参数,返回ArrayList<CourseSelectNDrop>,未查询成功将返回null
	 * @param String
	 * @return ArrayList<CourseSelectNDrop>
	 */
    public ArrayList<CourseSelectNDrop> courseQueryByStudent(String studentID);
    
    /**
	 * 传入teacherUserID参数,返回ArrayList<CourseSelectNDrop>,未查询成功将返回null
	 * @param String
	 * @return ArrayList<CourseSelectNDrop>
	 */
    public ArrayList<CourseSelectNDrop> courseQueryByTeacher(String teacherUserID);
    
    /**
	 * 传入courseID参数,返回ArrayList<CourseSelectNDrop>,未查询成功将返回null
	 * @param String
	 * @return ArrayList<CourseSelectNDrop>
	 */
    public ArrayList<CourseSelectNDrop> courseQueryByCourse(String courseID);
    
    /**
	 * 传入studentID,courseID,若courseID不存在/该课程学生已选/人数达到上限则抛出异常,SQL异常返回false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 * @throws RecordAlreadyExistException
	 * @throws OutOfLimitException
	 */
    public boolean addCourseByStudent(String studentID,String courseID)throws RecordNotFoundException,RecordAlreadyExistException,OutOfLimitException;
    
    /**
	 * 传入studentID,courseID,若学生未选该课程/课程人数为0则抛出异常,SQL异常返回false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 * @throws OutOfLimitException
	 */
    public boolean deleteCourseByStudent(String studentID,String courseID)throws RecordNotFoundException,OutOfLimitException;
    
    /**
	 * 传入ArrayList<CourseSelectNDrop>包含学生选课以及对应的分数信息,若学生未选该课程则抛出异常,SQL异常返回false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 */
    public boolean updateScoreByTeacher(ArrayList<CourseSelectNDrop> scoreList)throws RecordNotFoundException;
    
    /**
	 * 传入Course,若包含的老师信息不存在或者课程信息已经存在则抛出异常,SQL异常返回false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 * @throws RecordAlreadyExistException
	 */
    public boolean addCourseByAdmin(Course course)throws RecordAlreadyExistException,RecordNotFoundException;
    
    /**
	 * 传入Course,若包含的老师信息不存在或者课程不存在则抛出异常(在uMsg中区分),SQL异常返回false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 */
    public boolean updateCourseByAdmin(Course course)throws RecordNotFoundException;
    
    /**
	 * 传入CourseID,若课程信息不存在则抛出异常,SQL异常返回false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 */
    public boolean deleteCourseByAdmin(String courseID)throws RecordNotFoundException;
}

