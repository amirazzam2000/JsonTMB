import API.WebManager;
import JsonParsing.Location.JsonLocationReader;
import JsonParsing.Transportation.JsonStationReader;

public class Test {
    public static void main(String[] args) {

        String stationJson;
        JsonLocationReader.readLocations();
        stationJson = WebManager.callAllStations();
        if (stationJson != null)
            JsonStationReader.readStations(stationJson);
    }
}
