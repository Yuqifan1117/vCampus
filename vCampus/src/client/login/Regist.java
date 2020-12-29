package client.login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.UserType;
import model.isEmpty;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Regist extends JFrame {

	private JPanel contentPane;
	private JTextField textField_username;
	private JTextField textField_password;
	private JTextField textField_passwordconfirmed;
	private JComboBox comboBox_usertype;
	public static String username;
	public static String password;
	public static int usertype;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Regist frame = new Regist();
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
	public Regist() {
		setTitle("注册用户");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 379, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("用  户  名");
		label.setIcon(new ImageIcon(Regist.class.getResource("/icon/icons/denglu.png")));
		
		JLabel label_1 = new JLabel("密       码");
		label_1.setIcon(new ImageIcon(Regist.class.getResource("/icon/icons/zhucedenglumima.png")));
		
		JLabel label_2 = new JLabel("用户类型");
		label_2.setIcon(new ImageIcon(Regist.class.getResource("/icon/icons/GroupCopy.png")));
		
		JLabel label_3 = new JLabel("确认密码");
		label_3.setIcon(new ImageIcon(Regist.class.getResource("/icon/icons/zhucedengluyanzhengma.png")));
		
		JButton button = new JButton("注册");
		button.setIcon(new ImageIcon(Regist.class.getResource("/icon/icons/zhuce-2.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistConfirmed();
			}
		});
		
		textField_username = new JTextField();
		textField_username.setColumns(10);
		
		textField_password = new JTextField();
		textField_password.setColumns(10);
		
		textField_passwordconfirmed = new JTextField();
		textField_passwordconfirmed.setColumns(10);
		
		comboBox_usertype = new JComboBox();
		comboBox_usertype.setModel(new DefaultComboBoxModel(new String[] {"学生", "教师"}));
		
		JButton button_1 = new JButton("返回");
		button_1.setIcon(new ImageIcon(Regist.class.getResource("/icon/icons/fanhui.png")));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(Regist.class.getResource("/icon/icons/zhuce.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
								.addComponent(label)
								.addComponent(label_3))
							.addGap(47))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_2, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_username, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
						.addComponent(textField_password, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
						.addComponent(textField_passwordconfirmed, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
						.addComponent(comboBox_usertype, 0, 133, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(69)
					.addComponent(button)
					.addPreferredGap(ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
					.addComponent(button_1)
					.addGap(67))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(161, Short.MAX_VALUE)
					.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addGap(157))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textField_username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(textField_password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(textField_passwordconfirmed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(comboBox_usertype, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(50))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void back() {
		// TODO Auto-generated method stub
		this.dispose();
		Login.l.setVisible(true);
	}

	protected void RegistConfirmed() {
		// TODO Auto-generated method stub
		username=textField_username.getText().toString();
		password=textField_password.getText().toString();
		String passwordconfirmed=textField_passwordconfirmed.getText();
		
		if("教师".equals(comboBox_usertype.getSelectedItem().toString()))
			usertype=2;
		if("学生".equals(comboBox_usertype.getSelectedItem().toString()))
			usertype=1;
		if(username==null||"".equals(username))
		 {
			 JOptionPane.showMessageDialog(this,"用户名不能为空", "错误",JOptionPane.INFORMATION_MESSAGE);
			 return;
		 }
		else if(isEmpty.judge(password,passwordconfirmed))
		{JOptionPane.showMessageDialog(this, "密码不能为空", "错误",JOptionPane.INFORMATION_MESSAGE);return;}
	
		else if(!(password.equals(passwordconfirmed)))
	
		{
		JOptionPane.showMessageDialog(this, "请确认新密码", "错误",JOptionPane.INFORMATION_MESSAGE);
		this.textField_password.setText("");
		this.textField_passwordconfirmed.setText("");
		
		return;}
		else
			{
			//if(ok)
			JOptionPane.showMessageDialog(this, "注册成功", "错误",JOptionPane.INFORMATION_MESSAGE);
		//切换学籍管理
			}
	}
		 
		
		
	
}
