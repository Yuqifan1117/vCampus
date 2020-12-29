package client.login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import client.status.StatusCtl;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class AdminMainFrame extends JFrame {

	public static AdminMainFrame amf;
	public static UserManage frame;
	public static AdminCenter ac;
	private JPanel contentPane;

	private StatusCtl SC_jf;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainFrame frame = new MainFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public AdminMainFrame() {
		setTitle("管理员界面");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 379, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton(" 账号管理");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon(AdminMainFrame.class.getResource("/icon/icons/zhanghaoguanli.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccountManage();
			}
		});
		
		JButton btnNewButton_1 = new JButton("信息管理");
		btnNewButton_1.setIcon(new ImageIcon(AdminMainFrame.class.getResource("/icon/icons/xinxiguanli.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SC_jf = new StatusCtl("1000", 1);
			}
		});
		
		JButton button = new JButton("管理员中心");
		button.setIcon(new ImageIcon(AdminMainFrame.class.getResource("/icon/icons/guanliyuan-copy.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				center(e);
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AdminMainFrame.class.getResource("/icon/icons/guanliyuan-3.png")));
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(160)
					.addComponent(lblNewLabel)
					.addContainerGap(161, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(139)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
						.addComponent(button, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
					.addGap(139))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(18)
					.addComponent(lblNewLabel)
					.addGap(34)
					.addComponent(btnNewButton_1)
					.addGap(67)
					.addComponent(button)
					.addGap(79)
					.addComponent(btnNewButton)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void center(ActionEvent e) {
		// TODO Auto-generated method stub
		ac=new AdminCenter();
		ac.setVisible(true);
		amf=this;
		this.setVisible(false);
		
	}

	protected void AccountManage() {
		// TODO Auto-generated method stub
		frame =new UserManage();
		frame.setVisible(true);
		this.setVisible(false);
		amf=this;
	}

	

}
