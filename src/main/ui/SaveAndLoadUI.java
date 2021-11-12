package ui;

import model.ArmorSet;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class SaveAndLoadUI extends JInternalFrame implements ActionListener {
    private static final int WIDTH = 200;
    private static final int HEIGHT = 100;
    private Component theComponent;
    private ArmorToolUI armorToolUI;
    private static  final String JSON_STORE = "./data/sets.json";
    private JsonReader jsonReader;
    private JsonWriter jsonWriter;


    public SaveAndLoadUI(Component parent, ArmorToolUI armorToolUI) {
        super("Sav/Load Data", false, false, false, false);
        theComponent = parent;
        this.armorToolUI = armorToolUI;
        jsonReader = new JsonReader(JSON_STORE);
        jsonWriter = new JsonWriter(JSON_STORE);
        setLayout(new FlowLayout());
        setSize(WIDTH, HEIGHT);
        addButtons();
        setPosition(parent);
        setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: adds buttons for saving/loading data
    public void addButtons() {
        JButton saveDataButton = new JButton("Save Sets");
        saveDataButton.setActionCommand("saveData");
        saveDataButton.addActionListener(this);
        add(saveDataButton);

        JButton loadDataButton = new JButton("Load Sets From File");
        loadDataButton.setActionCommand("loadData");
        loadDataButton.addActionListener(this);
        add(loadDataButton);
    }

    // EFFECTS: takes action when one of the buttons is pressed
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("saveData")) {
            saveSets();
        } else if (e.getActionCommand().equals("loadData")) {
            loadSets();
        }
    }

    // EFFECTS: saves sets to file
    private void saveSets() {
        try {
            jsonWriter.open();
            jsonWriter.write(armorToolUI.getSets());
            jsonWriter.close();
            System.out.println("Saved all sets to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads workroom from file
    private void loadSets() {
        try {
            armorToolUI.setSets(jsonReader.read());
            System.out.println("Loaded armor sets from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: sets the position of this SetsDisplayUI relative to the parent component
    public void setPosition(Component parent) {
        setLocation(20, 300);
    }
}
