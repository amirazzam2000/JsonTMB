package JsonParsing.Location;

import DataModel.LocationData.Hotel;
import DataModel.LocationData.Location;

import DataModel.LocationData.Monument;
import DataModel.LocationData.Restaurant;
import DataModel.TransportationData.StopData.Line;
import DataModel.TransportationData.StopData.Stop;
import Managers.Location.*;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *
 * Class: java.JsonParsing.Location.JsonLocationReader
 *
 * <p>This class reads the information stored in Location.json file, this
 * file contains four kinds of locations: Restaurants, Hotels, Monuments and
 * generic locations.
 * <p></p>
 * Note that for each kind of locations there is one corresponding class in
 * the {@link DataModel}.
 * <p></p>
 * This class does not store any data and only one static method that parse the
 * information from the json file. then, for each location in the file it
 * creates an object from its corresponding class {@link Location},
 * {@link Hotel}, {@link Restaurant}, or {@link Monument} and fills it with
 * the information of that location. afterwards, all of these locations are
 * added to the {@link LocationManager} which stores all the locations in
 * the system.
 * <p></p>
 *
 * @author Amir Azzam - amir.azzam@students.salle.url.edu
 * @author <p>Nicole Alexa leser - nicolealexa.leser@students.salle.url.edu
 * @version 27/12/2019
 *
 * @see Location
 */
public class JsonLocationReader {

    /**
     * Parse the information from the location json file and store them in the location manger
     *
     * @return   an array of all the locations contained in the location.json file stored in the resources folder
     * @throws FileNotFoundException if the file was not found or if the file
     * name is wrong
     *
     * */
    public static LocationManager readLocations() throws FileNotFoundException {
        LocationManager locations = new LocationManager();
        Location auxLocation ;
        JsonReader jsonReader ;

            // read the information inside the json file and store them in Gson Element
            jsonReader = new JsonReader(new FileReader("src/resources/location.json"));

            JsonElement gson = JsonParser.parseReader(jsonReader);

            // taking the information out of the Gson element and storing them in a json object
            JsonObject json = gson.getAsJsonObject();

                // read each location in the json object and store it in its corresponding class
                for (JsonElement jsonObject :json.getAsJsonObject().get("locations").getAsJsonArray()) {
                    double[] coordinates = new double[2];
                    coordinates[1] = jsonObject.getAsJsonObject().get(
                            "coordinates").getAsJsonArray().get(0).getAsDouble();
                    coordinates[0] = jsonObject.getAsJsonObject().get(
                            "coordinates").getAsJsonArray().get(1).getAsDouble();

                    // if the location has an "architect" then it's a Monument so, save it in the monument class
                    if (jsonObject.getAsJsonObject().has("architect")){
                        auxLocation = new Monument(jsonObject.getAsJsonObject().get("name").getAsString(),
                                coordinates,
                                    jsonObject.getAsJsonObject().get("description").getAsString(),
                                        jsonObject.getAsJsonObject().get("architect").getAsString(),
                                            jsonObject.getAsJsonObject().get("inauguration").getAsInt());
                    }

                    // if the location has "characteristics" then it's a Restaurant so, save it in the Restaurant class
                    else if (jsonObject.getAsJsonObject().has("characteristics")){
                        String[] characteristics = new String[jsonObject.getAsJsonObject().get("characteristics").getAsJsonArray().size()];
                        for (int i = 0 ; i < jsonObject.getAsJsonObject().get("characteristics").getAsJsonArray().size() ;i++){
                            characteristics[i] = jsonObject.getAsJsonObject().get("characteristics").getAsJsonArray().get(i).getAsString();
                        }
                        auxLocation = new Restaurant(jsonObject.getAsJsonObject().get("name").getAsString(),
                                coordinates,
                                    jsonObject.getAsJsonObject().get("description").getAsString(),
                                        characteristics);
                    }
                    // if the location has "stars" then it's a Hotel so, save it in the Hotel class
                    else if (jsonObject.getAsJsonObject().has("stars")){
                        auxLocation = new Hotel(jsonObject.getAsJsonObject().get("name").getAsString(),
                                coordinates,
                                    jsonObject.getAsJsonObject().get("description").getAsString(),
                                        jsonObject.getAsJsonObject().get("stars").getAsInt());
                    }
                    // if the location doesn't have any of the attributes mentioned before then it should be added as a location object
                    else{
                        auxLocation = new Location(jsonObject.getAsJsonObject().get("name").getAsString(),
                                coordinates,
                                    jsonObject.getAsJsonObject().get("description").getAsString());
                    }

                    LocationManager.add(auxLocation);

                }
        return  locations;
    }



}
