package JsonParsing.Transportation;

import DataModel.LocationData.FavLocation;
import DataModel.TransportationData.StationData.Station;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;

public class JsonStationReader {

    /**
     * Parse the information from the Station json String that the API returns and store them in the Station manger
     *
     * @return   an array of all the Stations contained in the Station String returned by the API
     * */
    public static ArrayList<Station> readFavStations(String input, FavLocation location){
        ArrayList<Station> stations = new ArrayList<>();
        Station auxStation = new Station();
        JsonElement json = JsonParser.parseString(input);
        JsonObject jsonStations = json.getAsJsonObject();

        for (JsonElement jStation: jsonStations.getAsJsonArray("features")) {
            double[] coordinates = new double[2];
            if (jStation.getAsJsonObject().has("geometry")){
                coordinates[1] =
                        jStation.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray().get(0).getAsDouble();
                coordinates[0] =
                        jStation.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray().get(1).getAsDouble();
            }
            if (calculateDifference(location.getLatitude(), location.getLongitude() ,  coordinates[0], coordinates[1]) < 0.5) {
                auxStation.setCoordinates(coordinates);
                auxStation.setDistance(calculateDifference(location.getLatitude(), location.getLongitude(),  coordinates[0], coordinates[1]));
                auxStation.setLocationName(location.getLocation().getName());
                if (jStation.getAsJsonObject().get("properties").getAsJsonObject().has("NOM_ESTACIO")) {
                    auxStation.setStationName(jStation.getAsJsonObject().get("properties").getAsJsonObject().get("NOM_ESTACIO").getAsString());
                }
                if (jStation.getAsJsonObject().get("properties").getAsJsonObject().has("CODI_ESTACIO")) {
                    auxStation.setStationId(jStation.getAsJsonObject().get("properties").getAsJsonObject().get("CODI_ESTACIO").getAsString());
                }
                if (jStation.getAsJsonObject().get("properties").getAsJsonObject().has("DATA_INAUGURACIO")) {
                    auxStation.setDate(jStation.getAsJsonObject().get("properties").getAsJsonObject().get("DATA_INAUGURACIO").getAsString());
                }
                if (jStation.getAsJsonObject().get("properties").getAsJsonObject().has("PICTO")) {
                    auxStation.setLineName(jStation.getAsJsonObject().get("properties").getAsJsonObject().get("PICTO").getAsString());
                }
                if (!stations.contains(auxStation))
                    stations.add(new Station(auxStation));
            }
        }


        return stations;
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


    public static ArrayList<Station> readInauguratedStations(String input, int year){
        ArrayList<Station> stations = new ArrayList<>();
        Station auxStation = new Station();
        JsonElement json = JsonParser.parseString(input);
        JsonObject jsonStations = json.getAsJsonObject();


        for (JsonElement jStation: jsonStations.getAsJsonArray("features")) {
            String date;
            int auxYear = 0;
            if (jStation.getAsJsonObject().get("properties").getAsJsonObject().has("DATA_INAUGURACIO")) {
                date = (jStation.getAsJsonObject().get("properties").getAsJsonObject().get("DATA_INAUGURACIO").getAsString());
                auxYear = Integer.parseInt(date.substring(0,4));
            }

            if (year == auxYear) {

                double[] coordinates = new double[2];
                if (jStation.getAsJsonObject().has("geometry")){
                    coordinates[1] = jStation.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray().get(0).getAsFloat();
                    coordinates[0] = jStation.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray().get(1).getAsFloat();
                    auxStation.setCoordinates(coordinates);
                }
                if (jStation.getAsJsonObject().get("properties").getAsJsonObject().has("NOM_ESTACIO")) {
                    auxStation.setStationName(jStation.getAsJsonObject().get("properties").getAsJsonObject().get("NOM_ESTACIO").getAsString());
                }
                if (jStation.getAsJsonObject().get("properties").getAsJsonObject().has("CODI_LINIA")) {
                    auxStation.setStationId(jStation.getAsJsonObject().get("properties").getAsJsonObject().get("CODI_LINIA").getAsString());
                }

                if (jStation.getAsJsonObject().get("properties").getAsJsonObject().has("PICTO")) {
                    auxStation.setLineName(jStation.getAsJsonObject().get("properties").getAsJsonObject().get("PICTO").getAsString());
                }
                if (!stations.contains(auxStation))
                    stations.add(new Station(auxStation));
            }
        }


        return stations;
    }
}
