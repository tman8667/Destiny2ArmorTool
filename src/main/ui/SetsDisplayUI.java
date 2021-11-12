package ui;

import javax.swing.*;
import java.awt.*;

public class SetsDisplayUI extends JInternalFrame {
    private static final int WIDTH = 300;
    private static final int HEIGHT = 200;
    private Component theComponent;
    private JPanel thePanel;
    private JScrollPane scrollPane;

    public SetsDisplayUI(Component parent) {
        super("View Sets", false, false, false, false);
        theComponent = parent;
        setLayout(new FlowLayout());
        thePanel = new JPanel();
        thePanel.setSize(new Dimension(WIDTH, HEIGHT));
        scrollPane = new JScrollPane();
        setAutoscrolls(true);
        scrollPane.setSize(new Dimension(100, 100));
        thePanel.add(scrollPane);
        add(thePanel);
        setSize(WIDTH, HEIGHT);
        setPosition(parent);
        setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: sets the position of this SetsDisplayUI relative to the parent component
    public void setPosition(Component parent) {
        setLocation(parent.getWidth() - getWidth() - 10, 0);
    }
}
