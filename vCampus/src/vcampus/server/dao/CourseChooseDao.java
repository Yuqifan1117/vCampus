package vcampus.server.dao;

import java.util.ArrayList;

import vcampus.server.exception.*;
import vcampus.vo.CourseSelectNDrop;
import vcampus.vo.Course;


public interface CourseChooseDao {
	/**
	 * ����courseID����,����Course����,δ��ѯ�ɹ�������null
	 * @param String
	 * @return course
	 */
    public Course findCourse(String courseID);
    
	/**
	 * ��ȡ���пγ���Ϣ,����ArrayList<Course>,δ��ѯ�ɹ�������null
	 * @param null
	 * @return ArrayList<course>
	 */
    public ArrayList<Course> allCourses();
    
    /**
	 * ����studentID����,����ArrayList<CourseSelectNDrop>,δ��ѯ�ɹ�������null
	 * @param String
	 * @return ArrayList<CourseSelectNDrop>
	 */
    public ArrayList<CourseSelectNDrop> courseQueryByStudent(String studentID);
    
    /**
	 * ����teacherUserID����,����ArrayList<CourseSelectNDrop>,δ��ѯ�ɹ�������null
	 * @param String
	 * @return ArrayList<CourseSelectNDrop>
	 */
    public ArrayList<CourseSelectNDrop> courseQueryByTeacher(String teacherUserID);
    
    /**
	 * ����courseID����,����ArrayList<CourseSelectNDrop>,δ��ѯ�ɹ�������null
	 * @param String
	 * @return ArrayList<CourseSelectNDrop>
	 */
    public ArrayList<CourseSelectNDrop> courseQueryByCourse(String courseID);
    
    /**
	 * ����studentID,courseID,��courseID������/�ÿγ�ѧ����ѡ/�����ﵽ�������׳��쳣,SQL�쳣����false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 * @throws RecordAlreadyExistException
	 * @throws OutOfLimitException
	 */
    public boolean addCourseByStudent(String studentID,String courseID)throws RecordNotFoundException,RecordAlreadyExistException,OutOfLimitException;
    
    /**
	 * ����studentID,courseID,��ѧ��δѡ�ÿγ�/�γ�����Ϊ0���׳��쳣,SQL�쳣����false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 * @throws OutOfLimitException
	 */
    public boolean deleteCourseByStudent(String studentID,String courseID)throws RecordNotFoundException,OutOfLimitException;
    
    /**
	 * ����ArrayList<CourseSelectNDrop>����ѧ��ѡ���Լ���Ӧ�ķ�����Ϣ,��ѧ��δѡ�ÿγ����׳��쳣,SQL�쳣����false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 */
    public boolean updateScoreByTeacher(ArrayList<CourseSelectNDrop> scoreList)throws RecordNotFoundException;
    
    /**
	 * ����Course,����������ʦ��Ϣ�����ڻ��߿γ���Ϣ�Ѿ��������׳��쳣,SQL�쳣����false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 * @throws RecordAlreadyExistException
	 */
    public boolean addCourseByAdmin(Course course)throws RecordAlreadyExistException,RecordNotFoundException;
    
    /**
	 * ����Course,����������ʦ��Ϣ�����ڻ��߿γ̲��������׳��쳣(��uMsg������),SQL�쳣����false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 */
    public boolean updateCourseByAdmin(Course course)throws RecordNotFoundException;
    
    /**
	 * ����CourseID,���γ���Ϣ���������׳��쳣,SQL�쳣����false
	 * @param String
	 * @return boolean
	 * @throws RecordNotFoundException
	 */
    public boolean deleteCourseByAdmin(String courseID)throws RecordNotFoundException;
}

