package client.libraryNshop;

import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.table.AbstractTableModel;

import client.socket.clientSocket;
import vcampus.server.dao.LibraryDao;
import vcampus.server.dao.LibraryDaoImpl;
import vcampus.vo.Book;
import vcampus.vo.Request;

public class BookTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	
	private Vector<String> TableTitle;
	private Vector TableData;

	CopyOnWriteArrayList<Book> list = new CopyOnWriteArrayList<Book>();
	
	public BookTableModel(){
		TableTitle= new Vector();
		   TableTitle.add("���");
		   TableTitle.add("����");
		   TableTitle.add("����");
		   TableTitle.add("������");
		   TableTitle.add("λ��");
		   TableTitle.add("����");
		   TableTitle.add("�ѽ�"); 
	}
	
	// ����User�б�, ͬʱ֪ͨJTabel���ݶ������, �ػ����
	public void setBooks(CopyOnWriteArrayList<Book> arrayList) {
		this.list = arrayList;
		this.fireTableDataChanged();// ͬʱ֪ͨJTabel���ݶ������, �ػ����
		/*for(int i=0;i<list.size();i++)
		{
			vcampus.vo.Book book=list.get(i);
			Vector rowData=new Vector();
			String id=book.getBookID();
			rowData.add(id);
			rowData.add(book.getBookName());
			rowData.add(book.getAuthor());
			rowData.add(book.getBookPress());
			rowData.add(book.getBookLocation());
			rowData.add(book.getTotalAmount());
			rowData.add(book.getBorrowedAmount());
		}
		*/
	}
	
	public int getColumnCount() {
		return 7;
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
		Book book = list.get(rowIndex);
		switch(columnIndex) {
		case 0: return book.getBookID();
		case 1:	return book.getBookName();
		case 2: return book.getAuthor();
		case 3: return book.getBookPress();
		case 4: return book.getBookLocation();
		case 5: return book.getTotalAmount();
		case 6: return book.getBorrowedAmount();
		}
		return book;
	}
	
	
	public void showTable() {
		Request testSample = new Request();
		testSample.setRequest_ID(403);
		clientSocket Sample = new clientSocket();
		Request Result = Sample.sendRequestToServer(testSample);
		
		CopyOnWriteArrayList<Book> booklist=new CopyOnWriteArrayList<Book>();
		booklist=Result.get_bookList();
		this.list=booklist;
		this.fireTableDataChanged();
	}
}

