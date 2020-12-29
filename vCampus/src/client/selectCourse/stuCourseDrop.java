package client.selectCourse;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class stuCourseDrop extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTable table;
	private JButton Button_confirm;

	private String studentID;
	private String StudentName;
	private Object[][] data = { { "", "", "", "", "", "", "", "" } };
//	ArrayList<Course> availableCourseTable =null;
	int selectedRow;
	int selectedColumn;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stuCourseDrop frame = new stuCourseDrop("09019101", "tom");
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
	public stuCourseDrop(String id, String name) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		studentID = id;
		StudentName = name;
		this.setTitle("welcome" + studentID + StudentName);
		Object[] columnNames = { "", "周一", "周二", "周三", "周四", "周五", "周六", "周日" };

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
				selectedColumn = table.getSelectedColumn();
			}
		});
		table.getTableHeader().setResizingAllowed(false);// 禁止改变列宽
		table.getTableHeader().setReorderingAllowed(false);// 禁止改变列顺序
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// 禁止自动改变大小

		contentPane.add(table.getTableHeader(), BorderLayout.NORTH);
		contentPane.add(table, BorderLayout.CENTER);
		contentPane.add(table);
		
		Button_confirm = new JButton("确认");
		Button_confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// confirm
//				stuCourseDrop(studentID, selectedCourseTable.get(selectedRow).getCourseID());
				JOptionPane.showMessageDialog(null, "选课成功"  + selectedRow + selectedColumn, "【选课系统】", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		contentPane.add(Button_confirm, BorderLayout.SOUTH);
	}

	private void setData(String ID) {
//		ͨ通过studentID获得所有已选课程ArrayList<Course>selectedCourseTable
		int course_num = 0;// 课程数
//		selectedCourseTable = stuCourseCheck(studentID);
//		course_num = selectedCourseTable.size();

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
//			int row = selectedCourseTable.get(i).getCourseDate();
//			int col = selectedCourseTable.get(i).getWeekIndex();
//			String courseName = selectedCourseTable.get(i).getCourseName();
//			String coursePlace = selectedCourseTable.get(i).getCoursePlace();
//			a[row + 1][col] = courseName + " " + coursePlace;
//		}

		data = a;
	}
}
