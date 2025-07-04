package pl.edu.agh.to.lab4;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pl.edu.agh.to.lab4.providers.PersonDataProvider;
import pl.edu.agh.to.lab4.providers.PrisonersDataProvider;
import pl.edu.agh.to.lab4.search.NameSearchStrategy;
import pl.edu.agh.to.lab4.suspect.CracovCitizen;
import pl.edu.agh.to.lab4.suspect.Prisoner;
import pl.edu.agh.to.lab4.util.CompositeAggregate;
import pl.edu.agh.to.lab4.util.Finder;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FinderTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private PrintStream originalOut;

    private PersonDataProvider allPersons = new PersonDataProvider();

    private PrisonersDataProvider allPrisoners = new PrisonersDataProvider();

    private Finder suspectFinder;

    public FinderTest() {
        CompositeAggregate aggregate = new CompositeAggregate();
        aggregate.addAggregate(allPersons);
        aggregate.addAggregate(allPrisoners);
        this.suspectFinder = new Finder(aggregate);
    }

    @Test
    public void testDisplayingNotJailedPrisoner() {
        allPrisoners.findAll().clear();
        addPrisoner("Wiezeienie stanowe", new Prisoner("Jan", "Kowalski", "802104543357", 2000, 1));
        suspectFinder.display(new NameSearchStrategy("Jan"));
        assertContentIsDisplayed("Jan Kowalski");
    }

    @Test
    public void testDisplayingSuspectedPerson() {
        allPersons.getAllCracovCitizens().clear();
        allPersons.getAllCracovCitizens().add(new CracovCitizen("Jan", "Kowalski", 20));
        suspectFinder.display(new NameSearchStrategy("Jan"));
        assertContentIsDisplayed("Jan Kowalski");
    }

    @Test
    public void testNotDisplayingTooYoungPerson() {
        allPersons.getAllCracovCitizens().clear();
        allPersons.getAllCracovCitizens().add(new CracovCitizen("Jan", "Kowalewski", 15));
        suspectFinder.display(new NameSearchStrategy("Jan"));
        assertContentIsNotDisplayed("Jan Kowalewski");
    }

    @Test
    public void testNotDisplayingJailedPrisoner() {
        allPrisoners.findAll().clear();
        addPrisoner("Wiezeienie stanowe", new Prisoner("Jan", "Kowalski2", "802104543357", 2000, 26));
        suspectFinder.display(new NameSearchStrategy("Jan"));
        assertContentIsNotDisplayed("Jan Kowalski2");
    }

    private void assertContentIsDisplayed(String expectedContent) {
        assertTrue("Application did not contain expected content: " + outContent.toString(), outContent.toString()
                .contains(expectedContent));
    }

    private void assertContentIsNotDisplayed(String expectedContent) {
        assertFalse("Application did contain expected content although it should not: " + outContent.toString(), outContent.toString()
                .contains(expectedContent));
    }

    @Before
    public void redirectSystemOut() {
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void resetSystemOut() {
        System.setOut(originalOut);
    }

    private void addPrisoner(String category, Prisoner prisoner) {
        allPrisoners.findAll().computeIfAbsent(category, k -> new ArrayList<>()).add(prisoner);
    }
}
