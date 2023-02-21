package organiser;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

/*
 * This Organiser class is the main class for the organiser package.
 * It has the functionality to create, modify, fetch and delete events.
 */
public class Organiser {
    
    //Here Array of Organisable is used to store all the events
    public static ArrayList<Organisable> events = new ArrayList<Organisable>();

    public void createWorkshop(String name, String description, String location, String date, String time,
            String duration, int capacity) throws Exception {
        events.add(new Workshop(name, description, location, date, time, duration, capacity));
    }
    
    public void createWorkshop(String name, String location, String date, String time,
            String duration, int capacity) throws Exception {
        events.add(new Workshop(name, location, date, time, duration, capacity));
    }

    public void createConference(String name, String description, String location, String date, String time,
            String duration, int capacity) throws Exception {
        events.add(new Conference(name, description, location, date, time, duration, capacity));
    }

    public void createConference(String name, String location, String date, String time,
            String duration, int capacity) throws Exception {
        events.add(new Conference(name, location, date, time, duration, capacity));
    }

    public void deleteEvent(String name) {
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getName().equals(name)) {
                events.remove(i);
            }
        }
    }

    public ArrayList<Organisable> getEvents() {
        return events;
    }

    public ArrayList<Organisable> getWorkshops() {
        ArrayList<Organisable> workshops = new ArrayList<Organisable>();
        for (Organisable event : events) {
            if (event instanceof Workshop) {
                workshops.add(event);
            }
        }
        return workshops;
    }

    public ArrayList<Organisable> getConferences() {
        ArrayList<Organisable> conferences = new ArrayList<Organisable>();
        for (Organisable event : events) {
            if (event instanceof Conference) {
                conferences.add(event);
            }
        }
        return conferences;
    }

    public ArrayList<Organisable> getEventsByDate(String date) {
        ArrayList<Organisable> eventsByDate = new ArrayList<Organisable>();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        for (Organisable event : events) {
            String eventDate = df.format(event.getDate());
            if (eventDate.equals(date)) {
                eventsByDate.add(event);
            }
        }
        return eventsByDate;
    }

    public ArrayList<Organisable> getEventsByLocation(String location) {
        ArrayList<Organisable> eventsByLocation = new ArrayList<Organisable>();
        for (Organisable event : events) {
            if (event.getLocation().equals(location)) {
                eventsByLocation.add(event);
            }
        }
        return eventsByLocation;
    }

    public ArrayList<Organisable> getUpcomingWorkshops() {
        ArrayList<Organisable> upcomingWorkshops = new ArrayList<Organisable>();
        for (Organisable event : events) {
            if (event instanceof Workshop && event.getDate().after(new Date())) {
                upcomingWorkshops.add(event);
            }
        }
        return upcomingWorkshops;
    }

    public ArrayList<Organisable> getUpcomingConferences() {
        ArrayList<Organisable> upcomingConferences = new ArrayList<Organisable>();
        for (Organisable event : events) {
            if (event instanceof Conference && event.getDate().after(new Date())) {
                upcomingConferences.add(event);
            }
        }
        return upcomingConferences;
    }

    public void bookWorkshop(String name, String regNo) throws Exception {
        for (Organisable event : events) {
            if (event.TYPE.equals("Workshop") && event.getName().equals(name)) {
                event.book(regNo);
                break;
            }
        }
    }

    public void bookConference(String name, String regNo) throws Exception {
        for (Organisable event : events) {
            if (event.TYPE.equals("Conference") && event.getName().equals(name)) {
                event.book(regNo);
                break;
            }
        }
    }

    public void showAttendees(String name) {
        for (Organisable event : events) {
            if (event.getName().equals(name)) {
                event.showAttendees();
                break;
            }
        }
    }
}
