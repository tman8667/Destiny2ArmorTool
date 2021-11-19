package ui;

import model.ArmorSet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// A class that represents a panel to remove an added set
public class SetRemoverUI extends JInternalFrame implements ActionListener {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 200;
    private Component theComponent;
    private ArmorToolUI armorToolUI;
    private JTextArea addedSetNames;
    private JTextField setNameBox;
    private JPanel rightPanel;

    public SetRemoverUI(Component parent, ArmorToolUI armorToolUI) {
        super("Remove Set", false, false, false, false);
        theComponent = parent;
        this.armorToolUI = armorToolUI;
        setLayout(new BorderLayout());
        setSize(WIDTH, HEIGHT);
        addComponents();
        setPosition(parent);
        setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: adds components to this frame
    private void addComponents() {
        addedSetNames = new JTextArea("Added set names:");
        addedSetNames.setEditable(false);
        addedSetNames.setFont(new Font("Arial", Font.PLAIN, 16));
        addedSetNames.setPreferredSize(new Dimension(200,150));
        addedSetNames.setBackground(new Color(163, 163, 163));
        add(addedSetNames, BorderLayout.WEST);

        rightPanel = new JPanel(new FlowLayout());
        rightPanel.setPreferredSize(new Dimension(200, 150));

        setNameBox = new JTextField("Enter name of set to remove");
        setNameBox.setPreferredSize(new Dimension(150, 40));
        setNameBox.setFont(new Font("Arial", Font.PLAIN, 15));
        rightPanel.add(setNameBox);

        JButton removeSetButton = new JButton("Remove set");
        removeSetButton.setActionCommand("removeSet");
        removeSetButton.addActionListener(this);
        rightPanel.add(removeSetButton);

        rightPanel.setVisible(true);
        add(rightPanel, BorderLayout.EAST);
    }

    // EFFECTS: takes action when one of the buttons is pressed
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("removeSet")) {
            removeSet();
        }
    }

    // MODIFIES: armorToolUI
    // EFFECTS: removes set with name given in text box from armorToolUI
    private void removeSet() {
        armorToolUI.removeSet(setNameBox.getText());
    }

    // MODIFIES: this
    // EFFECTS: updates list of added sets' names
    public void update() {
        addedSetNames.setText("Added set names:" + getNames());
        setNameBox.setText("Enter name of set to remove");
    }

    // EFFECTS: returns string of names of all added sets on separate lines
    private String getNames() {
        String namesString = "";
        for (ArmorSet s : armorToolUI.getSets()) {
            namesString += "\n" + s.getName();
        }
        return  namesString;
    }

    // MODIFIES: this
    // EFFECTS: sets the position of this SetsDisplayUI relative to the parent component
    public void setPosition(Component parent) {
        setLocation(400, 550);
    }
}
