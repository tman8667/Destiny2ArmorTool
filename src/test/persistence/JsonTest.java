package persistence;

import model.ArmorPiece;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    public void checkArmorPiece(String type, int mobility, int resilience, int recovery,
                                int intellect, int discipline, int strength, ArmorPiece ap) {
        assertEquals(type, ap.getType());
        assertEquals(mobility, ap.getWeapons());
        assertEquals(resilience, ap.getHealth());
        assertEquals(recovery, ap.getClassability());
        assertEquals(intellect, ap.getSuperability());
        assertEquals(discipline, ap.getGrenade());
        assertEquals(strength, ap.getMelee());
    }
}
