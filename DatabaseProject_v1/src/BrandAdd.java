/**品牌商新增畫面
 * 
 */
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

import java.awt.BorderLayout;
import java.awt.Color;

public class BrandAdd {

	private JFrame frame;
	private JTextField textField, textField_1, textField_2, textField_3; 
	private User user;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BrandAdd window = new BrandAdd();
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
//	public BrandAdd() {
//		initialize();
//	}
	
	public BrandAdd(User user) {
		this.user = user;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("新增品牌商");
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setBackground(new Color(175, 238, 238));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("新增品牌商");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel.setBounds(19, 16, 89, 16);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 245, 238));
		textField.setBounds(19, 70, 224, 36);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1= new JTextField();
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(255, 245, 238));
		textField_1.setBounds(19, 129, 224, 36);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(255, 245, 238));
		textField_2.setBounds(19, 177, 224, 36);
		frame.getContentPane().add(textField_2);
		
		JLabel lblNewLabel_1 = new JLabel("品牌商名稱");
		lblNewLabel_1.setBounds(19, 58, 77, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("地址");	//altered
		lblNewLabel_2.setBounds(19, 112, 33, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("聯絡人");	//altered
		lblNewLabel_3.setBounds(19, 166, 61, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("取消");
		btnNewButton.setBounds(258, 241, 77, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("新增");
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
					JOptionPane.showMessageDialog(null,"輸入欄位不可為空值!", "Error",JOptionPane.ERROR_MESSAGE);
				}else {
//					try {
//						Class.forName("com.mysql.cj.jdbc.Driver");
//					}catch(ClassNotFoundException ce) {
//						ce.printStackTrace();
//					}
					try {
						Connection conn = DriverManager.getConnection(LoginFrame.URL, LoginFrame.USERNAME, LoginFrame.PASSWORD);
						PreparedStatement pst = conn.prepareStatement("SELECT * FROM 品牌商");
						try(ResultSet rs = pst.executeQuery()){
							while(rs.next()) {
								if(rs.getString("名稱").equals(bName)) {
									JOptionPane.showMessageDialog(null,"該品牌商已存在資料庫中!", "Error",JOptionPane.ERROR_MESSAGE);
								}
							}
						}
						conn.close();
					}catch(SQLException se) {
						se.printStackTrace();
					}
					
					try {
						Connection conn = DriverManager.getConnection(LoginFrame.URL, LoginFrame.USERNAME, LoginFrame.PASSWORD);
						PreparedStatement pst = conn.prepareStatement("INSERT INTO 品牌商 VALUES(?,?,?,?)");
						pst.setInt(1, 98);		// my phpMyAdmin database does not automatically generate id, so I use this line for testing
						pst.setString(2, bName);
						pst.setString(3, bContactP);
						pst.setString(4, bAddress);
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null,"成功新增品牌商!", "Message",JOptionPane.INFORMATION_MESSAGE);
						conn.close();
					}catch(SQLException se) {
						se.printStackTrace();
					}
				}
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		
//		JTextArea textArea = new JTextArea();
//		textArea.setLineWrap(true);
//		textArea.setBounds(0, 48, 450, 224);
//		frame.getContentPane().add(textArea);
		
		
		
		frame.setVisible(true);
	}
}

