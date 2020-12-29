package client.libraryNshop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import client.socket.clientSocket;
import vcampus.server.dao.LibraryDao;
import vcampus.server.dao.LibraryDaoImpl;
import vcampus.server.exception.OutOfLimitException;
import vcampus.server.exception.RecordNotFoundException;
import vcampus.vo.BookBorrow;
import vcampus.vo.Request;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;

public class BorrowBook extends JFrame {
	private String UserId;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String userid=new String();
					BorrowBook frame = new BorrowBook(userid);
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
	public BorrowBook(String id) {
		setTitle("\u501F\u4E66");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("\u4E66\u7C4D");
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setText("输入书籍的编号");
		JButton btnNewButton = new JButton("\u501F\u9605");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookID=textField.getText();
				String num=textField_1.getText();
				int borrownumber=Integer.valueOf(num.toString());
				
				Request testSample = new Request();
				testSample.setRequest_ID(404);
				
				BookBorrow bookborrow=new BookBorrow();
				Date ts = new Date(System.currentTimeMillis());
				UserId=id;
				bookborrow.setUserID(UserId);
				bookborrow.setBookID(bookID);
				bookborrow.setBorrowTime(ts);
				bookborrow.setBorrowNumber(borrownumber);
				testSample.set_borrowNreturn(bookborrow);
				clientSocket Sample = new clientSocket();
				Request Result = Sample.sendRequestToServer(testSample);
				dispose();
				}
		});
		
		JLabel lblNewLabel_1 = new JLabel("\u501F\u9605\u6570\u91CF");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setText("输入借阅此书的数量");
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(160)
							.addComponent(btnNewButton))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(73)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(182, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(49)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(35))
		);
		panel.setLayout(gl_panel);
		setDefaultCloseOperation(AddBookView.DISPOSE_ON_CLOSE);
	}
}
