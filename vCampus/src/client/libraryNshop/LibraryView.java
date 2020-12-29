package client.libraryNshop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import com.hxtt.global.ad;

import client.socket.clientSocket;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.Book;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.awt.FlowLayout;
//import vcampus.util.*;
import vcampus.vo.BookBorrow;
import vcampus.vo.Request;
import vcampus.server.*;
import vcampus.server.dao.DBConnection;
import vcampus.server.dao.LibraryDaoImpl;
import vcampus.server.dao.*;

public class LibraryView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	public JTable table;

	private String UserId;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					int type=0;
					String userid=new String();
					LibraryView frame = new LibraryView(userid,type);
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
	public LibraryView(String id,int usertype) {// User u
		UserId=id;
		setTitle("\u56FE\u4E66\u9986\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 628, 441);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u7BA1\u7406");
		if(usertype==0)
			menu.setEnabled(true);
		else
			menu.setEnabled(false);
		menuBar.add(menu);
		
		JMenu menu_1 = new JMenu("\u501F\u9605");
		menuBar.add(menu_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u501F\u4E66");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BorrowBook borrow=new BorrowBook(UserId);
				borrow.setVisible(true);
			}
		});
		menu_1.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("\u8FD8\u4E66");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SendBook send=new SendBook(UserId);
				send.setVisible(true);
			}
		});
		menu_1.add(menuItem_3);
		
		JMenu menu_2 = new JMenu("\u6211\u7684\u4E66\u67B6");
		menu_2.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				MyBook my=new MyBook();
				my.setVisible(true);
			}
		});
		menuBar.add(menu_2);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u4E66\u540D");
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		BookTableModel model= new BookTableModel(){

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row,int column) {
				return false;
				}
		};
		
		table = new JTable();
		table.setModel(model);
		
		//model.setBooks(list);
		model.showTable();
		model.addTableModelListener(table);
		scrollPane.setViewportView(table);

		JButton button = new JButton("\u641C\u7D22");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CopyOnWriteArrayList<vcampus.vo.Book> booklist=new 	CopyOnWriteArrayList<vcampus.vo.Book>();
				String bookname=textField.getText();
				//LibraryDao dao = new LibraryDaoImpl();
				vcampus.vo.Book book=new vcampus.vo.Book();
				book.setBookName(bookname);
				
				Request testSample = new Request();
				testSample.setRequest_ID(402);
				testSample.set_book(book);
				clientSocket Sample = new clientSocket();
				
				Request Result = Sample.sendRequestToServer(testSample);
				if (Result.getCheckResult()) {
					booklist=Result.get_bookList();
				}
	
				//booklist=Result.get_bookList();
				model.setBooks(booklist);
				//ArrayList<Book> book=dao.queryBook(bookname);
				//model.setBooks(book);
				model.fireTableDataChanged();
				table.updateUI();
				
			}
		});
		JButton button_1 = new JButton("\u663E\u793A\u5168\u90E8");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.showTable();
				table.updateUI();
			}
		});
		JMenuItem menuItem = new JMenuItem("\u6DFB\u52A0\u4E66\u7C4D");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBookView add=new AddBookView();
				add.setVisible(true);	
				table.updateUI();
			}
		});
		
		JMenuItem menuItem_1 = new JMenuItem("\u5220\u9664\u4E66\u7C4D");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteBook del=new DeleteBook();
				del.setVisible(true);
			}
		});
		
		menu.add(menuItem);
		menu.add(menuItem_1);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(26)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(155)
					.addComponent(button)
					.addGap(18)
					.addComponent(button_1)
					.addContainerGap(165, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button)
						.addComponent(button_1)))
		);
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("\u501F\u9605");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row=table.getSelectedRow();
				String bookid=table.getValueAt(row, 0).toString();
				BorrowBook_1 borrowview=new BorrowBook_1(bookid,UserId);
				borrowview.setVisible(true);
				
			}
		});
		panel_1.add(btnNewButton);
	}
}
