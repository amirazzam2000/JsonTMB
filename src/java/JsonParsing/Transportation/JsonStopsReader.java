package JsonParsing.Transportation;

import DataModel.LocationData.FavLocation;
import DataModel.TransportationData.*;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;

public class JsonStopsReader {
    public static ArrayList<Stop> readFavStops(String input, FavLocation location){
        ArrayList<Stop> stop = new ArrayList<>();
        Stop auxStop = new Stop();

        JsonElement json = JsonParser.parseString(input);
        JsonObject jsonStations = json.getAsJsonObject();


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
