/*供應商資訊（管理者介面）
 * 
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class SupplierInfo {

	private JFrame frame;
	private JTextField txtField;
	private User user;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SupplierInfo  window = new SupplierInfo ();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
//	public SupplierInfo() {
//		initialize();
//	}
	
	public SupplierInfo(User user) {
		this.user = user;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("供應商資訊");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("供應商");
		lblNewLabel.setBounds(24, 20, 61, 16);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		frame.getContentPane().add(lblNewLabel);
		
//		JLabel lblNewLabel_1 = new JLabel("供應商");
//		lblNewLabel_1.setBounds(48, 64, 61, 16);
//		lblNewLabel_1.setForeground(UIManager.getColor("Button.darkShadow"));
//		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
//		frame.getContentPane().add(lblNewLabel_1);
//		
//		JLabel lblNewLabel_2 = new JLabel("電話");
//		lblNewLabel_2.setBounds(146, 64, 61, 16);
//		frame.getContentPane().add(lblNewLabel_2);
//		
//		JLabel lblNewLabel_3 = new JLabel("住址");
//		lblNewLabel_3.setBounds(242, 64, 61, 16);
//		frame.getContentPane().add(lblNewLabel_3);
//		
//		JLabel lblNewLabel_4 = new JLabel("備註");
//		lblNewLabel_4.setBounds(344, 64, 61, 16);
//		frame.getContentPane().add(lblNewLabel_4);
		
//		JTextArea textArea = new JTextArea();
//		textArea.setLineWrap(true);
//		textArea.setBackground(Color.WHITE);
//		textArea.setBounds(0, 48, 450, 224);
//		frame.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("新增");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setBounds(171, 195, 117, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SupplierAdd sAdd = new SupplierAdd(user);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JLabel lbl = new JLabel("欲編輯之供應商id:");
		lbl.setBounds(100, 10, 100, 29);
		frame.getContentPane().add(lbl);
		
		txtField = new JTextField("");
		txtField.setColumns(10);
		txtField.setBounds(200, 10, 100, 29);
		frame.getContentPane().add(txtField);
		
		JButton editBtn = new JButton("編輯供應商");
		editBtn.setBounds(300, 10, 120, 29);
		editBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtField.getText();
				txtField.setText("");
				if(id.equals("")) {
					JOptionPane.showMessageDialog(null,"請輸入供應商id!", "Error",JOptionPane.ERROR_MESSAGE);
				}else {
					try {
						Connection conn = DriverManager.getConnection(LoginFrame.URL, LoginFrame.USERNAME, LoginFrame.PASSWORD);
						PreparedStatement pst = conn.prepareStatement("SELECT id FROM 供應商");
						try(ResultSet rs = pst.executeQuery()){
							boolean is_valid_id = false;
							while(rs.next()) {
								String resultID = String.valueOf(rs.getInt("id"));
								System.out.println(resultID);
								System.out.println(rs.getInt("id")+1);
								if(resultID.equals(id)) {
									SupplierEdit bE = new SupplierEdit(id, user);
									frame.dispose();
									is_valid_id = true;
									break;
								}
							}
							if(is_valid_id == false) {
								JOptionPane.showMessageDialog(null,"id輸入錯誤，請重新輸入", "Error",JOptionPane.ERROR_MESSAGE);
							}
						}
						conn.close();
					}catch(SQLException se) {
						se.printStackTrace();
					}
				}
			}
		});
		frame.getContentPane().add(editBtn);
		
		JTable table = new JTable();
		String[] columns = {"id", "名稱", "地址", "聯絡人"};
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.setColumnIdentifiers(columns);
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		}catch(ClassNotFoundException ce) {
//			ce.printStackTrace();
//		}
		try {
			Connection conn = DriverManager.getConnection(LoginFrame.URL, LoginFrame.USERNAME, LoginFrame.PASSWORD);
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM 供應商");
			try (ResultSet rs = pst.executeQuery()){
				String[] row = new String[4];
				while(rs.next()) {
					row[0] = String.valueOf(rs.getInt("id"));
					row[1] = rs.getString("名稱");
					row[2] = rs.getString("地址");
					row[3] = rs.getString("聯絡人");
					model.addRow(row);
				}
				table.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
				JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				table.setPreferredScrollableViewportSize(new Dimension(400,120));
				table.setFillsViewportHeight(true);
				JPanel tablePane = new JPanel();
				tablePane.add(scrollPane);
				tablePane.setBounds(30, 50, 420, 120);
				frame.getContentPane().add(tablePane);
			}
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		frame.setVisible(true);
	}
}
