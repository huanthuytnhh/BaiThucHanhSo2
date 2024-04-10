package BaiThucHanhSo2ver2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bai8 extends JFrame implements KeyListener {
    JLabel lb;

    public Bai8() {
        lb = new JLabel("Key Event");
        lb.setHorizontalAlignment(JLabel.CENTER); // Set horizontal alignment to center
        
        JPanel panel = new JPanel(new GridLayout(1, 1)); // GridLayout with one cell
        panel.add(lb);
        
        this.add(panel);
        
        this.setSize(400, 400);
        this.setVisible(true);
        this.setTitle("Key Event Test");
        this.addKeyListener(this);

        this.addWindowListener(
        new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        }
        );
    }

    public void keyPressed(KeyEvent e) {
       
    }

    public void keyReleased(KeyEvent e) {
        
    }

    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        lb.setText("" + c);
    }

    public static void main(String[] args) {
        new Bai8();
    }
}
