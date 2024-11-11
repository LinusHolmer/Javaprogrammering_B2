package adventureTest;

import adventure.model.Burglar;
import adventure.model.Resident;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntityAttackTest {

    private Resident resident;
    private Burglar burglar;

    @BeforeEach
    public void setUp() {
        resident = new Resident();
        burglar = new Burglar();
    }

    @Test
    public void testAttack() {
        // Resident punches Burglar
        resident.attack(burglar);

        // Check that Burglar's health has decreased by Resident's damage
        assertEquals(9, burglar.getHealth(), "Burglar's health should be reduced by Resident's damage");
    }
}
