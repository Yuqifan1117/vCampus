package client.selectCourse;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

///////////////////////
import vcampus.vo.*;///////////////////////

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import client.socket.*;///////////////////////

public class stuCourseCheck extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	private String studentID;
	private String StudentName;
	private Object[][] data = { { "", "", "", "", "", "", "", "" } };
	private Object[] columnNames = { "", "周一", "周二", "周三", "周四", "周五", "周六", "周日" };
	private CopyOnWriteArrayList<Course> selectedCourseTable = null;
	private stuCourseSelect SCS_jf;
	private stuCourseDrop SCD_jf;
	private courseSearchByKeyword CSBK_jf;
	private courseSearchByTime CSBT_jf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stuCourseCheck frame = new stuCourseCheck("4568", "tom");
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
	public stuCourseCheck(String id, String name) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 500);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("选课");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("选课");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (SCS_jf == null) {
					SCS_jf = new stuCourseSelect(studentID, StudentName);
					SCS_jf.setVisible(true);
				} else {
					SCS_jf.setVisible(true);
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("退课");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (SCD_jf == null) {
					SCD_jf = new stuCourseDrop(studentID, StudentName);
					SCD_jf.setVisible(true);
				} else {
					SCD_jf.setVisible(true);
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);

		JMenu mnNewMenu_1 = new JMenu("查询");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem = new JMenuItem("按关键字查询");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (CSBK_jf == null) {
					CSBK_jf = new courseSearchByKeyword();
					CSBK_jf.setVisible(true);
				} else {
					CSBK_jf.setVisible(true);
				}
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("按时间查询");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (CSBT_jf == null) {
					CSBT_jf = new courseSearchByTime();
					CSBT_jf.setVisible(true);
				} else {
					CSBT_jf.setVisible(true);
				}
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		studentID = id;
		StudentName = name;
		this.setTitle("welcome" + studentID + StudentName);

		setData(id);

		DefaultTableModel model = new DefaultTableModel(data, columnNames) {
			public boolean isCellEditable(int row, int column) {
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
	}

	private void setData(String ID) {
		int course_num = 0;

		Object[][] a = { { "第一节", "", "", "", "", "", "", "" }, { "第二节", "", "", "", "", "", "", "" },
				{ "第三节", "", "", "", "", "", "", "" }, { "第四节", "", "", "", "", "", "", "" },
				{ "第五节", "", "", "", "", "", "", "" }, { "午休", "", "", "", "", "", "", "" },
				{ "第六节", "", "", "", "", "", "", "" }, { "第七节", "", "", "", "", "", "", "" },
				{ "第八节", "", "", "", "", "", "", "" }, { "第九节", "", "", "", "", "", "", "" },
				{ "第十节", "", "", "", "", "", "", "" }, { "傍晚", "", "", "", "", "", "", "" },
				{ "第十一节", "", "", "", "", "", "", "" }, { "第十二节", "", "", "", "", "", "", "" },
				{ "第十三节", "", "", "", "", "", "", "" }, };
//		Request MyRequest = new Request();///////////////////////
//		Request Response = new Request();
//		MyRequest.setRequest_ID(300);///////////////////////
//		clientSocket MySocket = new clientSocket();///////////////////////
//		Response= MySocket.sendRequestToServer(MyRequest);
//		System.out.println(MyRequest.getRequest_ID());
//		System.out.println(Response.getRequest_ID());

		Request clientRequest = new Request();
		clientRequest.setRequest_ID(300);
		
		Student temp = new Student();
		temp.setStudentID(ID);
		clientRequest.set_student(temp);
		
		clientSocket Sample = new clientSocket();
		Request Response = Sample.sendRequestToServer(clientRequest);
		
		System.out.println(Response.getRequest_ID());
		System.out.println(Response.getCheckResult());
		
		if (Response.getCheckResult()) {
			selectedCourseTable = Response.get_courseList();///////////////////////
			course_num = selectedCourseTable.size();
			System.out.println(course_num);

			for (int i = 0; i < course_num; i++) {
				System.out.println(i);
				
//				int row = selectedCourseTable.get(i).getCourseDay();
//				int col = selectedCourseTable.get(i).getCourseOrder();
//				System.out.println(row);
//				System.out.println(col);
				Course s = selectedCourseTable.get(i);
				String courseName = selectedCourseTable.get(i).getCourseName();
				String coursePlace = selectedCourseTable.get(i).getCoursePlace();
//				a[row + 1][col] = courseName + " " + coursePlace;
				System.out.println(i+courseName+coursePlace);
			}

			data = a;
		} else {
			System.out.println("something happened");
		}
	}
}
