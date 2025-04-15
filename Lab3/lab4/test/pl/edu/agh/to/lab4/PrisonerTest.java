package pl.edu.agh.to.lab4;

import org.junit.Test;

import static org.junit.Assert.*;

public class PrisonerTest {
    @Test
    public void testPrisonerIsInJail() {
        Prisoner news = new Prisoner("Jan", "Kowalski", "802104543357", 2011, 25);
        assertTrue(news.isJailedNow());
    }

    @Test
    public void testPrisonerHasBeenReleasedFromJail() {
        Prisoner news = new Prisoner("Jan", "Kowalski", "802104543357", 2008, 5);
        assertFalse(news.isJailedNow());
    }

    @Test
    public void testGetAge() {
        Prisoner news = new Prisoner("Janusz", "Zamkniety", "801104543357", 2010, 5);
        assertEquals(45, news.getAge());
    }
}
