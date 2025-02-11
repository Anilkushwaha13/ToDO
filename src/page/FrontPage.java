package page;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

import static javax.swing.BoxLayout.Y_AXIS;

public class FrontPage extends JFrame {


    public FrontPage() {
        this.setLayout(null);
        this.setVisible(true);

        this.setSize(500, 650);
        this.add(ListPanel);
        this.add(Btn1);


        JScrollPane scrollPane = new JScrollPane(ListPanel);
        scrollPane.setBounds(50, 50, 400, 450); // Set scroll pane bounds
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); // Scrollbar shows when needed

        // Add JScrollPane to the JFrame
        this.add(scrollPane);


        ListPanel.setLayout(new BoxLayout(ListPanel, Y_AXIS));
        // Add padding and border to ListPanel
        ListPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 2), // Border around the panel
                BorderFactory.createEmptyBorder(10, 10, 10, 10) // Padding inside the panel
        ));
        ListPanel.setBounds(50, 50, 400, 450);
      ListPanel.setBackground(Color.lightGray);
        Btn1.setBounds(200, 520, 100, 40);
        Btn1.setText(" Add to list ");
        Btn1.setSize(100, 40);


        Btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addtask();
            }
        });



        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });

    }

    JButton Btn1 = new JButton();
    JPanel ListPanel = new JPanel();



    public void addtask() {
        JDialog AddText;
        AddText = new JDialog();
        AddText.setSize(300,500);
        AddText.setLayout(null);
        AddText.setVisible(true);
        AddText.setLocationRelativeTo(null);
       AddText.setTitle("Add Your work");
        JTextArea Text = new JTextArea();
        JButton btn1 = new JButton("Add");
        JButton btn2 = new JButton("Cancel");

        Text.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        Text.setBounds(30,50,220,200);
        Text.setLineWrap(true); // Enable line wrap
        Text.setWrapStyleWord(true); // Enable word wrapping (wrap at word boundaries)

        // Prevent horizontal scrolling in the JTextArea
        Text.setMargin(new Insets(10, 10, 10, 10)); // Add some padding
        JScrollPane textScrollPane = new JScrollPane(Text); // Add JTextArea inside JScrollPane for scrolling
        textScrollPane.setBounds(30, 50, 220, 200);
        AddText.add(textScrollPane);

        btn1.setBounds(40,300,100,30);
        btn2.setBounds(160,300,100,30);


        AddText.add(Text);
        AddText.add(btn1);
        AddText.add(btn2);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 String str = Text.getText();
                if (str.isEmpty()) {
                    JOptionPane.showMessageDialog(AddText, "Task cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                 JCheckBox check = new JCheckBox();
                 JLabel label =new JLabel(str);
                JPanel subPanel = new JPanel();
                subPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // Horizontal layout
                subPanel.setMaximumSize(new Dimension(350, 40));
                subPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                subPanel.add(check);
                subPanel.add(label);
                 ListPanel.add(subPanel);

                ListPanel.add(Box.createRigidArea(new Dimension(0, 15)));
                ListPanel.revalidate();
                ListPanel.repaint();

                check.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Font font = new Font("SansSerif", Font.BOLD, 12);
                        Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());

                       if (check.isSelected()) {
                            // Apply strikethrough

                            attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
                           System.out.println("first run");

                        } else {
                            attributes.remove(TextAttribute.STRIKETHROUGH,TextAttribute.STRIKETHROUGH_ON);

                            attributes.put(TextAttribute.FONT, font);

                           System.out.println("Second  run");
                            // Remove strikethrough
                            }
                        label.setFont(label.getFont().deriveFont(attributes));
                    }
                });




               AddText.dispose();
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddText.dispose();
            }
        });

    }
}
