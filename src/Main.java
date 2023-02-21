import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.InputStreamReader;

import organiser.*;

public class Main {
    
    public static void display(ArrayList<Organisable> events) {
        if (events.size() == 0) {
            System.out.println("No events");
            return;
        }
        for (Organisable event : events) {
            System.out.println("Name: " + event.getName());
            System.out.println("\tDescription: " + event.getDescription());
            System.out.println("\tLocation: " + event.getLocation());
            System.out.println("\tDate: " + event.getDate());
            System.out.println("\tTime: " + event.getTime());
            System.out.println("\tDuration: " + event.getDuration());
            System.out.println("\tCapacity: " + event.getCapacity());
            System.out.println("\tAttendees: " + event.getAttendeesCount());
            System.out.println("\tType: " + event.TYPE);
        }
    }
    public static void main(String[] args) throws Exception {
        Organiser organiser = new Organiser();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int choice;
            System.out.println("1. Create Workshop");
            System.out.println("2. Create Conference");
            System.out.println("3. Delete Event");
            System.out.println("4. Display All Events");
            System.out.println("5. Display Workshops");
            System.out.println("6. Display Conferences");
            System.out.println("7. Book Workshop");
            System.out.println("8. Book Conference");
            System.out.println("9. See Attendees of an Event");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(br.readLine());
            switch (choice) {
                case 1:
                    System.out.print("Enter name of workshop: ");
                    String name = br.readLine();
                    System.out.print("Enter description: ");
                    String description = br.readLine();
                    System.out.print("Enter location: ");
                    String location = br.readLine();
                    System.out.print("Enter date: ");
                    String date = br.readLine();
                    System.out.print("Enter time: ");
                    String time = br.readLine();
                    System.out.print("Enter duration: ");
                    String duration = br.readLine();
                    System.out.print("Enter capacity: ");
                    int capacity = Integer.parseInt(br.readLine());
                    organiser.createWorkshop(name, description, location, date, time, duration, capacity);
                    break;
                case 2:
                    System.out.print("Enter name of conference: ");
                    name = br.readLine();
                    System.out.print("Enter description: ");
                    description = br.readLine();
                    System.out.print("Enter location: ");
                    location = br.readLine();
                    System.out.print("Enter date: ");
                    date = br.readLine();
                    System.out.print("Enter time: ");
                    time = br.readLine();
                    System.out.print("Enter duration: ");
                    duration = br.readLine();
                    System.out.print("Enter capacity: ");
                    capacity = Integer.parseInt(br.readLine());
                    organiser.createConference(name, description, location, date, time, duration, capacity);
                    break;
                case 3:
                    System.out.print("Enter name: ");
                    name = br.readLine();
                    organiser.deleteEvent(name);
                    break;
                case 4:
                    display(organiser.getEvents());
                    break;
                case 5:
                    display(organiser.getWorkshops());
                    break;
                case 6:
                    display(organiser.getConferences());
                    break;
                case 7:
                    System.out.print("Enter name workshop: ");
                    name = br.readLine();
                    System.out.print("Enter registration number: ");
                    String regNo = br.readLine();
                    organiser.bookWorkshop(name, regNo);
                    break;
                case 8:
                    System.out.print("Enter name of conference: ");
                    name = br.readLine();
                    System.out.print("Enter registration number: ");
                    regNo = br.readLine();
                    organiser.bookConference(name, regNo);
                    break;
                case 9:
                    System.out.print("Enter name of event: ");
                    name = br.readLine();
                    organiser.showAttendees(name);
                    break;
                case 10:
                    return;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}
