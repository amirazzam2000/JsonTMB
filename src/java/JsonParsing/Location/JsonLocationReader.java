package JsonParsing.Location;

import DataModel.LocationData.Hotel;
import DataModel.LocationData.Location;

import DataModel.LocationData.Monument;
import DataModel.LocationData.Restaurant;
import Managers.Location.*;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonLocationReader {

    /**
     * Parse the information from the location json file and store them in the location manger
     *
     * @return   an array of all the locations contained in the location.json file stored in the resources folder
     * */
    public static LocationManager readLocations(){
        LocationManager locations = new LocationManager();
        Location auxLocation ;
        JsonReader jsonReader ;
        try {
            // read the information inside the json file and store them in Gson Element
            jsonReader = new JsonReader(new FileReader("src/resources/location.json"));
            JsonParser parser = new JsonParser();
            JsonElement gson = parser.parse(jsonReader);

            // taking the information out of the Gson element and storing them in a json object
            JsonObject json = gson.getAsJsonObject();

                // read each location in the json object and store it in its corresponding class
                for (JsonElement jsonObject: json.getAsJsonObject().get("locations").getAsJsonArray()) {
                    float[] coordinates = new float[2];
                    coordinates[0] = jsonObject.getAsJsonObject().get("coordinates").getAsJsonArray().get(0).getAsFloat();
                    coordinates[1] = jsonObject.getAsJsonObject().get("coordinates").getAsJsonArray().get(1).getAsFloat();

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

                    locations.add(auxLocation);

                }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return  locations;
    }



}
