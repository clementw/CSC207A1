import java.util.ArrayList;
import java.util.Collections;

public class Airport {
    private String name;
    private ArrayList flights;

    public Airport(String name) {
        this.name = name;
        this.flights = new ArrayList();
    }

    public String getName() {
        return name;
    }

    public String toString() {
        String s = name;
        String f = "";
        int fs = flights.size();
        if (flights != null && fs != 0) {
            f += ((Flight) flights.get(0)).getName();

            for (int i = 1; i < flights.size(); i++) {
                f = f + ", " + ((Flight) flights.get(i)).getName();
            }
        }

        return s + " (" + f + ")";
    }

    public boolean equals(Airport a) {
        ArrayList f1 = this.flights;
        ArrayList f2 = a.getFlights();

        return this.name.equals(a.getName()) && f1.equals(f2);
    }

    public boolean wasVisitedBy(Flight f) {
        return f.getAirports().contains(this);
    }


    public boolean onSameFlight(Airport a) {
        for (Object f1 : this.getFlights()) {
            for (Object f2 : this.getFlights()) {
                if (f1 == f2) {
                    return true;
                }
            }
        }
        return false;
    }

    public void addFlight(Flight f) {
        flights.add(f);
        if (!f.getAirports().contains(this)) {
            f.addAirport(this);
        }
    }

    public ArrayList getFlights() {
        return flights;
    }

//    public int compare(Airport a, Airport a1){
//        return
//    }
}


