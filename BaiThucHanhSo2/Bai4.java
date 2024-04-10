package BaiThucHanhSo2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bai4 extends JFrame {
    JLabel lb1, lb2, lb3, lb4, lb5;
    JTextField txt1, txt2, txt3, txt4, txt5;
    JButton ok, reset, exit;
    JPanel mainPanel, inputPanel, buttonPanel;

    public Bai4() {
        super("String Manipulation"); // Set the window title
        createGUI();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack(); // Adjusts the window to fit its contents
        this.setLocationRelativeTo(null); // Center the window
        this.setVisible(true);
    }

    private void createGUI() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Input Panel
        inputPanel = new JPanel(new GridLayout(5, 2));
        lb1 = new JLabel("Enter a String:");
        txt1 = new JTextField();
        inputPanel.add(lb1);
        inputPanel.add(txt1);

        lb2 = new JLabel("To UpperCase:");
        txt2 = new JTextField();
        txt2.setEditable(false);
        inputPanel.add(lb2);
        inputPanel.add(txt2);

        lb3 = new JLabel("To LowerCase:");
        txt3 = new JTextField();
        txt3.setEditable(false);
        inputPanel.add(lb3);
        inputPanel.add(txt3);

        lb4 = new JLabel("To LowerUpper:");
        txt4 = new JTextField();
        txt4.setEditable(false);
        inputPanel.add(lb4);
        inputPanel.add(txt4);

        lb5 = new JLabel("Number of Words:");
        txt5 = new JTextField();
        txt5.setEditable(false);
        inputPanel.add(lb5);
        inputPanel.add(txt5);

        // Button Panel
        buttonPanel = new JPanel();
        ok = new JButton("OK");
        reset = new JButton("Reset");
        exit = new JButton("Exit");

        ok.addActionListener(e -> processText());
        reset.addActionListener(e -> resetFields());
        exit.addActionListener(e -> System.exit(0));

        buttonPanel.add(ok);
        buttonPanel.add(reset);
        buttonPanel.add(exit);

        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        this.add(mainPanel);
    }

    private void processText() {
        String input = txt1.getText();
        txt2.setText(input.toUpperCase());
        txt3.setText(input.toLowerCase());
        txt4.setText(convertToAlternatingCase(input));
        txt5.setText(Integer.toString(countWords(input)));
    }

    private String convertToAlternatingCase(String text) {
        StringBuilder sb = new StringBuilder();
        boolean toUpper = true;
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                sb.append(toUpper ? Character.toUpperCase(c) : Character.toLowerCase(c));
                toUpper = !toUpper;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private int countWords(String text) {
        String trimmed = text.trim();
        if (trimmed.isEmpty()) return 0;
        return trimmed.split("\\s+").length;
    }

    private void resetFields() {
        txt1.setText("");
        txt2.setText("");
        txt3.setText("");
        txt4.setText("");
        txt5.setText("");
    }

    public static void main(String[] args) {
        new Bai4();
    }
}
