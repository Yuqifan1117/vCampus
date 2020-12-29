package vcampus.server.dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;

import vcampus.server.exception.*;
import vcampus.vo.CourseSelectNDrop;
import vcampus.vo.Course;

/**
 * @author YangHangyuan
 *
 */
public class CourseChooseDaoImpl implements CourseChooseDao{
	
	private DBConnection DBC=new DBConnection();
	private PreparedStatement stmt=null;
	private ResultSet rs=null;
    
    private ArrayList<CourseSelectNDrop> ResultSetToCourseChooseArrayList(){
		try {
	    	ArrayList<CourseSelectNDrop> list=new ArrayList<CourseSelectNDrop>();
			CourseSelectNDrop c;
			do {
				c=new CourseSelectNDrop();
				c.setCourseID(rs.getString("courseID"));
				c.setCourseName(rs.getString("courseName"));
				c.setStudentID(rs.getString("studentID"));
				c.setTeacherUserID(rs.getString("teacherUserID"));
				c.setTeacherName(rs.getString("teacherName"));
				c.setScore(rs.getDouble("score"));
				list.add(c);
			}while(rs.next());
			return list;
		}
		catch (Exception e) {
			// TODO: handle exception
            System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
    
    private ArrayList<Course> ResultSetToCourseArrayListInformation(){
    	try {
	    	ArrayList<Course> list=new ArrayList<Course>();
			do {
		    	Course course;
		    	course=new Course();
	    		course.setCourseDay(rs.getInt("courseDay"));
	    		course.setCourseOrder(rs.getInt("courseOrder"));
	    		course.setCourseID(rs.getString("courseID"));
	    		course.setCourseName(rs.getString("courseName"));
	    		course.setCoursePlace(rs.getString("coursePlace"));
	    		course.setCredit(rs.getDouble("credit"));
	    		course.setCurrentNumber(rs.getInt("currentNumber"));
	    		course.setDeptName(rs.getString("deptName"));
	    		course.setNumberLimit(rs.getInt("numberLimit"));
	    		course.setTeacherName(rs.getString("teacherName"));
	    		course.setTeacherUserID(rs.getString("TeacherUserID"));
				list.add(course);
			}while(rs.next());
			return list;
		}
		catch (Exception e) {
			// TODO: handle exception
            System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
    }
    
    private Course ResultSetToCourseInformation() {
    	try {
    		Course course;
	    	course=new Course();
    		course.setCourseDay(rs.getInt("courseDay"));
    		course.setCourseOrder(rs.getInt("courseOrder"));
    		course.setCourseHour(rs.getInt("courseHour"));
    		course.setCourseID(rs.getString("courseID"));
    		course.setCourseName(rs.getString("courseName"));
    		course.setCoursePlace(rs.getString("coursePlace"));
    		course.setCredit(rs.getDouble("credit"));
    		course.setCurrentNumber(rs.getInt("currentNumber"));
    		course.setDeptName(rs.getString("deptName"));
    		course.setNumberLimit(rs.getInt("numberLimit"));
    		course.setTeacherName(rs.getString("teacherName"));
    		course.setTeacherUserID(rs.getString("TeacherUserID"));
    		return course;
    	}catch(Exception e) {
			// TODO: handle exception
            System.out.println(e.getMessage());
			e.printStackTrace();
    	}
    	return null;
    }
    
    @Override
    public Course findCourse(String courseID){
    	try {
    		String sql= "select * from courseinformation where courseID ="+ "'"+ courseID+"'";
			stmt=DBC.con.prepareStatement(sql);
			rs = stmt.executeQuery();

			if(rs.next()) {
				return ResultSetToCourseInformation();
			}
    	}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
    	}
    	return null;
    }
    
	@Override
	public ArrayList<Course> allCourses() {
		try {
    		String sql= "select * from courseinformation";
			stmt=DBC.con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				return ResultSetToCourseArrayListInformation();
			}
    	}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
    	}
    	return null;
	}
    
    @Override
	public ArrayList<CourseSelectNDrop> courseQueryByStudent(String studentID){
		try {
			String sql="SELECT * FROM coursechoose WHERE studentID='"+studentID+"'";
			stmt=DBC.con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				return ResultSetToCourseChooseArrayList();
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
		return null;
	}
	
	@Override
	public ArrayList<CourseSelectNDrop> courseQueryByTeacher(String teacherUserID){
		try {
			String sql="SELECT * FROM coursechoose WHERE teacherUserID='"+teacherUserID+"'";
			stmt=DBC.con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				return ResultSetToCourseChooseArrayList();
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<CourseSelectNDrop> courseQueryByCourse(String courseID){
		try {
			String sql="SELECT * FROM coursechoose WHERE courseID='"+courseID+"'";
			stmt=DBC.con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				return ResultSetToCourseChooseArrayList();
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
		return null;
	}

	@Override
    public boolean addCourseByStudent(String studentID,String courseID)
    		throws RecordNotFoundException,RecordAlreadyExistException,OutOfLimitException{
		try {
			String sql1="SELECT * FROM courseinformation WHERE courseID='"+courseID+"'";
			stmt=DBC.con.prepareStatement(sql1);
			rs = stmt.executeQuery();
			if(!rs.next())throw new RecordNotFoundException();
			int currentNumber=rs.getInt("currentNumber");
			int numberLimit=rs.getInt("numberLimit");
			String courseName=rs.getString("courseName");
			String teacherUserID=rs.getString("teacherUserID");
			String teacherName=rs.getString("teacherName");
			String sql2="SELECT * FROM coursechoose WHERE courseID='"+courseID+"' AND "
					+"studentID='"+studentID+"'";
			stmt=DBC.con.prepareStatement(sql2);
			rs = stmt.executeQuery();
			if(rs.next())throw new RecordAlreadyExistException();
			
			if(currentNumber==numberLimit)throw new OutOfLimitException();
			currentNumber++;
			//UPDATE tbl_courseinformation
			String sql="UPDATE courseinformation SET currentAmount = "+currentNumber+" WHERE courseID='"+courseID+"'";
			stmt=DBC.con.prepareStatement(sql);
			stmt.executeUpdate();

			//UPDATE tbl_coursechoose
			String sql3="INSERT INTO coursechoose (courseID,courseName,studentID,teacherUserID,teacherName,score)"
					+"VALUES (?,?,?,?,?)";
			stmt=DBC.con.prepareStatement(sql3);
			stmt.setString(1,courseID);
			stmt.setString(2,courseName);
			stmt.setString(3,studentID);
			stmt.setString(4, teacherUserID);
			stmt.setString(5, teacherName);
			stmt.setDouble(6, 0.0);
			stmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteCourseByStudent(String studentID, String courseID)
			throws RecordNotFoundException ,OutOfLimitException{
		try {
			String sql1="SELECT * FROM courseinformation WHERE courseID='"+courseID+"'";
			stmt=DBC.con.prepareStatement(sql1);
			rs = stmt.executeQuery();
			if(!rs.next())throw new RecordNotFoundException();
			int currentNumber=rs.getInt("currentNumber");
			String sql2="SELECT * FROM coursechoose WHERE courseID='"+courseID+"' AND "
					+"studentID='"+studentID+"'";
			stmt=DBC.con.prepareStatement(sql2);
			rs = stmt.executeQuery();
			if(!(rs.next()))throw new RecordNotFoundException();
			
			if(currentNumber==0)throw new OutOfLimitException();
			currentNumber--;
			//UPDATE tbl_courseinformation
			String sql="UPDATE tbl_courseinformation SET currentAmount = "+currentNumber
					+" WHERE courseID='"+courseID+"'";
			stmt=DBC.con.prepareStatement(sql);
			stmt.executeUpdate();
			
			//UPDATE tbl_coursechoose
			String sqll="DELETE FROM coursechoose WHERE courseID = '"+courseID
					+"' AND studentID='"+studentID+"'";
			stmt=DBC.con.prepareStatement(sqll);
			stmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean updateScoreByTeacher(ArrayList<CourseSelectNDrop> scoreList)
			throws RecordNotFoundException {
		try {
			int length=scoreList.size();
			for(int i=0;i<length;i++) {
				String sql="SELECT * FROM coursechoose WHERE courseID='"+scoreList.get(i).getCourseID()
						+"' AND studentID='"+scoreList.get(i).getStudentID()+"'";
				stmt=DBC.con.prepareStatement(sql);
				rs = stmt.executeQuery();
				if(!rs.next())throw new RecordNotFoundException(); 
				String sql1="UPDATE coursechoose SET score = "+scoreList.get(i).getScore()
						+" WHERE courseID = '"+scoreList.get(i).getCourseID()+"' AND studentID='"
						+scoreList.get(i).getStudentID()+"'";
				stmt=DBC.con.prepareStatement(sql1);
				stmt.executeUpdate();
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean addCourseByAdmin(Course course) throws RecordAlreadyExistException,RecordNotFoundException {
		try{
			Course course1=findCourse(course.getCourseID());
			if(course1!=null)throw new RecordAlreadyExistException();
			
			String sql1="SELECT * FROM teacher WHERE id=?";
			stmt=DBC.con.prepareStatement(sql1);
			stmt.setString(1, course.getTeacherUserID());
			rs=stmt.executeQuery();
			if(!rs.next())throw new RecordNotFoundException();
			
			String sql = "INSERT INTO courseinformation (courseID, courseName, deptName, "
				+"teacherUserID, teacherName, courseHour, credit, courseDay, courseOrder,"
				+ "coursePlace, numberLimit, ) "
				+"VALUES (?,?,?,?,?,?,?,?,?,?,?,?) ";
			
			stmt=DBC.con.prepareStatement(sql);
			stmt.setString(1, course.getCourseID());
			stmt.setString(2, course.getCourseName());
			stmt.setString(3, course.getDeptName());
			stmt.setString(4, course.getTeacherUserID());
			stmt.setString(5, course.getTeacherName());
			stmt.setInt(6, course.getCourseHour());
			stmt.setDouble(7, course.getCredit());
			stmt.setInt(8, course.getCourseDay());
			stmt.setInt(9, course.getCourseOrder());
			stmt.setString(10, course.getCoursePlace());
			stmt.setInt(11, course.getNumberLimit());
			stmt.setInt(12, course.getCurrentNumber());
			stmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean updateCourseByAdmin(Course course) throws RecordNotFoundException {
		try{
			Course course1=findCourse(course.getCourseID());
			if(course1==null) {
				RecordNotFoundException e=new RecordNotFoundException();
				e.setMsg("Course not found!");
				throw e;
			}
			

			String sql1="SELECT * FROM teacher WHERE name=?";
			stmt=DBC.con.prepareStatement(sql1);
			stmt.setString(1, course.getTeacherName());
			rs=stmt.executeQuery();
			if(!rs.next()) {
				RecordNotFoundException e=new RecordNotFoundException();
				e.setMsg("Teacher not found!");
				throw e;
			}
			
			String sql = "UPDATE courseinformation SET courseName =?,deptName =?,"
				+"teacherUserID=?,teacherName=?,courseHour=?, credit=?,courseDay=?,"
				+"courseOrder=?,coursePlace=?,numberLimit=?,currentNumber=? "
				+"WHERE courseID = ?";
			stmt=DBC.con.prepareStatement(sql);
			stmt.setString(1, course.getCourseName());
			stmt.setString(2, course.getDeptName());
			stmt.setString(3, course.getTeacherName());
			stmt.setString(4, course.getTeacherName());
			stmt.setInt(5, course.getCourseHour());
			stmt.setDouble(6, course.getCredit());
			stmt.setInt(7, course.getCourseDay());
			stmt.setInt(8, course.getCourseOrder());
			stmt.setString(9, course.getCoursePlace());
			stmt.setInt(10, course.getNumberLimit());
			stmt.setInt(11, course.getCurrentNumber());
			stmt.setString(12, course.getCourseID());
			stmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
			return false;	
		}
		return true;
	}

	@Override
	public boolean deleteCourseByAdmin(String courseID) throws RecordNotFoundException {
		try{
			Course course1=findCourse(courseID);
			if(course1==null)throw new RecordNotFoundException();
			
			String sql="DELETE FROM coursechoose WHERE courseID='"+courseID+"'";
			stmt=DBC.con.prepareStatement(sql);
			stmt.executeUpdate();

			String sql1="DELETE FROM courseinformation WHERE courseID='"+courseID+"'";
			stmt=DBC.con.prepareStatement(sql1);
			stmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
			return false;	
		}
		return true;
	}

}
