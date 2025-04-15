package pl.edu.agh.to.lab4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrisonerDataProviderTest {

    private PrisonersDataProvider prisonersDatabase = new PrisonersDataProvider();

    @Test
    public void testThereAreThreeJails() {
        assertEquals(3, prisonersDatabase.getAllPrisons().size());
    }
}
