package client.login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import client.libraryNshop.LibraryView;
import client.libraryNshop.ShopView;
import client.status.StatusCtl;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class TeacherMF extends JFrame {

	private JPanel contentPane;

	public static TeacherMF tmf;

	public static UserManage frame;
	LibraryView LV_jf;
	ShopView SV_jf;
	StatusCtl SC_jf; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherMF frame = new TeacherMF();
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
	public TeacherMF() {
		setTitle("教师界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 378, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("账号管理");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccountManage();
			}
		});
		btnNewButton.setIcon(new ImageIcon(TeacherMF.class.getResource("/icon/icons/zhanghaoguanli.png")));
		
		JButton button = new JButton("信息管理");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SC_jf = new StatusCtl("101", 2);
			}
		});
		button.setIcon(new ImageIcon(TeacherMF.class.getResource("/icon/icons/xinxiguanli.png")));
		
		JButton button_1 = new JButton("教师中心");
		button_1.setIcon(new ImageIcon(TeacherMF.class.getResource("/icon/icons/jiaoshi.png")));
		
		JButton button_2 = new JButton("在线超市");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(SV_jf == null) {
					SV_jf = new ShopView(2);
					SV_jf.setVisible(true);
				}else {
					SV_jf.setVisible(true);
				}
			}
		});
		button_2.setIcon(new ImageIcon(TeacherMF.class.getResource("/icon/icons/chaoshi.png")));
		
		JButton button_3 = new JButton("银行账户");
		button_3.setIcon(new ImageIcon(TeacherMF.class.getResource("/icon/icons/bank.png")));
		
		JButton button_4 = new JButton("图  书  馆");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(LV_jf == null) {
					LV_jf = new LibraryView("123456", 2);
					LV_jf.setVisible(true);
				}else {
					LV_jf.setVisible(true);
				}
			}
		});
		button_4.setIcon(new ImageIcon(TeacherMF.class.getResource("/icon/icons/tushuguan.png")));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TeacherMF.class.getResource("/icon/icons/jiaoshi-2.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(60)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(button_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(button_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
							.addGap(74)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(button, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(button_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(button_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(159)
							.addComponent(lblNewLabel)))
					.addContainerGap(44, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(34)
					.addComponent(lblNewLabel)
					.addGap(54)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(button))
					.addGap(52)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_2)
						.addComponent(button_3))
					.addGap(49)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(62, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
	}
	protected void AccountManage() {
		// TODO Auto-generated method stub
		frame =new UserManage();
		frame.setVisible(true);
		
		this.setVisible(false);
		tmf=this;
	}
}
