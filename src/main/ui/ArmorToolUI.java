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

public class ArmorToolUI extends JFrame implements ActionListener {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 700;

    private static  final String JSON_STORE = "./data/sets.json";
    private ArrayList<ArmorSet> sets;
    private JTextArea setStats;
    private JsonReader jsonReader;
    private JsonWriter jsonWriter;

    public ArmorToolUI() {
        super("Destiny 2 Armor Comparison Tool");
        initializeFields();
        initializeGraphics();
    }

    public void initializeFields() {
        sets = new ArrayList<>();
        jsonReader = new JsonReader(JSON_STORE);
        jsonWriter = new JsonWriter(JSON_STORE);
    }

    private void initializeGraphics() {
        setLayout(new FlowLayout());
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton saveDataButton = new JButton("Save Sets");
        saveDataButton.setActionCommand("saveData");
        saveDataButton.addActionListener(this);
        add(saveDataButton);

        JButton loadDataButton = new JButton("Load Sets From File");
        loadDataButton.setActionCommand("loadData");
        loadDataButton.addActionListener(this);
        add(loadDataButton);

        JButton printSetsButton = new JButton("Print sets to console");
        printSetsButton.setActionCommand("printSets");
        printSetsButton.addActionListener(this);
        add(printSetsButton);

        setStats = new JTextArea();
        add(setStats);

        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("saveData")) {
            saveSets();
        } else if (e.getActionCommand().equals("loadData")) {
            loadSets();
        } else if (e.getActionCommand().equals("printSets")) {
            compareSets();
        }
    }

    // EFFECTS: list the stat totals for every set currently added
    private void compareSets() {
        if (!sets.isEmpty()) {
            for (ArmorSet set : sets) {
                int mobilityTotal = addMobility(set);
                int resilienceTotal = addResilience(set);
                int recoveryTotal = addRecovery(set);
                int intellectTotal = addIntellect(set);
                int disciplineTotal = addDiscipline(set);
                int strengthTotal = addStrength(set);
                setStats.insert("Stat totals for " + set.getName() + ":", 0);
                setStats.append("\nMobility: " + mobilityTotal);
                setStats.append("\nResilience: " + resilienceTotal);
                setStats.append("\nRecovery: " + recoveryTotal);
                setStats.append("\nIntellect: " + intellectTotal);
                setStats.append("\nDiscipline: " + disciplineTotal);
                setStats.append("\nStrength: " + strengthTotal);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No sets added",
                    "Alert",JOptionPane.WARNING_MESSAGE);
        }
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

    // EFFECTS: saves sets to file
    private void saveSets() {
        try {
            jsonWriter.open();
            jsonWriter.write(sets);
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
            sets = jsonReader.read();
            System.out.println("Loaded armor sets from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}
