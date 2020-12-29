package client.libraryNshop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import client.socket.clientSocket;
import vcampus.server.dao.LibraryDao;
import vcampus.server.dao.LibraryDaoImpl;
import vcampus.server.dao.ShopDao;
import vcampus.server.dao.ShopDaoImpl;
import vcampus.server.exception.OutOfLimitException;
import vcampus.server.exception.RecordNotFoundException;
import vcampus.vo.BookBorrow;
import vcampus.vo.ProductInformation;
import vcampus.vo.ProductPurchase;
import vcampus.vo.Request;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.sql.Date;
import java.util.concurrent.CopyOnWriteArrayList;
import java.awt.event.ActionEvent;

public class BorrowBook_1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private String UserID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String bookID=new String();
					String userid=new String();
					BorrowBook_1 frame = new BorrowBook_1(bookID,userid);
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
	public BorrowBook_1(String bookID,String ID) {
		UserID=ID;
		setTitle("\u501F\u9605\u6570\u91CF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 353, 218);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("\u501F\u9605\u6570\u91CF");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4\u501F\u9605");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num=textField.getText();
				int borrownumber=Integer.valueOf(num.toString());
				Request testSample = new Request();
				testSample.setRequest_ID(404);
				
				BookBorrow bookborrow=new BookBorrow();
				Date ts = new Date(System.currentTimeMillis()); 
				bookborrow.setUserID(UserID);
				bookborrow.setBookID(bookID);
				bookborrow.setBorrowTime(ts);
				bookborrow.setBorrowNumber(borrownumber);
				testSample.set_borrowNreturn(bookborrow);
				clientSocket Sample = new clientSocket();
				Request Result = Sample.sendRequestToServer(testSample);
				CopyOnWriteArrayList<BookBorrow> borrowlist=new CopyOnWriteArrayList<BookBorrow>();
				//LibraryDao dao=new LibraryDaoImpl();
				//bookborrow.setUserID("21312");
				//bookborrow.setBookID(bookID);
				//bookborrow.setBorrowTime(ts);
				//bookborrow.setBorrowNumber(borrownumber);
				//try {
					//dao.borrowBook(bookborrow);
				//} catch (RecordNotFoundException | OutOfLimitException e1) {
					// TODO Auto-generated catch block
				//	e1.printStackTrace();
				//}
				dispose();
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(64)
							.addComponent(lblNewLabel)
							.addGap(18)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(119)
							.addComponent(btnNewButton)))
					.addContainerGap(97, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(48)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(30))
		);
		panel.setLayout(gl_panel);
		setDefaultCloseOperation(AddBookView.DISPOSE_ON_CLOSE);
	}

}
