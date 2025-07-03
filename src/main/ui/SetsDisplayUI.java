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
    private static final Icon WEAPONS_ICON = new ImageIcon("./data/weapons.png"); // Old icon. Will change when available.
    private static final Icon HEALTH_ICON = new ImageIcon("./data/health.png"); // Old icon. Will change when available.
    private static final Icon CLASS_ICON = new ImageIcon("./data/class.png"); // Old icon. Will change when available.
    private static final Icon SUPER_ICON = new ImageIcon("./data/super.png"); // Old icon. Will change when available.
    private static final Icon GRENADE_ICON = new ImageIcon("./data/grenade.png");
    private static final Icon MELEE_ICON = new ImageIcon("./data/melee.png");
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
        Object[][] data = {{BLANK_ICON, s.getName()}, {WEAPONS_ICON, addWeapons(s)},
                {HEALTH_ICON, addHealth(s)}, {CLASS_ICON, addClassability(s)},
                {SUPER_ICON, addSuperability(s)}, {GRENADE_ICON, addGrenade(s)},
                {MELEE_ICON, addMelee(s)}};
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            public Class getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
        };
        JTable newTable = new JTable(model);
        newTable.setRowHeight(100);
        newTable.setFont(new Font("Arial", Font.BOLD, 16));
        newTable.setPreferredSize(new Dimension(250, 850));
        newTable.setEnabled(false);
        thePanel.add(newTable);
    }

    // EFFECTS: adds all Weapons values of the set
    private int addWeapons(ArmorSet s) {
        int total = 0;
        total += s.getHead().get(0).getWeapons();
        total += s.getArms().get(0).getWeapons();
        total += s.getChest().get(0).getWeapons();
        total += s.getLegs().get(0).getWeapons();
        total += s.getClassItem().get(0).getWeapons();
        return total;
    }

    // EFFECTS: adds all Health values of the set
    private int addHealth(ArmorSet s) {
        int total = 0;
        total += s.getHead().get(0).getHealth();
        total += s.getArms().get(0).getHealth();
        total += s.getChest().get(0).getHealth();
        total += s.getLegs().get(0).getHealth();
        total += s.getClassItem().get(0).getHealth();
        return total;
    }

    // EFFECTS: adds all Class values of the set
    private int addClassability(ArmorSet s) {
        int total = 0;
        total += s.getHead().get(0).getClassability();
        total += s.getArms().get(0).getClassability();
        total += s.getChest().get(0).getClassability();
        total += s.getLegs().get(0).getClassability();
        total += s.getClassItem().get(0).getClassability();
        return total;
    }

    // EFFECTS: adds all Super values of the set
    private int addSuperability(ArmorSet s) {
        int total = 0;
        total += s.getHead().get(0).getSuperability();
        total += s.getArms().get(0).getSuperability();
        total += s.getChest().get(0).getSuperability();
        total += s.getLegs().get(0).getSuperability();
        total += s.getClassItem().get(0).getSuperability();
        return total;
    }

    // EFFECTS: adds all Grenade values of the set
    private int addGrenade(ArmorSet s) {
        int total = 0;
        total += s.getHead().get(0).getGrenade();
        total += s.getArms().get(0).getGrenade();
        total += s.getChest().get(0).getGrenade();
        total += s.getLegs().get(0).getGrenade();
        total += s.getClassItem().get(0).getGrenade();
        return total;
    }

    // EFFECTS: adds all Melee values of the set
    private int addMelee(ArmorSet s) {
        int total = 0;
        total += s.getHead().get(0).getMelee();
        total += s.getArms().get(0).getMelee();
        total += s.getChest().get(0).getMelee();
        total += s.getLegs().get(0).getMelee();
        total += s.getClassItem().get(0).getMelee();
        return total;
    }

    // MODIFIES: this
    // EFFECTS: sets the position of this SetsDisplayUI relative to the parent component
    public void setPosition(Component parent) {
        setLocation(parent.getWidth() - getWidth() - 50, 10);
    }
}
