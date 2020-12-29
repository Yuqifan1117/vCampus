package client.bank;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.JButton;

public class bankView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_balance;
	private JTable table;
	private JButton Button_deposit;
	private JButton Button_withdraw;
	private JButton Button_transfer;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	private String userID;
	private Object[][] data = { { "", "", "", "", "", "", "", "" } };
	private Object[] columnNames = { "日期", "操作", "金额", "余额" };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bankView frame = new bankView("213190001");
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
	public bankView(String id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		userID = id;
		setData(userID);

		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 100, 200, 200, 200 };
		gbl_contentPane.rowHeights = new int[] { 43, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.5, 0.5, 1.0, 1.0 };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblNewLabel = new JLabel("余额");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		textField_balance = new JTextField();
		GridBagConstraints gbc_textField_balance = new GridBagConstraints();
		gbc_textField_balance.gridwidth = 3;
		gbc_textField_balance.insets = new Insets(5, 0, 5, 0);
		gbc_textField_balance.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_balance.gridx = 1;
		gbc_textField_balance.gridy = 0;
		contentPane.add(textField_balance, gbc_textField_balance);
		textField_balance.setColumns(10);

		lblNewLabel_1 = new JLabel("操作");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);

		Button_deposit = new JButton("存款");
		GridBagConstraints gbc_Button_deposit = new GridBagConstraints();
		gbc_Button_deposit.fill = GridBagConstraints.HORIZONTAL;
		gbc_Button_deposit.insets = new Insets(0, 0, 5, 5);
		gbc_Button_deposit.gridx = 1;
		gbc_Button_deposit.gridy = 1;
		contentPane.add(Button_deposit, gbc_Button_deposit);

		Button_withdraw = new JButton("取款");
		GridBagConstraints gbc_Button_withdraw = new GridBagConstraints();
		gbc_Button_withdraw.fill = GridBagConstraints.HORIZONTAL;
		gbc_Button_withdraw.insets = new Insets(0, 0, 5, 5);
		gbc_Button_withdraw.gridx = 2;
		gbc_Button_withdraw.gridy = 1;
		contentPane.add(Button_withdraw, gbc_Button_withdraw);

		Button_transfer = new JButton("转账");
		GridBagConstraints gbc_Button_transfer = new GridBagConstraints();
		gbc_Button_transfer.fill = GridBagConstraints.HORIZONTAL;
		gbc_Button_transfer.insets = new Insets(0, 0, 5, 0);
		gbc_Button_transfer.gridx = 3;
		gbc_Button_transfer.gridy = 1;
		contentPane.add(Button_transfer, gbc_Button_transfer);

		lblNewLabel_2 = new JLabel("\u6700\u8FD1\u4EA4\u6613\u660E\u7EC6");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.gridwidth = 4;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);

		DefaultTableModel model = new DefaultTableModel(data, columnNames) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(model);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 4;
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 3;
		contentPane.add(table, gbc_table);
	}

	private void setData(String id) {
		// TODO Auto-generated method stub
		Object[][] a = { 
				{ "20190901", "取款", "300", "2000" }, 
				{ "20190902", "取款", "300", "1700" },
				{ "20190902", "存款", "3000", "4700" } 
				};
		data = a;
		textField_balance.setText("4700");
	}
}
