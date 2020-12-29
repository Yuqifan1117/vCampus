package client.selectCourse;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class courseSearchByTime extends JFrame {

	private JPanel contentPane;
	private JTable table;

	private Object[][] data = { { "", "", "", "", "", "", "", "" } };
	private Object[] week = { "周一", "周二", "周三", "周四", "周五", "周六", "周日" };
	private Object[] order = { "第一节", "第二节", "第三节", "第四节", "第五节", "第六节", "第七节", "第八节", "第九节", "第十节", "第十一节", "第十二节", "第十三节" };
		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					courseSearchByTime frame = new courseSearchByTime();
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
	public courseSearchByTime() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		Object[] columnNames = { "�γ̴���", "�γ�����", "�Ͽ�ʱ��", "�Ͽεص�", "��ʦ", "ѧ�� ", "ѧԺ", "����" };

		setDataByTime("");

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

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);

		JLabel lblNewLabel = new JLabel("按时间查询");
		panel.add(lblNewLabel);

		JComboBox comboBox = new JComboBox(week);
		panel.add(comboBox);

		JComboBox comboBox_1 = new JComboBox(order);
		panel.add(comboBox_1);

		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton);
	}

	private void setDataByTime(String string) {
		// TODO Auto-generated method stub

	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
