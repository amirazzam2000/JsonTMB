package JsonParsing.Transportation;

import DataModel.TransportationData.Itinerary;
import DataModel.TransportationData.Route;
import DataModel.TransportationData.RouteJourney;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonRouteReader {

    public static Route readRoute(String input){
        Route route = new Route();
        JsonElement json = JsonParser.parseString(input);
        JsonObject jsonRoute = json.getAsJsonObject();
        if (jsonRoute.has("error")){
            return null; // convert to exception
        }
        else{
            for (JsonElement itinerary: jsonRoute.get("plan").getAsJsonObject().get("itineraries").getAsJsonArray()) {
                Itinerary auxItinerary = new Itinerary();
                auxItinerary.setDuration(itinerary.getAsJsonObject().get("duration").getAsInt());
                for (JsonElement leg: itinerary.getAsJsonObject().get("legs").getAsJsonArray()) {
                    RouteJourney auxJourney = new RouteJourney();
                    auxJourney.setDestination(leg.getAsJsonObject().get("to").getAsJsonObject().get("name").getAsString());
                    auxJourney.setOrigin(leg.getAsJsonObject().get("from").getAsJsonObject().get("name").getAsString());
                    if (leg.getAsJsonObject().get("from").getAsJsonObject().has("stopCode"))
                        auxJourney.setStopCode(leg.getAsJsonObject().get("from").getAsJsonObject().get("stopCode").getAsString());
                    else
                        auxJourney.setStopCode(null);
                    auxJourney.setDistance( leg.getAsJsonObject().get("distance").getAsInt());
                    auxJourney.setTime(leg.getAsJsonObject().get("duration").getAsInt());
                    auxJourney.setMode(leg.getAsJsonObject().get("mode").getAsString());
                    auxJourney.setLineOrStreet(leg.getAsJsonObject().get("route").getAsString());

                    auxItinerary.add(auxJourney);
                }

                route.addItineraries(auxItinerary);
            }
        }
        return route;
    }
}
