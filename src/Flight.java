import java.util.ArrayList;

public class Flight {
    private String name;
    private ArrayList airports;
    private String date;

    public Flight(String name, String date) {
        this.name = name;
        this.date = date;
        this.airports = new ArrayList();
    }

    public String toString() {
        String ls = System.lineSeparator();
        String s = name + ", " + date;
        if(airports != null && airports.size() != 0){
            for(int i = 0;i<airports.size();i++){
                s = s + ls + ((Airport) airports.get(i)).getName();
            }
        }
        return s;
    }

    public String getName() {
        return name;
    }

    public ArrayList getAirports() {
        return airports;
    }

    public String getDate() {
        return date;
    }

    public boolean equals(Flight f) {
        return this.name.equals(f.getName()) && this.date.equals(f.getDate());
    }

    public boolean wasVisitedBy(Airport a) {
        return airports.contains(a);
    }

    public void addAirport(Airport a) {
        airports.add(a);
        if(!a.getFlights().contains(this)){
            a.addFlight(this);
        }
    }
}
