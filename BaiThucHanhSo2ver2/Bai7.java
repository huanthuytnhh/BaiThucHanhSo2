package BaiThucHanhSo2ver2;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class Bai7 extends JFrame implements ItemListener, ListSelectionListener {
    JComboBox<String> combo_box;
    JCheckBox maleCheckBox;
    JCheckBox femaleCheckBox;
    JList<String> list;
    JLabel lb;
    JPanel pn;

    public Bai7() {
        combo_box = new JComboBox<>();
        combo_box.addItem("MS DOS");
        combo_box.addItem("Microsoft");
        combo_box.addItem("Mac OS");

        maleCheckBox = new JCheckBox("Male", false);
        femaleCheckBox = new JCheckBox("Female", false);

        DefaultListModel<String> model = new DefaultListModel<>();
        model.addElement("Tiger");
        model.addElement("Lion");
        model.addElement("Elephant");
        model.addElement("Bird");
        list = new JList<>(model);
        list.setVisibleRowCount(3); // Set the visible row count to 3

        lb = new JLabel("The event displayed here");
        pn = new JPanel(new FlowLayout());

        combo_box.addItemListener(this);
        maleCheckBox.addItemListener(this);
        femaleCheckBox.addItemListener(this);
        list.addListSelectionListener(this);

        JScrollPane scrollPane = new JScrollPane(list); // Add the list to a JScrollPane for scrolling

        
        pn.add(maleCheckBox);
        pn.add(femaleCheckBox);
        pn.add(combo_box);
        pn.add(scrollPane); // Add the JScrollPane instead of the list directly
        pn.add(lb);

        this.add(pn);
        this.setSize(400, 200);
        this.setTitle("ItemEventTest");
        this.setVisible(true);
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == combo_box && e.getStateChange() == ItemEvent.SELECTED) {
            String selectedItem = (String) combo_box.getSelectedItem();
            lb.setText("You selected: " + selectedItem);
        } else if (e.getSource() == maleCheckBox || e.getSource() == femaleCheckBox) {
            JCheckBox checkBox = (JCheckBox) e.getItem();
            String checkBoxText = checkBox.getText();
            String action = e.getStateChange() == ItemEvent.SELECTED ? "checked" : "unchecked";
            lb.setText("You " + action + " " + checkBoxText);
        }
    }

    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            String selectedValue = list.getSelectedValue();
            if (selectedValue != null) {
                lb.setText("You selected: " + selectedValue);
            }
        }
    }

    public static void main(String[] args) {
        new Bai7();
    }
}
