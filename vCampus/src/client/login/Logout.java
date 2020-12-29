package client.login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import client.socket.clientSocket;
import vcampus.vo.Request;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class Logout extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logout frame = new Logout();
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
	public Logout() {
		setTitle("注销账户");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 379, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("输入密码");
		label.setIcon(new ImageIcon(Logout.class.getResource("/icon/icons/mima.png")));
		
		JButton btnNewButton = new JButton("注销");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNewButton.setIcon(new ImageIcon(Logout.class.getResource("/icon/icons/zhuxiao-3.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogoutConfirmed();
			}
		});
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.setIcon(new ImageIcon(Logout.class.getResource("/icon/icons/denglu.png")));
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setIcon(new ImageIcon(Logout.class.getResource("/icon/icons/tuichu.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(78)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(41))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(142)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnNewButton_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
					.addContainerGap(153, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(174, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(154))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(67)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(68)
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(btnNewButton_1)
					.addGap(54))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void back() {
		// TODO Auto-generated method stub
		this.dispose();
		//UserManage.um.setVisible(true);
		if("系统管理员".equals(Login.selectedItem.getName()))
		{AdminMainFrame.amf.setVisible(true);}
		if("老师".equals(Login.selectedItem.getName()))
		{TeacherMF.tmf.setVisible(true);}
		if("学生".equals(Login.selectedItem.getName()))
		{StuMF.smf.setVisible(true);}
	}

	protected void LogoutConfirmed() {
//		// TODO Auto-generated method stub
//		Request clientRequest=new Request();   
//		 clientSocket Sample=new clientSocket();
//		 
//		 clientRequest.setRequest_ID(104);
//		 
		 
		if(Login.passwordField.getText().equals(this.textField.getText()))
		{
			
			this.dispose();
			JOptionPane.showMessageDialog(this,"注销成功", "提示",JOptionPane.INFORMATION_MESSAGE);
			if("系统管理员".equals(Login.selectedItem.getName()))
			{AdminMainFrame.amf.dispose();}
			if("老师".equals(Login.selectedItem.getName()))
			{TeacherMF.tmf.dispose();}
			if("学生".equals(Login.selectedItem.getName()))
			{StuMF.smf.dispose();}
			Login frame=new Login();
			frame.setVisible(true);
		}
		else if(!Login.passwordField.getText().equals(this.textField.getText()))
		{
			this.textField.setText("");
			JOptionPane.showMessageDialog(this,"密码不正确", "提示",JOptionPane.INFORMATION_MESSAGE);
			return;
		}
	}

}
