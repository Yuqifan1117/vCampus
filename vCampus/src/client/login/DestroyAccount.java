package client.login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import client.socket.clientSocket;
import vcampus.vo.Admin;
import vcampus.vo.Request;
import vcampus.vo.Student;
import vcampus.vo.Teacher;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class DestroyAccount extends JFrame {

	public static String userName;
	public static String userType;
	private JPanel contentPane;
	private JTextField textField_type;
	private JTextField textField_name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DestroyAccount frame = new DestroyAccount();
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
	public DestroyAccount() {
		setTitle("删除其他用户");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 379, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(DestroyAccount.class.getResource("/icon/icons/shanchu.png")));
		
		textField_type = new JTextField();
		textField_type.setColumns(10);
		
		textField_name = new JTextField();
		textField_name.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("用户类型");
		lblNewLabel.setIcon(new ImageIcon(DestroyAccount.class.getResource("/icon/icons/yonghu.png")));
		
		JLabel lblNewLabel_1 = new JLabel("用  户  名");
		lblNewLabel_1.setIcon(new ImageIcon(DestroyAccount.class.getResource("/icon/icons/zhuce-2.png")));
		
		JButton button = new JButton("确认删除");
		button.setIcon(new ImageIcon(DestroyAccount.class.getResource("/icon/icons/cuowu.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				destroyaccount(e);
			}
		});
		
		JButton btnNewButton = new JButton("     返回");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon(DestroyAccount.class.getResource("/icon/icons/fanhui.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back(e);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(51)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(button)
						.addGroup(Alignment.TRAILING, gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(lblNewLabel)
							.addComponent(lblNewLabel_1)))
					.addGap(68)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_type, 0, 0, Short.MAX_VALUE)
						.addComponent(textField_name, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
					.addGap(48))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(164)
					.addComponent(label)
					.addContainerGap(173, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(31)
					.addComponent(label)
					.addGap(56)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField_type, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(70)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(btnNewButton))
					.addGap(15))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void back(ActionEvent e) {
		// TODO Auto-generated method stub
		this.dispose();
		
		AdminCenter.AC.setVisible(true);
		
		
	}

	protected void destroyaccount(ActionEvent e) {
		// TODO Auto-generated method stub
		userName=textField_name.getText();
		userType=textField_type.getText();
		if("".equals(userName)||"".equals(userType))
		{
			JOptionPane.showMessageDialog(this, "格式错误", "提示",JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		else if("管理员".equals(userType))
		{
			JOptionPane.showMessageDialog(this, "不可删除其他管理员的账号", "提示",JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		//if(destroyAccount=true)
		else {
			Request clientRequest=new Request();   
			 clientSocket Sample=new clientSocket();
			 
			 clientRequest.setRequest_ID(105);
			 
			if ("学生".equals(userType)) {
				clientRequest.setRequest_type(1);
				Student tempStu = new Student();
				tempStu.setId(userName);
				clientRequest.set_student(tempStu);

				Request Response = Sample.sendRequestToServer(clientRequest);
				if (Response.getCheckResult()) {
					JOptionPane.showMessageDialog(this, "已删除", "提示", JOptionPane.INFORMATION_MESSAGE);
					this.dispose();
					AdminCenter.AC.setVisible(true);
				}
			}
			if ("老师".equals(userType)) {
				clientRequest.setRequest_type(2);
				Teacher tempTeacher = new Teacher();
				tempTeacher.setId(userName);
				clientRequest.set_teacher(tempTeacher);

				Request Response = Sample.sendRequestToServer(clientRequest);
				if (Response.getCheckResult()) {
					JOptionPane.showMessageDialog(this, "已删除", "提示", JOptionPane.INFORMATION_MESSAGE);
					this.dispose();
					AdminCenter.AC.setVisible(true);
				}
			}
			
			 
			 
		}
		
		//else{JOptionPane.showMessageDialog(this, "该账号不可被删除", "提示",JOptionPane.INFORMATION_MESSAGE);}
		
	}
}
