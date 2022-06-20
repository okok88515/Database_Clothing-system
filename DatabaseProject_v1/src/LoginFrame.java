/**
 * 登入頁面（這是第一個畫面，我沒有把initialize註解掉）

 */
import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LoginFrame {

	private JFrame login;
	private JTextField account_Field;
	private JTextField pwd_Field;
//	private SQLMan sqlMan;
	
	// php myAdmin
	static final String SERVER = "jdbc:mysql://140.119.19.73:3315/";
	static final String DATABASE = "107601034";
	static final String URL = SERVER + DATABASE + "?useSSL=false&characterEncoding=utf-8&PublicKeyRetrieval=true";
	static final String USERNAME = "107601034";
	static final String PASSWORD = "cfe83";
	private Connection conn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame window = new LoginFrame();
					window.login.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
//		load driver (because I use phpMyAdmin so I temporarily comment this section)
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		}catch(ClassNotFoundException e){
//			e.printStackTrace();
//		}
		
//		try {
//			LoginFrame.conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//			System.out.println("DB connected!");
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
	}

	/**
	 * Create the application.
	 */
	public LoginFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		login = new JFrame();
		login.setTitle("Login");
		login.setBounds(100, 100, 800, 600);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.getContentPane().setLayout(null);
		
		JLabel title_Label = new JLabel("\u670D\u98FE\u5E97\u5EAB\u5B58\u7CFB\u7D71\u2014\u767B\u5165\u9801\u9762");
		title_Label.setFont(new Font("�L�n������", Font.PLAIN, 40));
		title_Label.setBounds(130, 60, 485, 75);
		login.getContentPane().add(title_Label);
		
		JLabel account_Label = new JLabel("\u5E33\u865F");
		account_Label.setFont(new Font("�L�n������", Font.PLAIN, 20));
		account_Label.setBounds(160, 165, 50, 30);
		login.getContentPane().add(account_Label);
		
		JLabel pwd_Label = new JLabel("\u5BC6\u78BC");
		pwd_Label.setFont(new Font("�L�n������", Font.PLAIN, 20));
		pwd_Label.setBounds(160, 235, 50, 30);
		login.getContentPane().add(pwd_Label);
		
		account_Field = new JTextField();
		account_Field.setForeground(Color.GRAY);
		account_Field.setFont(new Font("�L�n������", Font.PLAIN, 14));
		account_Field.setText("\u8ACB\u8F38\u5165\u5E33\u865F");
		account_Field.setBounds(260, 165, 340, 30);
		account_Field.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				account_Field.setText("");
				account_Field.setForeground(Color.black);
			}
		});
		login.getContentPane().add(account_Field);
		account_Field.setColumns(10);
		
		pwd_Field = new JTextField();
		pwd_Field.setText("\u8ACB\u8F38\u5165\u5BC6\u78BC");
		pwd_Field.setFont(new Font("�L�n������", Font.PLAIN, 14));
		pwd_Field.setForeground(Color.GRAY);
		pwd_Field.setColumns(10);
		pwd_Field.setBounds(260, 235, 340, 30);
		pwd_Field.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				pwd_Field.setText("");
				pwd_Field.setForeground(Color.black);
			}
		});
		login.getContentPane().add(pwd_Field);
		
//		這個Label用不到了我就住解掉了
//		JLabel error_Label = new JLabel("\u932F\u8AA4\u8A0A\u606F");
//		error_Label.setFont(new Font("�L�n������", Font.BOLD, 20));
//		error_Label.setForeground(Color.RED);
//		error_Label.setBounds(335, 300, 85, 35);
//		login.getContentPane().add(error_Label);
		
		JButton Admin_Button = new JButton("\u7BA1\u7406\u8005\u767B\u5165");
		Admin_Button.setFont(new Font("�L�n������", Font.PLAIN, 20));
		Admin_Button.setBounds(160, 390, 180, 30);
		Admin_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User u1 = new User("98", "1234", "testUser1", true);		//	new a user (is adm) to test the bellowing code
				AdminHome a = new AdminHome(u1);	//testing
				login.dispose();
			}
		});
		login.getContentPane().add(Admin_Button);
		
//		�����n�J button
		JButton Store_Button = new JButton("\u9580\u5E02\u767B\u5165");
		Store_Button.setFont(new Font("�L�n������", Font.PLAIN, 20));
		Store_Button.setBounds(420, 390, 180, 30);
		Store_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User u2 = new User("1", "5678", "testUser2", false);		//	new a user (storeID: 1) to test the bellowing code
				StoreHome s = new StoreHome(u2);	//testing
				login.dispose();
			}
		});
		login.getContentPane().add(Store_Button);
	}
	
}

		
		
