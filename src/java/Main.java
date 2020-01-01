import API.WebManager;
import JsonParsing.Location.JsonLocationReader;
import JsonParsing.Transportation.JsonStationReader;
import System.MainSystem;

public class Main {
    public static void main(String[] args) {
        JsonLocationReader.readLocations();
        MainSystem.mainSystem();
    }
}
