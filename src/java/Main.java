import API.WebManager;
import JsonParsing.Location.JsonLocationReader;
import JsonParsing.Transportation.JsonStationReader;
import System.MainSystem;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        MainSystem mainSystem = new MainSystem();
        try {
            JsonLocationReader.readLocations();
            mainSystem.mainSystem();
        } catch (FileNotFoundException e) {
            System.out.println("Error: Can lunch the program. " + System.lineSeparator() +
                    "the location.Json file was not found");
        }
    }
}
