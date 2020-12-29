package client.libraryNshop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import client.socket.clientSocket;
import vcampus.server.dao.ShopDao;
import vcampus.server.dao.ShopDaoImpl;
import vcampus.server.exception.OutOfLimitException;
import vcampus.server.exception.RecordNotFoundException;
import vcampus.vo.ProductInformation;
import vcampus.vo.ProductPurchase;
import vcampus.vo.Request;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;

public class BuyView extends JFrame {
	private String UserId;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String proid=new String();
					String userid=new String();
					BuyView frame = new BuyView(proid,userid);
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
	public BuyView(String productID,String userid) {
		UserId=userid;
		setTitle("\u8D2D\u4E70\u6570\u91CF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 316, 188);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("\u8D2D\u4E70\u6570\u91CF");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4\u8D2D\u4E70");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String num=textField.getText();
				int purChaseAmount=Integer.valueOf(num.toString());
				ProductInformation thepro=new ProductInformation();
				ProductPurchase pur=new ProductPurchase();
				ProductInformation product=new ProductInformation();
				product.setProductID(productID);
				Request testSample1 = new Request();
				testSample1.setRequest_ID(502);
				testSample1.set_product(product);
				clientSocket Sample1 = new clientSocket();
				Request Result1 = Sample1.sendRequestToServer(testSample1);
				if(Result1.getCheckResult())
				{
					thepro=Result1.get_product();
				}
				String productName=thepro.getProductName();
				
				pur.setUserID(UserId);
				pur.setProductID(productID);
				pur.setProductName(productName);
				pur.setPurchaseAmount(purChaseAmount);
				Date dt=new Date(System.currentTimeMillis()); 
				pur.setPurchaseTime(dt);
				
				Request testSample = new Request();
				testSample.setRequest_ID(504);
				testSample.set_productPurchase(pur);
				clientSocket Sample = new clientSocket();
				Request Result = Sample.sendRequestToServer(testSample);

			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(99)
							.addComponent(btnNewButton))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(37)
							.addComponent(lblNewLabel)
							.addGap(18)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(73, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(47, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(btnNewButton)
							.addGap(36))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(77))))
		);
		panel.setLayout(gl_panel);
		setDefaultCloseOperation(AddBookView.DISPOSE_ON_CLOSE);
	}
}
