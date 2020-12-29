package client.libraryNshop;

import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.table.AbstractTableModel;

import client.socket.clientSocket;
import vcampus.server.dao.ShopDao;
import vcampus.server.dao.ShopDaoImpl;
import vcampus.vo.Book;
import vcampus.vo.ProductInformation;
import vcampus.vo.Request;

public class ShopTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	
	private Vector<String> TableTitle;

	CopyOnWriteArrayList<ProductInformation> list = new CopyOnWriteArrayList<ProductInformation>();
	
	public ShopTableModel(){
		TableTitle= new Vector();
		   TableTitle.add("���");
		   TableTitle.add("��Ʒ");
		   TableTitle.add("�ۼ�/Ԫ");
		   TableTitle.add("���");
	}
	
	// ����User�б�, ͬʱ֪ͨJTabel���ݶ������, �ػ����
	public void setProduct(CopyOnWriteArrayList<ProductInformation> product) {
		this.list = product;
		this.fireTableDataChanged();// ͬʱ֪ͨJTabel���ݶ������, �ػ����
	}
	
	public int getColumnCount() {
		return 4;
	}
	
	public String getColumnName(int column) {
		return (String)this.TableTitle.get(column);
	}
	
	public int getRowCount() {
		if(list==null)return 0;
		else
		return list.size();
	}
	
	// ��list���ó�rowIndex��columnIndex����ʾ��ֵ
	public Object getValueAt(int rowIndex, int columnIndex) {
		ProductInformation product = list.get(rowIndex);
		switch(columnIndex) {
		case 0: return product.getProductID();
		case 1:	return product.getProductName();
		case 2: return product.getProductPrice();
		case 3: return product.getAmount();
		}
		return product;
	}
	
	
	public void showTable() {
		Request testSample = new Request();
		testSample.setRequest_ID(503);
		clientSocket Sample = new clientSocket();
		Request Result = Sample.sendRequestToServer(testSample);
		CopyOnWriteArrayList<ProductInformation> productlist=new CopyOnWriteArrayList<ProductInformation>();
		productlist=Result.get_productList();
		this.list=productlist;
		this.fireTableDataChanged();
	}
}

