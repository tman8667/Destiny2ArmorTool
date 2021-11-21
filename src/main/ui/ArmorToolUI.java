package ui;

import model.ArmorSet;
import model.Event;
import model.EventLog;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

// A class that represents an Armor Tool application's main window
// Some code in this and other classes adapted from AlarmController demo project
public class ArmorToolUI extends JFrame implements LogPrinter {
    public static final int WIDTH = 1500;
    public static final int HEIGHT = 900;
    private ArrayList<ArmorSet> sets;
    private JDesktopPane desktop;
    private SetRemoverUI setRemoverUI;
    private SetsDisplayUI setsDisplayUI;

    public ArmorToolUI() {
        setTitle("Destiny 2 Armor Comparison Tool");
        ImageIcon appIcon = new ImageIcon("./data/AppIcon.png");
        setIconImage(appIcon.getImage());
        sets = new ArrayList<>();
        initializeGraphics();
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                printLog(EventLog.getInstance());
                System.exit(0);
            }
        });
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
        addSetRemover();


        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    // MODIFIES: this
    // EFFECTS: adds an armor set viewer window to desktop
    private void addArmorSetViewer() {
        setsDisplayUI = new SetsDisplayUI(this, this);
        desktop.add(setsDisplayUI);
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

    // MODIFIES: this
    // EFFECTS: adds a set remover window to desktop
    private void addSetRemover() {
        setRemoverUI = new SetRemoverUI(this, this);
        add(setRemoverUI);
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
        setRemoverUI.update();
    }

    // EFFECTS: updates sets displayed in SetRemover amd SetsDisplay windows
    public void updateSetsAdded() {
        setRemoverUI.update();
        setsDisplayUI.displaySets();
    }

    // MODIFIES: this
    // EFFECTS: removes given set to list of sets
    public void removeSet(String name) {
        if (!sets.isEmpty()) {
            for (int i = 0; i <= sets.size(); i++) {
                if (i == sets.size()) {
                    JOptionPane.showMessageDialog(this,
                            "Check that you entered the name correctly",
                            "Could not find set",JOptionPane.WARNING_MESSAGE);
                } else if (sets.get(i).getName().equals(name)) {
                    sets.get(i).logRemoval();
                    sets.remove(i);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "No sets added",
                    "Alert",JOptionPane.WARNING_MESSAGE);
        }
        updateSetsAdded();
    }

    @Override
    public void printLog(EventLog el) {
        for (Event next : el) {
            System.out.println(next.toString());
        }

        repaint();
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
