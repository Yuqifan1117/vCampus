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
import vcampus.server.exception.RecordNotFoundException;
import vcampus.vo.Book;
import vcampus.vo.ProductInformation;
import vcampus.vo.Request;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteGoodsView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteGoodsView frame = new DeleteGoodsView();
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
	public DeleteGoodsView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("\u5546\u54C1\u7F16\u53F7");
		
		textField = new JTextField();
		textField.setText("\u8BF7\u8F93\u5165\u5546\u54C1\u7F16\u53F7");
		textField.setColumns(10);
		
		JButton button = new JButton("\u786E\u8BA4\u4E0B\u67B6");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String productID=textField.getText();
				Request testSample = new Request();
				testSample.setRequest_ID(501);
				ProductInformation pro=new ProductInformation();
				pro.setProductID(productID);
				testSample.set_product(pro);
				clientSocket Sample = new clientSocket();
				Request Result = Sample.sendRequestToServer(testSample);
				dispose();
				
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(91)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(button)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(151, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(89)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
					.addComponent(button)
					.addGap(39))
		);
		panel.setLayout(gl_panel);
		setDefaultCloseOperation(AddBookView.DISPOSE_ON_CLOSE);
	}
}
