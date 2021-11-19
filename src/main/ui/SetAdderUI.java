package ui;

import model.ArmorPiece;
import model.ArmorSet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// A class that represents a window to add new sets
public class SetAdderUI extends JInternalFrame implements ActionListener {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 500;
    private Component theComponent;
    private ArmorToolUI armorToolUI;
    private JPanel thePanel;
    private JTextField setName;
    private ArrayList<JTextField> headTextFields;
    private ArrayList<JTextField> armsTextFields;
    private ArrayList<JTextField> chestTextFields;
    private ArrayList<JTextField> legsTextFields;
    private ArrayList<JTextField> classItemTextFields;

    public SetAdderUI(Component parent, ArmorToolUI armorToolUI) {
        super("Add Set", false, false, false, false);
        theComponent = parent;
        this.armorToolUI = armorToolUI;
        setLayout(new FlowLayout());
        headTextFields = new ArrayList<>();
        armsTextFields = new ArrayList<>();
        chestTextFields = new ArrayList<>();
        legsTextFields = new ArrayList<>();
        classItemTextFields = new ArrayList<>();
        addComponents();
        setSize(WIDTH, HEIGHT);
        setPosition(parent);
        setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: adds components
    private void addComponents() {
        setName = new JTextField("Enter Set Name");
        setName.setPreferredSize(new Dimension(300, 50));
        setName.setFont(new Font("Arial", Font.PLAIN, 15));
        add(setName);
        addStatTextFields();
        JButton addSetButton = new JButton("Add Set");
        addSetButton.setActionCommand("addSet");
        addSetButton.addActionListener(this);
        addSetButton.setPreferredSize(new Dimension(100, 40));
        add(addSetButton);
    }

    // MODIFIES: this
    // EFFECTS: adds text fields to enter stat values
    private void addStatTextFields() {
        thePanel = new JPanel(new GridLayout(6, 7));
        thePanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        thePanel.setFont(new Font("Arial", Font.PLAIN, 15));
        thePanel.add(new JLabel(""));
        thePanel.add(new JLabel("Mobility"));
        thePanel.add(new JLabel("Resilience"));
        thePanel.add(new JLabel("Recovery"));
        thePanel.add(new JLabel("Intellect"));
        thePanel.add(new JLabel("Discipline"));
        thePanel.add(new JLabel("Strength"));
        addPieceRows();
        thePanel.setPreferredSize(new Dimension(WIDTH - 50, HEIGHT - 200));
        thePanel.setVisible(true);
        add(thePanel);
    }

    // EFFECTS: adds rows of text fields for each armor piece
    private void addPieceRows() {
        addHeadRow();
        addArmsRow();
        addChestRow();
        addLegsRow();
        addClassItemRow();
    }

    // MODIFIES: this
    // EFFECTS: adds row of text fields for head stats
    private void addHeadRow() {
        thePanel.add(new JLabel("Head:"));
        addTextFields(headTextFields);
        thePanel.add(headTextFields.get(0));
        thePanel.add(headTextFields.get(1));
        thePanel.add(headTextFields.get(2));
        thePanel.add(headTextFields.get(3));
        thePanel.add(headTextFields.get(4));
        thePanel.add(headTextFields.get(5));
    }

    // MODIFIES: this
    // EFFECTS: adds row of text fields for arms stats
    private void addArmsRow() {
        thePanel.add(new JLabel("Arms:"));
        addTextFields(armsTextFields);
        thePanel.add(armsTextFields.get(0));
        thePanel.add(armsTextFields.get(1));
        thePanel.add(armsTextFields.get(2));
        thePanel.add(armsTextFields.get(3));
        thePanel.add(armsTextFields.get(4));
        thePanel.add(armsTextFields.get(5));
    }

    // MODIFIES: this
    // EFFECTS: adds row of text fields for chest stats
    private void addChestRow() {
        thePanel.add(new JLabel("Chest:"));
        addTextFields(chestTextFields);
        thePanel.add(chestTextFields.get(0));
        thePanel.add(chestTextFields.get(1));
        thePanel.add(chestTextFields.get(2));
        thePanel.add(chestTextFields.get(3));
        thePanel.add(chestTextFields.get(4));
        thePanel.add(chestTextFields.get(5));
    }

    // MODIFIES: this
    // EFFECTS: adds row of text fields for legs stats
    private void addLegsRow() {
        thePanel.add(new JLabel("Legs:"));
        addTextFields(legsTextFields);
        thePanel.add(legsTextFields.get(0));
        thePanel.add(legsTextFields.get(1));
        thePanel.add(legsTextFields.get(2));
        thePanel.add(legsTextFields.get(3));
        thePanel.add(legsTextFields.get(4));
        thePanel.add(legsTextFields.get(5));
    }


    // MODIFIES: this
    // EFFECTS: adds row of text fields for class item stats
    private void addClassItemRow() {
        thePanel.add(new JLabel("ClassItem:"));
        addTextFields(classItemTextFields);
        thePanel.add(classItemTextFields.get(0));
        thePanel.add(classItemTextFields.get(1));
        thePanel.add(classItemTextFields.get(2));
        thePanel.add(classItemTextFields.get(3));
        thePanel.add(classItemTextFields.get(4));
        thePanel.add(classItemTextFields.get(5));
    }

    // MODIFIES: this
    // EFFECTS: adds 6 text fields to given array
    private void addTextFields(ArrayList<JTextField> textAreaList) {
        for (int i = 0; i < 6; i++) {
            textAreaList.add(new JTextField());
        }
    }

    // MODIFIES: this
    // EFFECTS: adds a set of armor to list of sets
    private void addArmorSet() {
        ArmorSet newSet = new ArmorSet(setName.getText());

        try {
            newSet.addPiece(makeNewPiece("head", headTextFields));
            newSet.addPiece(makeNewPiece("arms", armsTextFields));
            newSet.addPiece(makeNewPiece("chest", chestTextFields));
            newSet.addPiece(makeNewPiece("legs", legsTextFields));
            newSet.addPiece(makeNewPiece("class item", classItemTextFields));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a number in every box!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

        armorToolUI.addSet(newSet);
        resetAllTextFields();
        JOptionPane.showMessageDialog(this, "Refresh sets to see it",
                "Set Successfully Loaded", JOptionPane.INFORMATION_MESSAGE);
    }

    // EFFECTS: creates a new armor piece with name and stat values given by the user
    private ArmorPiece makeNewPiece(String type, ArrayList<JTextField> values) throws NumberFormatException {
        ArmorPiece newPiece;
        newPiece = new ArmorPiece(type, Integer.parseInt(values.get(0).getText()),
                Integer.parseInt(values.get(1).getText()), Integer.parseInt(values.get(2).getText()),
                Integer.parseInt(values.get(3).getText()), Integer.parseInt(values.get(4).getText()),
                Integer.parseInt(values.get(5).getText()));
        return newPiece;
    }

    // MODIFIES: this
    // EFFECTS: resets the text in each of the text fields
    private void resetAllTextFields() {
        setName.setText("Enter Set Name");
        for (JTextField jtf : headTextFields) {
            jtf.setText("");
        }
        for (JTextField jtf : armsTextFields) {
            jtf.setText("");
        }
        for (JTextField jtf : chestTextFields) {
            jtf.setText("");
        }
        for (JTextField jtf : legsTextFields) {
            jtf.setText("");
        }
        for (JTextField jtf : classItemTextFields) {
            jtf.setText("");
        }
    }

    // EFFECTS: takes action when button is pressed
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("addSet")) {
            System.out.println("Set called: " + setName.getText());
            addArmorSet();
        }
    }

    // MODIFIES: this
    // EFFECTS: sets the position of this SetsDisplayUI relative to the parent component
    public void setPosition(Component parent) {
        setLocation(70, 10);
    }
}