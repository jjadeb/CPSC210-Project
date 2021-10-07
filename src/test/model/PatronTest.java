package model;

import model.People.Patron;
import model.Shows.Show;
import model.Theatre.Theatre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatronTest {

    Patron bob;
    Patron shirley;
    Show cabaret;
    Show crazyForYou;
    Theatre Massey;

    @BeforeEach

    public void setUp() {
        bob = new Patron();
        cabaret = new Show();
        crazyForYou = new Show();
        cabaret.setTitle("Cabaret");
        crazyForYou.setTitle("Crazy For You");
    }

    @Test

    public void makePatronTest() {
        bob.setBirthday(012304);
        bob.setName("Bob");
        assertEquals("Bob", bob.getName());
        assertEquals(012304, bob.getBirthday());
    }

    @Test
    public void addShowsToPatronTest() {
        bob.addShow(cabaret);
        bob.addShow(crazyForYou);
        bob.addShow(cabaret);

        assertEquals(3, bob.myUpcomingShowSize());
        assertTrue(bob.isContainedInMyUpcomingShows(cabaret));
        assertTrue(bob.isContainedInMyUpcomingShows(crazyForYou));

    }

    @Test
    public void removeShowsFromPatronTest() {
        bob.addShow(cabaret);
        bob.addShow(crazyForYou);
        bob.addShow(cabaret);

        bob.removeShow(cabaret);
        bob.removeShow(cabaret);

        assertEquals(1, bob.myUpcomingShowSize());
        assertEquals(2, bob.myPastShowSize());
        assertFalse(bob.isContainedInMyUpcomingShows(cabaret));
        assertTrue(bob.isContainedInMyUpcomingShows(crazyForYou));
        assertTrue(bob.isContainedInMyPastShows(cabaret));
        assertTrue(bob.getMyShows().isContainedInPast(cabaret));

    }

    @Test
    public void myUpcomingShowNamesTest() {
        assertTrue(bob.myUpcomingShowNames().isEmpty());

        bob.addShow(cabaret);
        bob.addShow(crazyForYou);

        assertTrue(bob.myUpcomingShowNames().contains("Cabaret"));
        assertTrue(bob.myUpcomingShowNames().contains("Crazy For You"));

    }

}