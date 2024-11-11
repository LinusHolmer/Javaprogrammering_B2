package adventureTest;

import adventure.model.Burglar;
import adventure.model.Resident;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EntityIsConsciousTest {

    private Resident resident;
    private Burglar burglar;

    @BeforeEach
    public void setUp() {
        resident = new Resident();
        burglar = new Burglar();
    }

    @Test
    public void testIsConsciousReturnsTrue() {
        burglar.attack(resident);
        assertTrue(resident.isConscious(), "Resident borde vara medveten health > 0");
    }

    @Test
    public void testIsConsciousReturnsFalse() {
        burglar.attack(resident);
        burglar.attack(resident);
        burglar.attack(resident);


        assertFalse(resident.isConscious(), "Resident borde vara medvetslös med health <= 0");
    }
}
