package client.status;

import java.awt.BorderLayout;
import vcampus.server.dao.*;
import vcampus.vo.*;
import java.awt.EventQueue;
import java.awt.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import client.socket.clientSocket;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import vcampus.server.biz.*;
import vcampus.server.exception.RecordNotFoundException;
public class StatusTVisit extends JFrame {

	private JPanel contentPane;
	private JTextField textField_SMessage;
	private JTable table;
	private String UserID;
	private int UserType;

	/**
	 * Launch the application.
	 */
	
	

	/**
	 * Create the frame.
	 */
	public StatusTVisit(String ID,int Type) {
		UserID=ID;
		UserType=Type;
		AdminDao AService=new AdminDaoImpl();
		StudentServiceDao Service=new StudentServiceDaoImpl();
		TeacherDao TService=new TeacherDaoImpl();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500,400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		String[] strstu= {"全部","id","学院"};
		String[] strtea= {"全部","职称","所属机构"};
		JComboBox comboBox_stuchoose = new JComboBox(strstu);
		JComboBox comboBox_teachoose = new JComboBox(strtea);

		textField_SMessage = new JTextField();
		textField_SMessage.setColumns(10);
		Vector tcol=new Vector();
		Vector trow=new Vector();
		Vector row=new Vector();
		Vector f;
		
		
		JButton button_Search = new JButton("查询");
		
		
		
		JButton button_exit = new JButton("退出");
		button_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int exit=JOptionPane.showConfirmDialog(null,"是否退出","退出",JOptionPane.YES_NO_OPTION);
				if(exit==JOptionPane.YES_OPTION) {
				dispose();
				}
			}
		});
		
		
		JButton button_Delete = new JButton("删除");
		
		
		JButton button_Change = new JButton("修改");
		
		
		JScrollPane scrollPane = new JScrollPane();
		Object[] columnName= {"姓名","id","学号","性别","年龄","学院","专业","年级","学制"};
		Vector column=new Vector();
		column.add("姓名");
		column.add("id");
		column.add("学号");
		column.add("性别");
		column.add("年龄");
		column.add("学院");
		column.add("专业");
		column.add("年级");
		column.add("学制");
		Object[][] rowData= {};
		DefaultTableModel model=new DefaultTableModel(rowData,columnName) {
		public boolean isCellEditable(int row,int columnName) {
			return false;
		}
		};
		table = new JTable(model);
		scrollPane.setViewportView(table);
		
		
		
		JRadioButton radioButton_student = new JRadioButton("学生");	
		radioButton_student.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(radioButton_student.isSelected()) {
					comboBox_stuchoose.setVisible(true);
					comboBox_teachoose.setVisible(false);
					tcol.clear();
					row.clear();
					tcol.add("姓名");
					tcol.add("id");
					tcol.add("学号");
					tcol.add("性别");
					tcol.add("年龄");
					tcol.add("学院");
					tcol.add("专业");
					tcol.add("年级");
					tcol.add("学制");
					model.setDataVector(row, tcol);
					table.updateUI();
				}
			}
		});
		JRadioButton radioButton_teacher = new JRadioButton("教师");
		radioButton_teacher.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(radioButton_teacher.isSelected()) {
					comboBox_stuchoose.setVisible(false);
					comboBox_teachoose.setVisible(true);
					tcol.clear();
					row.clear();
					tcol.add("姓名");
					tcol.add("id");
					tcol.add("教师编号");
					tcol.add("性别");
					tcol.add("职称");
					tcol.add("所属机构");
					tcol.add("电话号码");
					model.setDataVector(row, tcol);
					table.updateUI();
				}
			}
		});
		ButtonGroup BG=new ButtonGroup();
		BG.add(radioButton_student);
		BG.add(radioButton_teacher);
		radioButton_student.setSelected(true);
		button_Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				row.clear();
				int chooses=comboBox_stuchoose.getSelectedIndex();	
				int chooset=comboBox_teachoose.getSelectedIndex();
				if(radioButton_student.isSelected()) {
				switch(chooses) {
				case 0:{
						//ArrayList<Student> list=AService.queryAllStudent();
						CopyOnWriteArrayList<Student> list=new CopyOnWriteArrayList();
						Request clientRequest = new Request();
						clientRequest.setRequest_ID(204);
						clientSocket Sample = new clientSocket();
						Request Result = Sample.sendRequestToServer(clientRequest);	
						System.out.println(Result.getRequest_ID());
						System.out.println(Result.getCheckResult());
						if (Result.getCheckResult()) {
							list=Result.get_studentList();
						}
						Student theStu=new Student();
						if(list!=null) {
						for(int i=0;i<list.size();i++) {
							Vector cell=new Vector();
							theStu=list.get(i);
							cell.add(theStu.getName());
							cell.add(theStu.getId());
							cell.add(theStu.getStudentID());
							cell.add(theStu.getSex());
							cell.add(theStu.getAge());
							cell.add(theStu.getAcademy());
							cell.add(theStu.getMajor());
							cell.add(theStu.getGrade());
							cell.add(theStu.getSchyear());
							row.add(cell);
						}
					}
				}			
					break;
				case 1:{
						String text=textField_SMessage.getText().trim();
						//ArrayList<Student> list=AService.queryStudentByStudentID(text);
						CopyOnWriteArrayList<Student> list=new CopyOnWriteArrayList();
						Request clientRequest = new Request();
						clientRequest.setRequest_ID(205);
						Student temp=new Student();
						temp.setId(text);
						clientRequest.set_student(temp);
						clientSocket Sample = new clientSocket();
						Request Result = Sample.sendRequestToServer(clientRequest);	
						
						if (Result.getCheckResult()) {
							list=Result.get_studentList();
						}
						else {
							System.out.println("false");
						}
						Student theStu=new Student();
						if(list!=null) {
						for(int i=0;i<list.size();i++) {
							Vector cell=new Vector();
							theStu=list.get(i);
							cell.add(theStu.getName());
							cell.add(theStu.getId());
							cell.add(theStu.getStudentID());
							cell.add(theStu.getSex());
							cell.add(theStu.getAge());
							cell.add(theStu.getAcademy());
							cell.add(theStu.getMajor());
							cell.add(theStu.getGrade());
							cell.add(theStu.getSchyear());
							row.add(cell);
						}	
					}
				}
					break;
				case 2:{
						String text=textField_SMessage.getText().trim();
						//ArrayList<Student> list=AService.queryStudentByAcademy(text);
						CopyOnWriteArrayList<Student> list=new CopyOnWriteArrayList();
						Request clientRequest = new Request();
						clientRequest.setRequest_ID(206);
						Student temp=new Student();
						temp.setAcademy(text);
						clientRequest.set_student(temp);
						clientSocket Sample = new clientSocket();
						Request Result = Sample.sendRequestToServer(clientRequest);				
						if (Result.getCheckResult()) {
							list=Result.get_studentList();
						}
						Student theStu=new Student();
						if(list!=null) {
						for(int i=0;i<list.size();i++) {
							Vector cell=new Vector();
							theStu=list.get(i);
							cell.add(theStu.getName());
							cell.add(theStu.getId());
							cell.add(theStu.getStudentID());
							cell.add(theStu.getSex());
							cell.add(theStu.getAge());
							cell.add(theStu.getAcademy());
							cell.add(theStu.getMajor());
							cell.add(theStu.getGrade());
							cell.add(theStu.getSchyear());
							row.add(cell);
						}	
					}
				}
					break;
				default:
					break;
					}
				}
				else if(radioButton_teacher.isSelected()) {
					switch(chooset) {
					case 0:{
						//ArrayList<Teacher> list=AService.queryAllTeacher();
						CopyOnWriteArrayList<Teacher> list=new CopyOnWriteArrayList();
						Request clientRequest = new Request();
						clientRequest.setRequest_ID(210);
						clientSocket Sample = new clientSocket();
						Request Result = Sample.sendRequestToServer(clientRequest);				
						if (Result.getCheckResult()) {
							list=Result.get_teacherList();
						}
						Teacher theTea=new Teacher();
						if(list!=null) {
						for(int i=0;i<list.size();i++) {
							Vector cell=new Vector();
							theTea=list.get(i);
							cell.add(theTea.getName());
							cell.add(theTea.getId());
							cell.add(theTea.getTeacherID());
							cell.add(theTea.getSex());
							cell.add(theTea.getProfessionalTitle());
							cell.add(theTea.getWorkplace());
							cell.add(theTea.getPhoneNumber());
							row.add(cell);
							}
						}
					}
						break;
					case 1:{
						String text=textField_SMessage.getText().trim();
						//ArrayList<Teacher> list=AService.queryTeacherByWorkplaceProfessionalTitle(text);
						CopyOnWriteArrayList<Teacher> list=new CopyOnWriteArrayList();
						Request clientRequest = new Request();
						clientRequest.setRequest_ID(212);
						Teacher temp=new Teacher();
						temp.setId(text);
						clientRequest.set_teacher(temp);
						clientRequest.get_teacher().setProfessionalTitle(text);
						clientSocket Sample = new clientSocket();
						Request Result = Sample.sendRequestToServer(clientRequest);				
						if (Result.getCheckResult()) {
							list=Result.get_teacherList();
						}
						Teacher theTea=new Teacher();
						if(list!=null) {
						for(int i=0;i<list.size();i++) {
							Vector cell=new Vector();
							theTea=list.get(i);
							cell.add(theTea.getName());
							cell.add(theTea.getId());
							cell.add(theTea.getTeacherID());
							cell.add(theTea.getSex());
							cell.add(theTea.getProfessionalTitle());
							cell.add(theTea.getWorkplace());
							cell.add(theTea.getPhoneNumber());
							row.add(cell);
							}
						}
					}
						break;
					case 2:{
						String text=textField_SMessage.getText().trim();
						//ArrayList<Teacher> list=AService.queryTeacherByWorkplace(text);
						CopyOnWriteArrayList<Teacher> list=new CopyOnWriteArrayList();
						Request clientRequest = new Request();
						clientRequest.setRequest_ID(213);
						Teacher temp=new Teacher();
						temp.setWorkplace(text);
						clientRequest.set_teacher(temp);
						clientSocket Sample = new clientSocket();
						Request Result = Sample.sendRequestToServer(clientRequest);				
						if (Result.getCheckResult()) {
							list=Result.get_teacherList();
						}
						Teacher theTea=new Teacher();
						if(list!=null) {
						for(int i=0;i<list.size();i++) {
							Vector cell=new Vector();
							theTea=list.get(i);
							cell.add(theTea.getName());
							cell.add(theTea.getId());
							cell.add(theTea.getTeacherID());
							cell.add(theTea.getSex());
							cell.add(theTea.getProfessionalTitle());
							cell.add(theTea.getWorkplace());
							cell.add(theTea.getPhoneNumber());
							row.add(cell);
							}
						}
					}
						break;
					}
				}
				model.setDataVector(row, tcol);
				table.updateUI();
			}
		});
		button_Change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//获取修改的用户并打开
				int x=table.getSelectedRow();
				//try {
				String getnumber= table.getValueAt(x, 1).toString();				
					if(radioButton_student.isSelected()) {
						Student TStu=new Student();
						//TStu = Service.findByUserID(getnumber);
						Request clientRequest = new Request();
						clientRequest.setRequest_ID(203);
						Student temp=new Student();
						temp.setId(getnumber);
						clientRequest.set_student(temp);
						clientSocket Sample = new clientSocket();
						Request Result = Sample.sendRequestToServer(clientRequest);				
						if (Result.getCheckResult()) {
							TStu=Result.get_student();
						}
						StatusSVisit SV=new StatusSVisit(TStu,0);
						SV.setVisible(true);
					}
					else if(radioButton_teacher.isSelected()) {
						Teacher Tea=new Teacher();
						//Tea=TService.findByID(getnumber);
						Request clientRequest = new Request();
						clientRequest.setRequest_ID(209);
						Teacher temp=new Teacher();
						temp.setId(getnumber);
						clientRequest.set_teacher(temp);
						clientSocket Sample = new clientSocket();
						Request Result = Sample.sendRequestToServer(clientRequest);				
						if (Result.getCheckResult()) {
							Tea=Result.get_teacher();
						}
						TeaPosition TP=new TeaPosition(Tea,0);
						TP.setVisible(true);
					}
				/*} catch(ArrayIndexOutOfBoundsException A) {
					JOptionPane.showMessageDialog(null, "请选择修改对象", "错误", JOptionPane.ERROR_MESSAGE);
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				//JOptionPane.showConfirmDialog(null, x);
			}
		});
		
		button_Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//获取删除的用户并删除
				int x=table.getSelectedRow();
				
				int Del=JOptionPane.showConfirmDialog(null,"是否删除","删除",JOptionPane.YES_NO_OPTION);
				if(Del==JOptionPane.YES_OPTION) {
					//try {
						if(radioButton_student.isSelected()) {
						String getnumber= table.getValueAt(x, 1).toString();
						//Service.destroyStudent(getnumber);
						Request clientRequest = new Request();
						clientRequest.setRequest_ID(201);
						Student temp=new Student();
						temp.setId(getnumber);
						clientRequest.set_student(temp);
						clientSocket Sample = new clientSocket();
						Request Result = Sample.sendRequestToServer(clientRequest);				
						}
						else if(radioButton_teacher.isSelected()) {
							String getnumber= table.getValueAt(x, 1).toString();
							//TService.deleteTeacher(getnumber);
							Request clientRequest = new Request();
							clientRequest.setRequest_ID(207);
							Teacher temp=new Teacher();
							temp.setId(getnumber);
							clientRequest.set_teacher(temp);
							clientSocket Sample = new clientSocket();
							Request Result = Sample.sendRequestToServer(clientRequest);				
						}
					/*} catch(ArrayIndexOutOfBoundsException A) {
						JOptionPane.showMessageDialog(null, "请选择删除对象", "错误", JOptionPane.ERROR_MESSAGE);
					}catch (RecordNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
				}
			}
		});
		//表头不可移动
		table.getTableHeader().setReorderingAllowed(false); 
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(36)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBox_stuchoose, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBox_teachoose, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
									.addGap(145)
									.addComponent(radioButton_student)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(radioButton_teacher)
									.addGap(74))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textField_SMessage, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
									.addComponent(button_Search)
									.addGap(55)))
							.addGap(42))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(button_Change)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_Delete)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_exit)
							.addGap(51))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
							.addGap(34))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(13, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(radioButton_student)
						.addComponent(radioButton_teacher)
						.addComponent(comboBox_teachoose, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_stuchoose, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_SMessage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_Search))
					.addGap(14)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_exit)
						.addComponent(button_Delete)
						.addComponent(button_Change))
					.addGap(11))
		);
		
		
		
		contentPane.setLayout(gl_contentPane);
	}
}
