package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArmorPieceTest {
    @Test
    public void testConstructor(){
        ArmorPiece testArmor = new ArmorPiece("chest",
                10, 10, 15, 21, 3, 8);
        assertEquals("chest", testArmor.getType());
        assertEquals(10, testArmor.getMobility());
        assertEquals(10, testArmor.getResilience());
        assertEquals(15, testArmor.getRecovery());
        assertEquals(21, testArmor.getIntellect());
        assertEquals(3, testArmor.getDiscipline());
        assertEquals(8, testArmor.getStrength());
    }

    @Test
    public void testGetStatTotal() {
        ArmorPiece testArmor = new ArmorPiece("class item",
                0, 0, 0, 0, 0, 0);
        assertEquals(0, testArmor.getStatTotal());

        ArmorPiece testArmor2 = new ArmorPiece("chest",
                10, 10, 15, 21, 3, 8);
        assertEquals((10 + 10 + 15 + 21 + 3 + 8), testArmor2.getStatTotal());

        ArmorPiece testArmor3 = new ArmorPiece("legs",
                10, 10, 40, 14, 3, 8);
        assertEquals((10 + 10 + 40 + 14 + 3 + 8), testArmor3.getStatTotal());
    }
}
