package client.login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

public class UserManage extends JFrame {

	private JPanel contentPane;

	public static UserManage um;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public UserManage() {
		setFont(new Font("Adobe Gothic Std", Font.PLAIN, 16));
		setTitle("账号管理");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 227, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton button = new JButton("更改密码");
		button.setIcon(new ImageIcon(UserManage.class.getResource("/icon/icons/zhucedenglumima.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdatePassword(e);
				
			}
		});
		
		JButton button_1 = new JButton("注销账户");
		button_1.setIcon(new ImageIcon(UserManage.class.getResource("/icon/icons/zhuxiao-3.png")));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logout();
				
			}
		});
		
		JButton button_2 = new JButton("退出登录");
		button_2.setIcon(new ImageIcon(UserManage.class.getResource("/icon/icons/tuichu.png")));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		
		JButton button_3 = new JButton("返    回");
		button_3.setIcon(new ImageIcon(UserManage.class.getResource("/icon/icons/fanhui.png")));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(61)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(button_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(button_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(button, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(button_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(76))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(14)
					.addComponent(button)
					.addGap(34)
					.addComponent(button_1)
					.addGap(36)
					.addComponent(button_2)
					.addGap(27)
					.addComponent(button_3)
					.addContainerGap(45, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void logout() {
		// TODO Auto-generated method stub
		Logout frame=new Logout();
		frame.setVisible(true);
		this.setVisible(false);
	}

	protected void exit() {
		// TODO Auto-generated method stub
		this.dispose();
		Login frame =new Login();
		frame.setVisible(true);
	}

	protected void back() {
		// TODO Auto-generated method stub
		this.dispose();
		if("系统管理员".equals(Login.selectedItem.getName()))
		{Login.f.setVisible(true);}
		if("老师".equals(Login.selectedItem.getName()))
		{Login.ft.setVisible(true);}
		if("学生".equals(Login.selectedItem.getName()))
		{Login.fs.setVisible(true);}
		
		
	}

	protected void UpdatePassword(ActionEvent e) {
		// TODO Auto-generated method stub
		ChangePassword frame=new ChangePassword();
		frame.setVisible(true);
		um=this;
		this.setVisible(false);
		
		
//		JFrame JUpdatePassword = new JFrame("更改密码");
//		JUpdatePassword.setSize(227, 300);
//		JUpdatePassword.setLocation(100, 100);
//		JLabel JOriginPassword=new JLabel("输入原密码");
//		JOriginPassword.setBounds(50, 20,150,50);
//		//JOriginPassword.setLocation(150, 50);
//		JUpdatePassword.add(JOriginPassword);
//		JUpdatePassword.setVisible(true);
//		JOriginPassword.setVisible(true);
	
		
		
	}
}
