package persistence;

import model.ArmorPiece;
import model.ArmorSet;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// Code adapted from JsonSerializationDemo project
public class JsonWriterTest extends JsonTest {

    @Test
    public void testWriterInvalidFile() {
        try {
            ArrayList<ArmorSet> sets = new ArrayList<>();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:filename.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    public void testWriterEmptySets() {
        try {
            ArrayList<ArmorSet> sets = new ArrayList<>();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptySets.json");
            writer.open();
            writer.write(sets);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptySets.json");
            sets = reader.read();
            assertEquals(0, sets.size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    public void testWriterGeneralSets() {
        try {
            ArrayList<ArmorSet> sets = new ArrayList();
            ArmorSet testSet1 = new ArmorSet("test set");
            testSet1.addPiece(new ArmorPiece("head", 10, 10, 10,
                    10, 10, 10));
            testSet1.addPiece(new ArmorPiece("arms", 10, 10, 10,
                    10, 10, 10));
            testSet1.addPiece(new ArmorPiece("chest", 10, 10, 10,
                    10, 10, 10));
            testSet1.addPiece(new ArmorPiece("legs", 10, 10, 10,
                    10, 10, 10));
            testSet1.addPiece(new ArmorPiece("class item", 0, 0, 0,
                    0, 0, 0));
            ArmorSet testSet2 = new ArmorSet("test set 2");
            testSet2.addPiece(new ArmorPiece("head", 12, 12, 12,
                    12, 12, 12));
            testSet2.addPiece(new ArmorPiece("arms", 12, 12, 12,
                    12, 12, 12));
            testSet2.addPiece(new ArmorPiece("chest", 12, 12, 12,
                    12, 12, 12));
            testSet2.addPiece(new ArmorPiece("legs", 12, 12, 12,
                    12, 12, 12));
            testSet2.addPiece(new ArmorPiece("class item", 0, 0, 10,
                    0, 0, 0));
            sets.add(testSet1);
            sets.add(testSet2);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralSets.json");
            writer.open();
            writer.write(sets);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralSets.json");
            sets = reader.read();
            assertEquals(2, sets.size());
            assertEquals("test set", sets.get(0).getName());
            checkArmorPiece("head", 10, 10, 10,
                    10, 10, 10, sets.get(0).getHead().get(0));
            checkArmorPiece("arms", 10, 10, 10,
                    10, 10, 10, sets.get(0).getArms().get(0));
            checkArmorPiece("chest", 10, 10, 10,
                    10, 10, 10, sets.get(0).getChest().get(0));
            checkArmorPiece("legs", 10, 10, 10,
                    10, 10, 10, sets.get(0).getLegs().get(0));
            checkArmorPiece("class item", 0, 0, 0,
                    0, 0, 0, sets.get(0).getClassItem().get(0));

            assertEquals("test set 2", sets.get(1).getName());
            checkArmorPiece("head", 12, 12, 12,
                    12, 12, 12, sets.get(1).getHead().get(0));
            checkArmorPiece("arms", 12, 12, 12,
                    12, 12, 12, sets.get(1).getArms().get(0));
            checkArmorPiece("chest", 12, 12, 12,
                    12, 12, 12, sets.get(1).getChest().get(0));
            checkArmorPiece("legs", 12, 12, 12,
                    12, 12, 12, sets.get(1).getLegs().get(0));
            checkArmorPiece("class item", 0, 0, 10,
                    0, 0, 0, sets.get(1).getClassItem().get(0));
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
