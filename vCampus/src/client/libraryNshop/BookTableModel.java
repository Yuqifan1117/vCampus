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
		   TableTitle.add("编号");
		   TableTitle.add("书名");
		   TableTitle.add("作者");
		   TableTitle.add("出版社");
		   TableTitle.add("位置");
		   TableTitle.add("总量");
		   TableTitle.add("已借"); 
	}
	
	// 设置User列表, 同时通知JTabel数据对象更改, 重绘界面
	public void setBooks(CopyOnWriteArrayList<Book> arrayList) {
		this.list = arrayList;
		this.fireTableDataChanged();// 同时通知JTabel数据对象更改, 重绘界面
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
	
	// 从list中拿出rowIndex行columnIndex列显示的值
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

