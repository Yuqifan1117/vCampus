package vcampus.server.dao;

import java.util.ArrayList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import vcampus.server.dao.DBConnection;
import vcampus.server.dao.ShopDao;
import vcampus.server.exception.*;
import vcampus.vo.*;


/**
 * @author Yu
 *
 */
public class ShopDaoImpl implements ShopDao{

	private DBConnection DBC=new DBConnection();
	private PreparedStatement stmt=null;
	private ResultSet rs=null;
	
	private ArrayList<ProductPurchase> ResultSetToProductPurchaseArrayList(){
		try {
			 ArrayList<ProductPurchase> list=new ArrayList<ProductPurchase>();
			 
			 do {
				 ProductPurchase pp;
				 pp=new ProductPurchase();
				 pp.setProductID(rs.getString("productID"));
				 pp.setProductName(rs.getString("productName"));
				 pp.setPurchaseAmount(rs.getInt("purchaseAmount"));
				 pp.setPurchaseTime(rs.getDate("purchaseTime"));
				 pp.setUserID(rs.getString("userID"));
				 
				 list.add(pp);
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
	
	private ArrayList<ProductInformation> ResultSetToProductInformationArrayList(){
		try {
			ArrayList<ProductInformation> list=new ArrayList<ProductInformation>();
			
			do {
				ProductInformation pi;
				pi=new ProductInformation();
				pi.setAmount(rs.getInt("amount"));
				pi.setProductID(rs.getString("productID"));
				pi.setProductName(rs.getString("productName"));
				pi.setProductPrice(rs.getDouble("productPrice"));
				pi.setProductCost(rs.getDouble("productCost"));
				list.add(pi);
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
	
	private ProductInformation ResultSetToProductInformation() {
		try {
			ProductInformation pi;
			pi=new ProductInformation();
			pi.setAmount(rs.getInt("amount"));
			pi.setProductID(rs.getString("productID"));
			pi.setProductName(rs.getString("productName"));
			pi.setProductPrice(rs.getDouble("productPrice"));
			pi.setProductCost(rs.getDouble("productCost"));
			return pi;
		}
		catch (Exception e) {
			// TODO: handle exception
            System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public ArrayList<ProductPurchase> queryAccountCurrentByUserID(String userID) {
		try {
			String sql1="SELECT * FROM productpurchase WHERE userID='"+userID+"'";
			stmt=DBC.con.prepareStatement(sql1);
			rs=stmt.executeQuery();
			if(rs.next()) {
				return ResultSetToProductPurchaseArrayList();
			}
		}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<ProductPurchase> queryAccountCurrentByProductID(String productID) {
		try {
			String sql1="SELECT * FROM productpurchase WHERE productID='"+productID+"'";
			stmt=DBC.con.prepareStatement(sql1);
			rs=stmt.executeQuery();
			if(rs.next()) {
				return ResultSetToProductPurchaseArrayList();
			}
		}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ProductInformation queryProductInformation(String productID) {
		try {
			String sql1="SELECT * FROM productinformation WHERE productID='"+productID+"'";
			stmt=DBC.con.prepareStatement(sql1);
			rs=stmt.executeQuery();
			if(rs.next()) {
				return ResultSetToProductInformation();
			}
		}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<ProductInformation> queryAllProduct() {
		try {
			String sql1="SELECT * FROM productinformation";
			stmt=DBC.con.prepareStatement(sql1);
			rs=stmt.executeQuery();
			if(rs.next()) {
				return ResultSetToProductInformationArrayList();
			}
		}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	/* ProductPurchase 中的oneConsumpTion\currentAccount\purchaseTime为后台计算得出
	 * 
	 * */
	@Override
	public boolean buyProduct(ProductPurchase buyProduct,int type) 
			throws RecordNotFoundException, OutOfLimitException {
		try {
			//String table=new String(type==0?"students":"teacher");
			String sql1="SELECT * FROM productinformation WHERE productID='"
					+buyProduct.getProductID()+"'";
			stmt=DBC.con.prepareStatement(sql1);
			rs=stmt.executeQuery();
			if(!rs.next())throw new RecordNotFoundException();
			int amount=rs.getInt("amount");
			double price=rs.getDouble("productPrice");
			if(amount<buyProduct.getPurchaseAmount()) {
				OutOfLimitException e=new OutOfLimitException();
				e.setMsg("Amount is out of limit!");
				throw e;
			}
			amount-=buyProduct.getPurchaseAmount();
			/*
			String sql2="SELECT * FROM "+table+" WHERE userID='"+buyProduct.getUserID()+"'";
			stmt=DBC.con.prepareStatement(sql2);
			rs=stmt.executeQuery();
			if(!rs.next())throw new RecordNotFoundException();
			
			double OneConsumption=buyProduct.getPurchaseAmount()*price;
			double money=rs.getDouble("money");
			if(money<OneConsumption){
				OutOfLimitException e=new OutOfLimitException();
				e.setMsg("Balance in Ecard is insufficient!");
				throw e;
			}
			money-=OneConsumption;
			*/
			//UPDATE productpurchase
			String sql="INSERT INTO productpurchase (productID,productName,purchaseAmount,"
						+"userID,purchaseTime) VALUES (?,?,?,?,?)";
		    Date ts = new Date(System.currentTimeMillis());
			stmt=DBC.con.prepareStatement(sql);
			stmt.setString(1,buyProduct.getProductID());
			stmt.setString(2,buyProduct.getProductName());
			stmt.setInt(3,buyProduct.getPurchaseAmount());
			stmt.setString(4,buyProduct.getUserID());
			stmt.setDate(5,ts);
			stmt.executeUpdate();
			
			//UPDATE productinformation
			
			if(amount==0) {
				String sqll="DELETE FROM productinformation WHERE productID='"
						+buyProduct.getProductID()+"'";
				stmt=DBC.con.prepareStatement(sqll);
				stmt.executeUpdate();
			}else {
				String sqll="UPDATE productinformation SET amount=? WHERE productID=?";
				stmt=DBC.con.prepareStatement(sqll);
				stmt.setInt(1,amount);
				stmt.setString(2,buyProduct.getProductID());
				stmt.executeUpdate();
			}
			stmt.executeUpdate();
			/*
			//UPDATE table
			String sqlll="UPDATE "+table+" SET money=? WHERE userID=?";
			stmt=DBC.con.prepareStatement(sqlll);
			//stmt.setDouble(1, money);
			stmt.setString(2, buyProduct.getUserID());
			
			*/
		}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean addProductByAdmin(ProductInformation product) throws RecordAlreadyExistException {
		try {
			String sql1="SELECT * FROM productinformation WHERE productID='"
					+product.getProductID()+"'";
			stmt=DBC.con.prepareStatement(sql1);
			rs=stmt.executeQuery();
			if(rs.next())throw new RecordAlreadyExistException();
			
			String sql="INSERT INTO productinformation (productID,productName,productCost,productPrice,amount)"
					+" VALUES (?,?,?,?,?)";
			stmt=DBC.con.prepareStatement(sql);
			stmt.setString(1, product.getProductID());
			stmt.setString(2, product.getProductName());
			stmt.setDouble(3, product.getProductCost());
			stmt.setDouble(4, product.getProductPrice());
			stmt.setInt(5, product.getAmount());
			stmt.executeUpdate();
			String sqll="UPDATE productpurchase SET productName=?"
					+" WHERE productID=?";
			stmt=DBC.con.prepareStatement(sqll);
			stmt.setString(1, product.getProductName());
			stmt.setString(2, product.getProductID());
			stmt.executeUpdate();

		}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean updateProductByAdmin(ProductInformation product) throws RecordNotFoundException {
		try {
			String sql1="SELECT * FROM productinformation WHERE productID='"
					+product.getProductID()+"'";
			stmt=DBC.con.prepareStatement(sql1);
			rs=stmt.executeQuery();
			if(!rs.next())throw new RecordNotFoundException();
			//更新商品名称、商品定价、商品数量、商品进价
			String sql="UPDATE productinformation SET productName=?,productCost=?,productPrice=?,amount=?"
					+" WHERE productID=?";
			stmt=DBC.con.prepareStatement(sql);
			stmt.setString(1, product.getProductName());
			stmt.setDouble(2, product.getProductCost());
			stmt.setDouble(3, product.getProductPrice());
			stmt.setInt(4, product.getAmount());
			stmt.setString(5, product.getProductID());
			stmt.executeUpdate();
			
			//UPDATE tbl_productpurchase
			String sqll="UPDATE productpurchase SET productName=?"
					+" WHERE productID=?";
			stmt=DBC.con.prepareStatement(sqll);
			stmt.setString(1, product.getProductName());
			stmt.setString(2, product.getProductID());
			stmt.executeUpdate();
			
		}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteProductByAdmin(String productID) throws RecordNotFoundException {
		try {
			String sql1="SELECT * FROM productinformation WHERE productID='"
					+productID+"'";
			stmt=DBC.con.prepareStatement(sql1);
			rs=stmt.executeQuery();
			if(!rs.next())throw new RecordNotFoundException();
			
			//UPDATE productinformation
			String sql="DELETE FROM productinformation WHERE productID='"
					+productID+"'";
			stmt=DBC.con.prepareStatement(sql);
			stmt.executeUpdate();

			//NOT TO UPDATE tbl_productpurchase
		}catch(SQLException e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
