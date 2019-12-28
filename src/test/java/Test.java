import API.WebManager;
import JsonParsing.Location.JsonLocationReader;
import JsonParsing.Transportation.JsonStationReader;

public class Test {
    public static void main(String[] args) {

        String JsonString;
        JsonLocationReader.readLocations();
        JsonString = WebManager.callAllStations();
        if (JsonString != null)
            JsonStationReader.readStations(JsonString);
    }
}
