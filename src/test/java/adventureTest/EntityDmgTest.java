package adventureTest;

import adventure.model.Resident;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntityDmgTest {

    private Resident resident;

    @BeforeEach
    public void setUp() {
        resident = new Resident();
    }

    @Test
    public void testTakeHit() {
        resident.takeDamage(5);
        assertEquals(7, resident.getHealth(), "residents health borde minska med 5");

        resident.takeDamage(5);
        assertEquals(2, resident.getHealth(), "residents health borde minska med 5");

        resident.takeDamage(10);
        assertEquals(0, resident.getHealth(), "residents health borde inte gå under 0");
    }
}
