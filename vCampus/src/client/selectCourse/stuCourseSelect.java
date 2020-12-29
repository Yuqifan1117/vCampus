package client.selectCourse;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import client.socket.clientSocket;
import vcampus.vo.Request;
import vcampus.vo.Student;

import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class stuCourseSelect extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;

	private String studentID;
	private String StudentName;
	private Object[][] data = { { "", "", "", "", "", "", "", "" } };
//	ArrayList<Course> availableCourseTable =null;
	int selectedRow;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stuCourseSelect frame = new stuCourseSelect("09019101", "tom");
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
	public stuCourseSelect(String id, String name) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		studentID = id;
		StudentName = name;
		this.setTitle("welcome" + studentID + StudentName);
		Object[] columnNames = { "课程代码", "课程名称", "上课时间", "上课时间", "教师", "学分 ", "状态"};

		setData(id);

		DefaultTableModel model = new DefaultTableModel(data,columnNames){
			public boolean isCellEditable(int row,int column) {
				return false;
				}
		};
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedRow = table.getSelectedRow();
			}
		});
		table.getTableHeader().setResizingAllowed(false);// 禁止改变列宽
		table.getTableHeader().setReorderingAllowed(false);// 禁止改变列顺序
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// 禁止自动改变大小
		
		contentPane.add(table.getTableHeader(), BorderLayout.NORTH);
		contentPane.add(table, BorderLayout.CENTER);
		contentPane.add(table);
		
		btnNewButton = new JButton("确认");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// confirm
				Request clientRequest = new Request();
				clientRequest.setRequest_ID(301);
				
				clientSocket Sample = new clientSocket();
				Request Response = Sample.sendRequestToServer(clientRequest);
				
				System.out.println(Response.getRequest_ID());
				System.out.println(Response.getCheckResult());
				
//				stuCourseSelect(studentID, availableCourseTable.get(selectedRow).getCourseID());
				JOptionPane.showMessageDialog(null, "选课成功" + selectedRow, "【选课系统】", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		contentPane.add(btnNewButton, BorderLayout.SOUTH);
	}

	public void setData(String studentID) {
//		ͨ��studentID��ÿ�ѡ�����пγ̣�����ArrayList<Course>availableCourseTable
		int course_num = 3;// ��ѡ�γ���
//		availableCourseTable = showAllSeletedCourse(studentID);
//		course_num = availableCourseTable.size();

//		Object[][] a = new Object[course_num][7];
//		if (course_num != 0) {
//			for (int row = 0; row < course_num; row++) {
//				a[row][0] = availableCourseTable.get(row).getCourseName();
//				a[row][1] = availableCourseTable.get(row).getTeacherName();
//				a[row][2] = availableCourseTable.get(row).getCourseID();
//				a[row][3] = availableCourseTable.get(row).getCoursePlace();
//				a[row][4] = availableCourseTable.get(row).getCredit();
//			}
//		}
		
		Object[][] a = {
				{ "526", "math", "fri", "j8-956", "mary", "4 ", "full" },
				{ "525", "math8", "fri", "j8-986", "mary", "4 ", "full" },
				{ "52776", "math99", "fri", "j8-9596", "mary", "4 ", "full" }
		};

		data = a;
	}
}
