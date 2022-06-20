/**
 * 登錄寄賣品資訊
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;

import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JToolBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class T2 {

	private JFrame frame;
	private JTextField T1;
	private JTextField T4;
	private JTextField T5;
	private User user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					T2 window = new T2();
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
	public T2() {
		initialize();
	}
	
	public T2(User user) {
		this.user = user;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u9580\u5E02\u4F7F\u7528\u4ECB\u9762\uFF0D\u767B\u9304\u5BC4\u8CE3\u54C1\u8CC7\u8A0A");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 46, 0, 96, 0};
		gridBagLayout.rowHeights = new int[]{0, 21, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel LTop = new JLabel("   \u767B\u9304\u5BC4\u8CE3\u54C1\u8CC7\u8A0A");
		LTop.setFont(new Font("�s�ө���", Font.PLAIN, 18));
		GridBagConstraints gbc_LTop = new GridBagConstraints();
		gbc_LTop.anchor = GridBagConstraints.WEST;
		gbc_LTop.gridwidth = 4;
		gbc_LTop.insets = new Insets(0, 0, 5, 5);
		gbc_LTop.gridx = 0;
		gbc_LTop.gridy = 0;
		frame.getContentPane().add(LTop, gbc_LTop);
		
		JLabel L1 = new JLabel("\u5BC4\u8CE3\u54C1ID");
		GridBagConstraints gbc_L1 = new GridBagConstraints();
		gbc_L1.gridwidth = 2;
		gbc_L1.anchor = GridBagConstraints.WEST;
		gbc_L1.insets = new Insets(0, 0, 5, 5);
		gbc_L1.gridx = 1;
		gbc_L1.gridy = 1;
		frame.getContentPane().add(L1, gbc_L1);
		
		T1 = new JTextField();
		T1.setText("\u8ACB\u8F38\u5165\u5BC4\u8CE3\u54C1ID");
		GridBagConstraints gbc_T1 = new GridBagConstraints();
		gbc_T1.fill = GridBagConstraints.BOTH;
		gbc_T1.insets = new Insets(0, 0, 5, 5);
		gbc_T1.gridx = 3;
		gbc_T1.gridy = 1;
		frame.getContentPane().add(T1, gbc_T1);
		T1.setColumns(10);
		
		JLabel L2 = new JLabel("\u5BC4\u8CE3\u54C1\u5C3A\u5BF8");
		GridBagConstraints gbc_L2 = new GridBagConstraints();
		gbc_L2.gridwidth = 2;
		gbc_L2.anchor = GridBagConstraints.WEST;
		gbc_L2.insets = new Insets(0, 0, 5, 5);
		gbc_L2.gridx = 1;
		gbc_L2.gridy = 2;
		frame.getContentPane().add(L2, gbc_L2);
		
		JToolBar Size = new JToolBar();
		Size.setFloatable(false);
		GridBagConstraints gbc_Size = new GridBagConstraints();
		gbc_Size.fill = GridBagConstraints.BOTH;
		gbc_Size.insets = new Insets(0, 0, 5, 5);
		gbc_Size.gridx = 3;
		gbc_Size.gridy = 2;
		frame.getContentPane().add(Size, gbc_Size);
		
		JCheckBox c1 = new JCheckBox("XS");
		Size.add(c1);
		
		JCheckBox c2 = new JCheckBox("S");
		Size.add(c2);
		
		JCheckBox c3 = new JCheckBox("M");
		Size.add(c3);
		
		JCheckBox c4 = new JCheckBox("L");
		Size.add(c4);
		
		JCheckBox c5 = new JCheckBox("XL");
		Size.add(c5);
		
		JCheckBox c6 = new JCheckBox("XXL");
		Size.add(c6);
		
		JLabel L4 = new JLabel("\u62BD\u6210");
		GridBagConstraints gbc_L4 = new GridBagConstraints();
		gbc_L4.gridwidth = 2;
		gbc_L4.anchor = GridBagConstraints.WEST;
		gbc_L4.insets = new Insets(0, 0, 5, 5);
		gbc_L4.gridx = 1;
		gbc_L4.gridy = 3;
		frame.getContentPane().add(L4, gbc_L4);
		
		T4 = new JTextField();
		T4.setText("\u8ACB\u8F38\u5165\u767E\u5206\u6BD4");
		GridBagConstraints gbc_T4 = new GridBagConstraints();
		gbc_T4.insets = new Insets(0, 0, 5, 5);
		gbc_T4.fill = GridBagConstraints.BOTH;
		gbc_T4.gridx = 3;
		gbc_T4.gridy = 3;
		frame.getContentPane().add(T4, gbc_T4);
		T4.setColumns(10);
		
		JLabel L5 = new JLabel("\u5B9A\u50F9");
		GridBagConstraints gbc_L5 = new GridBagConstraints();
		gbc_L5.gridwidth = 2;
		gbc_L5.anchor = GridBagConstraints.WEST;
		gbc_L5.insets = new Insets(0, 0, 5, 5);
		gbc_L5.gridx = 1;
		gbc_L5.gridy = 4;
		frame.getContentPane().add(L5, gbc_L5);
		
		T5 = new JTextField();
		T5.setText("\u8ACB\u8F38\u5165\u91D1\u984D");
		GridBagConstraints gbc_T5 = new GridBagConstraints();
		gbc_T5.insets = new Insets(0, 0, 5, 5);
		gbc_T5.fill = GridBagConstraints.BOTH;
		gbc_T5.gridx = 3;
		gbc_T5.gridy = 4;
		frame.getContentPane().add(T5, gbc_T5);
		T5.setColumns(10);
		
		JLabel O1 = new JLabel(" ");
		GridBagConstraints gbc_O1 = new GridBagConstraints();
		gbc_O1.fill = GridBagConstraints.VERTICAL;
		gbc_O1.gridwidth = 4;
		gbc_O1.insets = new Insets(0, 0, 5, 5);
		gbc_O1.gridx = 0;
		gbc_O1.gridy = 5;
		frame.getContentPane().add(O1, gbc_O1);
		
		JButton B1 = new JButton("\u767B\u9304");
		B1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String T2d = "";
				if (c1.isSelected()) {
					T2d += "XS";
				}
				if (c2.isSelected()) {
					T2d += " S";
				}
				if (c3.isSelected()) {
					T2d += " M";
				}
				if (c4.isSelected()) {
					T2d += " L";
				}
				if (c5.isSelected()) {
					T2d += " XL";
				}
				if (c6.isSelected()) {
					T2d += " XXL";
				}
				T2d = T2d.trim();
				
				String data = T1.getText()+" \""+T2d+"\" \n"+T4.getText()+"% $"+T5.getText();
				
				System.out.println(data);

				if (data.isEmpty()) {
					O1.setForeground(Color.RED);
					O1.setText("�n������");
				}
				else {
					data += " �n����";
					O1.setForeground(Color.BLACK);
					O1.setText(data);
				}
			}
		});
		GridBagConstraints gbc_B1 = new GridBagConstraints();
		gbc_B1.gridwidth = 2;
		gbc_B1.fill = GridBagConstraints.BOTH;
		gbc_B1.insets = new Insets(0, 0, 5, 5);
		gbc_B1.gridx = 1;
		gbc_B1.gridy = 6;
		frame.getContentPane().add(B1, gbc_B1);
		
		JButton HOME = new JButton("\u56DE\u9996\u9801");
		GridBagConstraints gbc_HOME = new GridBagConstraints();
		gbc_HOME.anchor = GridBagConstraints.EAST;
		gbc_HOME.insets = new Insets(0, 0, 5, 5);
		gbc_HOME.gridx = 3;
		gbc_HOME.gridy = 6;
		frame.getContentPane().add(HOME, gbc_HOME);
		
		JButton SignOut = new JButton("\u767B\u51FA");
		GridBagConstraints gbc_SignOut = new GridBagConstraints();
		gbc_SignOut.insets = new Insets(0, 0, 5, 0);
		gbc_SignOut.gridx = 4;
		gbc_SignOut.gridy = 6;
		frame.getContentPane().add(SignOut, gbc_SignOut);
		frame.setVisible(true);
	}
}
