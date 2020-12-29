package vcampus.server.dao;




import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vcampus.server.exception.*;
import vcampus.vo.Teacher;

/**
 * @author YangHangyuan
 *
 */
public class TeacherDaoImpl implements TeacherDao{
	
	private DBConnection DBC=new DBConnection();
	private PreparedStatement stmt=null;
	private ResultSet rs=null;
	
	public Teacher ResultSetToTeacher(){
		Teacher std=new Teacher();
		try {
			std.setName(rs.getString("teacherName"));
			std.setPassword(rs.getString("password"));
			std.setSex(rs.getString("sex"));
			std.setId(rs.getString("id"));
			std.setDeptName(rs.getString("deptName"));
			std.setEmailAddress(rs.getString("emailAddress"));
			std.setPhoneNumber(rs.getString("phoneNumber"));
			std.setAccount(rs.getDouble("account"));
			std.setProfessionalTitle(rs.getString("professionalTitle"));
			std.setMoney(rs.getDouble("money"));
			std.setTeacherID(rs.getString("teacherID"));
		}
		catch (Exception e) {
			// TODO: handle exception
            System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return std;
	}
	
	@Override
	public Teacher findByID(String id){
		try {
			String sql= "SELECT * FROM teacher WHERE id ="+ "'"+ id+"'";
			stmt=DBC.con.prepareStatement(sql);
			rs = stmt.executeQuery();

			if(rs.next()) {
				return ResultSetToTeacher();
			}
		}
		catch (SQLException e) {
			// TODO: handle exception
            System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean insertByUserNameAndPassword(String id,String password)
			throws RecordAlreadyExistException{
		
		try {
			Teacher std1=findByID(id);
			if(std1!=null)throw new RecordAlreadyExistException();
			String sql = "INSERT INTO teacher (id, password) VALUES ( '"+id+"' , '"+password+"' )";
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
	public boolean updatePassword(String id,String password)
			throws RecordNotFoundException{
		try {
			Teacher std1=findByID(id);
			if(std1==null)throw new RecordNotFoundException();
			//create SQL string
			String sql="UPDATE teacher SET password=? WHERE id=?";
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

	@Override
	public boolean updateSelfInformation(Teacher std)
			throws RecordNotFoundException {
		try {
			Teacher std1=findByID(std.getId());
			if(std1==null)throw new RecordNotFoundException();
			
			//UPDATE teacher
			String sql="UPDATE teacher SET sex=?,teacherName=?,deptName=?,emailAddress=?,"
					+ "phoneNumber=?,account=?,money=?,teacherID=?,"
					+"professionalTitle=?, "
					+ "WHERE id=?";
			
			stmt=DBC.con.prepareStatement(sql);
			stmt.setString(1, std.getSex());
			stmt.setString(2, std.getName());
			stmt.setString(3, std.getDeptName());
			stmt.setString(4, std.getEmailAddress());
			stmt.setString(5, std.getPhoneNumber());
			stmt.setDouble(6, std.getAccount());
			stmt.setDouble(7, std.getMoney());
			stmt.setString(8, std.getTeacherID());
			stmt.setString(9, std.getProfessionalTitle());
			stmt.setString(10, std.getId());
			stmt.executeUpdate();

			//TODO : UPDATE other tables ABOUT this teacher
			String sqll="UPDATE courseinformation SET teacherName=? "
					+ "WHERE teacherUserID=?";
			stmt=DBC.con.prepareStatement(sqll);
			stmt.setString(1, std.getName());
			stmt.setString(2, std.getId());
			stmt.executeUpdate();
		}
		catch (SQLException e) {
			// TODO: handle exception
            System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteTeacher(String id)
			throws RecordNotFoundException {
		try {
			Teacher std1=findByID(id);
			if(std1==null)throw new RecordNotFoundException();
			String sql = "DELETE FROM teacher WHERE id=?";
			stmt=DBC.con.prepareStatement(sql);
			stmt.setString(1,id);
			stmt.executeUpdate();
			
			//TODO : erase any self-information in other tables
			String sqll = "DELETE FROM coursechoose WHERE teacherUserID=?";
			stmt=DBC.con.prepareStatement(sqll);
			stmt.setString(1,id);
			stmt.executeUpdate();
			String sqll2 = "DELETE FROM courseinformation WHERE teacherUserID=?";
			stmt=DBC.con.prepareStatement(sqll2);
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

