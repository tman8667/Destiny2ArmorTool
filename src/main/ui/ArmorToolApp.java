package ui;

import model.ArmorPiece;
import model.ArmorSet;
import persistence.JsonReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// Armor comparison tool application
// Code adapted from TellerApp program used in lecture
public class ArmorToolApp {
    private static  final String JSON_STORE = "./data/testArmorSets.json";
    private ArrayList<ArmorSet> sets;
    private Scanner input;
    private JsonReader jsonReader;

    // EFFECTS: Initializes sets as an empty list and runs the application
    public ArmorToolApp() throws FileNotFoundException {
        sets = new ArrayList<>();
        jsonReader = new JsonReader(JSON_STORE);
        runArmorTool();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runArmorTool() {
        boolean keepGoing = true;
        String command;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nSee you star-side, Guardian.");
    }

    // MODIFIES: this
    // EFFECTS: Initializes the scanner
    private void init() {
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // EFFECTS displays menu options to the user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> add an armor set");
        System.out.println("\tr -> remove an armor set");
        System.out.println("\tc -> remove all currently added sets");
        System.out.println("\tp -> print comparison of stat totals");
        System.out.println("\ts -> save added armor sets to file");
        System.out.println("\tl -> load armor sets from file");
        System.out.println("\tq -> quit application");
    }

    // MODIFIES: this
    // EFFECTS: processes user commands
    private void processCommand(String command) {
        if (command.equals("a")) {
            addArmorSet();
        } else if (command.equals("r")) {
            removeArmorSet();
        } else if (command.equals("c")) {
            clearSets();
        } else if (command.equals("p")) {
            compareSets();
        } else if (command.equals("s")) {
            saveSets();
        } else if (command.equals("l")) {
            loadSets();
        } else {
            System.out.println("The command you entered is not valid...");
        }
    }

    // MODIFIES: this
    // EFFECTS: adds a set of armor to list of sets
    private void addArmorSet() {
        ArmorSet newSet;
        System.out.println("\nEnter a name for this set:");
        String setName = input.next();
        newSet = new ArmorSet(setName);
        while (!newSet.isFull()) {
            ArmorPiece newPiece = makeNewPiece();
            if (newSet.addPiece(newPiece)) {
                newSet.addPiece(newPiece);
                System.out.println("Armor piece successfully added.");
            } else {
                System.out.println("That slot is already full, add a different piece");
            }
        }
        sets.add(newSet);
        System.out.println("Successfully added set");
    }

    // EFFECTS: creates a new armor piece with name and stat values given by the user
    private ArmorPiece makeNewPiece() {
        ArmorPiece newPiece;
        ArrayList<Integer> statValues;
        String type = "";
        boolean nameSuccess = false;
        while (!nameSuccess) {
            System.out.println("\nEnter the armor type you wish to add (head, arms, chest, legs or class item):");
            type = input.next();
            if (!isValid(type)) {
                System.out.println("\nThat is not a valid type name");
            } else {
                nameSuccess = true;
            }
        }
        statValues = getStatValues();
        newPiece = new ArmorPiece(type, statValues.get(0), statValues.get(1), statValues.get(2), statValues.get(3),
                statValues.get(4), statValues.get(5));
        System.out.println("Successfully created armor piece with stat total: " + newPiece.getStatTotal());
        return newPiece;
    }

    // EFFECTS: gets list of stat values from the user
    private ArrayList<Integer> getStatValues() {
        ArrayList<Integer> statValues = new ArrayList<>();
        System.out.println("\nEnter the mobility value:");
        statValues.add(Integer.parseInt(input.next()));
        System.out.println("\nEnter the resilience value:");
        statValues.add(Integer.parseInt(input.next()));
        System.out.println("\nEnter the recovery value:");
        statValues.add(Integer.parseInt(input.next()));
        System.out.println("\nEnter the intellect value:");
        statValues.add(Integer.parseInt(input.next()));
        System.out.println("\nEnter the discipline value:");
        statValues.add(Integer.parseInt(input.next()));
        System.out.println("\nEnter the strength value:");
        statValues.add(Integer.parseInt(input.next()));
        return statValues;
    }

    // EFFECTS: removes set with name user specifies, if it exists
    private void removeArmorSet() {
        String name;
        if (!sets.isEmpty()) {
            System.out.println("\nEnter the name of the set you wish to remove:");
            name = input.next();
            for (int i = 0; i < sets.size(); i++) {
                if (sets.get(i).getName().equals(name)) {
                    sets.remove(i);
                    System.out.println("\nSuccessfully removed set");
                } else if (i == sets.size() - 1) {
                    System.out.println("\nCould not find set with that name");
                }
            }
        } else {
            System.out.println("\nThere are no sets to remove");
        }
    }

    // MODIFIES: this
    // EFFECTS: clears all the sets that have been added
    private void clearSets() {
        sets.clear();
        System.out.println("Successfully cleared all sets");
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
                System.out.println("\nStat totals for " + set.getName() + ":");
                System.out.println("\tMobility: " + mobilityTotal);
                System.out.println("\tResilience: " + resilienceTotal);
                System.out.println("\tRecovery: " + recoveryTotal);
                System.out.println("\tIntellect: " + intellectTotal);
                System.out.println("\tDiscipline: " + disciplineTotal);
                System.out.println("\tStrength: " + strengthTotal);
            }
        } else {
            System.out.println("\nThere are no sets added");
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

    // EFFECTS: returns true if this armor's type is one of:
    //          "head", "arms", "chest", "legs", or "class item"
    public boolean isValid(String slotName) {
        ArrayList<String> validNames = new ArrayList<>();
        validNames.add("head");
        validNames.add("arms");
        validNames.add("chest");
        validNames.add("legs");
        validNames.add("class item");

        if (!validNames.contains(slotName)) {
            return false;
        }

        return true;
    }

    // EFFECTS: saves sets to file
    private void saveSets() {
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
