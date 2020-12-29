package client.login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import client.libraryNshop.LibraryView;
import client.libraryNshop.ShopView;
import client.selectCourse.stuCourseCheck;
import client.selectCourse.stuCourseSelect;
import client.status.StatusCtl;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class StuMF extends JFrame {

	private JPanel contentPane;
	public static UserManage frame;
	public static StuMF smf;

	stuCourseCheck SCC_jf;
	StatusCtl SC_jf; 
	LibraryView LV_jf;
	ShopView SV_jf;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StuMF frame = new StuMF();
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
	public StuMF() {
		setTitle("学生界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 379, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton button = new JButton("账号管理");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccountManage();
			}
		});
		button.setIcon(new ImageIcon(StuMF.class.getResource("/icon/icons/zhanghaoguanli.png")));
		
		JButton button_1 = new JButton("信息管理");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				if (SC_jf == null) {
					SC_jf = new StatusCtl("1000", 1);
//					SC_jf.setVisible(true);
//				} else {
//					SC_jf.setVisible(true);
//				}
			}
		});
		button_1.setIcon(new ImageIcon(StuMF.class.getResource("/icon/icons/xinxiguanli.png")));
		
		JButton button_2 = new JButton("图书馆");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (LV_jf == null) {
					LV_jf = new LibraryView("21312", 1);
					LV_jf.setVisible(true);
				} else {
					LV_jf.setVisible(true);
				}
			}
		});
		button_2.setIcon(new ImageIcon(StuMF.class.getResource("/icon/icons/tushuguan.png")));
		
		JButton button_3 = new JButton("在线超市");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (SV_jf == null) {
					SV_jf = new ShopView(1);
					SV_jf.setVisible(true);
				} else {
					SV_jf.setVisible(true);
				}
			}
		});
		button_3.setIcon(new ImageIcon(StuMF.class.getResource("/icon/icons/chaoshi.png")));
		
		JButton button_4 = new JButton("选课系统");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (SCC_jf == null) {
					SCC_jf = new stuCourseCheck("09019101", "tom");
					SCC_jf.setVisible(true);
				} else {
					SCC_jf.setVisible(true);
				}
			}
		});
		button_4.setIcon(new ImageIcon(StuMF.class.getResource("/icon/icons/shijian-.png")));
		
		JButton button_5 = new JButton("银行账号");
		button_5.setIcon(new ImageIcon(StuMF.class.getResource("/icon/icons/bank.png")));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(StuMF.class.getResource("/icon/icons/icon.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(51)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(button_5, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(button_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(button))
							.addGap(104)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(button_3, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
								.addComponent(button_2, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
								.addComponent(button_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(42))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(160))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(54)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_5)
						.addComponent(button_3))
					.addGap(49)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_4)
						.addComponent(button_2))
					.addGap(55))
		);
		contentPane.setLayout(gl_contentPane);
		
	}
	protected void AccountManage() {
		// TODO Auto-generated method stub
		frame =new UserManage();
		frame.setVisible(true);
		this.setVisible(false);
		smf=this;
	}
}
