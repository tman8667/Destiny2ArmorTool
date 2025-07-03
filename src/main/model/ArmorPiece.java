package model;

import org.json.JSONObject;
import persistence.Writable;

// Represents a single armor piece with a type and six stat values
public class ArmorPiece implements Writable {
    private String type;
    private int weapons;
    private int health;
    private int classability;
    private int superability;
    private int grenade;
    private int melee;

    // REQUIRES: all stat values must be between 0 and 40
    // MODIFIES: this
    // EFFECTS creates a new armor piece with given type and stat values
    public ArmorPiece(String type, int weapons, int health, int classability,
                      int superability, int grenade, int melee) {
        this.type = type;
        this.weapons = weapons;
        this.health = health;
        this.classability = classability;
        this.superability = superability;
        this.grenade = grenade;
        this.melee = melee;
        EventLog.getInstance().logEvent(
                new Event("Armor piece created with stat total: " + getStatTotal()));
    }

    public String getType() {
        return type;
    }

    public int getWeapons() {
        return weapons;
    }

    public int getHealth() {
        return health;
    }

    public int getClassability() {
        return classability;
    }

    public int getSuperability() {
        return superability;
    }

    public int getGrenade() {
        return grenade;
    }

    public int getMelee() {
        return melee;
    }

    // EFFECTS: returns the total of all the stat values for this armor piece
    public int getStatTotal() {
        return (getWeapons() + getHealth() + getClassability() + getSuperability()
                + getGrenade() + getMelee());
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("type", type);
        json.put("weapons", weapons);
        json.put("health", health);
        json.put("class", classability);
        json.put("super", superability);
        json.put("grenade", grenade);
        json.put("melee", melee);
        return json;
    }
}
