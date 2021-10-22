package persistence;

import model.ArmorPiece;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    public void checkArmorPiece(String type, int mobility, int resilience, int recovery,
                                int intellect, int discipline, int strength, ArmorPiece ap) {
        assertEquals(type, ap.getType());
        assertEquals(mobility, ap.getMobility());
        assertEquals(resilience, ap.getResilience());
        assertEquals(recovery, ap.getRecovery());
        assertEquals(intellect, ap.getIntellect());
        assertEquals(discipline, ap.getDiscipline());
        assertEquals(strength, ap.getStrength());
    }
}
