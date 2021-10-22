package persistence;

import model.ArmorSet;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;
import persistence.JsonTest;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// Code adapted from JsonSerializationDemo project
public class JsonReaderTest extends JsonTest {

    @Test
    public void testReaderNoneExistentFile(){
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            ArrayList<ArmorSet> sets = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            //pass
        }
    }

    @Test
    public void testReaderEmptySets() {
        JsonReader reader = new JsonReader("./data/testReaderEmptySets.json");
        try {
            ArrayList<ArmorSet> sets = reader.read();
            assertEquals(0, sets.size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    public void testReaderGeneralSets() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralSets.json");
        try {
            ArrayList<ArmorSet> sets = reader.read();
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
            fail("Couldn't read from file");
        }
    }
}
