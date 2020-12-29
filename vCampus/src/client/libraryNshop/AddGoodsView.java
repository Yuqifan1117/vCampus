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
import vcampus.server.exception.RecordAlreadyExistException;
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
import java.util.concurrent.CopyOnWriteArrayList;
import java.awt.event.ActionEvent;

public class AddGoodsView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddGoodsView frame = new AddGoodsView();
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
	public AddGoodsView() {
		setTitle("\u4E0A\u67B6\u7269\u54C1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("\u5546\u54C1\u7F16\u53F7");
		
		JLabel lblNewLabel_1 = new JLabel("\u5546\u54C1\u540D\u79F0");
		
		JLabel lblNewLabel_2 = new JLabel("");
		
		JLabel lblNewLabel_3 = new JLabel("\u5546\u54C1\u552E\u4EF7");
		
		JLabel label = new JLabel("\u5546\u54C1\u6210\u672C");
		
		JLabel label_1 = new JLabel("\u5546\u54C1\u5E93\u5B58");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4\u4E0A\u67B6");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String productID=textField.getText();
				String productName=textField_1.getText();
				String aaa=textField_2.getText();
				double productPrice = Double.valueOf(aaa.toString());
				String bbb=textField_3.getText();
				double productCost=Double.valueOf(bbb.toString());
				String ccc=textField_4.getText();
				int amount=Integer.valueOf(ccc.toString());
		
				ProductInformation product = new ProductInformation();
				product.setProductID(productID);
				product.setProductName(productName);
				product.setProductPrice(productPrice);
				product.setProductCost(productCost);
				product.setAmount(amount);
				
				Request testSample = new Request();
				testSample.setRequest_ID(500);
				testSample.set_product(product);
				clientSocket Sample = new clientSocket();
				Request Result = Sample.sendRequestToServer(testSample);
				
				dispose();
				
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(100)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addGap(18)
									.addComponent(textField_1))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addGap(18)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_2)
										.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
											.addComponent(label)
											.addComponent(lblNewLabel_3)
											.addComponent(label_1)))
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
										.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
										.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(157)
							.addComponent(btnNewButton)))
					.addContainerGap(155, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_3)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
					.addComponent(btnNewButton))
		);
		panel.setLayout(gl_panel);
		setDefaultCloseOperation(AddGoodsView.DISPOSE_ON_CLOSE);
	}
	

}
