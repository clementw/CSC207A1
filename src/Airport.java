import java.util.ArrayList;

public class Airport {
    private String name;
    private ArrayList flights;

    public Airport(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "";
    }

    public boolean equals(Flight f) {
        return false;
    }

    public boolean wasVisitedBy(Flight f) {
        return false;
    }

    public boolean onSameFlight(Airport f) {
        return false;
    }

    public void addFlight(Flight f) {
        flights.add(f);
    }





}


