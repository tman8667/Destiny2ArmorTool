package model;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArmorSetTest {
    ArmorSet testSet;

    @BeforeEach
    public void runBefore() {
        testSet = new ArmorSet("Test Set");
    }

    @Test
    public void testAddPieceClassItem() {
        assertEquals("Test Set", testSet.getName());
        ArmorPiece validPiece = new ArmorPiece("class item", 0, 0, 0,
                0, 0, 0);
        assertTrue(testSet.addPiece(validPiece));

        ArmorPiece validPiece2 = new ArmorPiece("class item", 0, 0, 0,
                10, 0, 0);
        assertFalse(testSet.addPiece(validPiece2));
    }

    @Test
    public void testAddPieceHead() {
        ArmorPiece validPiece = new ArmorPiece("head", 3, 17, 8,
                10, 12, 5);
        assertTrue(testSet.addPiece(validPiece));

        ArmorPiece validPiece2 = new ArmorPiece("head", 3, 17, 8,
                10, 12, 5);
        assertFalse(testSet.addPiece(validPiece2));
    }

    @Test
    public void testAddPieceArms() {
        ArmorPiece validPiece = new ArmorPiece("arms", 3, 17, 8,
                10, 12, 5);
        assertTrue(testSet.addPiece(validPiece));

        ArmorPiece validPiece2 = new ArmorPiece("arms", 3, 17, 8,
                10, 12, 5);
        assertFalse(testSet.addPiece(validPiece2));
    }

    @Test
    public void testAddPieceChest() {
        ArmorPiece validPiece = new ArmorPiece("chest", 3, 17, 8,
                10, 12, 5);
        assertTrue(testSet.addPiece(validPiece));

        ArmorPiece validPiece2 = new ArmorPiece("chest", 3, 17, 8,
                10, 12, 5);
        assertFalse(testSet.addPiece(validPiece2));
    }

    @Test
    public void testAddPieceLegs() {
        ArmorPiece validPiece = new ArmorPiece("legs", 3, 17, 8,
                10, 12, 5);
        assertTrue(testSet.addPiece(validPiece));

        ArmorPiece validPiece2 = new ArmorPiece("legs", 3, 17, 8,
                10, 12, 5);
        assertFalse(testSet.addPiece(validPiece2));
    }

    @Test
    public void testIsFull() {
        assertFalse(testSet.isFull());
        ArmorPiece testHead = new ArmorPiece("head", 3, 17, 8,
                10, 12, 5);
        testSet.addPiece(testHead);
        assertFalse(testSet.isFull());
        ArmorPiece testArms = new ArmorPiece("arms", 3, 17, 8,
                10, 12, 5);
        testSet.addPiece(testArms);
        assertFalse(testSet.isFull());
        ArmorPiece testChest = new ArmorPiece("chest", 3, 17, 8,
                10, 12, 5);
        testSet.addPiece(testChest);
        assertFalse(testSet.isFull());
        ArmorPiece testLegs = new ArmorPiece("legs", 3, 17, 8,
                10, 12, 5);
        testSet.addPiece(testLegs);
        assertFalse(testSet.isFull());
        ArmorPiece testClassItem = new ArmorPiece("class item", 0, 0, 0,
                0, 0, 0);
        testSet.addPiece(testClassItem);
        assertTrue(testSet.isFull());
    }

    @Test
    public void testClearSlotClassItem() {
        ArmorPiece testPiece = new ArmorPiece("class item", 10, 0, 0,
                0, 0, 0);
        testSet.addPiece(testPiece);

        assertTrue(testSet.clearSlot("class item"));
        assertTrue(testSet.getClassItem().isEmpty());
        assertFalse(testSet.clearSlot("class item"));
    }

    @Test
    public void testClearSlotHead() {
        ArmorPiece testPiece = new ArmorPiece("head", 10, 12, 9,
                13, 8, 10);
        testSet.addPiece(testPiece);

        assertTrue(testSet.clearSlot("head"));
        assertTrue(testSet.getHead().isEmpty());
        assertFalse(testSet.clearSlot("head"));
    }

    @Test
    public void testClearSlotArms() {
        ArmorPiece testPiece = new ArmorPiece("arms", 10, 12, 9,
                13, 8, 10);
        testSet.addPiece(testPiece);

        assertTrue(testSet.clearSlot("arms"));
        assertTrue(testSet.getArms().isEmpty());
        assertFalse(testSet.clearSlot("arms"));
    }

    @Test
    public void testClearSlotChest() {
        ArmorPiece testPiece = new ArmorPiece("chest", 10, 12, 9,
                13, 8, 10);
        testSet.addPiece(testPiece);

        assertTrue(testSet.clearSlot("chest"));
        assertTrue(testSet.getChest().isEmpty());
        assertFalse(testSet.clearSlot("chest"));
    }

    @Test
    public void testClearSlotLegs() {
        ArmorPiece testPiece = new ArmorPiece("legs", 10, 12, 9,
                13, 8, 10);
        testSet.addPiece(testPiece);

        assertTrue(testSet.clearSlot("legs"));
        assertTrue(testSet.getLegs().isEmpty());
        assertFalse(testSet.clearSlot("legs"));
    }

    @Test
    public void testToJson() {
        ArmorPiece testHead = new ArmorPiece("head", 3, 17, 8,
                10, 12, 5);
        JSONObject headObject = testHead.toJson();
        testSet.addPiece(testHead);
        ArmorPiece testArms = new ArmorPiece("arms", 3, 17, 8,
                10, 12, 5);
        JSONObject armsObject = testArms.toJson();
        testSet.addPiece(testArms);
        ArmorPiece testChest = new ArmorPiece("chest", 3, 17, 8,
                10, 12, 5);
        JSONObject chestObject = testHead.toJson();
        testSet.addPiece(testChest);
        ArmorPiece testLegs = new ArmorPiece("legs", 3, 17, 8,
                10, 12, 5);
        JSONObject legsObject = testHead.toJson();
        testSet.addPiece(testLegs);
        ArmorPiece testClassItem = new ArmorPiece("class item", 0, 0, 0,
                0, 0, 0);
        JSONObject classItemObject = testHead.toJson();
        testSet.addPiece(testClassItem);
        JSONObject json = testSet.toJson();
        assertEquals("Test Set", json.getString("name"));
    }
}
