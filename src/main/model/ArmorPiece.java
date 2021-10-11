package model;

import java.util.ArrayList;

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

    // EFFECTS: returns this armor piece's type
    public String getType() {
        return type;
    }

    // EFFECTS: returns this armor piece's mobility value
    public int getMobility() {
        return mobility;
    }

    // EFFECTS: returns this armor piece's resilience value
    public int getResilience() {
        return resilience;
    }

    // EFFECTS: returns this armor piece's recovery value
    public int getRecovery() {
        return recovery;
    }

    // EFFECTS: returns this armor piece's intellect value
    public int getIntellect() {
        return intellect;
    }

    // EFFECTS: returns this armor piece's discipline value
    public int getDiscipline() {
        return discipline;
    }

    // EFFECTS: returns this armor piece's strength value
    public int getStrength() {
        return strength;
    }

    // EFFECTS: returns the total of all the stat values for this armor piece
    public int getStatTotal() {
        return (getMobility() + getResilience() + getRecovery() + getIntellect()
                + getDiscipline() + getStrength());
    }

    // EFFECTS: returns true if this armor's type is one of:
    //          "head", "arms", "chest", "legs", or "class item"
    public boolean isValid() {
        ArrayList<String> validNames = new ArrayList<>();
        validNames.add("head");
        validNames.add("arms");
        validNames.add("chest");
        validNames.add("legs");
        validNames.add("class item");

        if (!validNames.contains(type)) {
            return false;
        }

        return true;
    }
}
