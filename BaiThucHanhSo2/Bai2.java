package BaiThucHanhSo2;
import java.awt.*;
import javax.swing.*;
public class Bai2 extends JFrame{
	public static void main(String[] args) {
		Bai2 b2=new Bai2();
		b2.setBounds(200,500,700,700);
		JTextField msg=new JTextField("Hien thi thong bao");
		msg.setEditable(false);
		JButton nutVe=new JButton("Ve");
		Canvas vungve=new Canvas();
		vungve.setSize(150,150);
		vungve.setBackground(Color.white);
		Scrollbar sb1=new Scrollbar(Scrollbar.VERTICAL,0,10,30,100);
		Scrollbar sb2=new Scrollbar(Scrollbar.VERTICAL,0,10,30,100);
		b2.setLayout(new BorderLayout());
		b2.add(nutVe,BorderLayout.NORTH);

		b2.add(msg,BorderLayout.SOUTH);

		b2.add(vungve,BorderLayout.CENTER);

		b2.add(sb1,BorderLayout.WEST);
		b2.add(sb2,BorderLayout.EAST);
		b2.setVisible(true);
	}
}
