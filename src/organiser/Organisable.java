/*
 * The organisable class is the base class for all events.
 * It contains all the common attributes of all events.
 */
package organiser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

// The interface OrganisableInterface is implemented by the Organisable class here
public class Organisable implements OrganisableInterface {
    //The attributes namely name, description, location, time, duration and TYPE are strings
    public String name; // also works as an ID
    public String description;
    public String location;
    public Date date;
    public String time;
    public String duration;
    public int capacity;

    public ArrayList<String> attendees = new ArrayList<String>();

    public String TYPE;

    public Organisable(String name, String description, String location, String date, String time, String duration, int capacity)
            throws Exception {
        this.name = name;
        this.description = description;
        this.location = location;
        this.time = time;
        this.duration = duration;
        this.capacity = capacity;
        SimpleDateFormat df = new SimpleDateFormat("HH:mm dd/MM/yyyy");
        this.date = df.parse(time + " " + date);
        TYPE = "Organisable";
    }

    //This constructor is overloaded to allow for the creation of events without a description
    public Organisable(String name, String location, String date, String time, String duration, int capacity)
            throws Exception {
        this.name = name;
        this.description = "not provided";
        this.location = location;
        this.time = time;
        this.duration = duration;
        this.capacity = capacity;
        SimpleDateFormat df = new SimpleDateFormat("HH:mm dd/MM/yyyy");
        this.date = df.parse(time + " "+date);
        TYPE = "Organisable";
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(String date) {
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
        // Here error handling is used to catch any exceptions that may occur
        try {
            this.date = df.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDuration() {
        return this.duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getAttendeesCount() {
        return attendees.size();
    }

    public int findInAttendees(String regNo) {
        for (int i = 0; i < attendees.size(); i++) {
            if (attendees.get(i).equals(regNo)) {
                return i;
            }
        }
        return -1;
    }

    public void book(String regNo) {
        if (attendees.size() >= capacity) {
            System.out.println("Sorry, the event is full.");
        } else if (findInAttendees(regNo) != -1) {
            System.out.println("Sorry, you have already booked this event.");
        } else {
            attendees.add(regNo);
            System.out.println("You have successfully booked this event.");
        }
    }

    public void showAttendees() {
        for (int i = 0; i < attendees.size(); i++) {
            System.out.println(attendees.get(i));
        }
    }
}
