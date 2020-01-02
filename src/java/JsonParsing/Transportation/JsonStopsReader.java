package JsonParsing.Transportation;

import DataModel.LocationData.FavLocation;
import DataModel.TransportationData.StationData.Station;
import DataModel.TransportationData.StopData.Stop;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
/**
 *
 * Class: java.JsonParsing.Transportation.JsonStopsReader
 *
 * <p>Parse the Stop information form a Json String
 *
 * @author Amir Azzam - amir.azzam@students.salle.url.edu
 * @author <p>Nicole Alexa leser - nicolealexa.leser@students.salle.url.edu
 * @version 27/12/2019
 *
 * @see Stop
 */
public class JsonStopsReader {
    /**
     * Parse the information from the Stop json String that the API returns.
     * @param input Json string containing all the information about the
     *              stops supported by TMB
     * @param location  the favorite location that will be as a reference
     *                 point in order to decide which stops are going to be
     *                 picked
     * @return an array of all the stops contained in the Json String
     * that are within the distance limit from the reference location
     */
    public static ArrayList<Stop> readFavStops(String input, FavLocation location){
        ArrayList<Stop> stop = new ArrayList<>();
        Stop auxStop = new Stop();

        // read the Json string and save it in a Json element
        JsonElement json = JsonParser.parseString(input);
        JsonObject jsonStations = json.getAsJsonObject();

        // for each stop check how far is it from the reference favorite
        // location and add it to the list if it's within the distance limit
        for (JsonElement jStation: jsonStations.getAsJsonArray("features")) {
            float[] coordinates = new float[2];
            if (jStation.getAsJsonObject().has("geometry")){
                coordinates[1] = jStation.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray().get(0).getAsFloat();
                coordinates[0] = jStation.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray().get(1).getAsFloat();
            }
            if (calculateDifference(location.getLatitude(), location.getLongitude() ,  coordinates[0], coordinates[1]) < 0.5) {
                auxStop.setCoordinates(coordinates);
                auxStop.setDistance(calculateDifference(location.getLatitude(), location.getLongitude() ,  coordinates[0], coordinates[1]));
                auxStop.setLocationName(location.getLocation().getName());
                if (jStation.getAsJsonObject().get("properties").getAsJsonObject().has("NOM_PARADA")) {
                    auxStop.setStopName(jStation.getAsJsonObject().get("properties").getAsJsonObject().get("NOM_PARADA").getAsString());
                }
                if (jStation.getAsJsonObject().get("properties").getAsJsonObject().has("CODI_PARADA")) {
                    auxStop.setStopId(jStation.getAsJsonObject().get("properties").getAsJsonObject().get("CODI_PARADA").getAsString());
                }
                if (jStation.getAsJsonObject().get("properties").getAsJsonObject().has("DATA")) {
                    auxStop.setDate(jStation.getAsJsonObject().get("properties").getAsJsonObject().get("DATA").getAsString());
                }
                stop.add(new Stop(auxStop));
            }
        }


        return stop;
    }

    /**
     * calculates the distance between two locations on the map having there
     * coordinates written using the <i>EPSG: 4326</i> coordinate system
     *
     * @param lat1 latitude of the first location
     * @param lon1 longitude of the first location
     * @param lat2 latitude of the second location
     * @param lon2 longitude of the second location
     * @return the distance between the two locations measured in kilometers
     */
    public static double calculateDifference(double lat1, double lon1, double lat2 , double lon2){

        double R = 6371;
        double dLat =  (Math.PI / 180) * (lat2 - lat1);
        double dLon =  (Math.PI / 180) * (lon2 - lon1);

        double aux = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.cos((Math.PI / 180) * lat1) * Math.cos((Math.PI / 180) * lat2) *
                        Math.sin(dLon/2) * Math.sin(dLon/2);

        double aux2 = 2 * Math.atan2(Math.sqrt(aux), Math.sqrt(1-aux));
        return R * aux2;
    }
}
