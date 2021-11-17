package ui;

import model.ArmorSet;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

// A class that represents an application's main window
// Code adapted from AlarmController demo project
public class ArmorToolUI extends JFrame {
    public static final int WIDTH = 1500;
    public static final int HEIGHT = 900;

    private static  final String JSON_STORE = "./data/sets.json";
    private ArrayList<ArmorSet> sets;
    private JDesktopPane desktop;

    public ArmorToolUI() {
        setTitle("Destiny 2 Armor Comparison Tool");
        sets = new ArrayList<>();
        initializeGraphics();
    }

    // MODIFIES: this
    // EFFECTS: initializes the graphical components
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

    // MODIFIES: this
    // EFFECTS: adds an armor set viewer window to desktop
    private void addArmorSetViewer() {
        SetsDisplayUI setsDisplay = new SetsDisplayUI(this, this);
        desktop.add(setsDisplay);
    }

    // MODIFIES: this
    // EFFECTS: adds an armor set adder window to desktop
    private void addArmorSetAdder() {
        SetAdderUI setAdderUI = new SetAdderUI(this, this);
        add(setAdderUI);
    }

    // MODIFIES: this
    // EFFECTS: adds a save/load window to desktop
    private void addSaveAndLoad() {
        SaveAndLoadUI saveAndLoadUI = new SaveAndLoadUI(this, this);
        add(saveAndLoadUI);
    }

    public ArrayList<ArmorSet> getSets() {
        return this.sets;
    }

    public void setSets(ArrayList<ArmorSet> sets) {
        this.sets = sets;
    }

    // MODIFIES: this
    // EFFECTS: adds given set to list of sets
    public void addSet(ArmorSet set) {
        sets.add(set);
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
