package BaiThucHanhSo2ver2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Bai1 extends JFrame implements ActionListener {
	JLabel lb1,lb2,lb3,lb;
	JTextField txta,txtb,txtkq;
	JButton tinh,reset,thoat;
	JPanel pn,pn1,pn2,pn3;
	 
	public Bai1() {
		GUI();
	}
	
	public void GUI() {
		lb=new JLabel("Giai phuong trinh bac nhat");
		lb1=new JLabel("Nhap a:");
		lb2=new JLabel("Nhap b:");
		lb3=new JLabel("Ket qua:");
		
		txta= new JTextField(7);
		txtb= new JTextField(7);
		txtkq= new JTextField(7);
		txtkq.setEditable(false);
		
		tinh=new JButton("Tinh");
		tinh.addActionListener(this);
		reset=new JButton("reset");
		reset.addActionListener(this);
		thoat= new JButton("Thoat");
		thoat.addActionListener(this);
		
		pn=new JPanel(new GridLayout(3,1));
		pn1=new JPanel(new FlowLayout());
		pn2=new JPanel(new GridLayout(3,2));
		pn3=new JPanel(new GridLayout(1,3));
		
		pn1.add(lb);
		
		pn2.add(lb1);
		pn2.add(txta);
		pn2.add(lb2);
		pn2.add(txtb);
		pn2.add(lb3);
		pn2.add(txtkq);
		
		pn3.add(tinh);
		pn3.add(reset);
		pn3.add(thoat);
		
		pn.add(pn1);
		pn.add(pn2);
		pn.add(pn3);
		
		this.add(pn);
		this.setSize(400,400);
		this.setTitle("Giai phuong trinh bac nhat");
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==tinh) {
			int a=Integer.parseInt(txta.getText());
			int b=Integer.parseInt(txtb.getText());
			if(a!=0) {
				txtkq.setText(Float.toString((float)-b/a));
			} 
			else 
			if(b!=0) 
			{
				txtkq.setText("Vo nghiem");
			}
			else 
			{
				txtkq.setText("Vo so nghiem");
			}
			} else {
				if(e.getSource()==reset) {
					txtkq.setText(null);
					txta.setText(null);
					txtb.setText(null);
			} else {
				if(e.getSource()==thoat) {
					System.exit(0);
				}
			}
		
		}
	}
	public static void main(String[] args) {
		new Bai1();
	}
}
