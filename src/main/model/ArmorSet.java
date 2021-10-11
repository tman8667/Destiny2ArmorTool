package model;

import java.util.ArrayList;

public class ArmorSet {
    private String name;
    private ArrayList<ArmorPiece> head;
    private ArrayList<ArmorPiece> arms;
    private ArrayList<ArmorPiece> chest;
    private ArrayList<ArmorPiece> legs;
    private ArrayList<ArmorPiece> classItem;

    // EFFECTS: creates a new ArmorSet object with given name
    public ArmorSet(String name) {
        this.name = name;
    }

    // MODIFIES: this
    // EFFECTS: adds given piece to this armor set if the piece is valid
    //          and the slot for that piece is not full
    //          returns true if armor is successfully added, false otherwise
    public boolean addPiece(ArmorPiece armor) {
        return false;
    }

    // MODIFIES: this
    // EFFECTS: clears the armor piece in the given slot and returns true if the operation was successful,
    //          false otherwise
    public boolean clearSlot(String slotName) {
        return false;
    }
}
