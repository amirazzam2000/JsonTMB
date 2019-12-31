package JsonParsing.Transportation;

import DataModel.TransportationData.Itinerary;
import DataModel.TransportationData.Route;
import DataModel.TransportationData.RouteJourney;
import JsonParsing.ParsingExceptions.RouteExceptions.RouteExceptions;
import JsonParsing.ParsingExceptions.RouteExceptions.RouteOutOfReach;
import JsonParsing.ParsingExceptions.RouteExceptions.RouteWrongParameter;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonRouteReader {

    public static Route readRoute(String input) throws RouteOutOfReach, RouteWrongParameter {
        Route route = new Route();
        JsonElement json = JsonParser.parseString(input);
        JsonObject jsonRoute = json.getAsJsonObject();
        if (jsonRoute.has("error")){
            if (jsonRoute.get("error").getAsString().compareToIgnoreCase("No trip found. There may be no transit service within the maximum specified distance or at the specified time, or your start or end point might not be safely accessible.") == 0)
                throw new RouteOutOfReach("TMB is doing its best to make the bus and subway make this route in the future.");
            else
                throw new RouteWrongParameter("Error, there is some wrong parameter :(");
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
