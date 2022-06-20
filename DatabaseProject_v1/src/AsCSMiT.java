/**
 * 撖都���澈摮�
 */
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

public class AsCSMiT {

	JFrame frame;
	private JTextField T1;
	private User user;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AsCSMiT sub_window = new AsCSMiT();
//					sub_window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
//	public AsCSMiT() {
//		initialize();
//	}
	
	public AsCSMiT(User user) {
		initialize();
		this.user = user;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u5168\u90E8\u9580\u5E02\u5EAB\u5B58");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 23);
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		T1 = new JTextField();
		T1.setHorizontalAlignment(SwingConstants.CENTER);
		T1.setText("請輸入寄賣品ID或童裝ID");
		T1.setForeground(Color.GRAY);
		T1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				T1.setText("");
				T1.setForeground(Color.black);
			}
		});
		panel.add(T1);
		T1.setColumns(10);
		
		JButton B1 = new JButton("\u95DC\u9589");
		B1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		panel.add(B1, BorderLayout.EAST);
		
		table_1 = new JTable(); 	//jtable
		DefaultTableModel model = (DefaultTableModel)table_1.getModel();
		
		JButton B2 = new JButton("\u67E5\u8A62");
		B2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				String inputID = T1.getText();
				T1.setText("");
				if(inputID.equals("") || inputID.equals("請輸入寄賣品ID或童裝ID")) {
					JOptionPane.showMessageDialog(null,"請輸入寄賣品ID或童裝ID!", "Error",JOptionPane.ERROR_MESSAGE);
				}else {
//					try {
//						Class.forName("com.mysql.cj.jdbc.Driver");
//					}catch(ClassNotFoundException ce) {
//						ce.printStackTrace();
//					}
					try {
						Connection conn = DriverManager.getConnection(LoginFrame.URL, LoginFrame.USERNAME, LoginFrame.PASSWORD);
						
						if(inputID.substring(0,1).equals("A")) {
							PreparedStatement pst = conn.prepareStatement("SELECT * FROM 童裝庫存 WHERE `平台名稱/門市id` = ? AND `童裝id` = ?");
							pst.setString(1,user.getID());
							pst.setString(2,inputID);
							
							String[] columns = {"童裝id", "童裝尺寸", "數量"}; 	//set JTable columns
							model.setColumnIdentifiers(columns);
							
							try(ResultSet rs = pst.executeQuery()){
								String[] row = new String[3];
								boolean is_valid_id = false;
								while(rs.next()) {
									is_valid_id = true;
									row[0] = rs.getString("童裝id");
									row[1] = rs.getString("童裝尺寸");
									row[2] = String.valueOf(rs.getInt("庫存數量"));
									model.addRow(row);
								}
								if(is_valid_id == false) {
									JOptionPane.showMessageDialog(null,"查無資料", "Error",JOptionPane.ERROR_MESSAGE);
								}
								conn.close();
							}catch(SQLException se){
								se.printStackTrace();
							}
						}else if(inputID.substring(0,1).equals("B")) {
							PreparedStatement pst_1 = conn.prepareStatement("SELECT * FROM 寄賣品門市庫存 WHERE 門市id = ? AND 寄賣品id = ?");
							pst_1.setString(1,user.getID());
							pst_1.setString(2, inputID);
							
							String[] columns = {"寄賣品id", "寄賣品尺寸", "數量"};
							model.setColumnIdentifiers(columns);
							
							try(ResultSet rs = pst_1.executeQuery()){
								boolean is_valid_id = false;
								String[] row = new String[3];
								while(rs.next()) {
									is_valid_id = true;
									row[0] = rs.getString("寄賣品id");
									row[1] = rs.getString("寄賣品尺寸");
									row[2] = String.valueOf(rs.getInt("數量"));
									model.addRow(row);
								}
								if(is_valid_id == false) {
									JOptionPane.showMessageDialog(null,"查無資料", "Error",JOptionPane.ERROR_MESSAGE);
								}
								conn.close();
							}catch(SQLException se){
								se.printStackTrace();
							}
						}else {
							JOptionPane.showMessageDialog(null,"id輸入錯誤，請重新輸入", "Error",JOptionPane.ERROR_MESSAGE);
						}
						conn.close();
					}catch(SQLException se) {
						se.printStackTrace();
					}
				}
			}
		});
		panel.add(B2, BorderLayout.WEST);
		
		table_1.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		table_1.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table_1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(0, 22, 434, 239);
		frame.getContentPane().add(scrollPane);
		
		frame.setVisible(true);
	}
}
