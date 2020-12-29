package client.login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AdminCenter extends JFrame {

	private JPanel contentPane;
	public static AdminCenter AC;
	
	public static DestroyAccount d;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminCenter frame = new AdminCenter();
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
	public AdminCenter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 379, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("管理员中心");
		label.setIcon(new ImageIcon(AdminCenter.class.getResource("/icon/icons/guanliyuan-2.png")));
		
		JButton button = new JButton("删除用户");
		button.setIcon(new ImageIcon(AdminCenter.class.getResource("/icon/icons/tuichu.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				destroy(e);
			}
		});
		
		JButton button_1 = new JButton("编辑课程");
		button_1.setIcon(new ImageIcon(AdminCenter.class.getResource("/icon/icons/shijian-.png")));
		
		JButton button_2 = new JButton(" 返     回");
		button_2.setIcon(new ImageIcon(AdminCenter.class.getResource("/icon/icons/fanhui.png")));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back(e);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(115)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(button_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
						.addComponent(button_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
						.addComponent(button, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
						.addComponent(label))
					.addGap(147))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addGap(53)
					.addComponent(button)
					.addGap(72)
					.addComponent(button_1)
					.addGap(68)
					.addComponent(button_2)
					.addContainerGap(36, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void back(ActionEvent e) {
		// TODO Auto-generated method stub
		this.dispose();
		
		AdminMainFrame.amf.setVisible(true);
	}

	protected void destroy(ActionEvent e) {
		// TODO Auto-generated method stub
		d=new DestroyAccount();
		d.setVisible(true);
		AC=this;
		this.setVisible(false);
		
	}
}
