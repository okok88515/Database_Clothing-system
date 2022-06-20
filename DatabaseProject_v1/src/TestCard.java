import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TestCard implements ActionListener{
	private JFrame fm=new JFrame("�d��������");
	private JPanel cardpan,containbtn; //cardpan���d����ܰϰ�A containbtn�����s��ܰϰ�
	private JButton btn1,btn2,btn3,btn4; //���B�w�q�֤H�����s
	private JPanel pan1,pan2,pan3,pan4; //���B�w�q�����O����ܸ֥y
	private CardLayout card;    //�w�q�d���G��
	private JTextArea ta1,ta2,ta3,ta4; //�w�q��֥y����r��
	
	public static void main(String[] args) {
		new TestCard();
	}
	
	public TestCard(){
		//�H�U����l�Ƥ���
		cardpan=new JPanel();
		containbtn=new JPanel();
		card=new CardLayout();
		cardpan.setLayout(card);
		btn1=new JButton("����");
		btn2=new JButton("���j");
		btn3=new JButton("�թ~��");
		btn4=new JButton("�s�E�M");
		ta1=new JTextArea(30,30);
		ta2=new JTextArea(30,30);
		ta3=new JTextArea(30,30);
		ta4=new JTextArea(30,30);
		//��w�q�����s�����ܫ��s�����O��
		containbtn.add(btn1);
		containbtn.add(btn2);
		containbtn.add(btn3);
		containbtn.add(btn4);
		pan1=new JPanel();
		//�����s�s�W��ť�ƥ�
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		//���w�q����r�줤�s�W�֤H�������֥y
		ta1.append("��ӭ��l�͵��ϡA\r\n");
		ta1.append("�����r�����e�t�C\r\n");
		ta1.append("���y���U�T�d�ءA\r\n");
		ta1.append("�ìO�Ȫe���E�ѡC");
		ta2.append("��Ӷ��ϻ�A�h�A\r\n");
		ta2.append("�@����O�W�C�ѡC\r\n");
		ta2.append("���t�����d��A\r\n");
		ta2.append("���y�F�d�U����C");
		ta3.append("�@�D�ݶ��Q�����A\r\n");
		ta3.append("�b�����b�����C\r\n");
		ta3.append("�i���E���T�]�A\r\n");
		ta3.append("�S���ï]����}�C");
		ta4.append("�K�v��ı��A\r\n");
		ta4.append("�B�B�D�ڳ��C\r\n");
		ta4.append("�]�ӭ��B�n�A\r\n");
		ta4.append("�Ḩ���h�֡C");
		pan1.add(ta1);
		pan2=new JPanel();
		pan2.add(ta2);
		pan3=new JPanel();
		pan3.add(ta3);
		pan4=new JPanel();
		pan4.add(ta4);
		//��w�q�n�����O���d���G��������
		cardpan.add("b1",pan1);
		cardpan.add("b2",pan2);
		cardpan.add("b3",pan3);
		cardpan.add("b4",pan4);
		fm.add(containbtn,BorderLayout.NORTH);//����ܫ��s��������W�����
		fm.add(cardpan,BorderLayout.CENTER);//����ܤ�r�쪺�����줤�����
		fm.setSize(400,400);
		fm.setLocation(200,100);
		fm.setVisible(true);
		fm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		/**
		* e.getActionCommand�]�^��ܪ����G�O��������W�����e����
		* card.show(cardpan, "b1");���ܹ�������M��ܤ��󪺦W��
		* CardLayout.show(Container parent, String name)�G��ܥd������{��k�w�q
		*/
		if("����".equals(e.getActionCommand())){
		card.show(cardpan, "b1");
		}
		if("���j".equals(e.getActionCommand())){
		card.show(cardpan, "b2");
		}
		if("�թ~��".equals(e.getActionCommand())){
		card.show(cardpan, "b3");
		}
		if("�s�E�M".equals(e.getActionCommand())){
		card.show(cardpan, "b4");
		}
	}
}