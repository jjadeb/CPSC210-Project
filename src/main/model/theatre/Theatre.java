package model.theatre;

import model.people.Patron;
import model.people.PatronList;
import model.shows.Show;
import model.shows.ShowList;

import java.util.ArrayList;

//Represents a theatre that hosts shows
public class Theatre {


    String name;
    PatronList patrons;
    ShowList shows;


    public Theatre() {
        patrons = new PatronList();
        shows = new ShowList();
        name = "";


    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //MODIFIES: this
    //EFFECTS: Adds a show to the upcoming show list
    public void addNewShow(Show show) {
        shows.addNewShow(show);
    }

    //REQUIRES: Show must not be in the past show list
    //MODIFIES: this
    //EFFECTS: Moves a show from the upcoming show list to the past show list
    public void archiveShow(Show show) {
        shows.archive(show);
    }

    //MODIFIES: this
    //EFFECTS: Adds a patron to the list of theatre patrons
    public void addNewPatron(Patron patron) {
        patrons.addNewPatron(patron);
    }

    //MODIFIES: this
    //EFFECTS: Removes a patron from the list of theatre patrons
    public void removePatron(Patron patron) {
        patrons.removePatron(patron);
    }


    //EFFECTS: Checks to see if a patron is in the patron list
    public boolean isContainsPatron(Patron patron) {
        return patrons.contains(patron);
    }

    //EFFECTS: Returns the size of the patron list
    public int patronSize() {
        return patrons.getSize();
    }

    //EFFECTS: Checks to see if a show is in the upcoming show list
    public boolean isUpcomingShow(Show show) {
        return shows.isContainedInUpcoming(show);
    }

    //EFFECTS: Checks to see if a show is in the past show list
    public boolean isPastShow(Show show) {
        return shows.isContainedInPast(show);
    }

    //EFFECTS: Returns the size of the upcoming show list
    public int upcomingShowSize() {
        return shows.getUpcomingShowsSize();
    }

    //EFFECTS: Returns the size of the past show list
    public int pastShowSize() {
        return shows.getPastShowsSize();
    }

    //EFFECTS: Returns the names of upcoming shows
    public ArrayList<String> getUpcomingShowNames() {
        return shows.getUpcomingShowNames();
    }

    //EFFECTS: Returns  upcoming shows
    public ArrayList<Show> getUpcomingShows() {
        return shows.getUpcomingShows();
    }

    //EFFECTS: Retrieves patron from theatre list
    public Patron getPatron(String name, Integer birthday) {
        Patron find = null;
        for (Patron patron : patrons.getPatronList()) {
            if (patron.getName().equals(name) && (patron.getBirthday() == birthday)) {
                find = patron;
            }
        }
        return find;
    }
}


//    public Iterator<Show> showIterator() {
//        return shows.getUpcomingShows().iterator();
//    }

//    public Iterator<Patron> patronIterator() {
//        return patrons.getPatronList().iterator();
//    }
//}