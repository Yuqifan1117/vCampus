package client.selectCourse;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vcampus.vo.Course;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;

public class admCourseAdd_old extends JFrame {

	/**
	 * 
	 * @author Administrator
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField courseID;
	private JTextField courseName;
	private JTextField courseDate;
	private JTextField coursePlace;
	private JTextField courseHour;
	private JTextField teacherUserID;
	private JTextField teacherName;
	private JTextField deptName;
	private JTextField credit;
	private JTextField stuNumLimit;
	private JButton Button_confirm;
	private JButton Button_reset;
	private JButton Button_cancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admCourseAdd_old frame = new admCourseAdd_old();
					frame.setResizable(false);
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
	public admCourseAdd_old() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel label = new JLabel("课程代码");
		label.setBounds(15, 13, 72, 18);
		contentPane.add(label);

		JLabel label_1 = new JLabel("课程名称");
		label_1.setBounds(15, 44, 72, 18);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("上课时间");// �ܼ�
		label_2.setBounds(15, 75, 72, 18);
		contentPane.add(label_2);
		
		

		JLabel label_3 = new JLabel("上课地点");
		label_3.setBounds(15, 106, 72, 18);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("学时");
		label_4.setBounds(15, 137, 72, 18);
		contentPane.add(label_4);

		JLabel label_5 = new JLabel("教师ID");
		label_5.setBounds(15, 168, 72, 18);
		contentPane.add(label_5);

		JLabel label_6 = new JLabel("教师名称");
		label_6.setBounds(15, 199, 72, 18);
		contentPane.add(label_6);

		JLabel label_7 = new JLabel("学院");
		label_7.setBounds(15, 230, 72, 18);
		contentPane.add(label_7);

		JLabel label_8 = new JLabel("学分");
		label_8.setBounds(15, 261, 72, 18);
		contentPane.add(label_8);

		JLabel label_9 = new JLabel("人数");
		label_9.setBounds(15, 292, 72, 18);
		contentPane.add(label_9);

		courseID = new JTextField();
		courseID.setColumns(10);
		courseID.setBounds(100, 13, 195, 18);
		contentPane.add(courseID);

		courseName = new JTextField();
		courseName.setBounds(100, 44, 195, 18);
		contentPane.add(courseName);
		courseName.setColumns(10);

		courseDate = new JTextField();
		courseDate.setColumns(10);
		courseDate.setBounds(100, 75, 195, 18);
		contentPane.add(courseDate);

		coursePlace = new JTextField();
		coursePlace.setColumns(10);
		coursePlace.setBounds(100, 106, 195, 18);
		contentPane.add(coursePlace);

		courseHour = new JTextField();
		courseHour.setColumns(10);
		courseHour.setBounds(100, 137, 195, 18);
		contentPane.add(courseHour);

		teacherUserID = new JTextField();
		teacherUserID.setColumns(10);
		teacherUserID.setBounds(100, 168, 195, 18);
		contentPane.add(teacherUserID);

		teacherName = new JTextField();
		teacherName.setColumns(10);
		teacherName.setBounds(100, 199, 195, 18);
		contentPane.add(teacherName);

		deptName = new JTextField();
		deptName.setColumns(10);
		deptName.setBounds(100, 230, 195, 18);
		contentPane.add(deptName);

		credit = new JTextField();
		credit.setColumns(10);
		credit.setBounds(100, 261, 195, 18);
		contentPane.add(credit);

		stuNumLimit = new JTextField();
		stuNumLimit.setColumns(10);
		stuNumLimit.setBounds(100, 292, 195, 18);
		contentPane.add(stuNumLimit);

		Button_confirm = new JButton("ȷ��");
		Button_confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// confirm
				String s_courseID = courseID.getText();
				String s_courseName = courseName.getText();
				String s_deptName = courseName.getText();
				String s_teacherUserID = teacherUserID.getText();
				String s_teacherName = teacherName.getText();
				int D_courseDate = Integer.parseInt(courseDate.getText());
				int i_courseHour = Integer.parseInt(courseHour.getText());
				double d_credit = Double.parseDouble(courseHour.getText());
				String s_coursePlace = coursePlace.getText();
				int i_stuNumLimit = Integer.parseInt(stuNumLimit.getText());
				Course newCourse = new Course(s_courseID, s_courseName, s_deptName, s_teacherUserID, s_teacherName,
						i_courseHour, d_credit, D_courseDate/10,D_courseDate%10, s_coursePlace, i_stuNumLimit, 0/*m_currentNumber*/);
//						(String courseID, String courseName, String deptName, String teacherUserID, String teacherName, int courseHour,
//								double credit, Date courseDate, String coursePlace, int numberLimit, int currentNumber)
				JOptionPane.showMessageDialog(null, "��ӿγ̳ɹ�", "��ѡ��ϵͳ��", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		Button_confirm.setBounds(15, 325, 80, 27);
		contentPane.add(Button_confirm);

		Button_reset = new JButton("����");
		Button_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				courseName.setText("");
				courseDate.setText("");
				coursePlace.setText("");
				courseHour.setText("");
				teacherUserID.setText("");
				teacherName.setText("");
				deptName.setText("");
				credit.setText("");
				stuNumLimit.setText("");
			}
		});
		Button_reset.setBounds(115, 325, 80, 27);
		contentPane.add(Button_reset);
	}
}
