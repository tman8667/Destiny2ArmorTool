package model;

import java.util.ArrayList;

// Represents a single armor piece with a type and six stat values
public class ArmorPiece {
    private String type;
    private int mobility;
    private int resilience;
    private int recovery;
    private int intellect;
    private int discipline;
    private int strength;

    // REQUIRES: all stat values must be between 0 and 40
    // MODIFIES: this
    // EFFECTS creates a new armor piece with given type and stat values
    public ArmorPiece(String type, int mobility, int resilience, int recovery,
                      int intellect, int discipline, int strength) {
        this.type = type;
        this.mobility = mobility;
        this.resilience = resilience;
        this.recovery = recovery;
        this.intellect = intellect;
        this.discipline = discipline;
        this.strength = strength;
    }

    public String getType() {
        return type;
    }

    public int getMobility() {
        return mobility;
    }

    public int getResilience() {
        return resilience;
    }

    public int getRecovery() {
        return recovery;
    }

    public int getIntellect() {
        return intellect;
    }

    public int getDiscipline() {
        return discipline;
    }

    public int getStrength() {
        return strength;
    }

    // EFFECTS: returns the total of all the stat values for this armor piece
    public int getStatTotal() {
        return (getMobility() + getResilience() + getRecovery() + getIntellect()
                + getDiscipline() + getStrength());
    }
}
