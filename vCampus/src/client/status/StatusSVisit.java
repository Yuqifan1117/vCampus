package client.status;

import java.awt.*;
import vcampus.vo.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import client.socket.clientSocket;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import vcampus.server.biz.*;
import vcampus.server.exception.*;

public class StatusSVisit extends JFrame {
	private StudentServiceDao Service;
	private JPanel contentPane;
	private JTextField textField_name;
	private JTextField textField_number;
	private JTextField textField_age;
	private JTextField textField_academy;
	private JTextField textField_ID;
	private JTextField textField_gender;
	private JTextField textField_birth;
	private JTextField textField_grade;
	private JTextField textField_date;
	private JTextField textField_major;
	private JTextField textField_schyear;
	private JButton button_change;
	private JButton button_exit;
	private Student s;
	private int UserType;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * 
	 * @wbp.parser.constructor
	 */
	public StatusSVisit(String UserID, int Type) {
		// Service=new StudentServiceDaoImpl();
		/*
		 * String tid="1000"; try { s = Service.findByUserID(tid);
		 * 
		 * } catch (RecordNotFoundException e2) { // TODO Auto-generated catch block
		 * e2.printStackTrace(); }
		 */
		UserType = Type;
		Request clientRequest = new Request();
		clientRequest.setRequest_ID(203);
		Student temp = new Student();
		temp.setId(UserID);
		clientRequest.set_student(temp);
		clientSocket Sample = new clientSocket();
		Request Result = Sample.sendRequestToServer(clientRequest);
		System.out.println(Result.getCheckResult());
		if (Result.getCheckResult()) {
			s = Result.get_student();
		}
		BuildFrame();
	}

	public StatusSVisit(Student ts, int Type) {
		// Service=new StudentServiceDaoImpl();
		s = ts;
		UserType = Type;
		BuildFrame();
	}

	public void BuildFrame() {
		// Frame初始化

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(12, 12, 12, 12));
		setContentPane(contentPane);

		JLabel label_name = new JLabel("\u59D3\u540D");

		textField_name = new JTextField();
		textField_name.setColumns(3);

		JLabel label_gender = new JLabel("性别");

		textField_gender = new JTextField();
		textField_gender.setColumns(3);

		JLabel label_major = new JLabel("专业");

		textField_major = new JTextField();
		textField_major.setColumns(3);

		JLabel label_number = new JLabel("学号");

		textField_number = new JTextField();
		textField_number.setColumns(3);

		JLabel label_birth = new JLabel("出生日期");

		textField_birth = new JTextField();
		textField_birth.setColumns(3);

		JLabel label_age = new JLabel("年龄");

		textField_age = new JTextField();
		textField_age.setColumns(3);

		JLabel label_grade = new JLabel("年级");

		textField_grade = new JTextField();
		textField_grade.setColumns(3);

		JLabel label_schyear = new JLabel("学制");

		textField_schyear = new JTextField();
		textField_schyear.setColumns(3);

		JLabel label_academy = new JLabel("学院");

		textField_academy = new JTextField();
		textField_academy.setColumns(3);

		JLabel label_date = new JLabel("入学年份");

		textField_date = new JTextField();
		textField_date.setColumns(3);
		button_change = new JButton("编辑");
		JLabel label_ID = new JLabel("身份证号");
		if (UserType != 0) {
			button_change.setEnabled(false);
		}
		textField_ID = new JTextField();
		textField_ID.setColumns(3);

		textField_name.setText(s.getName());
		textField_number.setText(s.getStudentID());
		textField_age.setText(Integer.toString(s.getAge()));
		textField_academy.setText(s.getAcademy());
		textField_ID.setText(s.getId());
		textField_gender.setText(s.getSex());
		textField_birth.setText(s.getBirth());
		textField_grade.setText(s.getGrade());
		textField_date.setText(s.getDate());
		textField_major.setText(s.getMajor());
		textField_schyear.setText(Integer.toString(s.getSchyear()));

		JButton button_finish = new JButton("完成");
		// 完成按钮响应
		button_finish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// 保存信息
				// try {
				String name = textField_name.getText();
				String number = textField_number.getText();
				int age = Integer.parseInt(textField_age.getText());
				String academy = textField_academy.getText();
				String ID = textField_ID.getText();
				String gender = textField_gender.getText();
				String birth = textField_birth.getText();
				String grade = textField_grade.getText();
				String date = textField_date.getText();
				String major = textField_major.getText();
				int schyear = Integer.parseInt(textField_schyear.getText());

				s.setName(name);
				s.setStudentID(number);
				s.setId(ID);
				s.setGrade(grade);
				s.setMajor(major);
				s.setSex(gender);
				s.setAcademy(academy);
				s.setAge(age);
				s.setBirth(birth);
				s.setDate(date);
				s.setSchyear(schyear);

				// Service.updateStudentInfo(s);
				Request clientRequest = new Request();
				clientRequest.setRequest_ID(202);
				clientRequest.set_student(s);
				clientSocket Sample = new clientSocket();
				Request Result = Sample.sendRequestToServer(clientRequest);
				// 不允许编辑
				textField_name.setEditable(false);
				textField_number.setEditable(false);
				textField_age.setEditable(false);
				textField_academy.setEditable(false);
				textField_gender.setEditable(false);
				textField_birth.setEditable(false);
				textField_grade.setEditable(false);
				textField_date.setEditable(false);
				textField_major.setEditable(false);
				textField_schyear.setEditable(false);
				button_finish.setVisible(false);
				button_change.setVisible(true);
				/*
				 * } catch (RecordNotFoundException e1) { // TODO Auto-generated catch block
				 * e1.printStackTrace(); }catch(NumberFormatException z) {
				 * JOptionPane.showMessageDialog(null, "年龄、学制应输入数字", "错误",
				 * JOptionPane.ERROR_MESSAGE); }
				 */
			}
		});
		button_finish.setVisible(false);
		// 编辑按钮响应
		button_change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 允许编辑
				textField_name.setEditable(true);
				textField_number.setEditable(true);
				textField_age.setEditable(true);
				textField_academy.setEditable(true);
				textField_gender.setEditable(true);
				textField_birth.setEditable(true);
				textField_grade.setEditable(true);
				textField_date.setEditable(true);
				textField_major.setEditable(true);
				textField_schyear.setEditable(true);
				button_finish.setVisible(true);
				button_change.setVisible(false);
			}
		});

		button_exit = new JButton("退出");
		// 退出按钮响应
		button_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 退出确认弹窗
				int exit = JOptionPane.showConfirmDialog(null, "是否退出", "退出", JOptionPane.YES_NO_OPTION);
				if (exit == JOptionPane.YES_OPTION) {
					dispose();
				}
			}
		});
		textField_name.setEditable(false);
		textField_number.setEditable(false);
		textField_age.setEditable(false);
		textField_academy.setEditable(false);
		textField_ID.setEditable(false);
		textField_gender.setEditable(false);
		textField_birth.setEditable(false);
		textField_grade.setEditable(false);
		textField_date.setEditable(false);
		textField_major.setEditable(false);
		textField_schyear.setEditable(false);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(
				gl_contentPane.createSequentialGroup().addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(label_ID).addGap(5)
								.addComponent(textField_ID, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
								.addGap(319))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
										.createSequentialGroup().addGap(15).addComponent(label_name).addGap(20)
										.addComponent(textField_name, GroupLayout.PREFERRED_SIZE, 85,
												GroupLayout.PREFERRED_SIZE)
										.addGap(20).addComponent(label_gender)
										.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
										.addComponent(textField_gender, GroupLayout.PREFERRED_SIZE, 86,
												GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
												.addComponent(label_academy).addGap(20)
												.addComponent(textField_academy, GroupLayout.PREFERRED_SIZE, 85,
														GroupLayout.PREFERRED_SIZE)
												.addGap(5)
												.addComponent(label_date, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(textField_date, GroupLayout.PREFERRED_SIZE, 86,
														GroupLayout.PREFERRED_SIZE)
												.addGap(0))
										.addGroup(gl_contentPane.createSequentialGroup().addGap(15)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_contentPane.createSequentialGroup()
																.addComponent(label_age).addGap(20)
																.addComponent(textField_age, GroupLayout.PREFERRED_SIZE,
																		85, GroupLayout.PREFERRED_SIZE)
																.addGap(20).addComponent(label_grade))
														.addGroup(gl_contentPane.createSequentialGroup()
																.addComponent(label_number).addGap(20)
																.addComponent(textField_number,
																		GroupLayout.PREFERRED_SIZE, 84,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(label_birth, GroupLayout.DEFAULT_SIZE, 60,
																		Short.MAX_VALUE)))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
														.addComponent(textField_grade, Alignment.LEADING,
																GroupLayout.PREFERRED_SIZE, 85,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(textField_birth, GroupLayout.PREFERRED_SIZE, 85,
																GroupLayout.PREFERRED_SIZE))))
								.addGap(34)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup().addComponent(label_schyear)
												.addGap(5).addComponent(textField_schyear, GroupLayout.PREFERRED_SIZE,
														93, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup().addComponent(label_major)
												.addGap(5).addComponent(textField_major, GroupLayout.PREFERRED_SIZE, 93,
														GroupLayout.PREFERRED_SIZE)))))
						.addGap(0))
				.addGroup(Alignment.TRAILING,
						gl_contentPane.createSequentialGroup().addContainerGap(240, Short.MAX_VALUE)
								.addComponent(button_change).addGap(8)
								.addComponent(button_exit, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(button_finish, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
								.addGap(23)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(3).addComponent(label_name))
						.addComponent(textField_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(3).addComponent(label_gender))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(3).addComponent(label_major))
						.addComponent(textField_major, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_gender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup().addGap(35)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(3).addComponent(label_number))
								.addComponent(textField_number, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_birth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(38).addComponent(label_birth)))
				.addGap(35)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(3).addComponent(label_age))
						.addComponent(textField_age, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(3).addComponent(label_grade))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(3).addComponent(label_schyear))
						.addComponent(textField_schyear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_grade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(35)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(3).addComponent(label_academy))
						.addComponent(textField_academy, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(3).addGroup(
								gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(label_date)
										.addComponent(textField_date, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(38).addComponent(label_ID))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(35).addComponent(textField_ID,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addGap(39)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(button_exit)
						.addComponent(button_change).addComponent(button_finish, GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))));
		contentPane.setLayout(gl_contentPane);
	}
}
