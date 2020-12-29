package client.libraryNshop;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import client.socket.clientSocket;
import vcampus.server.dao.LibraryDao;
import vcampus.server.dao.LibraryDaoImpl;
import vcampus.server.dao.ShopDao;
import vcampus.server.dao.ShopDaoImpl;
import vcampus.server.exception.OutOfLimitException;
import vcampus.server.exception.RecordNotFoundException;
import vcampus.vo.BookBorrow;
import vcampus.vo.ProductInformation;
import vcampus.vo.Request;

import javax.swing.DefaultCellEditor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;

public class ShopView extends JFrame {

	
	private String UserId;
	private JPanel contentPane;
	public JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					int i=0;
					ShopView frame = new ShopView(0);
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
	public ShopView(int usertype) {
		setTitle("\u5546\u5E97\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu_2 = new JMenu("\u7BA1\u7406");
		if(usertype==0)
			menu_2.setEnabled(true);
		else
			menu_2.setEnabled(false);
		menuBar.add(menu_2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u4E0A\u67B6\u7269\u54C1");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddGoodsView add=new AddGoodsView();
				add.setVisible(true);
				table.updateUI();
			}
		});
		menu_2.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u4E0B\u67B6\u7269\u54C1");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteGoodsView delete=new DeleteGoodsView();
				delete.setVisible(true);
				
			}
		});
		menu_2.add(mntmNewMenuItem_1);
		
		/*JMenuItem menuItem = new JMenuItem("\u4FEE\u6539\u4FE1\u606F");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateGoodsView update=new UpdateGoodsView();
				update.setVisible(true);
			}
		});

		menu_2.add(menuItem);
		*/
		/*JMenu menu_1 = new JMenu("\u8D2D\u7269\u8BB0\u5F55");
		menu_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				TrolleyView trolley=new TrolleyView();
				trolley.setVisible(true);
			}
		});

		
				menuBar.add(menu_1);
				*/
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		ShopTableModel model= new ShopTableModel(){

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			boolean[] editables = {false, false, false,false,true};
			public boolean isCellEditable(int row,int column) {
				return editables[column];
				}
		};
		
		table = new JTable();
		table.setModel(model);
		model.showTable();
		model.addTableModelListener(table);
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("\u5546\u54C1");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton button = new JButton("\u67E5\u627E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String productID=textField.getText();
				if(textField.getText().length()!=0) {
					ProductInformation product=new ProductInformation();
					ProductInformation pro=new ProductInformation();
					product.setProductID(productID);
					Request testSample = new Request();
					testSample.setRequest_ID(502);
					testSample.set_product(product);
					clientSocket Sample = new clientSocket();
					Request Result = Sample.sendRequestToServer(testSample);
					if (Result.getCheckResult()) {
						pro=Result.get_product();
					}
					CopyOnWriteArrayList<ProductInformation> productlist=new CopyOnWriteArrayList<ProductInformation>();
					productlist.add(pro);
			/*	ShopDao dao = new ShopDaoImpl();
				ProductInformation product=dao.queryProductInformation(productID);
				list.add(product);*/
				model.setProduct(productlist);
				model.fireTableDataChanged();
				table.updateUI();		
			}
				else model.showTable();
			}
		});
		
		JButton button_1 = new JButton("\u663E\u793A\u5168\u90E8");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ShopDao dao=new ShopDaoImpl();
				//model.setProduct(dao.queryAllProduct());
				model.showTable();
				table.updateUI();
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(85)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addGap(51)
					.addComponent(button)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button_1)
					.addContainerGap(18, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(button)
						.addComponent(button_1)))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("\u8D2D\u4E70");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row=table.getSelectedRow();
				String proID=table.getValueAt(row, 0).toString();
				BuyView buy=new BuyView(proID,UserId);
				buy.setVisible(true);
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(177)
					.addComponent(btnNewButton)
					.addContainerGap(190, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnNewButton))
		);
		panel_1.setLayout(gl_panel_1);
		
		
	}
}
