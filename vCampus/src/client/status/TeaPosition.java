package client.status;
import vcampus.vo.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import client.socket.clientSocket;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import vcampus.server.biz.*;
import vcampus.server.dao.TeacherDao;
import vcampus.server.dao.TeacherDaoImpl;
import vcampus.server.exception.RecordNotFoundException;
public class TeaPosition extends JFrame {

	private JPanel contentPane;
	private JTextField textField_name;
	private JTextField textField_phone;
	private JTextField textField_gender;
	private JTextField textField_position;
	private JTextField textField_birth;
	private JButton button_editor;
	private JButton button_finish;
	private JButton button_exit;
	private TeacherServiceDao Service;
	private Teacher T;
	private JTextField textField_id;
	private JLabel label_4;
	private JTextField textField_wp;
	private int UserType;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 * @wbp.parser.constructor
	 */
	public TeaPosition(String UserID,int Type) {
		/*TeacherServiceDao Service=new TeacherServiceDaoImpl(); 
		TeacherDao AService=new TeacherDaoImpl();
		String tid="100";
		try {
			T = AService.findByID(tid);
			
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}*/
		UserType=Type;
		Request clientRequest = new Request();
		clientRequest.setRequest_ID(209);
		Teacher temp=new Teacher();
		temp.setId(UserID);
		clientRequest.set_teacher(temp);
		clientSocket Sample = new clientSocket();
		Request Result = Sample.sendRequestToServer(clientRequest);				
		if (Result.getCheckResult()) {
			T=Result.get_teacher();
		}
		BuildFrame();
	}
	public TeaPosition(Teacher Tc,int Type) {
		TeacherServiceDao Service=new TeacherServiceDaoImpl(); 
		T=Tc;
		UserType=Type;
		BuildFrame();
	}
	public void BuildFrame() {
		//TeacherServiceDao Service=new TeacherServiceDaoImpl(); 
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500,400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(12, 12, 12, 12));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u59D3\u540D");
		
		JLabel label_1 = new JLabel("\u6027\u522B");
		
		JLabel label_3 = new JLabel("\u804C\u79F0");
		
		JLabel label_5 = new JLabel("\u51FA\u751F\u5E74\u6708");
		
		JLabel label_6 = new JLabel("\u7535\u8BDD");
		
		textField_name = new JTextField();
		textField_name.setColumns(10);
		
		textField_phone = new JTextField();
		textField_phone.setColumns(10);
		
		textField_gender = new JTextField();
		textField_gender.setColumns(10);
		
		textField_position = new JTextField();
		textField_position.setColumns(10);
		
		textField_birth = new JTextField();
		textField_birth.setColumns(10);
		
		textField_id = new JTextField();
		textField_id.setColumns(10);
		button_editor = new JButton("编辑");
		textField_wp = new JTextField();
		textField_wp.setColumns(10);
		if(UserType!=0) {
			button_editor.setEnabled(false);
		}
		textField_name.setText(T.getName());
		textField_phone.setText(T.getPhoneNumber());
		textField_position.setText(T.getProfessionalTitle());
		textField_gender.setText(T.getSex());
		textField_birth.setText(T.getBirth());
		textField_id.setText(T.getId());
		textField_wp.setText(T.getWorkplace());

		button_editor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				textField_name.setEditable(true);
				textField_phone.setEditable(true);
				textField_position.setEditable(true);
				textField_gender.setEditable(true);
				textField_birth.setEditable(true);
				textField_wp.setEditable(true);
				button_finish.setVisible(true);
				button_editor.setVisible(false);	
			}
		});
		
		button_finish = new JButton("完成");
		button_finish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					//保存信息
				//try {
					String name=textField_name.getText();
					String phone=textField_phone.getText();
					String position=textField_position.getText();
					String gender=textField_gender.getText();
					String birth=textField_birth.getText();
					String id=textField_id.getText();
					String wp=textField_wp.getText();
					T.setName(name);
					T.setProfessionalTitle(position);
					T.setSex(gender);
					T.setBirth(birth);
					T.setPhoneNumber(phone);
					T.setId(id);
					T.setWorkplace(wp);
					//Service.updateTeacherInfo(T);
					Request clientRequest = new Request();
					clientRequest.setRequest_ID(208);
					clientRequest.set_teacher(T);
					clientSocket Sample = new clientSocket();
					Request Result = Sample.sendRequestToServer(clientRequest);				
					textField_name.setEditable(false);
					textField_phone.setEditable(false);
					textField_position.setEditable(false);
					textField_gender.setEditable(false);
					textField_birth.setEditable(false);
					textField_wp.setEditable(false);
					button_finish.setVisible(false);
					button_editor.setVisible(true);
				/*}catch(Exception s) {
					s.printStackTrace();
				}*/
			}
		});
		button_finish.setVisible(false);
		button_exit = new JButton("退出");
		button_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int exit=JOptionPane.showConfirmDialog(null,"是否退出","退出",JOptionPane.YES_NO_OPTION);
				if(exit==JOptionPane.YES_OPTION) {
				dispose();
				}
			}
		});
		textField_name.setEditable(false);
		textField_phone.setEditable(false);
		textField_position.setEditable(false);
		textField_gender.setEditable(false);
		textField_birth.setEditable(false);
		textField_id.setEditable(false);
		textField_wp.setEditable(false);
		JLabel label_2 = new JLabel("\u6559\u5E08\u7F16\u53F7");
		
		label_4 = new JLabel("\u6240\u5C5E\u673A\u6784");
		
		
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_6)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_phone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(label_4))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_position, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(label_2))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(59)
							.addComponent(label_5)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_birth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_wp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(111, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(244, Short.MAX_VALUE)
					.addComponent(button_editor)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button_exit)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button_finish)
					.addGap(9))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_gender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(322, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textField_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5)
						.addComponent(textField_birth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(textField_position, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(textField_id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_6)
						.addComponent(textField_phone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(textField_wp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(textField_gender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_editor)
						.addComponent(button_exit)
						.addComponent(button_finish)))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
