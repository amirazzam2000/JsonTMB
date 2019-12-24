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

    public static LocationManager readLocations(){
        LocationManager locations = new LocationManager();
        Location auxLocation ;
        JsonReader jsonReader ;
        try {
            jsonReader = new JsonReader(new FileReader("src/resources/location.json"));

            JsonParser parser = new JsonParser();
            JsonElement gson = parser.parse(jsonReader);

            // taking the information out of the Gson element and storing them in a json element
            JsonObject json = gson.getAsJsonObject();

                for (JsonElement jsonObject: json.getAsJsonObject().get("locations").getAsJsonArray()) {
                    float[] coordinates = new float[2];
                    coordinates[0] = jsonObject.getAsJsonObject().get("coordinates").getAsJsonArray().get(0).getAsFloat();
                    coordinates[1] = jsonObject.getAsJsonObject().get("coordinates").getAsJsonArray().get(1).getAsFloat();

                    if (jsonObject.getAsJsonObject().has("architect")){
                        auxLocation = new Monument(jsonObject.getAsJsonObject().get("name").getAsString(),
                                coordinates,
                                    jsonObject.getAsJsonObject().get("description").getAsString(),
                                        jsonObject.getAsJsonObject().get("architect").getAsString(),
                                            jsonObject.getAsJsonObject().get("inauguration").getAsInt());
                    }
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
                    else if (jsonObject.getAsJsonObject().has("stars")){
                        auxLocation = new Hotel(jsonObject.getAsJsonObject().get("name").getAsString(),
                                coordinates,
                                    jsonObject.getAsJsonObject().get("description").getAsString(),
                                        jsonObject.getAsJsonObject().get("stars").getAsInt());
                    }
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
