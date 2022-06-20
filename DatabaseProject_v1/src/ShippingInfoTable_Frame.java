import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

/*這頁是ShippingInfo的下一頁，我是用表格的形式，不知道新增資料的時候會不會很難QQ*/

public class ShippingInfoTable_Frame {

	private JFrame frame;
	private JTable table;
//	private JTable table_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private String p1,p2,p3,date1, date2;
	
	private User user;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ShippingInfoTable_Frame window = new ShippingInfoTable_Frame();
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
//	public ShippingInfoTable_Frame() {
//		initialize();
//	}
	
	public ShippingInfoTable_Frame(String p1, String p2, String p3, String date_y, String date1_m, String date1_d, String date2_m, String date2_d, User user) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.date1 = String.format("%s-%s-%s", date_y, date1_m, date1_d);
		this.date2 = String.format("%s-%s-%s", date_y, date2_m, date2_d);
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
		
		String[] columns = {"訂購單號","物流單號","平台名稱","出貨期限","出貨童裝ID", "童裝尺寸", "訂購數量"};
//		Object[][] data = {
//				{"", "", "", "", "", "", ""},
//				{"", "", "", "", "", "", ""},
//				{"", "", "", "", "", "", ""},
//				{"", "", "", "", "", "", ""},
//				{"", "", "", "", "", "", ""},
//				{"", "", "", "", "", "", ""},
//				{"", "", "", "", "", "", ""},
//				{"", "", "", "", "", "", ""},
//				{"", "", "", "", "", "", ""},
//				{"", "", "", "", "", "", ""},
//				{"", "", "", "", "", "", ""},
//				{"", "", "", "", "", "", ""},
//				{"", "", "", "", "", "", ""},
//				{"", "", "", "", "", "", ""},
//				{"", "", "", "", "", "", ""},
//				{"", "", "", "", "", "", ""},
//				{"", "", "", "", "", "", ""},
//				{"", "", "", "", "", "", ""},
//				{"", "", "", "", "", "", ""},
//				{"", "", "", "", "", "", ""},
//				{"", "", "", "", "", "", ""},
//				{"", "", "", "", "", "", ""},
//				{"", "", "", "", "", "", ""},
//				{"", "", "", "", "", "", ""},
//				{"", "", "", "", "", "", ""},
//			};
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.setColumnIdentifiers(columns);
		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		}catch(ClassNotFoundException ce) {
//			ce.printStackTrace();
//		}
		try {
			Connection conn = DriverManager.getConnection(LoginFrame.URL, LoginFrame.USERNAME, LoginFrame.PASSWORD);
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM 出貨細節 WHERE (平台名稱 = ? OR 平台名稱 = ? OR 平台名稱 = ?) AND (出貨期限 BETWEEN ? AND ?)");
			pst.setString(1, p1);
			pst.setString(2, p2);
			pst.setString(3, p3);
			java.sql.Date d1=java.sql.Date.valueOf(date1); 
			java.sql.Date d2=java.sql.Date.valueOf(date2);
			pst.setDate(4, d1);
			pst.setDate(5, d2);
			
			try(ResultSet rs = pst.executeQuery()){
				String[] row = new String[7];
				boolean query_success = false;
				while(rs.next()) {
					row[0] = rs.getString("訂購單號");
					row[1] = String.valueOf(rs.getString("物流單號"));
					row[2] = rs.getString("平台名稱");
					row[3] = rs.getString("出貨期限");
					row[4] = rs.getString("出貨童裝id");
					row[5] = rs.getString("童裝尺寸");
					row[6] = String.valueOf(rs.getInt("訂購數量"));
					model.addRow(row);
					query_success = true;
				}
				if(query_success == false) {
					JOptionPane.showMessageDialog(null,"查無資料", "Query Result",JOptionPane.ERROR_MESSAGE);
				}
			}
			conn.close();
		}catch(SQLException se) {
			se.printStackTrace();
		}
		table.setFont(new Font("微軟正黑體", Font.PLAIN, 12));/*{
			public boolean isCellEditable(int data, int columns) {
				return false;
			}
		};*/
		table.setPreferredScrollableViewportSize(new Dimension(450, 400));
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 836, 428);
		frame.getContentPane().add(scrollPane);
		
		btnNewButton = new JButton("回首頁");
		btnNewButton.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		btnNewButton.setBounds(564, 455, 108, 35);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("登出");
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		btnNewButton_1.setBounds(705, 455, 108, 35);
		frame.getContentPane().add(btnNewButton_1);
		frame.setVisible(true);
	}
}
