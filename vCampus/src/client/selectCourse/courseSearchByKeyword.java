package client.selectCourse;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Panel;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class courseSearchByKeyword extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable newTable;

	private Object[][] data = { { "", "", "", "", "", "", "", "" } };
	private Label label;
	private TextField textField;
	private Button button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					courseSearchByKeyword frame = new courseSearchByKeyword();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

//	String courseID;
//	String courseName;
//	String deptName;
//	String teacherName;
//	int courseHour;
//	double credit;
//	Date courseDate;
//	String coursePlace;

//	int numberLimit;

//	int currentNumber;
//	double score;

	/**
	 * Create the frame.
	 */
	public courseSearchByKeyword() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		Object[] columnNames = { "周一", "周二", "周三", "周四", "周五", "周六", "周日" };

		setDataByKeyword("");

		DefaultTableModel model = new DefaultTableModel(data,columnNames){
			public boolean isCellEditable(int row,int column) {
				return false;
				}
		};
		table = new JTable(model);
		table.getTableHeader().setResizingAllowed(false);// 禁止改变列宽
		table.getTableHeader().setReorderingAllowed(false);// 禁止改变列顺序
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// 禁止自动改变大小

		contentPane.add(table.getTableHeader(), BorderLayout.NORTH);
		contentPane.add(table, BorderLayout.CENTER);
		contentPane.add(table);

		Panel panel = new Panel();
		contentPane.add(panel, BorderLayout.SOUTH);

		label = new Label("请输入关键字");
		panel.add(label);

		textField = new TextField();
		textField.setColumns(20);
		panel.add(textField);

		button = new Button("查询");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String key = textField.getText();
				setDataByKeyword(key);
				table.setVisible(false);
				
				newTable = new JTable(data, columnNames);
				newTable.getTableHeader().setResizingAllowed(false);// ��ֹ�ı��п�
				newTable.getTableHeader().setReorderingAllowed(false);// ��ֹ�ı���˳��
				newTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// ��ֹ�Զ��ı��С

				contentPane.add(newTable.getTableHeader(), BorderLayout.NORTH);
				contentPane.add(newTable, BorderLayout.CENTER);
				contentPane.add(newTable);
			}
		});
		panel.add(button);
	}

	public void setDataByKeyword(String keyword) {
//		������пγ̣�����ArrayList<Course>allCourseTable
//		int course_num = allCourseTable.size();// ��ѡ�γ���
//		allCourseTable = showAllCourse();
//		course_num = allCourseTable.size();
//
//		Object[][] a = new Object[course_num][8];
//		if (course_num != 0) {
//			for (int row = 0; row < course_num; row++) {
//				if (allCourseTable.get(row).getCourseID() == keyword
//						|| allCourseTable.get(row).getCourseName() == keyword
//						|| allCourseTable.get(row).getCourseDate() == keyword
//						|| allCourseTable.get(row).getCoursePlace == keyword
//						|| allCourseTable.get(row).getTeacherName() == keyword
//						|| allCourseTable.get(row).getCredit() == keyword
//						|| allCourseTable.get(row).getDeptName() == keyword
//						|| allCourseTable.get(row).getCoursePlace() == keyword) {
//					a[row][0] = allCourseTable.get(row).getCourseID();
//					a[row][1] = allCourseTable.get(row).getCourseName();
//					a[row][2] = allCourseTable.get(row).getCourseDate();
//					a[row][3] = allCourseTable.get(row).getCoursePlace();
//					a[row][4] = allCourseTable.get(row).getTeacherName();
//					a[row][5] = allCourseTable.get(row).getCredit();
//					a[row][6] = allCourseTable.get(row).getDeptName();
//					a[row][7] = allCourseTable.get(row).getCoursePlace();
//				}
//			}
//		}

		Object[][] a = { { "52996", "math", "fri", "j8-956", "mary", "4 ", "math", "available" },
				{ "525", "math8", "fri", "j8-986", "mary", "4 ", "math", "available" } };

		Object[][] b = { { "526", "math", "fri", "j8-956", "mary", "4 ", "math", "full" },
				{ "525", "math8", "fri", "j8-986", "mary", "4 ", "math", "full" },
				{ "52776", "math99", "fri", "j8-9596", "mary", "4 ", "math", "full" } };

		if (keyword == "") {
			data = b;
		} else {
			data = a;
		}
	}
}
