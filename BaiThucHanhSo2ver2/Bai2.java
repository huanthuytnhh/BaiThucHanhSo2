package BaiThucHanhSo2ver2;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Bai2 extends JFrame implements ActionListener {
    JLabel lb, lb1, lb2, lb3;
    JTextField txt1, txt2, txtkq;
    JButton Add, Sub, Mul, Div, Reset, Exit;
    JPanel pn, pn1, pn2, pn3, pn4,pn5;

    public Bai2() {
        lb = new JLabel("Basic Arithmetic Operations");
        lb1 = new JLabel("Number 1:");
        lb2 = new JLabel("Number 2:");
        lb3 = new JLabel("Results:");

        Add = new JButton("Addition");
        Sub = new JButton("Subtraction");
        Mul = new JButton("Multiplication");
        Div = new JButton("Division");
        Reset = new JButton("Reset");
        Exit = new JButton("Exit");

        txt1 = new JTextField(7);
        txt2 = new JTextField(7);
        txtkq = new JTextField(7);

        pn = new JPanel(new GridLayout(3, 1));
        pn1 = new JPanel(new GridLayout(2, 1)); // Updated to 3 rows
        pn2 = new JPanel(new FlowLayout()); // nua duoi
        pn3 = new JPanel(new FlowLayout()); // chua tieu de
        pn4 = new JPanel(new GridLayout(3, 2)); // chua textfield
        pn5 = new JPanel(new FlowLayout());
        JPanel pn6=new JPanel(new GridLayout(2,1));
        pn3.add(lb);
        
        
        pn4.add(lb1);
        pn4.add(txt1);
        pn4.add(lb2);
        pn4.add(txt2); // Fixed to use txt2 for the second number
        pn4.add(lb3);
        pn4.add(txtkq);

        pn2.add(Add);
        pn2.add(Sub);
        pn2.add(Mul);
        pn2.add(Div);
        pn5.add(Reset);
        pn5.add(Exit);
        pn6.add(pn2);
        pn6.add(pn5);
        pn1.add(pn3); // Added pn3 to pn1
        pn1.add(pn4); // Added pn4 to pn1
        pn.add(pn1); // Updated to add pn1
       // pn.add(pn6);
       // pn5.set
        pn.add(pn6);
        this.add(pn);
        this.setSize(500, 400);
        this.setTitle("Arithmetic Operations");
        this.setVisible(true);

        Add.addActionListener(this); // Registering action listeners for buttons
        Sub.addActionListener(this);
        Mul.addActionListener(this);
        Div.addActionListener(this);
        Reset.addActionListener(this);
        Exit.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) { // Corrected method signature
        if (e.getSource() == Reset) {
            txt1.setText(null);
            txt2.setText(null);
            txtkq.setText(null);
        } else if (e.getSource() == Exit) {
            System.exit(0);
        } else {
            int a = Integer.parseInt(txt1.getText());
            int b = Integer.parseInt(txt2.getText());
            if (e.getSource() == Add) {
                txtkq.setText(Float.toString((float) (a + b)));
            } else if (e.getSource() == Sub) {
                txtkq.setText(Float.toString((float) (a - b)));
            } else if (e.getSource() == Mul) {
                txtkq.setText(Float.toString((float) (a * b)));
            } else if (e.getSource() == Div) {
                if (b != 0) {
                    txtkq.setText(Float.toString((float) (a / b)));
                } else {
                    txtkq.setText("Cannot divide by zero");
                }
            }

        }
    }

    public static void main(String[] args) {
        new Bai2();
    }
}
