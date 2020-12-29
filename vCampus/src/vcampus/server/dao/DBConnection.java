package vcampus.server.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**�����ݿ⽨����ϵ
 * 
 * @author Yuqifan
 *
 */

public class DBConnection {
	Connection con = null;
	Statement s = null;
	ResultSet rs=null;
	public  DBConnection() {
	    try {
	    	   ///��������jar
	    	Class.forName("com.hxtt.sql.access.AccessDriver");
	    	   //ָ��Access���ݿ��ļ���λ��
	    	String url = "jdbc:Access:///C:/Users/Administrator/Desktop/Database1.mdb";// C:\Users\Administrator\Desktop
	    	   //��������
	    	con = DriverManager.getConnection(url, "", "");      
	    }
	    catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
