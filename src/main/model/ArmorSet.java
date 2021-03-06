package model;

import model.exceptions.LogException;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

// Represents a full set of five armor pieces
public class ArmorSet implements Writable {
    private String name;
    private ArrayList<ArmorPiece> head;
    private ArrayList<ArmorPiece> arms;
    private ArrayList<ArmorPiece> chest;
    private ArrayList<ArmorPiece> legs;
    private ArrayList<ArmorPiece> classItem;

    // EFFECTS: creates a new ArmorSet object with given name
    public ArmorSet(String name) {
        this.name = name;
        head = new ArrayList<>();
        arms = new ArrayList<>();
        chest = new ArrayList<>();
        legs = new ArrayList<>();
        classItem = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<ArmorPiece> getHead() {
        return head;
    }

    public ArrayList<ArmorPiece> getArms() {
        return arms;
    }

    public ArrayList<ArmorPiece> getChest() {
        return chest;
    }

    public ArrayList<ArmorPiece> getLegs() {
        return legs;
    }

    public ArrayList<ArmorPiece> getClassItem() {
        return classItem;
    }

    // EFFECTS: returns true if every slot is full
    public boolean isFull() {
        return (head.size() == 1) && (arms.size() == 1) && (chest.size() == 1)
                && (legs.size() == 1) && (classItem.size() == 1);
    }

    // REQUIRES: armor's type is one of "head", "arms", "chest", "legs", "class item"
    // MODIFIES: this
    // EFFECTS: adds given piece to this armor set if the piece is valid
    //          and the slot for that piece is not full
    //          returns true if armor is successfully added, false otherwise
    public boolean addPiece(ArmorPiece armor) {
        if (armor.getType().equals("head") && head.isEmpty()) {
            head.add(armor);
            EventLog.getInstance().logEvent(new Event("Armor piece added to set: " + getName()));
            return true;
        } else if (armor.getType().equals("arms") && arms.isEmpty()) {
            arms.add(armor);
            EventLog.getInstance().logEvent(new Event("Armor piece added to set: " + getName()));
            return true;
        } else if (armor.getType().equals("chest") && chest.isEmpty()) {
            chest.add(armor);
            EventLog.getInstance().logEvent(new Event("Armor piece added to set: " + getName()));
            return true;
        } else if (armor.getType().equals("legs") && legs.isEmpty()) {
            legs.add(armor);
            EventLog.getInstance().logEvent(new Event("Armor piece added to set: " + getName()));
            return true;
        } else if (armor.getType().equals("class item") && classItem.isEmpty()) {
            classItem.add(armor);
            EventLog.getInstance().logEvent(new Event("Armor piece added to set: " + getName()));
            return true;
        }
        return false;
    }

    // REQUIRES: slotName is one of "head", "arms", "chest", "legs", "class item"
    // MODIFIES: this
    // EFFECTS: clears the armor piece in the given slot and returns true if the operation was successful,
    //          false otherwise
    public boolean clearSlot(String slotName) {
        if (slotName.equals("head") && !head.isEmpty()) {
            head.remove(0);
            return true;
        } else if (slotName.equals("arms") && !arms.isEmpty()) {
            arms.remove(0);
            return true;
        } else if (slotName.equals("chest") && !chest.isEmpty()) {
            chest.remove(0);
            return true;
        } else if (slotName.equals("legs") && !legs.isEmpty()) {
            legs.remove(0);
            return true;
        } else if (slotName.equals("class item") && !classItem.isEmpty()) {
            classItem.remove(0);
            return true;
        }
        return false;
    }

    // EFFECTS: logs when this armor set is removed from the application
    public void logRemoval() {
        EventLog.getInstance().logEvent(new Event("Removed set: " + getName()));
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("pieces", piecesToJson());
        return  json;
    }

    // EFFECTS: returns all the pieces of this set as a JSON array
    private JSONArray piecesToJson() {
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(getHead().get(0).toJson());
        jsonArray.put(getArms().get(0).toJson());
        jsonArray.put(getChest().get(0).toJson());
        jsonArray.put(getLegs().get(0).toJson());
        jsonArray.put(getClassItem().get(0).toJson());
        return  jsonArray;
    }
}
