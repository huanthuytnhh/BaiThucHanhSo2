package BaiThucHanhSo2ver2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bai6 extends JFrame implements ActionListener{
    JButton ok;
    JTextField txt1;
    List list;
    JLabel lb;
    JPanel pn;

    public Bai6() {
        ok = new JButton("OK");
        lb = new JLabel("The event is displayed here");
        list = new List(3, false);

        list.add("Tiger");
        list.add("Lion");
        list.add("Elephant"); // Corrected spelling from "Elephent" to "Elephant"
        list.add("Bird");
        
        txt1 = new JTextField(20); // Initialize txt1 with a width of 20 columns

        pn = new JPanel(new FlowLayout());
        pn.add(ok);
        pn.add(txt1);
        pn.add(list);
        pn.add(lb);

        ok.addActionListener(this);
        list.addActionListener(this);
        txt1.addActionListener(this);

        this.add(pn);
        this.setSize(460, 175);
        this.setTitle("ActionEventTest");
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ok) {
            lb.setText("You pressed OK button");
        } else if (e.getSource() == list) {
            // Use .equals() for string comparison
            String actionCommand = e.getActionCommand();
            if ("Tiger".equals(actionCommand)) {
                lb.setText("You pressed Tiger");
             //   txt1.setText("Tiger");
            } else if ("Lion".equals(actionCommand)) {
                lb.setText("You pressed Lion");
               // txt1.setText("Lion");
            } else if ("Elephant".equals(actionCommand)) {
                lb.setText("You pressed Elephant");
               // txt1.setText("Elephent");
            } else if ("Bird".equals(actionCommand)) {
                lb.setText("You pressed Bird");
              //  txt1.setText("Bird");
            }
        } else if (e.getSource() == txt1) {
            lb.setText("You pressed "+txt1.getText()+" in TextField");
        } 
    }

    public static void main(String[] args) {
        new Bai6();
    }
}
