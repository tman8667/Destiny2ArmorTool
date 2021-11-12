package ui;

import model.ArmorSet;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

// A class that represents an application's main window
// Code adapted from AlarmController demo project
public class ArmorToolUI extends JFrame {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 700;

    private static  final String JSON_STORE = "./data/sets.json";
    private ArrayList<ArmorSet> sets;
    private JDesktopPane desktop;

    public ArmorToolUI() {
        setTitle("Destiny 2 Armor Comparison Tool");
        initializeFields();
        initializeGraphics();
    }

    public void initializeFields() {
        sets = new ArrayList<>();
    }

    private void initializeGraphics() {
        desktop = new JDesktopPane();
        desktop.addMouseListener(new DesktopFocusAction());

        setContentPane(desktop);
        setSize(WIDTH, HEIGHT);

        addArmorSetViewer();
        addArmorSetAdder();
        addSaveAndLoad();


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    private void addArmorSetViewer() {
        SetsDisplayUI setsDisplay = new SetsDisplayUI(this);
        desktop.add(setsDisplay);
    }

    private void addArmorSetAdder() {
        SetAdderUI setAdderUI = new SetAdderUI(this);
        add(setAdderUI);
    }

    private void addSaveAndLoad() {
        SaveAndLoadUI saveAndLoadUI = new SaveAndLoadUI(this, this);
        add(saveAndLoadUI);
    }

    public ArrayList<ArmorSet> getSets() {
        return sets;
    }

    public void setSets(ArrayList<ArmorSet> sets) {
        this.sets = sets;
    }

    // EFFECTS: list the stat totals for every set currently added
    /*private void compareSets() {
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
    }*/

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
    // EFFECTS: takes action when user clicks desktop to switch focus
    private class DesktopFocusAction extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            ArmorToolUI.this.requestFocusInWindow();
        }
    }
}
