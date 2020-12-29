package client.selectCourse;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import vcampus.vo.Course;

public class admCourseCheck extends JFrame {

	private JPanel contentPane;
	private JTable table;

	private Object[][] data = { { "", "", "", "", "", "", "", "" } };
	private ArrayList<Course>allCourseTable = null;
	private admCourseAdd ACA_jf;
	private admCourseDelete ACD_jf;
	private courseSearchByKeyword CSBK_jf;
	private courseSearchByTime CSBT_jf;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admCourseCheck frame = new admCourseCheck();
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
	public admCourseCheck() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("课程管理");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("添加课程");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ACA_jf == null) {
					ACA_jf = new admCourseAdd();
					ACA_jf.setVisible(true);
				}
				else {
					ACA_jf.setVisible(true);
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("删除课程");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ACD_jf == null) {
					ACD_jf = new admCourseDelete();
					ACD_jf.setVisible(true);
				}
				else {
					ACD_jf.setVisible(true);
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
				}
				else {
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
				}
				else {
					CSBT_jf.setVisible(true);
				}	
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Object[] columnNames = { "","周一", "周二", "周三", "周四", "周五", "周六", "周日" };

		setData();

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
	}

	private void setData() {
//		������пγ̣�����ArrayList<Course>allCourseTable
		int course_num = 0;// ���пγ���
//		course_num = allCourseTable.size();

		Object[][] a = { 
				{ "第一节", "", "", "", "", "", "", "" }, 
				{ "第二节", "", "", "", "", "", "", "" },
				{ "第三节", "", "", "", "", "", "", "" }, 
				{ "第四节", "", "", "", "", "", "", "" },
				{ "第五节", "", "", "", "", "", "", "" }, 
				{ "午休", "", "", "", "", "", "", "" },
				{ "第六节", "", "", "", "", "", "", "" }, 
				{ "第七节", "", "", "", "", "", "", "" },
				{ "第八节", "", "", "", "", "", "", "" }, 
				{ "第九节", "", "", "", "", "", "", "" },
				{ "第十节", "", "", "", "", "", "", "" }, 
				{ "傍晚", "", "", "", "", "", "", "" }, 
				{ "第十一节", "", "", "", "", "", "", "" },
				{ "第十二节", "", "", "", "", "", "", "" }, 
				{ "第十三节", "", "", "", "", "", "", "" },
				};

//		for(int i=0; i<course_num; i++) {
//			int row = allCourseTable.get(i).getCourseDate();
//			int col = allCourseTable.get(i).getWeekIndex();
//			String courseName = allCourseTable.get(i).getCourseName();
//			String coursePlace = allCourseTable.get(i).getCoursePlace();
//			a[row + 1][col] = courseName + " " + coursePlace;
//		}

		data = a;
	}

}
