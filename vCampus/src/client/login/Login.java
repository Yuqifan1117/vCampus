package client.login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import com.jgoodies.forms.factories.DefaultComponentFactory;

//import model.IO;
import model.UserType;
import model.yanzheng;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;

import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.imageio.ImageIO;
import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;
import javax.swing.text.IconView;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import vcampus.vo.*;
import client.socket.*;

public class Login extends JFrame {
	public static Icon i;
	public static JLabel pic;
	public static AdminMainFrame f;
	public static TeacherMF ft;
	public static StuMF fs;
	public static Login l;
	public static String alphauser;
	public static String alphapassword;
	public static JTextField textField_username;
	private JComboBox comboBox_usertype;
	public static JPasswordField passwordField;
	private JTextField textField_ip;
	private JTextField textField_server;
	private JRadioButton rdbtnIP;
	private JRadioButton rdbtnServer;
	private JRadioButton rdbtnLocalhost;
	private JRadioButton remFlag;
	public static UserType selectedItem;
	private JTextField textField_yanzheng;

	public static String username;
	public static String password;
	public static yanzheng yzm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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

	public Login() {
		yzm = new yanzheng();
		try {
			yzm.pic();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		setBackground(new Color(255, 255, 255));
		setForeground(new Color(51, 102, 102));
		setTitle("vCampus🤘");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 379, 382);
		JPanel contentPane = new JPanel();
		contentPane.setToolTipText("vCampus");
		contentPane.setBorder(UIManager.getBorder("FormattedTextField.border"));
		contentPane.setBackground(new Color(245, 245, 245));

		setContentPane(contentPane);

		JLabel label = new JLabel("掌上校园登陆界面");
		label.setBackground(new Color(255, 255, 255));

		label.setIcon(new ImageIcon(Login.class.getResource("/icon/icons/houzi.png")));

		label.setFont(new Font("Arial Unicode MS", Font.BOLD, 26));
		label.setForeground(new Color(0, 153, 255));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.TOP);

		JLabel label_1 = new JLabel("用户名");
		ImageIcon image = new ImageIcon("/icon/icons/denglumima.png");
		image.setImage(image.getImage().getScaledInstance(20, 20, 20));// 设置图片大小
		label_1.setIcon(new ImageIcon(Login.class.getResource("/icon/icons/denglu-2.png")));

		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		label_1.setForeground(Color.BLACK);
		label_1.setBackground(Color.BLACK);

		JLabel label_2 = new JLabel("密   码");
		label_2.setIcon(new ImageIcon(Login.class.getResource("/icon/icons/mima.png")));
		label_2.setFont(UIManager.getFont("Label.font"));
		label_2.setForeground(Color.BLACK);
		label_2.setBackground(Color.BLACK);

		JLabel label_ = new JLabel("用户类型");
		label_.setIcon(new ImageIcon(Login.class.getResource("/icon/icons/yonghu.png")));
		label_.setForeground(Color.BLACK);
		label_.setBackground(Color.BLACK);

		comboBox_usertype = new JComboBox();
		comboBox_usertype.setModel(
				new DefaultComboBoxModel(new UserType[] { UserType.STUDENT, UserType.TEACHER, UserType.ADMIN }));

		textField_username = new JTextField();
		textField_username.setColumns(10);

		pic = new JLabel(new ImageIcon("E:/C、D盘文件备份/Java设计/vCampus/src/yzm/yanzheng" + yanzheng.time + ".jpg"));
		contentPane.add(pic);
		pic.setBounds(110, 235, 100, 30);

		JButton button_login = new JButton("登陆");
		button_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login(e);
			}
		});

		JButton button_reset = new JButton("重置");
		button_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset(e);
			}
		});

		JButton btnNewButton = new JButton("注册");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Regist();
			}
		});

		passwordField = new JPasswordField();

		remFlag = new JRadioButton("记住密码");
		remFlag.setSelected(true);

		rdbtnLocalhost = new JRadioButton("localhost");
		rdbtnLocalhost.setSelected(true);

		rdbtnIP = new JRadioButton("ip端口");

		rdbtnServer = new JRadioButton("服务器");

		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnLocalhost);
		group.add(rdbtnIP);
		group.add(rdbtnServer);

		textField_ip = new JTextField();
		textField_ip.setColumns(10);

		textField_server = new JTextField();
		textField_server.setColumns(10);

		JLabel label_3 = new JLabel("输入验证码");

		textField_yanzheng = new JTextField();
		textField_yanzheng.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
						.createSequentialGroup().addGap(35)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(rdbtnLocalhost)
								.addGroup(gl_contentPane
										.createSequentialGroup().addGroup(gl_contentPane
												.createParallelGroup(Alignment.LEADING).addComponent(rdbtnIP)
												.addComponent(rdbtnServer).addComponent(label_1).addComponent(label_2,
														GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_contentPane
														.createParallelGroup(Alignment.TRAILING).addComponent(label_3)
														.addComponent(label_))
												.addGroup(gl_contentPane.createSequentialGroup().addGap(4).addGroup(
														gl_contentPane.createParallelGroup(Alignment.LEADING, false)
																.addComponent(button_login, Alignment.TRAILING,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(btnNewButton, Alignment.TRAILING,
																		GroupLayout.PREFERRED_SIZE, 78,
																		Short.MAX_VALUE))))
										.addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																.addComponent(button_reset).addComponent(remFlag)
																.addComponent(textField_yanzheng,
																		GroupLayout.PREFERRED_SIZE, 102,
																		GroupLayout.PREFERRED_SIZE))
														.addGap(42))
												.addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
														.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(textField_username, Alignment.LEADING)
														.addComponent(textField_server, Alignment.LEADING)
														.addComponent(textField_ip, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
														.addGroup(Alignment.LEADING,
																gl_contentPane.createSequentialGroup()
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(passwordField))
														.addComponent(comboBox_usertype, 0, 144, Short.MAX_VALUE))
														.addGap(42))))))
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(label).addGap(76)))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addComponent(label).addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(rdbtnLocalhost).addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(rdbtnIP).addComponent(
						textField_ip, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(rdbtnServer).addComponent(
						textField_server, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(label_2)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_contentPane
						.createParallelGroup(Alignment.BASELINE).addComponent(label_).addComponent(comboBox_usertype,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_contentPane
						.createParallelGroup(Alignment.BASELINE).addComponent(label_3).addComponent(textField_yanzheng,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(button_login)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnNewButton))
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(remFlag)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(button_reset)))
				.addContainerGap()));
		contentPane.setLayout(gl_contentPane);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { contentPane, label_, button_login, label_2,
				label_1, comboBox_usertype, textField_username, button_reset, label }));
//		if (remFlag.isSelected()) {
//
//			try {
//
//				String pathname = "rem.txt";
//				FileReader reader = new FileReader(pathname);
//				BufferedReader br = new BufferedReader(reader);
//
//				String line;
//				line = br.readLine();
//				textField_username.setText(line);
//
//				line = br.readLine();
//				passwordField.setText(line);
//
//			} catch (IOException ae) {
//				ae.printStackTrace();
//			}
//		}

	}

	protected void Regist() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		l = this;
		Regist frame = new Regist();
		frame.setVisible(true);

	}

	public void login(ActionEvent e) {
		// TODO Auto-generated method stub

//			IO.read();

		username = textField_username.getText().toString();
		password = passwordField.getText().toString();
		selectedItem = (UserType) comboBox_usertype.getSelectedItem();

		final ImageIcon icon = new ImageIcon("/icon/icons/error-2.png");

		Request clientRequest = new Request();
		clientRequest.setRequest_ID(101);

		clientSocket Sample = new clientSocket();

		/*
		 * Request clientRequest = new Request(); clientRequest.setRequest_ID(300);
		 * 
		 * Student temp = new Student(); temp.setStudentID(ID);
		 * clientRequest.set_student(temp);
		 * 
		 * clientSocket Sample = new clientSocket(); Request Response =
		 * Sample.sendRequestToServer(clientRequest);
		 */

		if (username == null || "".equals(username)) {
			JOptionPane.showMessageDialog(this, "用户名不能为空", "错误", JOptionPane.INFORMATION_MESSAGE, icon);
			return;
		}
		if (password == null || "".equals(password)) {
			JOptionPane.showMessageDialog(this, "密码不能为空", "错误", JOptionPane.INFORMATION_MESSAGE, icon);

			return;
		}
		/*
		 * 
		 * if(loginpermit==true)
		 * 
		 * 
		 */
		if ("系统管理员".equals(selectedItem.getName())) {
			clientRequest.setRequest_type(0);
			Admin tempAdmin = new Admin();
			tempAdmin.setAdminID(username);
			tempAdmin.setPassword(password);
			
			clientRequest.set_admin(tempAdmin);
			Request Response = Sample.sendRequestToServer(clientRequest);

			Response.getCheckResult();// 客户端返回值
			// 下行

			if (Response.getCheckResult()) {
				if (rdbtnServer.isSelected() && "".equals(textField_server.getText())) {
					JOptionPane.showMessageDialog(this, "服务器不能为空", "错误", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				if (rdbtnIP.isSelected() && "".equals(textField_ip.getText())) {

					JOptionPane.showMessageDialog(this, "IP地址不能为空", "错误", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
//					if(remFlag.isSelected())
//					{
//							   String remusername = textField_username.getText();
//							   String rempassword=passwordField.getText();
//							   
//							 
//							   File file = new File("rem");
//							 
//							   
//							   if (!file.exists()) {
//							    try {
//									file.createNewFile();
//								} catch (IOException e1) {
//									// TODO Auto-generated catch block
//									e1.printStackTrace();
//								}
//							   }
//							 
//							   FileWriter fw = null;
//							try {
//								fw = new FileWriter(file.getAbsoluteFile());
//							} catch (IOException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							}
//							   BufferedWriter bw = new BufferedWriter(fw);
//							   try {
//								bw.write(remusername);
//							} catch (IOException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							}
//							   try {
//								bw.newLine();
//							} catch (IOException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							}
//							   try {
//								bw.write(rempassword);
//							} catch (IOException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							}
//							   try {
//								bw.close();
//							} catch (IOException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							}
//							 
//					}
//					if(!remFlag.isSelected())
//					{
//						File file = new File("rem");
//						 
//						   
//						   if (!file.exists()) {
//						    try {
//								file.createNewFile();
//							} catch (IOException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							}
//						   }
//						   FileWriter fileWriter = null;
//						try {
//							fileWriter = new FileWriter(file);
//						} catch (IOException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
//				            try {
//								fileWriter.write("");
//							} catch (IOException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							}
//				            try {
//								fileWriter.flush();
//							} catch (IOException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							}
//				            try {
//								fileWriter.close();
//							} catch (IOException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							}
//					}		 

				// 验证码
				if (!yzm.s.equals(textField_yanzheng.getText())) {
					JOptionPane.showMessageDialog(this, "验证码错误", "错误", JOptionPane.INFORMATION_MESSAGE);

					try {
						yzm.pic();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					;
					ImageIcon newicon = new ImageIcon(
							"/Users/zheyu/eclipse-workspace/vCampus/src/icon/icons/yanzheng" + yanzheng.time + ".jpg");
					pic.setIcon(newicon);

					pic.setBounds(130, 265, 100, 30);
					return;
				}
				f = new AdminMainFrame();
				f.setVisible(true);
				this.dispose();
			}

			else {
				passwordField.setText("");
				comboBox_usertype.setSelectedIndex(0);
				JOptionPane.showMessageDialog(this, "用户名或密码错误", "错误", JOptionPane.INFORMATION_MESSAGE, icon);
				return;

			}

		}
		if ("老师".equals(selectedItem.getName())) {
			clientRequest.setRequest_type(2);
			Teacher tempTeacher = new Teacher();
			tempTeacher.setId(username);
			tempTeacher.setPassword(password);
			clientRequest.set_teacher(tempTeacher);
			Request Response = Sample.sendRequestToServer(clientRequest);

			// Response.getCheckResult();//客户端返回值
			if (Response.getCheckResult()) {
				if (rdbtnServer.isSelected() && "".equals(textField_server.getText())) {
					JOptionPane.showMessageDialog(this, "服务器不能为空", "错误", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				if (rdbtnIP.isSelected() && "".equals(textField_ip.getText())) {

					JOptionPane.showMessageDialog(this, "IP地址不能为空", "错误", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
//					if(remFlag.isSelected())
//					{
//							   String remusername = textField_username.getText();
//							   String rempassword=passwordField.getText();
//							   
//							 
//							   File file = new File("rem");
//							 
//							   
//							   if (!file.exists()) {
//							    try {
//									file.createNewFile();
//								} catch (IOException e1) {
//									// TODO Auto-generated catch block
//									e1.printStackTrace();
//								}
//							   }
//							 
//							   FileWriter fw = null;
//							try {
//								fw = new FileWriter(file.getAbsoluteFile());
//							} catch (IOException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							}
//							   BufferedWriter bw = new BufferedWriter(fw);
//							   try {
//								bw.write(remusername);
//							} catch (IOException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							}
//							   try {
//								bw.newLine();
//							} catch (IOException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							}
//							   try {
//								bw.write(rempassword);
//							} catch (IOException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							}
//							   try {
//								bw.close();
//							} catch (IOException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							}
//							 
//					}
//					if(!remFlag.isSelected())
//					{
//						File file = new File("rem");
//						 
//						   
//						   if (!file.exists()) {
//						    try {
//								file.createNewFile();
//							} catch (IOException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							}
//						   }
//						   FileWriter fileWriter = null;
//						try {
//							fileWriter = new FileWriter(file);
//						} catch (IOException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
//				            try {
//								fileWriter.write("");
//							} catch (IOException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							}
//				            try {
//								fileWriter.flush();
//							} catch (IOException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							}
//				            try {
//								fileWriter.close();
//							} catch (IOException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							}
//					}		 

				if (!yzm.s.equals(textField_yanzheng.getText())) {
					JOptionPane.showMessageDialog(this, "验证码错误", "错误", JOptionPane.INFORMATION_MESSAGE);
					try {
						yzm.pic();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					;
					ImageIcon newicon = new ImageIcon(
							"/Users/zheyu/eclipse-workspace/vCampus/src/icon/icons/yanzheng" + yanzheng.time + ".jpg");
					pic.setIcon(newicon);

					pic.setBounds(130, 265, 100, 30);

					return;
				}

				ft = new TeacherMF();
				ft.setVisible(true);
				this.dispose();
			} else {
				passwordField.setText("");
				comboBox_usertype.setSelectedIndex(0);
				JOptionPane.showMessageDialog(this, "用户名或密码错误", "错误", JOptionPane.INFORMATION_MESSAGE, icon);
				return;
			}

		}
		if ("学生".equals(selectedItem.getName())) {

			clientRequest.setRequest_type(1);
			Student tempStu = new Student();
			tempStu.setId(username);
//				 tempStu.setStudentID(studentID);
			tempStu.setPassword(password);
			clientRequest.set_student(tempStu);
			Request Response = Sample.sendRequestToServer(clientRequest);

			Response.getCheckResult();// 客户端返回值
			System.out.println(Response.getCheckResult());
			System.out.println(username + password);

			if (Response.getCheckResult()) {
				if (rdbtnServer.isSelected() && "".equals(textField_server.getText())) {
					JOptionPane.showMessageDialog(this, "服务器不能为空", "错误", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				if (rdbtnIP.isSelected() && "".equals(textField_ip.getText())) {

					JOptionPane.showMessageDialog(this, "IP地址不能为空", "错误", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
//						if(remFlag.isSelected())
//						{
//								   String remusername = textField_username.getText();
//								   String rempassword=passwordField.getText();
//								   
//								 
//								   File file = new File("rem");
//								 
//								   
//								   if (!file.exists()) {
//								    try {
//										file.createNewFile();
//									} catch (IOException e1) {
//										// TODO Auto-generated catch block
//										e1.printStackTrace();
//									}
//								   }
//								 
//								   FileWriter fw = null;
//								try {
//									fw = new FileWriter(file.getAbsoluteFile());
//								} catch (IOException e1) {
//									// TODO Auto-generated catch block
//									e1.printStackTrace();
//								}
//								   BufferedWriter bw = new BufferedWriter(fw);
//								   try {
//									bw.write(remusername);
//								} catch (IOException e1) {
//									// TODO Auto-generated catch block
//									e1.printStackTrace();
//								}
//								   try {
//									bw.newLine();
//								} catch (IOException e1) {
//									// TODO Auto-generated catch block
//									e1.printStackTrace();
//								}
//								   try {
//									bw.write(rempassword);
//								} catch (IOException e1) {
//									// TODO Auto-generated catch block
//									e1.printStackTrace();
//								}
//								   try {
//									bw.close();
//								} catch (IOException e1) {
//									// TODO Auto-generated catch block
//									e1.printStackTrace();
//								}
//								 
//						}
//						if(!remFlag.isSelected())
//						{
//							File file = new File("rem");
//							 
//							   
//							   if (!file.exists()) {
//							    try {
//									file.createNewFile();
//								} catch (IOException e1) {
//									// TODO Auto-generated catch block
//									e1.printStackTrace();
//								}
//							   }
//							   FileWriter fileWriter = null;
//							try {
//								fileWriter = new FileWriter(file);
//							} catch (IOException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							}
//					            try {
//									fileWriter.write("");
//								} catch (IOException e1) {
//									// TODO Auto-generated catch block
//									e1.printStackTrace();
//								}
//					            try {
//									fileWriter.flush();
//								} catch (IOException e1) {
//									// TODO Auto-generated catch block
//									e1.printStackTrace();
//								}
//					            try {
//									fileWriter.close();
//								} catch (IOException e1) {
//									// TODO Auto-generated catch block
//									e1.printStackTrace();
//								}
//						}		 

				if (!yzm.s.equals(textField_yanzheng.getText())) {
					JOptionPane.showMessageDialog(this, "验证码错误", "错误", JOptionPane.INFORMATION_MESSAGE);
					try {
						yzm.pic();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					;
					ImageIcon newicon = new ImageIcon(
							"/Users/zheyu/eclipse-workspace/vCampus/src/icon/icons/yanzheng" + yanzheng.time + ".jpg");
					pic.setIcon(newicon);

					pic.setBounds(130, 265, 100, 30);
					return;
				}

				fs = new StuMF();
				fs.setVisible(true);
				this.dispose();
			} else {
				passwordField.setText("");
				comboBox_usertype.setSelectedIndex(0);
				JOptionPane.showMessageDialog(this, "用户名或密码错误", "错误", JOptionPane.INFORMATION_MESSAGE, icon);
				return;
			}
		}
	}

	protected void reset(ActionEvent e) {
		// TODO Auto-generated method stub
		// 重置

		textField_username.setText("");

		passwordField.setText("");
		comboBox_usertype.setSelectedIndex(0);
	}
}
