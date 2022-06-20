/**
 * 供應商資訊編輯
 */
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SupplierEdit{

	private JFrame frame;
	private User user;
	private String queriedID, queriedName;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SupplierEdit window = new SupplierEdit();
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
//	public SupplierEdit() {
//		initialize();
//	}
	
	public SupplierEdit(String id, User user) {
		this.queriedID = id;
		this.user = user;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("編輯供應商");
		frame.setBounds(100, 100, 450, 300);
		//frame.getContentPane().setBackground(new Color(175, 238, 238));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("編輯供應商");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel.setBounds(19, 16, 89, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JTextField textField = new JTextField();
		textField.setBackground(new Color(255, 245, 238));
		textField.setBounds(19, 70, 224, 36);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextField textField_1= new JTextField();
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(255, 245, 238));
		textField_1.setBounds(19, 129, 224, 36);
		frame.getContentPane().add(textField_1);
		
		JTextField textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(255, 245, 238));
		textField_2.setBounds(19, 177, 224, 36);
		frame.getContentPane().add(textField_2);
		
//		JTextField textField_3 = new JTextField();
//		textField_3.setColumns(10);
//		textField_3.setBackground(new Color(255, 245, 238));
//		textField_3.setBounds(19, 236, 224, 36);
//		frame.getContentPane().add(textField_3);
		
		JLabel lblNewLabel_1 = new JLabel("供應商名稱");
		lblNewLabel_1.setBounds(19, 58, 77, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("電話");
		lblNewLabel_2.setBounds(19, 112, 33, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("住址");
		lblNewLabel_3.setBounds(19, 166, 61, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
//		JLabel lblNewLabel_4 = new JLabel("備註");
//		lblNewLabel_4.setBounds(19, 220, 61, 16);
//		frame.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("取消");
		btnNewButton.setBounds(258, 241, 77, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("確定");
		btnNewButton_1.setBackground(new Color(0, 0, 255));
		btnNewButton_1.setBounds(347, 241, 77, 29);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String bName = textField.getText();
				String bAddress = textField_1.getText();
				String bContactP = textField_2.getText();
				
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				
				if(bName.equals("") || bAddress.equals("") || bContactP.equals("")) {
					JOptionPane.showMessageDialog(null,"輸入欄位不可為空!", "Error",JOptionPane.ERROR_MESSAGE);
				}else {
//					try {
//						Class.forName("com.mysql.cj.jdbc.Driver");
//					}catch(ClassNotFoundException ce) {
//						ce.printStackTrace();
//					}
					try {
						Connection conn = DriverManager.getConnection(LoginFrame.URL, LoginFrame.USERNAME, LoginFrame.PASSWORD);
						PreparedStatement pst = conn.prepareStatement("UPDATE 供應商 SET 名稱 = ?, 地址 = ?, 聯絡人 = ? WHERE id = ?");
						pst.setString(1, bName);
						pst.setString(2, bAddress);
						pst.setNString(3, bContactP);
						pst.setInt(4, Integer.valueOf(queriedID));
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null,"成功編輯供應商!", "Message",JOptionPane.INFORMATION_MESSAGE);
						conn.close();
					}catch(SQLException se) {
						se.printStackTrace();
					}
					try {
						Connection conn = DriverManager.getConnection(LoginFrame.URL, LoginFrame.USERNAME, LoginFrame.PASSWORD);
						PreparedStatement pst = conn.prepareStatement("SELECT * FROM 供應商 WHERE id = ?");
						int qID = Integer.valueOf(queriedID);
						pst.setInt(1,qID);
						try(ResultSet rs = pst.executeQuery()){
							while(rs.next()) {
								textField.setText(rs.getString("名稱"));
								queriedName = textField.getText();
								textField_1.setText(rs.getString("地址"));
								textField_2.setText(rs.getString("聯絡人"));
							}
						}
						conn.close();
					}catch(SQLException se) {
						se.printStackTrace();
					}
				}
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("刪除供應商");
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setBackground(Color.RED);
		btnNewButton_2.setBounds(283, 53, 117, 29);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				
//				try {
//					Class.forName("com.mysql.cj.jdbc.Driver");
//				}catch(ClassNotFoundException ce) {
//					ce.printStackTrace();
//				}
				
				int dialogResult = JOptionPane.showConfirmDialog (null, String.format("確認刪除供應商「%s」?", queriedName),"Warning", JOptionPane.YES_NO_CANCEL_OPTION);
				if(dialogResult == JOptionPane.YES_OPTION){
					try {
						Connection conn = DriverManager.getConnection(LoginFrame.URL, LoginFrame.USERNAME, LoginFrame.PASSWORD);
						PreparedStatement pst = conn.prepareStatement("DELETE FROM 供應商 WHERE id = ?");
						pst.setInt(1, Integer.valueOf(queriedID));
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null,"成功刪除供應商!", "Message",JOptionPane.INFORMATION_MESSAGE);
						conn.close();
					}catch(SQLException se) {
						se.printStackTrace();
					}
				}
				
				try {
					Connection conn = DriverManager.getConnection(LoginFrame.URL, LoginFrame.USERNAME, LoginFrame.PASSWORD);
					PreparedStatement pst = conn.prepareStatement("SELECT * FROM 供應商 WHERE id = ?");
					int qID = Integer.valueOf(queriedID);
					pst.setInt(1,qID);
					try(ResultSet rs = pst.executeQuery()){
						while(rs.next()) {
							textField.setText(rs.getString("名稱"));
							queriedName = textField.getText();
							textField_1.setText(rs.getString("地址"));
							textField_2.setText(rs.getString("聯絡人"));
						}
					}
					conn.close();
				}catch(SQLException se) {
					se.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnNewButton_2);
		
		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		}catch(ClassNotFoundException ce) {
//			ce.printStackTrace();
//		}
		try {
			Connection conn = DriverManager.getConnection(LoginFrame.URL, LoginFrame.USERNAME, LoginFrame.PASSWORD);
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM 供應商 WHERE id = ?");
			int qID = Integer.valueOf(queriedID);
			pst.setInt(1,qID);
			try(ResultSet rs = pst.executeQuery()){
				while(rs.next()) {
					textField.setText(rs.getString("名稱"));
					queriedName = textField.getText();
					textField_1.setText(rs.getString("地址"));
					textField_2.setText(rs.getString("聯絡人"));
				}
			}
			conn.close();
		}catch(SQLException se) {
			se.printStackTrace();
		}
		
//		JTextArea textArea = new JTextArea();
//		textArea.setLineWrap(true);
//		textArea.setBounds(0, 48, 450, 224);
//		frame.getContentPane().add(textArea);
		
		frame.setVisible(true);
	}
}


