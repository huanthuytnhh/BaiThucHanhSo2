package BaiThucHanhSo2ver2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bai3 extends JFrame implements ActionListener {
	JButton red, green, blue, thoat;
	JPanel pn, pn1;

	public Bai3() {
		red = new JButton("Red");
		green = new JButton("Green");
		blue = new JButton("Blue");
		thoat = new JButton("Thoat");
		red.addActionListener(this);
		green.addActionListener(this);
		blue.addActionListener(this);
		thoat.addActionListener(this);

		pn = new JPanel(new BorderLayout());
		pn1 = new JPanel(new FlowLayout());
		pn1.add(red);
		pn1.add(green);
		pn1.add(blue);
		pn1.add(thoat);
		pn.add(pn1, BorderLayout.SOUTH);
		this.add(pn);
		this.setSize(400, 400);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == thoat) {
			System.exit(0);
		} else if (e.getSource() == red) {
			pn.setBackground(Color.RED);
			pn1.setBackground(Color.RED);// Set background of the content pane
		} else if (e.getSource() == blue) {
			pn.setBackground(Color.BLUE); 
			pn1.setBackground(Color.BLUE); // Set background of the content pane
		} else if (e.getSource() == green) {
			pn.setBackground(Color.GREEN); // Set background of the content pane
			pn1.setBackground(Color.GREEN);
		}
	}

	public static void main(String[] args) {
		new Bai3();
	}
}
