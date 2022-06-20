/**
 * 管理者介面-分貨資訊
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class Distribution_Frame {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private User user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Distribution_Frame window = new Distribution_Frame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Distribution_Frame() {
		initialize();
	}
	
	public Distribution_Frame(User user) {
		this.user = user;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("管理者介面－分貨資訊");
		frame.setBounds(100, 100, 850, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("童裝ID");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel.setBounds(169, 115, 82, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("童裝尺寸");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(169, 174, 122, 29);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("數量");
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(169, 230, 82, 29);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("門市ID");
		lblNewLabel_3.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(169, 291, 92, 29);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField.setBounds(335, 115, 308, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(335, 230, 308, 29);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("新細明體", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(335, 291, 308, 29);
		frame.getContentPane().add(textField_3);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("XS");
		rdbtnNewRadioButton.setFont(new Font("Calibri", Font.PLAIN, 20));
		rdbtnNewRadioButton.setBounds(335, 174, 51, 29);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("S");
		rdbtnNewRadioButton_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		rdbtnNewRadioButton_1.setBounds(388, 174, 51, 29);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("M");
		rdbtnNewRadioButton_2.setFont(new Font("Calibri", Font.PLAIN, 20));
		rdbtnNewRadioButton_2.setBounds(441, 174, 51, 29);
		frame.getContentPane().add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("L");
		rdbtnNewRadioButton_3.setFont(new Font("Calibri", Font.PLAIN, 20));
		rdbtnNewRadioButton_3.setBounds(494, 174, 51, 29);
		frame.getContentPane().add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("XL");
		rdbtnNewRadioButton_4.setFont(new Font("Calibri", Font.PLAIN, 20));
		rdbtnNewRadioButton_4.setBounds(547, 174, 51, 29);
		frame.getContentPane().add(rdbtnNewRadioButton_4);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("XXL");
		rdbtnNewRadioButton_5.setFont(new Font("Calibri", Font.PLAIN, 20));
		rdbtnNewRadioButton_5.setBounds(600, 174, 60, 29);
		frame.getContentPane().add(rdbtnNewRadioButton_5);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton_1);
		bg.add(rdbtnNewRadioButton_2);
		bg.add(rdbtnNewRadioButton_3);
		bg.add(rdbtnNewRadioButton_4);
		bg.add(rdbtnNewRadioButton_5);

		JButton btnNewButton = new JButton("確定分貨");
		btnNewButton.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		btnNewButton.setBounds(227, 362, 142, 43);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("取消分貨");
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		btnNewButton_1.setBounds(456, 362, 142, 43);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("回首頁");
		btnNewButton_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		btnNewButton_1_1.setBounds(621, 474, 99, 29);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("登出");
		btnNewButton_1_2.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		btnNewButton_1_2.setBounds(730, 474, 96, 29);
		frame.getContentPane().add(btnNewButton_1_2);
		
		JLabel lblNewLabel_4 = new JLabel("分貨功能");
		lblNewLabel_4.setFont(new Font("微軟正黑體", Font.PLAIN, 25));
		lblNewLabel_4.setBounds(360, 39, 134, 29);
		frame.getContentPane().add(lblNewLabel_4);
		
		frame.setVisible(true);
	}
}
