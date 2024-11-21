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
        resident.attack(burglar);

        assertEquals(9, burglar.getHealth(), "Burglar's health should be reduced by Resident's damage");
    }
}
