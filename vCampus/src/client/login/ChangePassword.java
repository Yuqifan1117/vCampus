package client.login;

//import model.IO;
import model.isEmpty;
import vcampus.vo.Admin;
import vcampus.vo.Request;
import vcampus.vo.Student;
import vcampus.vo.Teacher;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import client.socket.clientSocket;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class ChangePassword extends JFrame {

	private JPanel contentPane;
	private JButton button;
	private JPasswordField passwordField_ori;
	private JPasswordField passwordField_newconfirmed;
	private JPasswordField passwordField_new;
	public static String newusername;
	public static String newpassword;
	private JButton button_1;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { UpdatePassword frame = new
	 * UpdatePassword(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */
	/**
	 * Create the frame.
	 */
	public ChangePassword() {
		setTitle("修改密码");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 379, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel label = new JLabel("输入原密码");
		label.setIcon(new ImageIcon(ChangePassword.class.getResource("/icon/icons/mima.png")));

		JLabel label_1 = new JLabel("输入新密码");
		label_1.setIcon(new ImageIcon(ChangePassword.class.getResource("/icon/icons/zhucedenglumima.png")));

		JLabel label_2 = new JLabel("确认新密码");
		label_2.setIcon(new ImageIcon(ChangePassword.class.getResource("/icon/icons/zhucedenglumima.png")));

		button = new JButton("确定更改");
		button.setIcon(new ImageIcon(ChangePassword.class.getResource("/icon/icons/zhucedengluyanzhengma.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePassword(e);
			}
		});

		passwordField_ori = new JPasswordField();

		passwordField_newconfirmed = new JPasswordField();

		passwordField_new = new JPasswordField();

		button_1 = new JButton("    返回");
		button_1.setHorizontalAlignment(SwingConstants.LEFT);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
		button_1.setIcon(new ImageIcon(ChangePassword.class.getResource("/icon/icons/fanhui.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				gl_contentPane.createSequentialGroup().addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(42)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(label_2)
										.addComponent(label_1).addComponent(label))
								.addPreferredGap(ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(passwordField_new, GroupLayout.PREFERRED_SIZE, 112,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(passwordField_ori, GroupLayout.PREFERRED_SIZE, 112,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(passwordField_newconfirmed, GroupLayout.PREFERRED_SIZE, 112,
												GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()

								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(button_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(button, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 90,
												Short.MAX_VALUE))
								.addGap(92)))
						.addGap(60)));
		gl_contentPane
				.setVerticalGroup(
						gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(
										gl_contentPane.createSequentialGroup().addGap(46)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
														.addComponent(passwordField_ori, GroupLayout.PREFERRED_SIZE, 23,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(label))
												.addGap(45)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
														.addComponent(passwordField_new, GroupLayout.PREFERRED_SIZE, 23,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(label_1))
												.addGap(45)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
														.addComponent(passwordField_newconfirmed,
																GroupLayout.PREFERRED_SIZE, 23,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(label_2))
												.addGap(35).addComponent(button).addGap(26).addComponent(button_1)
												.addContainerGap(29, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}

	protected void back() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		this.dispose();
		UserManage.um.setVisible(true);
//				if("系统管理员".equals(Login.selectedItem.getName()))
//				{AdminMainFrame.amf.setVisible(true);}
//				if("老师".equals(Login.selectedItem.getName()))
//				{TeacherMF.tmf.setVisible(true);}
//				if("学生".equals(Login.selectedItem.getName()))
//				{StuMF.smf.setVisible(true);}
//				

	}

	protected String ChangePassword(ActionEvent e) {

		Request clientRequest = new Request();
		clientSocket Sample = new clientSocket();

		clientRequest.setRequest_ID(102);

		// TODO Auto-generated method stub
		if (isEmpty.judge(passwordField_ori.getText(), passwordField_new.getText())) {
			JOptionPane.showMessageDialog(this, "密码不能为空", "错误", JOptionPane.INFORMATION_MESSAGE);
			return passwordField_ori.getText();
		} else if (!(passwordField_newconfirmed.getText().equals(passwordField_new.getText()))) {
			JOptionPane.showMessageDialog(this, "请确认新密码", "错误", JOptionPane.INFORMATION_MESSAGE);
			this.passwordField_newconfirmed.setText("");
			this.passwordField_new.setText("");

			return passwordField_ori.getText();
		} else if (!Login.passwordField.getText().equals(passwordField_ori.getText())) {
			JOptionPane.showMessageDialog(this, "原密码不正确", "错误", JOptionPane.INFORMATION_MESSAGE);
			this.passwordField_ori.setText("");
			this.passwordField_new.setText("");
			this.passwordField_newconfirmed.setText("");
			return passwordField_ori.getText();
		} else {

			if ("系统管理员".equals(Login.selectedItem.getName()))

			{
				newpassword = this.passwordField_new.getText();
				
				clientRequest.setRequest_type(0);
				Admin tempAdmin = new Admin();
				tempAdmin.setPassword(newpassword);
				tempAdmin.setAdminID(Login.username);
				clientRequest.set_admin(tempAdmin);
				Request Response = Sample.sendRequestToServer(clientRequest);
				if(Response.getCheckResult())
				JOptionPane.showMessageDialog(this, "密码修改成功", "提示", JOptionPane.INFORMATION_MESSAGE);
				
			}
			if ("学生".equals(Login.selectedItem.getName()))

			{
				newpassword = this.passwordField_new.getText();
				
				clientRequest.setRequest_type(1);
				Student tempStu = new Student();
				tempStu.setPassword(newpassword);
				tempStu.setId(Login.username);
				clientRequest.set_student(tempStu);
				Request Response = Sample.sendRequestToServer(clientRequest);
				if(Response.getCheckResult())
				JOptionPane.showMessageDialog(this, "密码修改成功", "提示", JOptionPane.INFORMATION_MESSAGE);
				
			}
			if ("老师".equals(Login.selectedItem.getName()))

			{
				newpassword = this.passwordField_new.getText();
				
				clientRequest.setRequest_type(1);
				Teacher tempTeacher = new Teacher();
				tempTeacher.setPassword(newpassword);
				tempTeacher.setId(Login.username);
				clientRequest.set_teacher(tempTeacher);
				Request Response = Sample.sendRequestToServer(clientRequest);
				if(Response.getCheckResult())
				JOptionPane.showMessageDialog(this, "密码修改成功", "提示", JOptionPane.INFORMATION_MESSAGE);
				
			}
//			IO.write();
//			File file = new File("rem");
//			   if (!file.exists()) {
//			    try {
//					file.createNewFile();
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			   }
//			   FileWriter fileWriter = null;
//			try {
//				fileWriter = new FileWriter(file);
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//	            try {
//					fileWriter.write("");
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//	            try {
//					fileWriter.flush();
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//	            try {
//					fileWriter.close();
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
			this.dispose();
			Login newl = new Login();
			newl.setVisible(true);
			return passwordField_new.getText();
		}

	}
}
