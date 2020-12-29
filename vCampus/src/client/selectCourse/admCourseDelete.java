package client.selectCourse;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class admCourseDelete extends JFrame {

	private JPanel contentPane;
	private JTextField textField_courseID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admCourseDelete frame = new admCourseDelete();
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
	public admCourseDelete() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblid = new JLabel("\u8F93\u5165\u8BFE\u7A0BID\uFF1A");
		GridBagConstraints gbc_lblid = new GridBagConstraints();
		gbc_lblid.anchor = GridBagConstraints.WEST;
		gbc_lblid.gridwidth = 3;
		gbc_lblid.insets = new Insets(0, 0, 5, 0);
		gbc_lblid.gridx = 0;
		gbc_lblid.gridy = 2;
		contentPane.add(lblid, gbc_lblid);
		
		textField_courseID = new JTextField();
		GridBagConstraints gbc_textField_courseID = new GridBagConstraints();
		gbc_textField_courseID.gridwidth = 3;
		gbc_textField_courseID.insets = new Insets(0, 0, 5, 5);
		gbc_textField_courseID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_courseID.gridx = 0;
		gbc_textField_courseID.gridy = 3;
		contentPane.add(textField_courseID, gbc_textField_courseID);
		textField_courseID.setColumns(10);
		
		JButton Button_confirm = new JButton("确认");
		Button_confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//
			}
		});
		GridBagConstraints gbc_Button_confirm = new GridBagConstraints();
		gbc_Button_confirm.fill = GridBagConstraints.HORIZONTAL;
		gbc_Button_confirm.insets = new Insets(0, 0, 0, 5);
		gbc_Button_confirm.gridx = 0;
		gbc_Button_confirm.gridy = 6;
		contentPane.add(Button_confirm, gbc_Button_confirm);
		
		JButton Button_reset = new JButton("重置");
		Button_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_courseID.setText("");
			}
		});
		GridBagConstraints gbc_Button_reset = new GridBagConstraints();
		gbc_Button_reset.fill = GridBagConstraints.HORIZONTAL;
		gbc_Button_reset.insets = new Insets(0, 0, 0, 5);
		gbc_Button_reset.gridx = 1;
		gbc_Button_reset.gridy = 6;
		contentPane.add(Button_reset, gbc_Button_reset);
		
		JButton Button_cancel = new JButton("取消");
		GridBagConstraints gbc_Button_cancel = new GridBagConstraints();
		gbc_Button_cancel.fill = GridBagConstraints.HORIZONTAL;
		gbc_Button_cancel.insets = new Insets(0, 0, 0, 5);
		gbc_Button_cancel.gridx = 2;
		gbc_Button_cancel.gridy = 6;
		contentPane.add(Button_cancel, gbc_Button_cancel);
	}

}
