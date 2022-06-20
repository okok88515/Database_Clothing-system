import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;

/*這頁是ShippingInfoTable的上一頁*/

public class ShippingInfo_Frame {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	private String query;
	private User user;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ShippingInfo_Frame window = new ShippingInfo_Frame();
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
//	public ShippingInfo_Frame() {
//		initialize();
//	}
	
	public ShippingInfo_Frame(User user) {
		this.user = user;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("管理者介面－平台出貨資訊");
		frame.setBounds(100, 100, 850, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("想查詢的平台");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel.setBounds(106, 138, 120, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("時間區間");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(106, 226, 120, 28);
		frame.getContentPane().add(lblNewLabel_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("蝦皮");
		chckbxNewCheckBox.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		chckbxNewCheckBox.setBounds(262, 138, 120, 28);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Yahoo奇摩");
		chckbxNewCheckBox_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		chckbxNewCheckBox_1.setBounds(384, 138, 135, 28);
		frame.getContentPane().add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("momo");
		chckbxNewCheckBox_2.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		chckbxNewCheckBox_2.setBounds(521, 138, 120, 28);
		frame.getContentPane().add(chckbxNewCheckBox_2);
		
		textField = new JTextField();
		textField.setBounds(346, 226, 48, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("月");
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(404, 226, 27, 28);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(443, 226, 48, 30);
		frame.getContentPane().add(textField_1);
		
		JLabel lblNewLabel_2_1 = new JLabel(" 日    ~");
		lblNewLabel_2_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(501, 226, 74, 28);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(585, 226, 48, 30);
		frame.getContentPane().add(textField_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("月");
		lblNewLabel_2_2.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_2_2.setBounds(643, 226, 27, 28);
		frame.getContentPane().add(lblNewLabel_2_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(687, 226, 48, 30);
		frame.getContentPane().add(textField_3);
		
		JLabel lblNewLabel_2_3 = new JLabel("日");
		lblNewLabel_2_3.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_2_3.setBounds(745, 226, 27, 28);
		frame.getContentPane().add(lblNewLabel_2_3);
		
		JButton btnNewButton = new JButton("確定查詢");
		btnNewButton.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		btnNewButton.setBounds(336, 323, 144, 37);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String p1="",p2="",p3="";
					if(chckbxNewCheckBox.isSelected()) {p1 = chckbxNewCheckBox.getText();}
					if(chckbxNewCheckBox_1.isSelected()) {p2 = chckbxNewCheckBox_1.getText();}
					if(chckbxNewCheckBox_2.isSelected()) {p3 = chckbxNewCheckBox_2.getText();}
					String date_y = textField_4.getText();
					String date1_m = textField.getText();
					String date1_d = textField_1.getText();
					String date2_m = textField_2.getText();
					String date2_d = textField_3.getText();
					
					if((chckbxNewCheckBox.isSelected() || chckbxNewCheckBox_1.isSelected() || chckbxNewCheckBox_2.isSelected()) == false) {
						JOptionPane.showMessageDialog(null,"請選擇平台！", "Error",JOptionPane.ERROR_MESSAGE);
					}else if(date_y.equals("") || date1_m.equals("") || date1_d.equals("") || date2_m.equals("") || date2_d.equals("")){
						JOptionPane.showMessageDialog(null,"日期欄位不可為空，請再次輸入", "Error",JOptionPane.ERROR_MESSAGE);
					}else {
						int d_y = Integer.valueOf(date_y);
						int d1_m = Integer.valueOf(date1_m);
						int d1_d = Integer.valueOf(date1_d);
						int d2_m = Integer.valueOf(date2_m);
						int d2_d = Integer.valueOf(date2_d);
						if(d_y <1900 || d1_m>12 || d1_m<1 || d2_m>12 || d2_m<1 || d1_d>31 || d1_d<1 || d2_d>31 || d2_d<1){
							JOptionPane.showMessageDialog(null,"日期格式錯誤！請重新輸入", "Error",JOptionPane.ERROR_MESSAGE);
						}else {
							textField.setText("");
							textField_1.setText("");
							textField_2.setText("");
							textField_3.setText("");
							textField_4.setText("");
							ShippingInfoTable_Frame shipInfoF = new ShippingInfoTable_Frame(p1,p2,p3,date_y,date1_m,date1_d,date2_m,date2_d, user);
							frame.dispose();
						}
					}
				}catch(Exception ee) {
					JOptionPane.showMessageDialog(null,"輸入錯誤，請重新輸入", "Error",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("回首頁");
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		btnNewButton_1.setBounds(582, 453, 107, 37);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminHome aH = new AdminHome(user);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("登出");
		btnNewButton_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		btnNewButton_1_1.setBounds(719, 453, 107, 37);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("查詢平台出貨資訊");
		lblNewLabel_3.setFont(new Font("微軟正黑體", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(291, 42, 225, 28);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(251, 226, 48, 30);
		frame.getContentPane().add(textField_4);
		
		JLabel year_label = new JLabel("年");
		year_label.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		year_label.setBounds(309, 226, 27, 28);
		frame.getContentPane().add(year_label);
		
		frame.setVisible(true);
	}
}
