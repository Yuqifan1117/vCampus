package vcampus.server.dao;

import vcampus.server.exception.*;
import vcampus.vo.Account;
import vcampus.vo.Student;
import vcampus.vo.Teacher;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BankDaoImpl implements BankDao{

	private DBConnection DBC=new DBConnection();
	private PreparedStatement stmt=null;
	private ResultSet rs=null;
	
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
	public double queryMoneyByUserID(String userID) {
		StudentDao aDao=new StudentDaoImpl();
		Student std=aDao.findByID(userID);
		if(std==null) {
			TeacherDao tDao=new TeacherDaoImpl();
			Teacher tea=tDao.findByID(userID);
			if(tea!=null)tea.getMoney();
		}else return std.getMoney();
		return -1;
	}
	private ArrayList<Account> ResultSetToRechargeArrayList(){
		try {
			ArrayList<Account> list=new ArrayList<Account>();
			do {
				Account Account;
				Account=new Account();
				Account.setUserID(rs.getString("userID"));
				Account.setRechargeTime(rs.getDate("rechargeTime"));
				Account.setAmount(rs.getInt("amount"));
				list.add(Account);
			}while(rs.next());
			return list;
		}catch(Exception e) {
			// TODO: handle exception
            System.out.println(e.getMessage());
			e.printStackTrace();
    	}
		return null;
	}
	public ArrayList<Account> queryRechargeInformation(String userID){
		try {
			String sql="SELECT * FROM recharge WHERE userID='"+userID+"'";
			stmt=DBC.con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				return ResultSetToRechargeArrayList();
			}
		}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
		
	}
	@Override
	public boolean rechargeByBankAccount(Account charge_account)
			throws OutOfLimitException, RecordNotFoundException {
		try {
			String sql1="SELECT * FROM student WHERE userID='"+charge_account.getUserID()+"'";
			stmt=DBC.con.prepareStatement(sql1);
			rs=stmt.executeQuery();
			if(!rs.next())throw new RecordNotFoundException();
			
			double account=rs.getDouble("account");
			double money=rs.getDouble("money");
			if(account<charge_account.getAmount())throw new OutOfLimitException();
			account-=charge_account.getAmount();
			money+=charge_account.getAmount();
			
			//UPDATE tbl_student
			String sql="UPDATE student SET account=?,money=? WHERE userID=?";
			stmt=DBC.con.prepareStatement(sql);
			stmt.setDouble(1,account);
			stmt.setDouble(2,money);
			stmt.setString(3,charge_account.getUserID());
			stmt.executeUpdate();
			Date ts = new Date(System.currentTimeMillis());
			//UPDATE tbl_recharge
			String sqll="INSERT INTO recharge (userID,rechargeTime,amount) "
					+ " VALUES (?,?,?)";
			stmt=DBC.con.prepareStatement(sqll);
			stmt.setString(1,charge_account.getUserID());
			stmt.setDate(2, ts);
			stmt.setDouble(3, charge_account.getAmount());
			stmt.executeUpdate();
			
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
