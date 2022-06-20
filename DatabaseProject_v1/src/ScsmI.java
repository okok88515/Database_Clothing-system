/**
 * Jacky的註解在我這邊是亂碼，但這個是寄賣品庫存的頁面（by Iris)
 */
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JToolBar;

import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ScsmI {

	JFrame frame;
	private JTextField T1;
	private JTextField qn;
	private final ButtonGroup Size = new ButtonGroup();
	private final ButtonGroup Quantity = new ButtonGroup();
	static ScsmI window;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new ScsmI();
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
	public ScsmI() {
//		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u9580\u5E02\u5EAB\u5B58\u7BA1\u7406\uFF0D\u5BC4\u8CE3\u54C1\u5EAB\u5B58");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel LTop = new JLabel(" \u5BC4\u8CE3\u54C1\u5EAB\u5B58\uFF08X\u865F\u5E97\uFF09");
		LTop.setFont(new Font("�s�ө���", Font.PLAIN, 18));
		GridBagConstraints gbc_LTop = new GridBagConstraints();
		gbc_LTop.fill = GridBagConstraints.HORIZONTAL;
		gbc_LTop.gridwidth = 4;
		gbc_LTop.insets = new Insets(0, 0, 5, 5);
		gbc_LTop.gridx = 0;
		gbc_LTop.gridy = 0;
		frame.getContentPane().add(LTop, gbc_LTop);
		
		JButton B2 = new JButton("\u5168\u90E8\u9580\u5E02");
		B2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				AsCSMiT sub_window = new AsCSMiT(user);
//				sub_window.frame.setVisible(true);
			}
		});
		GridBagConstraints gbc_B2 = new GridBagConstraints();
		gbc_B2.fill = GridBagConstraints.BOTH;
		gbc_B2.insets = new Insets(0, 0, 5, 0);
		gbc_B2.gridx = 5;
		gbc_B2.gridy = 0;
		frame.getContentPane().add(B2, gbc_B2);
		
		JLabel L1 = new JLabel("\u5BC4\u8CE3\u54C1ID");
		GridBagConstraints gbc_L1 = new GridBagConstraints();
		gbc_L1.anchor = GridBagConstraints.WEST;
		gbc_L1.fill = GridBagConstraints.VERTICAL;
		gbc_L1.insets = new Insets(0, 0, 5, 5);
		gbc_L1.gridx = 1;
		gbc_L1.gridy = 1;
		frame.getContentPane().add(L1, gbc_L1);
		
		T1 = new JTextField();
		T1.setText("\u8ACB\u8F38\u5165\u5BC4\u8CE3\u54C1ID");
		GridBagConstraints gbc_T1 = new GridBagConstraints();
		gbc_T1.gridwidth = 2;
		gbc_T1.insets = new Insets(0, 0, 5, 5);
		gbc_T1.fill = GridBagConstraints.BOTH;
		gbc_T1.gridx = 3;
		gbc_T1.gridy = 1;
		frame.getContentPane().add(T1, gbc_T1);
		T1.setColumns(10);
		
		JLabel L2 = new JLabel("\u5BC4\u8CE3\u54C1\u5C3A\u5BF8");
		GridBagConstraints gbc_L2 = new GridBagConstraints();
		gbc_L2.anchor = GridBagConstraints.WEST;
		gbc_L2.insets = new Insets(0, 0, 5, 5);
		gbc_L2.gridx = 1;
		gbc_L2.gridy = 2;
		frame.getContentPane().add(L2, gbc_L2);
		
		JToolBar Sizetool = new JToolBar();
		Sizetool.setFloatable(false);
		GridBagConstraints gbc_Sizetool = new GridBagConstraints();
		gbc_Sizetool.fill = GridBagConstraints.BOTH;
		gbc_Sizetool.gridwidth = 2;
		gbc_Sizetool.insets = new Insets(0, 0, 5, 5);
		gbc_Sizetool.gridx = 3;
		gbc_Sizetool.gridy = 2;
		frame.getContentPane().add(Sizetool, gbc_Sizetool);
		
		JRadioButton r1 = new JRadioButton("XS");
		Size.add(r1);
		Sizetool.add(r1);
		
		JRadioButton r2 = new JRadioButton("S");
		Size.add(r2);
		Sizetool.add(r2);
		
		JRadioButton r3 = new JRadioButton("M");
		Size.add(r3);
		Sizetool.add(r3);
		
		JRadioButton r4 = new JRadioButton("L");
		Size.add(r4);
		Sizetool.add(r4);
		
		JRadioButton r5 = new JRadioButton("XL");
		Size.add(r5);
		Sizetool.add(r5);
		
		JRadioButton r6 = new JRadioButton("XXL");
		Size.add(r6);
		Sizetool.add(r6);
		
		JLabel L3 = new JLabel("\u4FEE\u6539\u6578\u91CF");
		GridBagConstraints gbc_L3 = new GridBagConstraints();
		gbc_L3.anchor = GridBagConstraints.WEST;
		gbc_L3.insets = new Insets(0, 0, 5, 5);
		gbc_L3.gridx = 1;
		gbc_L3.gridy = 3;
		frame.getContentPane().add(L3, gbc_L3);
		
		JToolBar Quantitytool = new JToolBar();
		Quantitytool.setFloatable(false);
		GridBagConstraints gbc_Quantitytool = new GridBagConstraints();
		gbc_Quantitytool.fill = GridBagConstraints.BOTH;
		gbc_Quantitytool.gridwidth = 2;
		gbc_Quantitytool.insets = new Insets(0, 0, 5, 5);
		gbc_Quantitytool.gridx = 3;
		gbc_Quantitytool.gridy = 3;
		frame.getContentPane().add(Quantitytool, gbc_Quantitytool);
		
		JRadioButton rp = new JRadioButton("\u589E\u52A0");
		Quantity.add(rp);
		Quantitytool.add(rp);
		
		JRadioButton rm = new JRadioButton("\u6E1B\u5C11");
		Quantity.add(rm);
		Quantitytool.add(rm);
		
		qn = new JTextField();
		qn.setText("\u8ACB\u8F38\u5165\u4FEE\u6539\u6578\u91CF");
		Quantitytool.add(qn);
		qn.setColumns(10);
		
		JLabel O1 = new JLabel(" ");
		GridBagConstraints gbc_O1 = new GridBagConstraints();
		gbc_O1.gridwidth = 5;
		gbc_O1.insets = new Insets(0, 0, 5, 5);
		gbc_O1.gridx = 0;
		gbc_O1.gridy = 4;
		frame.getContentPane().add(O1, gbc_O1);
		
		JButton B1 = new JButton("\u4FEE\u6539\u6578\u91CF");
		B1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String T2d = "";
				if (r1.isSelected()) {
					T2d += "XS";
				}
				if (r2.isSelected()) {
					T2d += "S";
				}
				if (r3.isSelected()) {
					T2d += "M";
				}
				if (r4.isSelected()) {
					T2d += "L";
				}
				if (r5.isSelected()) {
					T2d += "XL";
				}
				if (r6.isSelected()) {
					T2d += "XXL";
				}
				
				String T3d = "";
				if (rp.isSelected()) {
					T3d += "+";
				}
				if (rm.isSelected()) {
					T3d += "-";
				}
				
				String data = T1.getText()+" '"+T2d+"' "+T3d+qn.getText();
				
				System.out.println(data);

				if (data.isEmpty()) {
					O1.setForeground(Color.RED);
					O1.setText("��Ʀ��~");
				}
				else {
					data += " �ާ@��";
					O1.setForeground(Color.BLACK);
					O1.setText(data);
				}
			}
		});
		GridBagConstraints gbc_B1 = new GridBagConstraints();
		gbc_B1.gridwidth = 2;
		gbc_B1.fill = GridBagConstraints.VERTICAL;
		gbc_B1.insets = new Insets(0, 0, 0, 5);
		gbc_B1.gridx = 1;
		gbc_B1.gridy = 5;
		frame.getContentPane().add(B1, gbc_B1);
		
		JButton HOME = new JButton("\u56DE\u9996\u9801");
		GridBagConstraints gbc_HOME = new GridBagConstraints();
		gbc_HOME.insets = new Insets(0, 0, 0, 5);
		gbc_HOME.gridx = 4;
		gbc_HOME.gridy = 5;
		frame.getContentPane().add(HOME, gbc_HOME);
		
		JButton SignOut = new JButton("\u767B\u51FA");
		GridBagConstraints gbc_SignOut = new GridBagConstraints();
		gbc_SignOut.gridx = 5;
		gbc_SignOut.gridy = 5;
		frame.getContentPane().add(SignOut, gbc_SignOut);
	}

}
