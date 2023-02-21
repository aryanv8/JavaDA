package organiser;

/*
 * Here the Workshop class extends the Organisable class.
 * The inheritance is used here.
 */
public class Workshop extends Organisable {
    Workshop(String name, String description, String location, String date, String time, String duration, int capacity)
            throws Exception {
        super(name, description, location, date, time, duration, capacity);
        TYPE = "Workshop";
    }
    Workshop(String name, String location, String date, String time, String duration, int capacity)
            throws Exception {
        super(name, location, date, time, duration, capacity);
        TYPE = "Workshop";
    }
}
