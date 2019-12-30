import API.WebManager;
import DataModel.LocationData.FavLocation;
import DataModel.TransportationData.Route;
import JsonParsing.Location.JsonLocationReader;
import JsonParsing.Transportation.JsonRouteReader;
import JsonParsing.Transportation.JsonStationReader;

public class Test {
    public static void main(String[] args) {
/*        Route route = new Route();
        route.setOrigin("41.406449,2.168932");
        route.setDestination("41.432173,2.174134");
        route.setDay("12-30-2019");
        route.setHour("5:30pm");
        route.setDepartureOrArrival('d');
        route.setMaxWalkingDistance((float) 800);

        String JsonString;
        JsonString = WebManager.callRoute(route);
        System.out.println(JsonString);
        if (JsonString != null)
            JsonRouteReader.readRoute(JsonString);*/

        System.out.println( FavLocation.calculateDifference(41.408013, 2.130027,41.406850, 2.133705 ));
    }
}
/*
* 41.408013, 2.130027
* Plaça Catalunya
* 12-30-2019
* 12:00pm
*
* */
