package vcampus.server.dao;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import vcampus.server.exception.*;

import vcampus.vo.Student;

/**
 * @author Yuqifan
 *
 */
public class StudentDaoImpl implements StudentDao{
	
	private DBConnection DBC=new DBConnection();
	private PreparedStatement stmt=null;
	private ResultSet rs=null;
	
	private Student ResultSetToStudent(){
		try {
			Student std=new Student();
			std.setName(rs.getString("studentName"));
			std.setPassword(rs.getString("password"));
			std.setSex(rs.getString("sex"));
			std.setId(rs.getString("id"));
			std.setDeptName(rs.getString("deptName"));
			std.setEmailAddress(rs.getString("emailAddress"));
			std.setPhoneNumber(rs.getString("phoneNumber"));
			std.setMoney(rs.getDouble("money"));
			std.setStudentID(rs.getString("studentID"));
			std.setMajor(rs.getString("major"));
			std.setGrade(rs.getString("grade"));
			return std;
		}
		catch (Exception e) {
			// TODO: handle exception
            System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
    
	@Override
	public Student findByID(String id) {
		try {
			String sql= "select * from students where id ="+ "'"+ id+"'";
			stmt=DBC.con.prepareStatement(sql);
			rs = stmt.executeQuery();

			if(rs.next()) {
				return ResultSetToStudent();
			}
		}
		catch (SQLException e) {
            System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean insertByUserNameAndPassword(String id,String password)
			throws RecordAlreadyExistException{
		try {
			Student std1=findByID(id);
			if(std1!=null)throw new RecordAlreadyExistException();
			//UPDATE students
			String sql = "INSERT INTO students (id, password) VALUES ( '"+id+"' , '"+password+"' )";
			stmt=DBC.con.prepareStatement(sql);
			stmt.executeUpdate();
		}
		catch (SQLException e) {
            System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean updateSelfInformation(Student std)
			throws RecordNotFoundException {
		try {
			Student std1=findByID(std.getId());
			if(std1==null)throw new RecordNotFoundException();
			//UPDATE tbl_student
			String sql="UPDATE students SET sex=?,studentName=?,deptName=?,emailAddress=?,"
					+ "phoneNumber=?,money=?,studentID=?,major=?,grade=?"
					+ "WHERE id=?";
			
			stmt=DBC.con.prepareStatement(sql);
			stmt.setString(1, std.getSex());
			stmt.setString(2, std.getName());
			stmt.setString(3, std.getDeptName());
			stmt.setString(4, std.getEmailAddress());
			stmt.setString(5, std.getPhoneNumber());
			stmt.setDouble(6, std.getMoney());
			stmt.setString(7, std.getStudentID());
			stmt.setString(8, std.getMajor());
			stmt.setString(9, std.getGrade());
			stmt.setString(10, std.getId());
			stmt.executeUpdate();
			
		}
		catch (SQLException e) {
            System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean updatePassword(String id,String password)
			throws RecordNotFoundException{
		try {
			Student std1=findByID(id);
			if(std1==null)throw new RecordNotFoundException();
			String sql="UPDATE students SET password=? WHERE id=?";
			stmt=DBC.con.prepareStatement(sql);
			stmt.setString(1, password);
			stmt.setString(2, id);
			stmt.executeUpdate();
		}
		catch (SQLException e) {
            System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean deleteStudent(String id)
			throws RecordNotFoundException{
		try {
			Student std1=findByID(id);
			if(std1==null)throw new RecordNotFoundException();
			String studentID=std1.getStudentID();
			String sql = "DELETE FROM students WHERE id=?";
			stmt=DBC.con.prepareStatement(sql);
			stmt.setString(1,id);
			stmt.executeUpdate();
			
			//erase any self-information ABOUT this student in other tables
			String sqll = "DELETE FROM bookborrow WHERE id=?";
			stmt=DBC.con.prepareStatement(sqll);
			stmt.setString(1,id);
			stmt.executeUpdate();
			String sqll2 = "DELETE FROM coursechoose WHERE studentID=?";
			stmt=DBC.con.prepareStatement(sqll2);
			stmt.setString(1,studentID);
			stmt.executeUpdate();
			String sqll3 = "DELETE FROM productpurchase WHERE id=?";
			stmt=DBC.con.prepareStatement(sqll3);
			stmt.setString(1,id);
			stmt.executeUpdate();
			String sqll4 = "DELETE FROM recharge WHERE id=?";
			stmt=DBC.con.prepareStatement(sqll4);
			stmt.setString(1,id);
			stmt.executeUpdate();
		}
		catch (SQLException e) {
            System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}
}

