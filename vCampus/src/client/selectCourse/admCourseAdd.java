package client.selectCourse;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.Box;

public class admCourseAdd extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField courseID;
	private JTextField courseName;
	private JTextField coursePlace;
	private JTextField courseHoure;
	private JTextField teacherUserID;
	private JTextField teacherName;
	private JTextField deptName;
	private JTextField credit;
	private JTextField stuNumLimit;

	private Object[] week = { "周一", "周二", "周三", "周四", "周五", "周六", "周日" };
	private Object[] order = { "第一节", "第二节", "第三节", "第四节", "第五节", "第六节", "第七节", "第八节", "第九节", "第十节", "第十一节", "第十二节",
			"第十三节" };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admCourseAdd frame = new admCourseAdd();
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
	public admCourseAdd() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 60, 30, 90, 90 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 60.0, 30.0, 90.0, 90.0 };
		gbl_contentPane.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0,
				Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel label_courseID = new JLabel("\u8BFE\u7A0B\u4EE3\u53F7");
		GridBagConstraints gbc_label_courseID = new GridBagConstraints();
		gbc_label_courseID.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_courseID.insets = new Insets(0, 0, 5, 5);
		gbc_label_courseID.gridx = 0;
		gbc_label_courseID.gridy = 0;
		contentPane.add(label_courseID, gbc_label_courseID);

		courseID = new JTextField();
		courseID.setColumns(10);
		GridBagConstraints gbc_courseID = new GridBagConstraints();
		gbc_courseID.fill = GridBagConstraints.HORIZONTAL;
		gbc_courseID.gridwidth = 3;
		gbc_courseID.insets = new Insets(0, 0, 5, 0);
		gbc_courseID.gridx = 1;
		gbc_courseID.gridy = 0;
		contentPane.add(courseID, gbc_courseID);

		JLabel label_courseName = new JLabel("\u8BFE\u7A0B\u540D\u79F0");
		GridBagConstraints gbc_label_courseName = new GridBagConstraints();
		gbc_label_courseName.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_courseName.insets = new Insets(0, 0, 5, 5);
		gbc_label_courseName.gridx = 0;
		gbc_label_courseName.gridy = 1;
		contentPane.add(label_courseName, gbc_label_courseName);

		courseName = new JTextField();
		courseName.setColumns(10);
		GridBagConstraints gbc_courseName = new GridBagConstraints();
		gbc_courseName.fill = GridBagConstraints.HORIZONTAL;
		gbc_courseName.gridwidth = 3;
		gbc_courseName.insets = new Insets(0, 0, 5, 0);
		gbc_courseName.gridx = 1;
		gbc_courseName.gridy = 1;
		contentPane.add(courseName, gbc_courseName);

		JLabel label_courseDate = new JLabel("\u4E0A\u8BFE\u65F6\u95F4");
		GridBagConstraints gbc_label_courseDate = new GridBagConstraints();
		gbc_label_courseDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_courseDate.insets = new Insets(0, 0, 5, 5);
		gbc_label_courseDate.gridx = 0;
		gbc_label_courseDate.gridy = 2;
		contentPane.add(label_courseDate, gbc_label_courseDate);

		JComboBox comboBox_week = new JComboBox(week);
		GridBagConstraints gbc_comboBox_week = new GridBagConstraints();
		gbc_comboBox_week.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_week.gridwidth = 2;
		gbc_comboBox_week.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_week.gridx = 1;
		gbc_comboBox_week.gridy = 2;
		contentPane.add(comboBox_week, gbc_comboBox_week);

		JComboBox comboBox_order = new JComboBox(order);
		GridBagConstraints gbc_comboBox_order = new GridBagConstraints();
		gbc_comboBox_order.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_order.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_order.gridx = 3;
		gbc_comboBox_order.gridy = 2;
		contentPane.add(comboBox_order, gbc_comboBox_order);

		JLabel label_coursePlace = new JLabel("\u4E0A\u8BFE\u5730\u70B9");
		GridBagConstraints gbc_label_coursePlace = new GridBagConstraints();
		gbc_label_coursePlace.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_coursePlace.insets = new Insets(0, 0, 5, 5);
		gbc_label_coursePlace.gridx = 0;
		gbc_label_coursePlace.gridy = 3;
		contentPane.add(label_coursePlace, gbc_label_coursePlace);

		coursePlace = new JTextField();
		coursePlace.setColumns(10);
		GridBagConstraints gbc_coursePlace = new GridBagConstraints();
		gbc_coursePlace.fill = GridBagConstraints.HORIZONTAL;
		gbc_coursePlace.gridwidth = 3;
		gbc_coursePlace.insets = new Insets(0, 0, 5, 0);
		gbc_coursePlace.gridx = 1;
		gbc_coursePlace.gridy = 3;
		contentPane.add(coursePlace, gbc_coursePlace);

		JLabel courseHour = new JLabel("\u6BCF\u8282\u5B66\u65F6");
		GridBagConstraints gbc_courseHour = new GridBagConstraints();
		gbc_courseHour.fill = GridBagConstraints.HORIZONTAL;
		gbc_courseHour.insets = new Insets(0, 0, 5, 5);
		gbc_courseHour.gridx = 0;
		gbc_courseHour.gridy = 4;
		contentPane.add(courseHour, gbc_courseHour);

		courseHoure = new JTextField();
		courseHoure.setColumns(10);
		GridBagConstraints gbc_courseHoure = new GridBagConstraints();
		gbc_courseHoure.fill = GridBagConstraints.HORIZONTAL;
		gbc_courseHoure.gridwidth = 3;
		gbc_courseHoure.insets = new Insets(0, 0, 5, 0);
		gbc_courseHoure.gridx = 1;
		gbc_courseHoure.gridy = 4;
		contentPane.add(courseHoure, gbc_courseHoure);

		JLabel label_teacherUserID = new JLabel("\u6559\u5E08ID");
		GridBagConstraints gbc_label_teacherUserID = new GridBagConstraints();
		gbc_label_teacherUserID.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_teacherUserID.insets = new Insets(0, 0, 5, 5);
		gbc_label_teacherUserID.gridx = 0;
		gbc_label_teacherUserID.gridy = 5;
		contentPane.add(label_teacherUserID, gbc_label_teacherUserID);

		teacherUserID = new JTextField();
		teacherUserID.setColumns(10);
		GridBagConstraints gbc_teacherUserID = new GridBagConstraints();
		gbc_teacherUserID.fill = GridBagConstraints.HORIZONTAL;
		gbc_teacherUserID.gridwidth = 3;
		gbc_teacherUserID.insets = new Insets(0, 0, 5, 0);
		gbc_teacherUserID.gridx = 1;
		gbc_teacherUserID.gridy = 5;
		contentPane.add(teacherUserID, gbc_teacherUserID);

		JLabel label_teacherName = new JLabel("\u6559\u5E08\u540D\u79F0");
		GridBagConstraints gbc_label_teacherName = new GridBagConstraints();
		gbc_label_teacherName.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_teacherName.insets = new Insets(0, 0, 5, 5);
		gbc_label_teacherName.gridx = 0;
		gbc_label_teacherName.gridy = 6;
		contentPane.add(label_teacherName, gbc_label_teacherName);

		teacherName = new JTextField();
		teacherName.setColumns(10);
		GridBagConstraints gbc_teacherName = new GridBagConstraints();
		gbc_teacherName.fill = GridBagConstraints.HORIZONTAL;
		gbc_teacherName.gridwidth = 3;
		gbc_teacherName.insets = new Insets(0, 0, 5, 0);
		gbc_teacherName.gridx = 1;
		gbc_teacherName.gridy = 6;
		contentPane.add(teacherName, gbc_teacherName);

		JLabel label_deptName = new JLabel("\u5F00\u8BBE\u5B66\u9662");
		GridBagConstraints gbc_label_deptName = new GridBagConstraints();
		gbc_label_deptName.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_deptName.insets = new Insets(0, 0, 5, 5);
		gbc_label_deptName.gridx = 0;
		gbc_label_deptName.gridy = 7;
		contentPane.add(label_deptName, gbc_label_deptName);

		deptName = new JTextField();
		deptName.setColumns(10);
		GridBagConstraints gbc_deptName = new GridBagConstraints();
		gbc_deptName.fill = GridBagConstraints.HORIZONTAL;
		gbc_deptName.gridwidth = 3;
		gbc_deptName.insets = new Insets(0, 0, 5, 0);
		gbc_deptName.gridx = 1;
		gbc_deptName.gridy = 7;
		contentPane.add(deptName, gbc_deptName);

		JLabel label_credit = new JLabel("\u5B66\u5206");
		GridBagConstraints gbc_label_credit = new GridBagConstraints();
		gbc_label_credit.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_credit.insets = new Insets(0, 0, 5, 5);
		gbc_label_credit.gridx = 0;
		gbc_label_credit.gridy = 8;
		contentPane.add(label_credit, gbc_label_credit);

		credit = new JTextField();
		credit.setColumns(10);
		GridBagConstraints gbc_credit = new GridBagConstraints();
		gbc_credit.fill = GridBagConstraints.HORIZONTAL;
		gbc_credit.gridwidth = 3;
		gbc_credit.insets = new Insets(0, 0, 5, 0);
		gbc_credit.gridx = 1;
		gbc_credit.gridy = 8;
		contentPane.add(credit, gbc_credit);

		JLabel label_stuNumLimit = new JLabel("\u4EBA\u6570");
		GridBagConstraints gbc_label_stuNumLimit = new GridBagConstraints();
		gbc_label_stuNumLimit.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_stuNumLimit.insets = new Insets(0, 0, 5, 5);
		gbc_label_stuNumLimit.gridx = 0;
		gbc_label_stuNumLimit.gridy = 9;
		contentPane.add(label_stuNumLimit, gbc_label_stuNumLimit);

		stuNumLimit = new JTextField();
		stuNumLimit.setColumns(10);
		GridBagConstraints gbc_stuNumLimit = new GridBagConstraints();
		gbc_stuNumLimit.fill = GridBagConstraints.HORIZONTAL;
		gbc_stuNumLimit.gridwidth = 3;
		gbc_stuNumLimit.insets = new Insets(0, 0, 5, 0);
		gbc_stuNumLimit.gridx = 1;
		gbc_stuNumLimit.gridy = 9;
		contentPane.add(stuNumLimit, gbc_stuNumLimit);

		JButton Button_confirm = new JButton("确认");
		Button_confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		GridBagConstraints gbc_Button_confirm = new GridBagConstraints();
		gbc_Button_confirm.fill = GridBagConstraints.HORIZONTAL;
		gbc_Button_confirm.gridwidth = 2;
		gbc_Button_confirm.insets = new Insets(0, 0, 0, 5);
		gbc_Button_confirm.gridx = 0;
		gbc_Button_confirm.gridy = 11;
		contentPane.add(Button_confirm, gbc_Button_confirm);

		JButton Button_reset = new JButton("重置");
		Button_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				courseID.setText("");
				courseName.setText("");
				coursePlace.setText("");
				courseHoure.setText("");
				teacherUserID.setText("");
				teacherName.setText("");
				deptName.setText("");
				credit.setText("");
				stuNumLimit.setText("");
				comboBox_week.setSelectedIndex(0);
				comboBox_order.setSelectedIndex(0);
//				private JTextField courseID;
//				private JTextField courseName;
//				private JTextField coursePlace;
//				private JTextField courseHoure;
//				private JTextField teacherUserID;
//				private JTextField teacherName;
//				private JTextField deptName;
//				private JTextField credit;
//				private JTextField stuNumLimit;
			}
		});
		GridBagConstraints gbc_Button_reset = new GridBagConstraints();
		gbc_Button_reset.fill = GridBagConstraints.HORIZONTAL;
		gbc_Button_reset.insets = new Insets(0, 0, 0, 5);
		gbc_Button_reset.gridx = 2;
		gbc_Button_reset.gridy = 11;
		contentPane.add(Button_reset, gbc_Button_reset);

		JButton Button_cancel = new JButton("取消");
		Button_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		GridBagConstraints gbc_Button_cancel = new GridBagConstraints();
		gbc_Button_cancel.fill = GridBagConstraints.HORIZONTAL;
		gbc_Button_cancel.gridx = 3;
		gbc_Button_cancel.gridy = 11;
		contentPane.add(Button_cancel, gbc_Button_cancel);
	}

}
