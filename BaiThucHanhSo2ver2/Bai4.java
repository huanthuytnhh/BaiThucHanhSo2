package BaiThucHanhSo2ver2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bai4 extends JFrame implements ActionListener {
    JButton ok, reset, exit;
    JTextField txt1, txt2, txt3, txt4, txt5;
    JLabel lb1, lb2, lb3, lb4, lb5;
    JPanel pn, pn1, pn2, pn3, pn4, pn5, pn6;

    public void GUI() {
        ok = new JButton("OK");
        reset = new JButton("Reset");
        exit = new JButton("Exit");

        lb1 = new JLabel("Enter a String");
        lb2 = new JLabel("To UpperCase");
        lb3 = new JLabel("To LowerCase");
        lb4 = new JLabel("To LowerUpper");
        lb5 = new JLabel("Number of Word");
        
        txt1 = new JTextField("Hoc Lap Trinh Java", 25); // Initialize text fields
        txt2 = new JTextField("HOC LAP TRINH JAVA",25);
        txt3 = new JTextField("hoc lap trinh java",25);
        txt4 = new JTextField("hOC lAP tTRINH jAVA" ,25);
        txt5 = new JTextField(25);
        txt2.setForeground(Color.GRAY);
        txt3.setForeground(Color.GRAY);
        txt4.setForeground(Color.GRAY);
        
        ok.addActionListener(this);
        reset.addActionListener(this);
        exit.addActionListener(this);

        pn = new JPanel(new GridLayout(6,1));

        pn1 = new JPanel(new GridBagLayout());
        pn2 = new JPanel(new GridBagLayout());
        pn3 = new JPanel(new GridBagLayout());
        pn4 = new JPanel(new GridBagLayout());
        pn5 = new JPanel(new GridBagLayout());
        pn6 = new JPanel(new GridBagLayout());
        addComponents(pn1, lb1, 0, 0, 10, 10, 10, 50);
        addComponents(pn1, txt1, 1, 0, 10, 10, 10, 10);
        addComponents(pn2, lb2, 0, 0, 10, 10, 10, 50);
        addComponents(pn2, txt2, 1, 0, 10, 10, 10, 10);
        addComponents(pn3, lb3, 0, 0, 10, 10, 10, 50);
        addComponents(pn3, txt3, 1, 0, 10, 10, 10, 10);
        addComponents(pn4, lb4, 0, 0, 10, 10, 10, 50);
        addComponents(pn4, txt4, 1, 0, 10, 8, 10, 10);
        addComponents(pn5, lb5, 0, 0, 10, 10, 10, 50);
        addComponents(pn5, txt5, 1, 0, 10, 0, 10, 10);
       // addComponents(pn6, ok, 0, 0, 10, 10, 10, 50);
        addComponents(pn6, ok, 0, 0, 0, 0, 0, 50);
        addComponents(pn6, reset, 1, 0, 0, 40, 0, 40);
       // addComponents(pn6, reset, 1, 0, 10, 40, 10, 50);
       // addComponents(pn6, exit, 2, 0, 10, 50, 10, 0);
        addComponents(pn6, exit, 2, 0, 0, 50, 0, 0);
        // gridx, gridy, top , left , bottom , right

        
        
        pn.add(pn1);
        pn.add(pn2);
        pn.add(pn3);
        pn.add(pn4);
        pn.add(pn5);
        pn.add(pn6);

        add(pn);

        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addComponents(Container container, Component component, int gridx, int gridy, int t, int l, int b, int r) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.anchor = GridBagConstraints.WEST; // Align to the left
        gbc.insets = new Insets(t, l, b, r);
        container.add(component, gbc);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ok) {
            String inputString = txt1.getText();
            
            // Xử lý các thao tác mong muốn với chuỗi đầu vào (viết hoa, viết thường, ...)
            String upperCase = inputString.toUpperCase();
            String lowerCase = inputString.toLowerCase();
            String lowerUpper = "";
            for (int i = 0; i < inputString.length(); i++) {
                char c = inputString.charAt(i);
                if (Character.isUpperCase(c)) {
                    lowerUpper += Character.toLowerCase(c);
                } else if (Character.isLowerCase(c)) {
                    lowerUpper += Character.toUpperCase(c);
                } else {
                    lowerUpper += c;
                }
            }
            int wordCount = inputString.split("\\s+").length;
            
            // Hiển thị kết quả lên các text field phù hợp
            txt2.setText(upperCase);
            txt3.setText(lowerCase);
            txt4.setText(lowerUpper);
            txt5.setText(String.valueOf(wordCount));
        } else if (e.getSource() == reset) {
            // Xử lý khi nhấn nút "Reset"
            // Xóa dữ liệu trong các text field
            txt1.setText("");
            txt2.setText("");
            txt3.setText("");
            txt4.setText("");
            txt5.setText("");
        } else if (e.getSource() == exit) {
            // Xử lý khi nhấn nút "Exit"
            System.exit(0);
        }
    }

    public Bai4(String st) {
        super(st);
        GUI();
    }

    public static void main(String[] args) {
        new Bai4("");
    }
}