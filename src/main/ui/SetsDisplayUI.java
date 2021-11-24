package ui;

import model.ArmorSet;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

// A class that represents a panel to display added sets
public class SetsDisplayUI extends JInternalFrame implements ActionListener {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 700;
    private Component theComponent;
    private ArmorToolUI armorToolUI;
    private JPanel thePanel;
    private JScrollPane scrollPane;
    private static final Icon MOBILITY_ICON = new ImageIcon("./data/mobility.png");
    private static final Icon RESILIENCE_ICON = new ImageIcon("./data/resilience.png");
    private static final Icon RECOVERY_ICON = new ImageIcon("./data/recovery.png");
    private static final Icon INTELLECT_ICON = new ImageIcon("./data/intellect.png");
    private static final Icon DISCIPLINE_ICON = new ImageIcon("./data/discipline.png");
    private static final Icon STRENGTH_ICON = new ImageIcon("./data/strength.png");
    private static final Icon BLANK_ICON =
            new ImageIcon(new BufferedImage(1, 1,BufferedImage.TYPE_INT_ARGB));

    public SetsDisplayUI(Component parent, ArmorToolUI armorToolUI) {
        super("View Sets", false, false, false, false);
        theComponent = parent;
        this.armorToolUI = armorToolUI;
        setLayout(new BorderLayout());
        thePanel = new JPanel();
        thePanel.setSize(new Dimension(WIDTH, HEIGHT));
        thePanel.setLayout(new FlowLayout());
        scrollPane = new JScrollPane(thePanel);
        scrollPane.setSize(new Dimension(300, 400));
        add(BorderLayout.CENTER, scrollPane);
        addButton();
        setSize(WIDTH, HEIGHT);
        setPosition(parent);
        setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: adds button to refresh currently added sets
    public void addButton() {
        JButton removeSetsButton = new JButton("Remove All Sets");
        removeSetsButton.setActionCommand("removeSets");
        removeSetsButton.addActionListener(this);
        removeSetsButton.setBackground(Color.RED);
        removeSetsButton.setForeground(Color.BLACK);
        add(BorderLayout.SOUTH, removeSetsButton);
    }

    // EFFECTS: takes action when the buttons is pressed
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("removeSets")) {
            for (ArmorSet as : armorToolUI.getSets()) {
                as.logRemoval();
            }
            armorToolUI.setSets(new ArrayList<>());
            thePanel.removeAll();
            thePanel.repaint();
            armorToolUI.updateSetsAdded();
        }
    }

    // MODIFIES: this
    // EFFECTS: displays stats for all currently added sets
    public void displaySets() {
        thePanel.removeAll();
        thePanel.repaint();
        for (ArmorSet s : armorToolUI.getSets()) {
            createTable(s);
        }
    }

    // MODIFIES: this
    // EFFECTS: creates a new table to display an armor set's stat totals
    private void createTable(ArmorSet s) {
        String[] columnNames = {"Stat", "Value"};
        Object[][] data = {{BLANK_ICON, s.getName()}, {MOBILITY_ICON, addMobility(s)},
                {RESILIENCE_ICON, addResilience(s)}, {RECOVERY_ICON, addRecovery(s)},
                {INTELLECT_ICON, addIntellect(s)}, {DISCIPLINE_ICON, addDiscipline(s)},
                {STRENGTH_ICON, addStrength(s)}};
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            public Class getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
        };
        JTable newTable = new JTable(model);
        newTable.setRowHeight(100);
        newTable.setFont(new Font("Arial", Font.BOLD, 16));
        newTable.setPreferredSize(new Dimension(250, 850));
        thePanel.add(newTable);
    }

    // EFFECTS: adds all Mobility values of the set
    private int addMobility(ArmorSet s) {
        int total = 0;
        total += s.getHead().get(0).getMobility();
        total += s.getArms().get(0).getMobility();
        total += s.getChest().get(0).getMobility();
        total += s.getLegs().get(0).getMobility();
        total += s.getClassItem().get(0).getMobility();
        return total;
    }

    // EFFECTS: adds all Resilience values of the set
    private int addResilience(ArmorSet s) {
        int total = 0;
        total += s.getHead().get(0).getResilience();
        total += s.getArms().get(0).getResilience();
        total += s.getChest().get(0).getResilience();
        total += s.getLegs().get(0).getResilience();
        total += s.getClassItem().get(0).getResilience();
        return total;
    }

    // EFFECTS: adds all Recovery values of the set
    private int addRecovery(ArmorSet s) {
        int total = 0;
        total += s.getHead().get(0).getRecovery();
        total += s.getArms().get(0).getRecovery();
        total += s.getChest().get(0).getRecovery();
        total += s.getLegs().get(0).getRecovery();
        total += s.getClassItem().get(0).getRecovery();
        return total;
    }

    // EFFECTS: adds all Intellect values of the set
    private int addIntellect(ArmorSet s) {
        int total = 0;
        total += s.getHead().get(0).getIntellect();
        total += s.getArms().get(0).getIntellect();
        total += s.getChest().get(0).getIntellect();
        total += s.getLegs().get(0).getIntellect();
        total += s.getClassItem().get(0).getIntellect();
        return total;
    }

    // EFFECTS: adds all Discipline values of the set
    private int addDiscipline(ArmorSet s) {
        int total = 0;
        total += s.getHead().get(0).getDiscipline();
        total += s.getArms().get(0).getDiscipline();
        total += s.getChest().get(0).getDiscipline();
        total += s.getLegs().get(0).getDiscipline();
        total += s.getClassItem().get(0).getDiscipline();
        return total;
    }

    // EFFECTS: adds all Strength values of the set
    private int addStrength(ArmorSet s) {
        int total = 0;
        total += s.getHead().get(0).getStrength();
        total += s.getArms().get(0).getStrength();
        total += s.getChest().get(0).getStrength();
        total += s.getLegs().get(0).getStrength();
        total += s.getClassItem().get(0).getStrength();
        return total;
    }

    // MODIFIES: this
    // EFFECTS: sets the position of this SetsDisplayUI relative to the parent component
    public void setPosition(Component parent) {
        setLocation(parent.getWidth() - getWidth() - 50, 10);
    }
}
