import java.util.ArrayList;

public class Flight {
    String ls = System.lineSeparator();
    private String name;
    private ArrayList airports;
    private String date;

    public Flight(String name, String date) {
        this.name = name;
        this.date = date;
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

    public String toString() {
        String s = name + ", " + date;
        if(airports.size() != 0){
            s += ls;
            for(int i = 0;i<airports.size();i++){
                s = s + airports.get(i) + ls;
            }
        }
        return "";
    }

    public boolean equals(Airport f) {
        return false;
    }

    public boolean wasVisitedBy(Airport f) {
        if(airports.contains(f)){
            return true;
        }

        return false;
    }

    public boolean onSameFlight(Airport f) {
        return false;
    }

    public void addAirport(Airport f) {
        airports.add(f);
    }
}
