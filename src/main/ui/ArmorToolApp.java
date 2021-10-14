package ui;

import model.ArmorPiece;
import model.ArmorSet;
import java.util.ArrayList;
import java.util.Scanner;

// Armor comparison tool application
// Code adapted from TellerApp program used in lecture
public class ArmorToolApp {
    private ArrayList<ArmorSet> sets;
    private Scanner input;

    // EFFECTS: Initializes sets as an empty list and runs the application
    public ArmorToolApp() {
        sets = new ArrayList<>();
        runArmorTool();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runArmorTool() {
        boolean keepGoing = true;
        String command = null;

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
        System.out.println("\tl -> view comparison of stat totals");
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
            compareSets();
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

    private ArmorPiece makeNewPiece() {
        ArmorPiece newPiece;
        ArrayList<Integer> statValues = new ArrayList<>();
        String type = "";
        boolean nameSuccess = false;
        while (!nameSuccess) {
            System.out.println("\nEnter the armor type you wish to add:");
            type = input.next();
            if (!isValid(type)) {
                System.out.println("\nThat is not a valid type name");
            } else {
                nameSuccess = true;
            }
        }
        statValues = getStatVlues();
        newPiece = new ArmorPiece(type, statValues.get(0), statValues.get(1), statValues.get(2), statValues.get(3),
                statValues.get(4), statValues.get(5));
        System.out.println("Successfully added armor piece with stat total: " + newPiece.getStatTotal());
        return newPiece;
    }

    private ArrayList<Integer> getStatVlues() {
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

    private void removeArmorSet() {
        String name;
        if (!sets.isEmpty()) {
            System.out.println("\nEnter the name of the set you wish to remove:");
            name = input.next();
            for (int i = 0; i < sets.size(); i++) {
                if (sets.get(i).getName() == name) {
                    sets.remove(i);
                    System.out.println("Successfully removed set");
                } else if (i == sets.size() - 1) {
                    System.out.println("Could not find set with that name");
                }
            }
        }
        System.out.println("\nThere are no sets to remove");
    }

    private void compareSets() {

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
}
