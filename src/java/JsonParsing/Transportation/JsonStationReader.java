package JsonParsing.Transportation;

import DataModel.LocationData.FavLocation;
import DataModel.TransportationData.RouteData.Route;
import DataModel.TransportationData.StationData.Station;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;

/**
 *
 * Class: java.JsonParsing.Transportation.JsonStationReader
 *
 * <p>This class reads the response of the TMB API when requested to send the
 * all the Stations supported by TMB. The response is sent from the {@link API}
 * module to this class as a Json String
 * <p></p>
 * The class does not store any information but it has three methods, two of
 * them reads the response of the API, the only difference between the two
 * methods is the way they filter the information in the json String. One
 * method returns all the stations that are within 0.5Km radios from a
 * specified favorite location, while the other one returns the stations that
 * were inaugurated on the birth year of the user.
 * <p></p>
 * And the third method calculates the distance between two locations knowing
 * their coordinates in the <i>EPSG: 4326 coordinates system</i>.
 *
 * @author Amir Azzam - amir.azzam@students.salle.url.edu
 * @author <p>Nicole Alexa leser - nicolealexa.leser@students.salle.url.edu
 * @version 27/12/2019
 *
 * @see Station
 */
public class JsonStationReader {

    /**
     * Parse the information from the Station json String that the API returns
     *
     * @param input   Json string containing all the information about the
     *                stations supported by TMB
     * @param location the favorite location that will be as a reference
     *                 point in order to decide which stations are going to be
     *                 picked
     * @return   an array of all the Stations contained in the Json String
     * that are within the distance limit from the reference location
     * */
    public static ArrayList<Station> readFavStations(String input, FavLocation location){
        ArrayList<Station> stations = new ArrayList<>();
        Station auxStation = new Station();

        // read the Json string and save it in a Json element
        JsonElement json = JsonParser.parseString(input);
        JsonObject jsonStations = json.getAsJsonObject();

        // for each station check how far is it from the reference favorite
        // location and add it to the list if it's within the distance limit
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


    /**
     * gets all the stations that were built in the specified year
     * @param input Json string containing all the information about the
     *              stations supported by TMB
     * @param year the year in which the currently-registered user was born
     *           in.
     * @return all stations build on the reference year
     */
    public static ArrayList<Station> readInauguratedStations(String input, int year){
        ArrayList<Station> stations = new ArrayList<>();
        Station auxStation = new Station();

        // read the Json string and save it in a Json element
        JsonElement json = JsonParser.parseString(input);
        JsonObject jsonStations = json.getAsJsonObject();

        //for each station check if it was built in the reference year and
        // add it to the stations list
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
