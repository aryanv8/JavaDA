package organiser;

/*
 * Here the Conference class extends the Organisable class.
 * The inheritance is used here.
 */
public class Conference extends Organisable {
    Conference(String name, String description, String location, String date, String time, String duration, int capacity) throws Exception {
        super(name, description, location, date, time, duration, capacity);
        TYPE = "Conference";
    }
    Conference(String name, String location, String date, String time, String duration, int capacity) throws Exception {
        super(name, location, date, time, duration, capacity);
        TYPE = "Conference";
    }
}