package JsonParsing.Transportation;

import DataModel.TransportationData.RouteData.Itinerary;
import DataModel.TransportationData.RouteData.Route;
import DataModel.TransportationData.RouteData.RouteJourney;
import JsonParsing.ParsingExceptions.RouteExceptions.RouteOutOfReach;
import JsonParsing.ParsingExceptions.RouteExceptions.RouteWrongParameter;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 *
 * Class: java.JsonParsing.Transportation.JsonRouteReader
 *
 * <br/>Parse the Route information form a Json String
 *
 * @author Amir Azzam - amir.azzam@students.salle.url.edu
 * @author <br/>Nicole Alexa leser - nicolealexa.leser@students.salle.url.edu
 * @version 27/12/2019
 *
 * @see Route
 */
public class JsonRouteReader {
    /**
     * reads the route information returned from the API in the format of a
     * Json string
     *
     * @param input a Json string containing all the information about the
     *              route with all the possible itineraries to get from the
     *              origin to the destination
     * @return a route with all possible itineraries that connects the origin
     *         to the destination
     * @throws RouteOutOfReach if the TMP company doesn't reach one of the
     *                         specified places (origin / destination)
     * @throws RouteWrongParameter if there is any parameter that is mal
     *                          formatted or has a wrong value
     */
    public static Route readRoute(String input) throws RouteOutOfReach, RouteWrongParameter {
        Route route = new Route();
        // read the Json string and save it in a Json element
        JsonElement json = JsonParser.parseString(input);
        JsonObject jsonRoute = json.getAsJsonObject();

        // check if the returning result of the API is correct or if there
        // was any error in the process

        if (jsonRoute.has("error")){
            if (jsonRoute.get("error").getAsString().compareToIgnoreCase("No trip found. There may be no transit service within the maximum specified distance or at the specified time, or your start or end point might not be safely accessible.") == 0)
                throw new RouteOutOfReach("TMB is doing its best to make the bus and subway make this route in the future.");
            else
                throw new RouteWrongParameter("Error, there is some wrong parameter :(");
        }
        else{
            // read the information of each of the itineraries
            for (JsonElement itinerary: jsonRoute.get("plan").getAsJsonObject().get("itineraries").getAsJsonArray()) {
                Itinerary auxItinerary = new Itinerary();
                auxItinerary.setDuration(itinerary.getAsJsonObject().get("duration").getAsInt());

                if (itinerary.getAsJsonObject().has("walkDistance"))
                    auxItinerary.setMaxWalkDistance(itinerary.getAsJsonObject().get("walkDistance").getAsFloat());
                for (JsonElement leg: itinerary.getAsJsonObject().get("legs").getAsJsonArray()) {
                    RouteJourney auxJourney = new RouteJourney();
                    if (leg.getAsJsonObject().get("to").getAsJsonObject().has(
                            "name"))
                        auxJourney.setDestination(leg.getAsJsonObject().get("to").getAsJsonObject().get("name").getAsString());
                    if (leg.getAsJsonObject().get("from").getAsJsonObject().has("name"))
                        auxJourney.setOrigin(leg.getAsJsonObject().get("from").getAsJsonObject().get("name").getAsString());

                    if (leg.getAsJsonObject().get("from").getAsJsonObject().has("stopCode"))
                        auxJourney.setStopCode(leg.getAsJsonObject().get("from").getAsJsonObject().get("stopCode").getAsString());
                    else
                        auxJourney.setStopCode(null);
                    if ( leg.getAsJsonObject().has("distance"))
                        auxJourney.setDistance( leg.getAsJsonObject().get("distance").getAsInt());
                    if (leg.getAsJsonObject().has("duration"))
                        auxJourney.setTime(leg.getAsJsonObject().get("duration").getAsInt());
                    if (leg.getAsJsonObject().has("mode"))
                        auxJourney.setMode(leg.getAsJsonObject().get("mode").getAsString());
                    if(leg.getAsJsonObject().has("route"))
                         auxJourney.setLineOrStreet(leg.getAsJsonObject().get("route").getAsString());

                    auxItinerary.add(auxJourney);
                }

                route.addItineraries(auxItinerary);
            }
        }
        return route;
    }
}
