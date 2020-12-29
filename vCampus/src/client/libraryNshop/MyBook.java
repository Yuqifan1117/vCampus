package client.libraryNshop;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import vcampus.server.dao.LibraryDao;
import vcampus.server.dao.LibraryDaoImpl;
import vcampus.vo.Book;
import vcampus.vo.BookBorrow;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyBook extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyBook frame = new MyBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyBook() {
		setTitle("\u6211\u7684\u4E66\u67B6");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		Object[][] cellData= null;
		String[] headers= {"用户","编号","书名","借阅数量","借阅时间"};
		DefaultTableModel model= new DefaultTableModel(cellData,headers){
			public boolean isCellEditable(int row,int column) {
				return false;
				}
		};
		
		LibraryDao dao=new LibraryDaoImpl();
		ArrayList<BookBorrow> list=new ArrayList<BookBorrow>();
		list=dao.queryBookBorrow("21312");
		if(list!=null) {
		for(int i=0;i<list.size();i++)
		{
			BookBorrow borrowbook=list.get(i);
			Vector rowData=new Vector();
			Book book=new Book();
			book=dao.queryBookInformation(borrowbook.getBookID());
			rowData.add(borrowbook.getUserID());
			rowData.add(borrowbook.getBookID());
			rowData.add(book.getBookName());
			rowData.add(borrowbook.getBorrowNumber());
			rowData.add(borrowbook.getBorrowTime());
			model.addRow(rowData);
		}}
		table = new JTable(model);
		model.addTableModelListener(table);
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		/*JButton button = new JButton("\u8FD8\u4E66");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row=table.getSelectedRow();
				String ID=table.getValueAt(row, 1).toString();
				SendBook_1 sendbook=new SendBook_1(ID);
				sendbook.setVisible(true);
				
			}
		});
		panel_1.add(button);
		*/
		setDefaultCloseOperation(MyBook.DISPOSE_ON_CLOSE);
	}

	
}
