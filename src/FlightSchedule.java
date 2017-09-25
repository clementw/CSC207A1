import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FlightSchedule {
    public static void main(String[] args) throws IOException {
        ArrayList flights = new ArrayList();
        ArrayList airports = new ArrayList();
        ArrayList airports_added = new ArrayList();

        Path path = Paths.get("FlightList.txt");

        //read txt file
        try (BufferedReader fileInput = Files.newBufferedReader(path)) {
            String line = fileInput.readLine();
            while (line != null) {
                ArrayList airport_names = new ArrayList();

                // split string by flight number, date, and array of airports
                String[] split_orig = line.split("\\s", 3);
                String[] split_airports = split_orig[2].split("\\|");

                //initialize object Flight
                Flight f = new Flight(split_orig[0], split_orig[1]);

                //remove space before each airport and add to airport names list
                for (String s : split_airports) {
                    s = s.replace(" ", "");
                    if (!airport_names.contains(s)) {
                        airport_names.add(s);
                    }
                }

                //remove first null value in airport names list
                if (airport_names.size() != 0) {
                    airport_names.remove(0);

                    //add Airport object to airport list, add airport to Flight object
                    for (Object s : airport_names) {
                        if (airports_added.contains(s)) {
                            for (Object o : airports) {
                                if (((Airport) o).getName().equals(s)) {
                                    ((Airport) o).addFlight(f);
                                }
                            }
                        } else {
                            airports_added.add(s);
                            Airport a = new Airport(((String) s));
                            f.addAirport(a);
                            airports.add(a);
                        }
                    }
                }

                //add Flights object to flights list
                flights.add(f);

                line = fileInput.readLine();
            }
        }


        //start input process
        BufferedReader kbd = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the name of an airport.");
        String input = kbd.readLine();

        int in_lst = 0;
        Airport a = null;

        while (!input.equals("exit")) {
            if(airports_added.contains(input)){
                for (Object o : airports) {
                    if (input.equals(((Airport) o).getName())) {
                        in_lst = 1;
                        a = ((Airport) o);
                        break;
                    }
                }
            }


            if (in_lst == 0) {
                System.out.println("This is not a valid airport.");
            } else {
                System.out.println((a.toString()));
                System.out.println("Enter the name of an airport.");
            }
            input = kbd.readLine();
            in_lst = 0;
        }

    }
}