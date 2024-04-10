package BaiThucHanhSo2ver2;


import java.awt.*;
import javax.swing.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Bai9 extends JFrame implements MouseListener {
    JPanel pn;

    public Bai9() {
        pn = new JPanel();
       // this.setTitle("");
        this.add(pn);
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.addMouseListener(this);
        this.setTitle("MouseTest");
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Bai9();
    }

   
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            System.out.println("Left mouse button clicked at (" + e.getX() + ", " + e.getY() + ")");
        } else if (e.getButton() == MouseEvent.BUTTON2) {
            System.out.println("Middle mouse button clicked at (" + e.getX() + ", " + e.getY() + ")");
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            System.out.println("Right mouse button clicked at (" + e.getX() + ", " + e.getY() + ")");
        }
    }

   
    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse pressed at (" + e.getX() + ", " + e.getY() + ")");
    }

   
    public void mouseReleased(MouseEvent e) {
        System.out.println("Mouse released at (" + e.getX() + ", " + e.getY() + ")");
    }

   
    public void mouseEntered(MouseEvent e) {
        System.out.println("Mouse entered at (" + e.getX() + ", " + e.getY() + ")");
    }

   
    public void mouseExited(MouseEvent e) {
        System.out.println("Mouse exited at (" + e.getX() + ", " + e.getY() + ")");
    }
}

