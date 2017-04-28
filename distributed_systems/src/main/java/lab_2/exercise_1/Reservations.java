package lab_2.exercise_1;
//import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Reservations {
    private Map<String, Integer> clients;
    private int availability, initial_availability;
    
    Reservations(int available_tickets) {
        this.availability = available_tickets;
        this.initial_availability = available_tickets;
        clients = // Collections.synchronizedMap(
            new HashMap<String, Integer>();
        //);
    }

    public synchronized int book(String id) {
        if (availability > 0) {
            clients.put(id, initial_availability - availability + 1);
            availability--;
        }
        return clients.getOrDefault(id, 0);
    }

}