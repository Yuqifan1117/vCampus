package vcampus.server.dao;
import java.sql.ResultSet;


import java.sql.SQLException;
import java.util.ArrayList;

import vcampus.vo.*;
import java.sql.PreparedStatement;
import vcampus.server.exception.*;

/**
 * @author Yu
 *
 */
public class AdminDaoImpl implements AdminDao{
	
	private DBConnection DBC=new DBConnection();
	private PreparedStatement stmt=null;
	private ResultSet rs=null;
	
	private ArrayList<Student> ResultSetToStudentInformationArrayList(){
		try {
			ArrayList<Student> list=new ArrayList<Student>();
			do {
				Student Student;
				Student=new Student();
				Student.setId(rs.getString("id"));
				Student.setStudentID(rs.getString("studentID"));
				Student.setAge(rs.getInt("age"));
				Student.setName(rs.getString("studentName"));
				Student.setSex(rs.getString("sex"));
				Student.setMajor(rs.getString("major"));
				Student.setBirth(rs.getString("birth"));
				Student.setGrade(rs.getString("grade"));
				Student.setSchyear(rs.getInt("schyear"));
				Student.setAcademy(rs.getString("academy"));
				Student.setDate(rs.getString("tdate"));
				Student.setEmailAddress(rs.getString("emailAddress"));
				list.add(Student);
			}while(rs.next());
			return list;
		}catch(Exception e) {
			// TODO: handle exception
            System.out.println(e.getMessage());
			e.printStackTrace();
    	}
		return null;
	}
	private ArrayList<Teacher> ResultSetToTeacherInformationArrayList(){
		try {
			ArrayList<Teacher> list=new ArrayList<Teacher>();
			do {
				Teacher Teacher;
				Teacher=new Teacher();
				Teacher.setId(rs.getString("id"));
				Teacher.setName(rs.getString("teacherName"));
				Teacher.setSex(rs.getString("sex"));
				Teacher.setBirth(rs.getString("birth"));
				Teacher.setAccount(rs.getDouble("account"));
				Teacher.setMoney(rs.getDouble("money"));
				Teacher.setPhoneNumber(rs.getString("phoneNumber"));
				Teacher.setProfessionalTitle(rs.getString("professionalTitle"));
				Teacher.setEmailAddress(rs.getString("emailAddress"));
				Teacher.setTeacherID(rs.getString("teacherID"));
				Teacher.setWorkplace(rs.getString("workplace"));
				list.add(Teacher);
			}while(rs.next());
			return list;
		}catch(Exception e) {
			// TODO: handle exception
            System.out.println(e.getMessage());
			e.printStackTrace();
    	}
		return null;
	}
	public ArrayList<Student> queryAllStudent(){
		try {
			String sql="SELECT * FROM students";
			stmt=DBC.con.prepareStatement(sql);
			rs = stmt.executeQuery();

			if(rs.next()) {
				return ResultSetToStudentInformationArrayList();
			}
		}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<Student> queryStudentByMajor(String major) {
		try {
			String sql="SELECT * FROM students WHERE major ='"+major+"'";
			stmt=DBC.con.prepareStatement(sql);
			rs = stmt.executeQuery();

			if(rs.next()) {
				return ResultSetToStudentInformationArrayList();
			}
		}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<Student> queryStudentByDate(String date) {
		try {
			String sql="SELECT * FROM students WHERE date ='"+date+"'";
			stmt=DBC.con.prepareStatement(sql);
			rs = stmt.executeQuery();

			if(rs.next()) {
				return ResultSetToStudentInformationArrayList();
			}
		}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<Student> queryStudentByGrade(String grade) {
		try {
			String sql="SELECT * FROM students WHERE grade ='"+grade+"'";
			stmt=DBC.con.prepareStatement(sql);
			rs = stmt.executeQuery();

			if(rs.next()) {
				return ResultSetToStudentInformationArrayList();
			}
		}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<Student> queryStudentByAcademy(String academy){
		try {
			String sql="SELECT * FROM students WHERE academy ='"+academy+"'";
			stmt=DBC.con.prepareStatement(sql);
			rs = stmt.executeQuery();

			if(rs.next()) {
				return ResultSetToStudentInformationArrayList();
			}
		}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<Student> queryStudentByStudentID(String studentID){
		try {
			String sql="SELECT * FROM students WHERE id ='"+studentID+"'";
			stmt=DBC.con.prepareStatement(sql);
			rs = stmt.executeQuery();

			if(rs.next()) {
				return ResultSetToStudentInformationArrayList();
			}
		}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<Teacher> queryAllTeacher(){
		try {
			String sql="SELECT * FROM teacher";
			stmt=DBC.con.prepareStatement(sql);
			rs = stmt.executeQuery();

			if(rs.next()) {
				return ResultSetToTeacherInformationArrayList();
			}
		}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<Teacher> queryTeacherByWorkplace(String workplace){
		try {
			String sql="SELECT * FROM teacher WHERE workplace ='"+workplace+"'";
			stmt=DBC.con.prepareStatement(sql);
			rs = stmt.executeQuery();

			if(rs.next()) {
				return ResultSetToTeacherInformationArrayList();
			}
		}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<Teacher> queryTeacherByWorkplaceProfessionalTitle(String professionalTitle){
		try {
			String sql="SELECT * FROM teacher WHERE professionalTitle ='"+professionalTitle+"'";
			stmt=DBC.con.prepareStatement(sql);
			rs = stmt.executeQuery();

			if(rs.next()) {
				return ResultSetToTeacherInformationArrayList();
			}
		}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
//	private ArrayList<Student> ResultSetToStudentInformationArrayList(){
//		try {
//			ArrayList<Student> list=new ArrayList<Student>();
//			do {
//				Student Student;
//				Student=new Student();
//				Student.setStudentID(rs.getString("studentID"));
//				Student.setAge(rs.getInt("age"));
//				Student.setName(rs.getString("name"));
//				Student.setSex(rs.getString("sex"));
//				Student.setMajor(rs.getString("major"));
//				Student.setBirth(rs.getString("birth"));
//				Student.setGrade(rs.getString("grade"));
//				Student.setSchyear(rs.getInt("schyear"));
//				Student.setAcademy(rs.getString("academy"));
//				Student.setDate(rs.getString("date"));
//				Student.setEmailAddress(rs.getString("emailAddress"));
//				list.add(Student);
//			}while(rs.next());
//			return list;
//		}catch(Exception e) {
//			// TODO: handle exception
//            System.out.println(e.getMessage());
//			e.printStackTrace();
//    	}
//		return null;
//	}
//	private ArrayList<Teacher> ResultSetToTeacherInformationArrayList(){
//		try {
//			ArrayList<Teacher> list=new ArrayList<Teacher>();
//			do {
//				Teacher Teacher;
//				Teacher=new Teacher();
//
//				Teacher.setName(rs.getString("name"));
//				Teacher.setSex(rs.getString("sex"));
//				Teacher.setBirth(rs.getString("birth"));
//				Teacher.setAccount(rs.getDouble("account"));
//				Teacher.setMoney(rs.getDouble("money"));
//				Teacher.setPhoneNumber(rs.getString("phoneNumber"));
//				Teacher.setProfessionalTitle(rs.getString("professionTitle"));
//				Teacher.setEmailAddress(rs.getString("emailAddress"));
//				list.add(Teacher);
//			}while(rs.next());
//			return list;
//		}catch(Exception e) {
//			// TODO: handle exception
//            System.out.println(e.getMessage());
//			e.printStackTrace();
//    	}
//		return null;
//	}
//	public ArrayList<Student> queryAllStudent(){
//		try {
//			String sql="SELECT * FROM students";
//			
//			stmt=DBC.con.prepareStatement(sql);
//			rs = stmt.executeQuery();
//
//			if(rs.next()) {
//				return ResultSetToStudentInformationArrayList();
//			}
//		}catch(SQLException e) {
//    		System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
//		return null;
//	}
//	public ArrayList<Student> queryStudentByMajor(String major) {
//		try {
//			String sql="SELECT * FROM students WHERE major ='"+major+"'";
//			stmt=DBC.con.prepareStatement(sql);
//			rs = stmt.executeQuery();
//
//			if(rs.next()) {
//				return ResultSetToStudentInformationArrayList();
//			}
//		}catch(SQLException e) {
//    		System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
//		return null;
//	}
//	public ArrayList<Student> queryStudentByDate(String date) {
//		try {
//			String sql="SELECT * FROM students WHERE date ='"+date+"'";
//			stmt=DBC.con.prepareStatement(sql);
//			rs = stmt.executeQuery();
//
//			if(rs.next()) {
//				return ResultSetToStudentInformationArrayList();
//			}
//		}catch(SQLException e) {
//    		System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
//		return null;
//	}
//	public ArrayList<Student> queryStudentByGrade(String grade) {
//		try {
//			String sql="SELECT * FROM students WHERE grade ='"+grade+"'";
//			stmt=DBC.con.prepareStatement(sql);
//			rs = stmt.executeQuery();
//
//			if(rs.next()) {
//				return ResultSetToStudentInformationArrayList();
//			}
//		}catch(SQLException e) {
//    		System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
//		return null;
//	}
//	public ArrayList<Student> queryStudentByAcademy(String academy){
//		try {
//			String sql="SELECT * FROM students WHERE academy ='"+academy+"'";
//			stmt=DBC.con.prepareStatement(sql);
//			rs = stmt.executeQuery();
//
//			if(rs.next()) {
//				return ResultSetToStudentInformationArrayList();
//			}
//		}catch(SQLException e) {
//    		System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
//		return null;
//	}
//	public ArrayList<Student> queryStudentByStudentID(String studentID){
//		try {
//			String sql="SELECT * FROM students WHERE studentID ='"+studentID+"'";
//			stmt=DBC.con.prepareStatement(sql);
//			rs = stmt.executeQuery();
//
//			if(rs.next()) {
//				return ResultSetToStudentInformationArrayList();
//			}
//		}catch(SQLException e) {
//    		System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
//		return null;
//	}
//	public ArrayList<Teacher> queryAllTeacher(){
//		try {
//			String sql="SELECT * FROM teacher";
//			stmt=DBC.con.prepareStatement(sql);
//			rs = stmt.executeQuery();
//
//			if(rs.next()) {
//				return ResultSetToTeacherInformationArrayList();
//			}
//		}catch(SQLException e) {
//    		System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
//		return null;
//	}
//	public ArrayList<Teacher> queryTeacherByWorkplace(String workplace){
//		try {
//			String sql="SELECT * FROM teacher WHERE workplace ='"+workplace+"'";
//			stmt=DBC.con.prepareStatement(sql);
//			rs = stmt.executeQuery();
//
//			if(rs.next()) {
//				return ResultSetToTeacherInformationArrayList();
//			}
//		}catch(SQLException e) {
//    		System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
//		return null;
//	}
//	public ArrayList<Teacher> queryTeacherByWorkplaceProfessionalTitle(String professionalTitle){
//		try {
//			String sql="SELECT * FROM teacher WHERE professionalTitle ='"+professionalTitle+"'";
//			stmt=DBC.con.prepareStatement(sql);
//			rs = stmt.executeQuery();
//
//			if(rs.next()) {
//				return ResultSetToTeacherInformationArrayList();
//			}
//		}catch(SQLException e) {
//    		System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
//		return null;
//	}
	@Override
	public double queryAccountByUserID(String userID) {
		StudentDao aDao=new StudentDaoImpl();
		Student std=aDao.findByID(userID);
		if(std==null) {
			TeacherDao tDao=new TeacherDaoImpl();
			Teacher tea=tDao.findByID(userID);
			if(tea!=null)tea.getAccount();
		}else return std.getAccount();
		return -1;
	}
	
	@Override
	public Admin selectAdmin(String adminID){
		String sql="SELECT * FROM admin WHERE adminID=?";
		try {
			stmt=DBC.con.prepareStatement(sql);
			stmt.setString(1,adminID);
			rs = stmt.executeQuery();
			if(rs.next()){
				Admin admin=new Admin();
				admin.setAdminID(rs.getString("adminID"));
				admin.setPassword(rs.getString("password"));
				return admin;
			}
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	} 	
	
	@Override
	public boolean insertAdmin(String adminID,String password)
			throws RecordAlreadyExistException{		
		try {
			Admin admin=selectAdmin(adminID);
			if(admin!=null)throw new RecordAlreadyExistException();
			//UPDATE tbl_admin
			String sql="INSERT INTO admin (adminID,password) VALUES (?,?)";
			stmt=DBC.con.prepareStatement(sql);
			stmt.setString(1,adminID);
			stmt.setString(2,password);
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
	public boolean updatePassword(String adminID,String password)
			throws RecordNotFoundException{
		try{
			Admin admin=selectAdmin(adminID);
			if(admin==null)throw new RecordNotFoundException();
			//UPDATE tbl_admin
			String sql="UPDATE admin SET password=? WHERE adminID=?";
			stmt=DBC.con.prepareStatement(sql);
			stmt.setString(1, password);
			stmt.setString(2, adminID);
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
	public boolean deleteAdmin(String adminID)
			throws RecordNotFoundException {
		try{
			Admin admin=selectAdmin(adminID);
			if(admin==null)throw new RecordNotFoundException();
			//UPDATE tbl_admin
			String sql="DELETE FROM admin WHERE adminID=?";
			stmt=DBC.con.prepareStatement(sql);
			stmt.setString(1, adminID);
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
