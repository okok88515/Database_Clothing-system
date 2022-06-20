import java.awt.EventQueue;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;

public class InvManFrameWindow2 {

	private JFrame InvManFrame;
	private JTable table;
	private JPanel cardsPan;
	private CardLayout cardLay;
	private JTextField txtid;
	private JPanel allPanel;
	private JTextField txtid_1;
	private JTextField textField_3;
	private JPanel conPanel;
	private JPanel stoKidPanel;
	private JPanel onlKidPanel;
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_6;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InvManFrameWindow2 window = new InvManFrameWindow2();
					window.InvManFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InvManFrameWindow2() {
		//initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Box allBox = Box.createVerticalBox(); //�Ыث�����box layout�A�h�Ӥ��󫫪��ƦC
				
		InvManFrame = new JFrame("�w�s�޲z");
		InvManFrame.setSize(800, 600); //�]�w�����j�p
		InvManFrame.setLocationRelativeTo(null); //�����}�Ҧ�m�G�m��
		InvManFrame.setContentPane(allBox);
		
		JPanel userPanel = new JPanel();
		userPanel.setBorder(new EmptyBorder(0, 7, 0, 0));
		allBox.add(userPanel);
		userPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel userIDLabel = new JLabel("\u5E33\u865F\uFF1A");
		userPanel.add(userIDLabel);
		userIDLabel.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		userIDLabel.setPreferredSize(new Dimension(250, 20));
		
		JLabel userNameLabel = new JLabel("\u7BA1\u7406\u8005\uFF0F\u9580\u5E02\u540D\u7A31\uFF1A");
		userNameLabel.setPreferredSize(new Dimension(400, 20));
		userPanel.add(userNameLabel);
		userNameLabel.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		
		JPanel btnPanel = new JPanel();
		btnPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		FlowLayout fl_btnPanel = (FlowLayout) btnPanel.getLayout();
		fl_btnPanel.setAlignment(FlowLayout.LEADING);
		allBox.add(btnPanel);
		
		JButton btnNewButton = new JButton("\u5EAB\u5B58\u7E3D\u89BD");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLay.show(cardsPan,"all");	
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLay.show(cardsPan,"all");	
			}
		});
		btnNewButton.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		btnPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u7DB2\u8DEF\u5EAB\u5B58");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLay.show(cardsPan,"onlKid");	
			}
		});
		btnNewButton_1.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		btnPanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u9580\u5E02\u7AE5\u88DD");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLay.show(cardsPan,"stoKid");	
			}
		});
		btnNewButton_2.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		btnPanel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u9580\u5E02\u5BC4\u8CE3\u54C1");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLay.show(cardsPan,"con");	
			}
		});
		btnNewButton_3.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		btnPanel.add(btnNewButton_3);
		
		cardLay = new CardLayout();
		cardsPan = new JPanel(cardLay);
		allBox.add(cardsPan);
		
		allPanel = new JPanel();
		cardsPan.add(allPanel, "all");
		GridBagLayout gbl_allPanel = new GridBagLayout();
		gbl_allPanel.columnWidths = new int[]{0, 0};
		gbl_allPanel.rowHeights = new int[] {30, 38, 0};
		gbl_allPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_allPanel.rowWeights = new double[]{0.0, 0.0, 1.0};
		allPanel.setLayout(gbl_allPanel);
		
		JLabel lblNewLabel = new JLabel("\u5EAB\u5B58\u7E3D\u89BD");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("�s�ө���", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		allPanel.add(lblNewLabel, gbc_lblNewLabel);
		
		table = new JTable();
		table.setBorder(new EmptyBorder(0, 0, 0, 0));
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 2;
		allPanel.add(table, gbc_table);
		
		//�������ˮw�s
		onlKidPanel = new JPanel();
		cardsPan.add(onlKidPanel, "onlKid");
		GridBagLayout gbl_onlKidPanel = new GridBagLayout();
		gbl_onlKidPanel.columnWidths = new int[] {153, 0, 153, 0, 153, 0, 0};
		gbl_onlKidPanel.rowHeights = new int[] {30, 38, 0, 30, 0, 30, 0, 30, 30, 30, 30, 0, 30};
		gbl_onlKidPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 4.9E-324, 0.0, Double.MIN_VALUE};
		gbl_onlKidPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
		onlKidPanel.setLayout(gbl_onlKidPanel);
		
		JLabel lblNewLabel_3 = new JLabel("\u7DB2\u8DEF\u5EAB\u5B58\u7BA1\u7406");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("�s�ө���", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.gridwidth = 6;
		gbc_lblNewLabel_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 1;
		onlKidPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u7AE5\u88DDID");
		lblNewLabel_4.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 2;
		onlKidPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		txtid = new JTextField();
		txtid.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				txtid.setText("");
			}
		});
		txtid.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		txtid.setText("\u8ACB\u8F38\u5165\u7AE5\u88DDID");
		GridBagConstraints gbc_txtid = new GridBagConstraints();
		gbc_txtid.insets = new Insets(0, 0, 5, 5);
		gbc_txtid.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtid.gridx = 2;
		gbc_txtid.gridy = 2;
		onlKidPanel.add(txtid, gbc_txtid);
		txtid.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("\u7AE5\u88DD\u5C3A\u5BF8");
		lblNewLabel_7.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 4;
		onlKidPanel.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		JPanel panel_size = new JPanel();
		FlowLayout fl_panel_size = (FlowLayout) panel_size.getLayout();
		fl_panel_size.setAlignOnBaseline(true);
		fl_panel_size.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_size = new GridBagConstraints();
		gbc_panel_size.insets = new Insets(0, 0, 5, 5);
		gbc_panel_size.fill = GridBagConstraints.BOTH;
		gbc_panel_size.gridx = 2;
		gbc_panel_size.gridy = 4;
		onlKidPanel.add(panel_size, gbc_panel_size);
		
		JRadioButton rdbtnNewRadioButton_2_7 = new JRadioButton("XS");
		rdbtnNewRadioButton_2_7.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		panel_size.add(rdbtnNewRadioButton_2_7);
		
		JRadioButton rdbtnNewRadioButton_2_1_3 = new JRadioButton("S");
		rdbtnNewRadioButton_2_1_3.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		panel_size.add(rdbtnNewRadioButton_2_1_3);
		
		JRadioButton rdbtnNewRadioButton_2_2_3 = new JRadioButton("M");
		rdbtnNewRadioButton_2_2_3.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		panel_size.add(rdbtnNewRadioButton_2_2_3);
		
		JRadioButton rdbtnNewRadioButton_2_3_3 = new JRadioButton("L");
		rdbtnNewRadioButton_2_3_3.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		panel_size.add(rdbtnNewRadioButton_2_3_3);
		
		JRadioButton rdbtnNewRadioButton_2_4_4 = new JRadioButton("XL");
		rdbtnNewRadioButton_2_4_4.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		panel_size.add(rdbtnNewRadioButton_2_4_4);
		
		JRadioButton rdbtnNewRadioButton_2_4_1_3 = new JRadioButton("XXL");
		rdbtnNewRadioButton_2_4_1_3.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		panel_size.add(rdbtnNewRadioButton_2_4_1_3);
		
		JLabel lblNewLabel_7_1_2_1 = new JLabel("\u4FEE\u6539\u6578\u91CF");
		lblNewLabel_7_1_2_1.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_7_1_2_1 = new GridBagConstraints();
		gbc_lblNewLabel_7_1_2_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7_1_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7_1_2_1.gridx = 0;
		gbc_lblNewLabel_7_1_2_1.gridy = 6;
		onlKidPanel.add(lblNewLabel_7_1_2_1, gbc_lblNewLabel_7_1_2_1);
		
		JPanel panel_number = new JPanel();
		FlowLayout fl_panel_number = (FlowLayout) panel_number.getLayout();
		fl_panel_number.setAlignment(FlowLayout.LEFT);
		fl_panel_number.setAlignOnBaseline(true);
		GridBagConstraints gbc_panel_number = new GridBagConstraints();
		gbc_panel_number.insets = new Insets(0, 0, 5, 5);
		gbc_panel_number.fill = GridBagConstraints.BOTH;
		gbc_panel_number.gridx = 2;
		gbc_panel_number.gridy = 6;
		onlKidPanel.add(panel_number, gbc_panel_number);
		
		JRadioButton rdbtnNewRadioButton_4_1_1 = new JRadioButton("\u589E\u52A0");
		rdbtnNewRadioButton_4_1_1.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		panel_number.add(rdbtnNewRadioButton_4_1_1);
		
		JRadioButton rdbtnNewRadioButton_1_2_1_1 = new JRadioButton("\u6E1B\u5C11");
		rdbtnNewRadioButton_1_2_1_1.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		panel_number.add(rdbtnNewRadioButton_1_2_1_1);
		
		textField_1 = new JTextField();
		textField_1.setText("\u8ACB\u8F38\u5165\u4FEE\u6539\u6578\u91CF");
		textField_1.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		textField_1.setColumns(22);
		panel_number.add(textField_1);
		
		JLabel lblNewLabel_7_1_2_1_1 = new JLabel("\u5E73\u53F0\u540D\u7A31");
		lblNewLabel_7_1_2_1_1.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_7_1_2_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_7_1_2_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7_1_2_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7_1_2_1_1.gridx = 0;
		gbc_lblNewLabel_7_1_2_1_1.gridy = 8;
		onlKidPanel.add(lblNewLabel_7_1_2_1_1, gbc_lblNewLabel_7_1_2_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 8;
		onlKidPanel.add(comboBox, gbc_comboBox);
		
		//�ק�ƶq���s
		JButton btnNewButton_6_1 = new JButton("\u4FEE\u6539\u6578\u91CF");
		btnNewButton_6_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		GridBagConstraints gbc_btnNewButton_6_1 = new GridBagConstraints();
		gbc_btnNewButton_6_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_6_1.gridx = 2;
		gbc_btnNewButton_6_1.gridy = 10;
		onlKidPanel.add(btnNewButton_6_1, gbc_btnNewButton_6_1);
		btnNewButton_6_1.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		
		stoKidPanel = new JPanel();
		cardsPan.add(stoKidPanel, "stoKid");
		GridBagLayout gbl_stoKidPanel = new GridBagLayout();
		gbl_stoKidPanel.columnWidths = new int[] {153, 30, 244, 280, 113, 30, 0};
		gbl_stoKidPanel.rowHeights = new int[] {30, 38, 0, 30, 0, 30, 62, 30, 0, 30, 30};
		gbl_stoKidPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_stoKidPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0};
		stoKidPanel.setLayout(gbl_stoKidPanel);
		
		JLabel lblNewLabel_3_1 = new JLabel("\u9580\u5E02\u5EAB\u5B58\u7BA1\u7406\uFF0D\u7AE5\u88DD");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("�s�ө���", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_3_1 = new GridBagConstraints();
		gbc_lblNewLabel_3_1.gridwidth = 6;
		gbc_lblNewLabel_3_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_3_1.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_3_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3_1.gridx = 0;
		gbc_lblNewLabel_3_1.gridy = 1;
		stoKidPanel.add(lblNewLabel_3_1, gbc_lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("\u7AE5\u88DDID");
		lblNewLabel_4_1.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_4_1 = new GridBagConstraints();
		gbc_lblNewLabel_4_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4_1.gridx = 0;
		gbc_lblNewLabel_4_1.gridy = 2;
		stoKidPanel.add(lblNewLabel_4_1, gbc_lblNewLabel_4_1);
		
		txtid_1 = new JTextField();
		txtid_1.setText("\u8ACB\u8F38\u5165\u7AE5\u88DDID");
		txtid_1.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		txtid_1.setColumns(10);
		GridBagConstraints gbc_txtid_1 = new GridBagConstraints();
		gbc_txtid_1.gridwidth = 2;
		gbc_txtid_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtid_1.insets = new Insets(0, 0, 5, 5);
		gbc_txtid_1.gridx = 2;
		gbc_txtid_1.gridy = 2;
		stoKidPanel.add(txtid_1, gbc_txtid_1);
		
		JLabel lblNewLabel_7_2 = new JLabel("\u7AE5\u88DD\u5C3A\u5BF8");
		lblNewLabel_7_2.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_7_2 = new GridBagConstraints();
		gbc_lblNewLabel_7_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7_2.gridx = 0;
		gbc_lblNewLabel_7_2.gridy = 4;
		stoKidPanel.add(lblNewLabel_7_2, gbc_lblNewLabel_7_2);
		
		JPanel panel_size_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_size_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_size_1 = new GridBagConstraints();
		gbc_panel_size_1.gridwidth = 2;
		gbc_panel_size_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_size_1.fill = GridBagConstraints.BOTH;
		gbc_panel_size_1.gridx = 2;
		gbc_panel_size_1.gridy = 4;
		stoKidPanel.add(panel_size_1, gbc_panel_size_1);
		
		JRadioButton rdbtnNewRadioButton_2_7_1 = new JRadioButton("XS");
		rdbtnNewRadioButton_2_7_1.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		panel_size_1.add(rdbtnNewRadioButton_2_7_1);
		
		JRadioButton rdbtnNewRadioButton_2_1_3_1 = new JRadioButton("S");
		rdbtnNewRadioButton_2_1_3_1.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		panel_size_1.add(rdbtnNewRadioButton_2_1_3_1);
		
		JRadioButton rdbtnNewRadioButton_2_2_3_1 = new JRadioButton("M");
		rdbtnNewRadioButton_2_2_3_1.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		panel_size_1.add(rdbtnNewRadioButton_2_2_3_1);
		
		JRadioButton rdbtnNewRadioButton_2_3_3_1 = new JRadioButton("L");
		rdbtnNewRadioButton_2_3_3_1.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		panel_size_1.add(rdbtnNewRadioButton_2_3_3_1);
		
		JRadioButton rdbtnNewRadioButton_2_4_4_1 = new JRadioButton("XL");
		rdbtnNewRadioButton_2_4_4_1.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		panel_size_1.add(rdbtnNewRadioButton_2_4_4_1);
		
		JRadioButton rdbtnNewRadioButton_2_4_1_3_1 = new JRadioButton("XXL");
		rdbtnNewRadioButton_2_4_1_3_1.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		panel_size_1.add(rdbtnNewRadioButton_2_4_1_3_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 6;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 6;
		stoKidPanel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] {153, 30, 190, 220, 106, 0, 0};
		gbl_panel_1.rowHeights = new int[] {41, 14, 0, 30};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("\u4E0B\u5217\u5169\u9805\u64C7\u4E00\u586B\u5BEB\uFF0C\u4E26\u9EDE\u9078\u76F8\u61C9\u7684\u6309\u9215");
		lblNewLabel_1.setFont(new Font("�s�ө���", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridwidth = 3;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_7_1_1_2 = new JLabel("\u4FEE\u6539\u6578\u91CF");
		lblNewLabel_7_1_1_2.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_7_1_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_7_1_1_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7_1_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7_1_1_2.gridx = 0;
		gbc_lblNewLabel_7_1_1_2.gridy = 1;
		panel_1.add(lblNewLabel_7_1_1_2, gbc_lblNewLabel_7_1_1_2);
		
		JPanel panel_number_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_number_1.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_number_1 = new GridBagConstraints();
		gbc_panel_number_1.gridwidth = 3;
		gbc_panel_number_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_number_1.fill = GridBagConstraints.BOTH;
		gbc_panel_number_1.gridx = 2;
		gbc_panel_number_1.gridy = 1;
		panel_1.add(panel_number_1, gbc_panel_number_1);
		
		JRadioButton rdbtnNewRadioButton_4_1_1_1 = new JRadioButton("\u589E\u52A0");
		rdbtnNewRadioButton_4_1_1_1.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		panel_number_1.add(rdbtnNewRadioButton_4_1_1_1);
		
		JRadioButton rdbtnNewRadioButton_1_2_1_1_1 = new JRadioButton("\u6E1B\u5C11");
		rdbtnNewRadioButton_1_2_1_1_1.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		panel_number_1.add(rdbtnNewRadioButton_1_2_1_1_1);
		
		textField = new JTextField();
		textField.setText("\u8ACB\u8F38\u5165\u4FEE\u6539\u6578\u91CF");
		textField.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		textField.setColumns(35);
		panel_number_1.add(textField);
		
		JLabel lblNewLabel_7_1_1_1_1 = new JLabel("\u6709\u7121\u907A\u5931");
		lblNewLabel_7_1_1_1_1.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_7_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_7_1_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7_1_1_1_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_7_1_1_1_1.gridx = 0;
		gbc_lblNewLabel_7_1_1_1_1.gridy = 3;
		panel_1.add(lblNewLabel_7_1_1_1_1, gbc_lblNewLabel_7_1_1_1_1);
		
		JPanel panel_loss = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_loss.getLayout();
		flowLayout_2.setAlignOnBaseline(true);
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_loss = new GridBagConstraints();
		gbc_panel_loss.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_loss.gridwidth = 3;
		gbc_panel_loss.insets = new Insets(0, 0, 0, 5);
		gbc_panel_loss.gridx = 2;
		gbc_panel_loss.gridy = 3;
		panel_1.add(panel_loss, gbc_panel_loss);
		
		JRadioButton rdbtnNewRadioButton_4_1_1_1_1 = new JRadioButton("\u7121");
		rdbtnNewRadioButton_4_1_1_1_1.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		panel_loss.add(rdbtnNewRadioButton_4_1_1_1_1);
		
		JRadioButton rdbtnNewRadioButton_1_2_1_1_1_1 = new JRadioButton("\u6709");
		rdbtnNewRadioButton_1_2_1_1_1_1.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		panel_loss.add(rdbtnNewRadioButton_1_2_1_1_1_1);
		
		textField_6 = new JTextField();
		textField_6.setText("\u8ACB\u8F38\u5165\u907A\u5931\u6578\u91CF");
		textField_6.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		textField_6.setColumns(38);
		panel_loss.add(textField_6);
		
		JButton btnNewButton_6_1_1 = new JButton("\u4FEE\u6539\u6578\u91CF");
		btnNewButton_6_1_1.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		GridBagConstraints gbc_btnNewButton_6_1_1 = new GridBagConstraints();
		gbc_btnNewButton_6_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_6_1_1.gridx = 2;
		gbc_btnNewButton_6_1_1.gridy = 8;
		stoKidPanel.add(btnNewButton_6_1_1, gbc_btnNewButton_6_1_1);
		
		JButton btnNewButton_6_1_1_1 = new JButton("\u78BA\u8A8D\u5230\u8CA8\u5EAB\u5B58");
		btnNewButton_6_1_1_1.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		GridBagConstraints gbc_btnNewButton_6_1_1_1 = new GridBagConstraints();
		gbc_btnNewButton_6_1_1_1.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_6_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_6_1_1_1.gridx = 3;
		gbc_btnNewButton_6_1_1_1.gridy = 8;
		stoKidPanel.add(btnNewButton_6_1_1_1, gbc_btnNewButton_6_1_1_1);
		
		conPanel = new JPanel();
		cardsPan.add(conPanel, "con");
		GridBagLayout gbl_conPanel = new GridBagLayout();
		gbl_conPanel.columnWidths = new int[]{153, 0, 153, 0, 153, 0, 0};
		gbl_conPanel.rowHeights = new int[] {30, 38, 0, 30, 0, 30, 41, 30, 30, 30, 30, 0, 30, 0, 0, 0};
		gbl_conPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 4.9E-324, 0.0, Double.MIN_VALUE};
		gbl_conPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		conPanel.setLayout(gbl_conPanel);
		
		JLabel lblNewLabel_3_2 = new JLabel("\u9580\u5E02\u5EAB\u5B58\u7BA1\u7406\uFF0D\u5BC4\u8CE3\u54C1");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setFont(new Font("�s�ө���", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_3_2 = new GridBagConstraints();
		gbc_lblNewLabel_3_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_3_2.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_3_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3_2.gridx = 2;
		gbc_lblNewLabel_3_2.gridy = 1;
		conPanel.add(lblNewLabel_3_2, gbc_lblNewLabel_3_2);
		
		JLabel lblNewLabel_4_2 = new JLabel("\u5BC4\u8CE3\u54C1ID");
		lblNewLabel_4_2.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_4_2 = new GridBagConstraints();
		gbc_lblNewLabel_4_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4_2.gridx = 0;
		gbc_lblNewLabel_4_2.gridy = 2;
		conPanel.add(lblNewLabel_4_2, gbc_lblNewLabel_4_2);
		
		textField_3 = new JTextField();
		textField_3.setText("\u8ACB\u8F38\u5165\u5BC4\u8CE3\u54C1ID");
		textField_3.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		textField_3.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.gridx = 2;
		gbc_textField_3.gridy = 2;
		conPanel.add(textField_3, gbc_textField_3);
		
		JLabel lblNewLabel_7_3 = new JLabel("\u5BC4\u8CE3\u54C1\u5C3A\u5BF8");
		lblNewLabel_7_3.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_7_3 = new GridBagConstraints();
		gbc_lblNewLabel_7_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7_3.gridx = 0;
		gbc_lblNewLabel_7_3.gridy = 4;
		conPanel.add(lblNewLabel_7_3, gbc_lblNewLabel_7_3);
		
		JPanel panel_size_1_1 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_size_1_1.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		flowLayout_3.setAlignOnBaseline(true);
		GridBagConstraints gbc_panel_size_1_1 = new GridBagConstraints();
		gbc_panel_size_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_size_1_1.fill = GridBagConstraints.BOTH;
		gbc_panel_size_1_1.gridx = 2;
		gbc_panel_size_1_1.gridy = 4;
		conPanel.add(panel_size_1_1, gbc_panel_size_1_1);
		
		JRadioButton rdbtnNewRadioButton_2_7_1_1 = new JRadioButton("XS");
		rdbtnNewRadioButton_2_7_1_1.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		panel_size_1_1.add(rdbtnNewRadioButton_2_7_1_1);
		
		JRadioButton rdbtnNewRadioButton_2_1_3_1_1 = new JRadioButton("S");
		rdbtnNewRadioButton_2_1_3_1_1.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		panel_size_1_1.add(rdbtnNewRadioButton_2_1_3_1_1);
		
		JRadioButton rdbtnNewRadioButton_2_2_3_1_1 = new JRadioButton("M");
		rdbtnNewRadioButton_2_2_3_1_1.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		panel_size_1_1.add(rdbtnNewRadioButton_2_2_3_1_1);
		
		JRadioButton rdbtnNewRadioButton_2_3_3_1_1 = new JRadioButton("L");
		rdbtnNewRadioButton_2_3_3_1_1.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		panel_size_1_1.add(rdbtnNewRadioButton_2_3_3_1_1);
		
		JRadioButton rdbtnNewRadioButton_2_4_4_1_1 = new JRadioButton("XL");
		rdbtnNewRadioButton_2_4_4_1_1.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		panel_size_1_1.add(rdbtnNewRadioButton_2_4_4_1_1);
		
		JRadioButton rdbtnNewRadioButton_2_4_1_3_1_1 = new JRadioButton("XXL");
		rdbtnNewRadioButton_2_4_1_3_1_1.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		panel_size_1_1.add(rdbtnNewRadioButton_2_4_1_3_1_1);
		
		JLabel lblNewLabel_7_1_2 = new JLabel("\u4FEE\u6539\u6578\u91CF");
		lblNewLabel_7_1_2.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_7_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_7_1_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7_1_2.gridx = 0;
		gbc_lblNewLabel_7_1_2.gridy = 6;
		conPanel.add(lblNewLabel_7_1_2, gbc_lblNewLabel_7_1_2);
		
		JPanel panel_number_2 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_number_2.getLayout();
		flowLayout_4.setAlignOnBaseline(true);
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_number_2 = new GridBagConstraints();
		gbc_panel_number_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_number_2.fill = GridBagConstraints.BOTH;
		gbc_panel_number_2.gridx = 2;
		gbc_panel_number_2.gridy = 6;
		conPanel.add(panel_number_2, gbc_panel_number_2);
		
		JRadioButton rdbtnNewRadioButton_4_1_1_2 = new JRadioButton("\u589E\u52A0");
		rdbtnNewRadioButton_4_1_1_2.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		panel_number_2.add(rdbtnNewRadioButton_4_1_1_2);
		
		JRadioButton rdbtnNewRadioButton_1_2_1_1_2 = new JRadioButton("\u6E1B\u5C11");
		rdbtnNewRadioButton_1_2_1_1_2.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		panel_number_2.add(rdbtnNewRadioButton_1_2_1_1_2);
		
		textField_2 = new JTextField();
		textField_2.setText("\u8ACB\u8F38\u5165\u4FEE\u6539\u6578\u91CF");
		textField_2.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		textField_2.setColumns(22);
		panel_number_2.add(textField_2);
		
		JButton btnNewButton_6_1_2 = new JButton("\u4FEE\u6539\u6578\u91CF");
		btnNewButton_6_1_2.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		GridBagConstraints gbc_btnNewButton_6_1_2 = new GridBagConstraints();
		gbc_btnNewButton_6_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_6_1_2.gridx = 2;
		gbc_btnNewButton_6_1_2.gridy = 9;
		conPanel.add(btnNewButton_6_1_2, gbc_btnNewButton_6_1_2);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel.getLayout();
		flowLayout_5.setAlignment(FlowLayout.RIGHT);
		allBox.add(panel);
		
		JButton btnNewButton_4 = new JButton("\u56DE\u9996\u9801");
		btnNewButton_4.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		btnNewButton_4.setAlignmentX(0.5f);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("\u767B\u51FA");
		panel.add(btnNewButton_5);
		btnNewButton_5.setFont(new Font("�s�ө���", Font.PLAIN, 15));
		InvManFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //�I�������ɡA�����{��
		
	}
	
	private static void addAButton(String text, Container container){
		//�W�[�@�ӫ��s�쪫��e��
        JButton button = new JButton(text);
        //button.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(button);
    }
	
	public void actionPerformed(ActionEvent e) {
		/**
		* e.getActionCommand�]�^��ܪ����G�O��������W�����e����
		* cardsPan.show(cardpan, "b1");���ܹ�������M��ܤ��󪺦W��
		* CardLayout.show(Container parent, String name)�G��ܥd������{��k�w�q
		*/
		if("�w�s�`��".equals(e.getActionCommand())){
		cardLay.show(cardsPan, "all");		
		}
		if("�����w�s".equals(e.getActionCommand())){
		cardLay.show(cardsPan, "onlKid");
		}
		if("��������".equals(e.getActionCommand())){
		cardLay.show(cardsPan, "stoKid");
		}
		if("�����H��~".equals(e.getActionCommand())){
		cardLay.show(cardsPan, "con");
		}
	}
	
	
}
