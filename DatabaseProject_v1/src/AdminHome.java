/**
 * 蝞∠���擐��
 */
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.event.*;
import java.sql.*;

public class AdminHome {

	private JFrame adminHome;
	private User user;
//	private SQLMan sqlMan;
	
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AdminHome window = new AdminHome();
//					window.adminHome.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
//	public AdminHome() {
//		initialize();
//	}
	
	public AdminHome(User user) {
		this.user = user;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		adminHome = new JFrame();
		adminHome.setTitle("\u7BA1\u7406\u8005\u2014\u9996\u9801");
		adminHome.setBounds(100, 100, 800, 600);
		adminHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adminHome.getContentPane().setLayout(null);
		
//		嚙豬理嚙諒歹蕭嚙踝蕭_嚙踝蕭嚙踝蕭 嚙踝蕭嚙瘩
		JLabel welcome_Label = new JLabel("\u7BA1\u7406\u8005\u4ECB\u9762\u2014\u9996\u9801");
		welcome_Label.setFont(new Font("嚙盤嚙緯嚙踝蕭嚙踝蕭嚙踝蕭", Font.PLAIN, 40));
		welcome_Label.setBounds(60, 50, 330, 50);
		adminHome.getContentPane().add(welcome_Label);
		
//		嚙豬理嚙諒帳嚙踝蕭嚙磕嚙誶迎蕭嚙踝蕭T嚙踝蕭
		JTextArea info_TextArea = new JTextArea();
		info_TextArea.setTabSize(12);
		info_TextArea.setRows(2);
		info_TextArea.setColumns(1);
		info_TextArea.setFont(new Font("嚙盤嚙緯嚙踝蕭嚙踝蕭嚙踝蕭", Font.PLAIN, 12));
		info_TextArea.setText("\u7BA1\u7406\u8005\u8CC7\u8A0A\r\n\u5E33\u865F\uFF1AXXXXX          \u7BA1\u7406\u8005\u540D\u7A31\uFF1AXXXXX");
		info_TextArea.setBackground(SystemColor.inactiveCaptionBorder);
		info_TextArea.setBounds(60, 110, 330, 40);
		adminHome.getContentPane().add(info_TextArea);
		
//		嚙緯嚙踝蕭嚙踝蕭嚙誼賂蕭T button
		JButton keyIn_Button = new JButton("\u767B\u9304\u7AE5\u88DD\u8CC7\u8A0A");
		keyIn_Button.setFont(new Font("嚙盤嚙緯嚙踝蕭嚙踝蕭嚙踝蕭", Font.PLAIN, 18));
		keyIn_Button.setBounds(60, 200, 250, 50);
		keyIn_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				T1 t1 = new T1(user);
				adminHome.dispose();
			}
		});
		adminHome.getContentPane().add(keyIn_Button);
		
//		嚙踝蕭嚙踝蕭嚙諉品嚙瞑嚙踝蕭嚙緘嚙踝蕭嚙踝蕭T button
		JButton sup_contact_Button = new JButton("供應商聯絡資訊");
		sup_contact_Button.setFont(new Font("嚙盤嚙緯嚙踝蕭嚙踝蕭嚙踝蕭", Font.PLAIN, 18));
		sup_contact_Button.setBounds(60, 290, 250, 50);
		sup_contact_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SupplierInfo supInfo = new SupplierInfo(user);
				adminHome.dispose();
			}
		});
		adminHome.getContentPane().add(sup_contact_Button);
		
//		6/10 add brand_contact_Button
		JButton brand_contact_Button = new JButton("品牌商聯絡資訊");
		brand_contact_Button.setFont(new Font("嚙盤嚙緯嚙踝蕭嚙踝蕭嚙踝蕭", Font.PLAIN, 18));
		brand_contact_Button.setBounds(60, 380, 250, 50);
		brand_contact_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BrandInfo brandInfo = new BrandInfo(user);
				adminHome.dispose();
			}
		});
		adminHome.getContentPane().add(brand_contact_Button);
		
//		嚙豬理嚙緩嚙編 button
		JButton inventory_Button = new JButton("\u7BA1\u7406\u5EAB\u5B58");
		inventory_Button.setFont(new Font("嚙盤嚙緯嚙踝蕭嚙踝蕭嚙踝蕭", Font.PLAIN, 18));
		inventory_Button.setBounds(400, 200, 250, 50);
		inventory_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InvManFrameWindow inv = new InvManFrameWindow(user);
				adminHome.dispose();
			}
		});
		adminHome.getContentPane().add(inventory_Button);
		
//		嚙踝蕭嚙踝蕭嚙踝蕭嚙綞嚙碼嚙篆嚙踝蕭T button
		JButton platformShip_Button = new JButton("\u7DB2\u8DEF\u5E73\u53F0\u51FA\u8CA8\u8CC7\u8A0A");
		platformShip_Button.setFont(new Font("嚙盤嚙緯嚙踝蕭嚙踝蕭嚙踝蕭", Font.PLAIN, 18));
		platformShip_Button.setBounds(400, 290, 250, 50);
		platformShip_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShippingInfo_Frame shipInfo = new ShippingInfo_Frame(user);
				adminHome.dispose();
			}
		});
		adminHome.getContentPane().add(platformShip_Button);
		
//		嚙踝蕭嚙篆嚙踝蕭T button
		JButton distribute_Button = new JButton("\u5206\u8CA8\u8CC7\u8A0A");
		distribute_Button.setFont(new Font("嚙盤嚙緯嚙踝蕭嚙踝蕭嚙踝蕭", Font.PLAIN, 18));
		distribute_Button.setBounds(400, 380, 250, 50);
		distribute_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Distribution_Frame dist = new Distribution_Frame(user);
				adminHome.dispose();
			}
		});
		adminHome.getContentPane().add(distribute_Button);
		
//		嚙緯嚙碼 button
		JButton logout_Button = new JButton("\u767B\u51FA");
		logout_Button.setFont(new Font("嚙盤嚙緯嚙踝蕭嚙踝蕭嚙踝蕭", Font.PLAIN, 16));
		logout_Button.setBounds(680, 500, 80, 40);
		logout_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		adminHome.getContentPane().add(logout_Button);
		adminHome.setVisible(true);
	}
	

}
