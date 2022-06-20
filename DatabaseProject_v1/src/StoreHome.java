/**
 * 門市首頁
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StoreHome {

	private JFrame storeHome;
	private User user;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					StoreHome window = new StoreHome();
//					window.storeHome.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
//	public StoreHome() {
//		initialize();
//	}
	
	public StoreHome(User user) {
		this.user = user;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		storeHome = new JFrame();
		storeHome.setTitle("\u9580\u5E02\u2014\u9996\u9801");
		storeHome.setBounds(100, 100, 800, 600);
		storeHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		storeHome.getContentPane().setLayout(null);
		
		JLabel welcome_Label = new JLabel("\u9580\u5E02\u4F7F\u7528\u4ECB\u9762\u2014\u9996\u9801");
		welcome_Label.setFont(new Font("�L�n������", Font.PLAIN, 40));
		welcome_Label.setBounds(60, 50, 380, 50);
		storeHome.getContentPane().add(welcome_Label);
		
		JTextArea info_TextArea = new JTextArea();
		info_TextArea.setText("\u9580\u5E02\u5E33\u865F\u8CC7\u8A0A\r\n\u5E33\u865F\uFF1AXXXXX          \u9580\u5E02\u540D\u7A31\uFF1AXXXXX");
		info_TextArea.setTabSize(12);
		info_TextArea.setRows(2);
		info_TextArea.setFont(new Font("�L�n������", Font.PLAIN, 12));
		info_TextArea.setColumns(1);
		info_TextArea.setBackground(SystemColor.inactiveCaptionBorder);
		info_TextArea.setBounds(60, 110, 330, 40);
		storeHome.getContentPane().add(info_TextArea);
		
		JButton contact_Button = new JButton("\u67E5\u8A62\u54C1\u724C\u5546\u806F\u7D61\u8CC7\u8A0A");
		contact_Button.setFont(new Font("�L�n������", Font.PLAIN, 18));
		contact_Button.setBounds(60, 200, 250, 50);
		contact_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BrandInfo brandInfo = new BrandInfo(user);
				storeHome.dispose();
			}
		});
		storeHome.getContentPane().add(contact_Button);
		
		JButton keyIn_Button = new JButton("\u767B\u9304\u5BC4\u8CE3\u54C1\u8CC7\u8A0A");
		keyIn_Button.setFont(new Font("�L�n������", Font.PLAIN, 18));
		keyIn_Button.setBounds(60, 290, 250, 50);
		keyIn_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				T2 t2 = new T2(user);
				storeHome.dispose();
			}
		});
		storeHome.getContentPane().add(keyIn_Button);

		JButton query_inv_btn = new JButton("查詢本店庫存");
		query_inv_btn.setFont(new Font("�L�n������", Font.PLAIN, 18));
		query_inv_btn.setBounds(400, 200, 250, 50);
		query_inv_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AsCSMiT a = new AsCSMiT(user);
				storeHome.dispose();
			}
		});
		storeHome.getContentPane().add(query_inv_btn);
		
		JButton man_inv_btn = new JButton("管理門市庫存");
		man_inv_btn.setFont(new Font("�L�n������", Font.PLAIN, 18));
		man_inv_btn.setBounds(400, 290, 250, 50);
		man_inv_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InvManFrameWindow imfw = new InvManFrameWindow(user);
				storeHome.dispose();
			}
		});
		storeHome.getContentPane().add(man_inv_btn);
		
		JButton logout_Button = new JButton("\u767B\u51FA");
		logout_Button.setFont(new Font("�L�n������", Font.PLAIN, 16));
		logout_Button.setBounds(680, 500, 80, 40);
		storeHome.getContentPane().add(logout_Button);
		storeHome.setVisible(true);
	}

}
