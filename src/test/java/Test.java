import API.WebManager;
import DataModel.LocationData.FavLocation;
import DataModel.TransportationData.Route;
import DataModel.TransportationData.Station;
import DataModel.TransportationData.Stop;
import JsonParsing.Location.JsonLocationReader;
import JsonParsing.Transportation.JsonRouteReader;
import JsonParsing.Transportation.JsonStationReader;
import JsonParsing.Transportation.JsonStopsReader;

import java.util.ArrayList;

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

       // System.out.println( JsonStationReader.calculateDifference(41.408013, 2.130027,41.418278, 2.140972 ));
        String JsonString;
        JsonString = WebManager.callAllStations();
        ArrayList<Station> stations;
        if (JsonString != null);
            //stations = JsonStationReader.readFavStations(JsonString,41.408385, 2.130064);
        JsonString = WebManager.callAllStops();
        ArrayList<Stop> stops;
        if (JsonString != null);
           // stops = JsonStopsReader.readFavStops(JsonString,41.408385, 2.130064);

    }
}
/*
* 41.408013, 2.130027
* Plaça Catalunya
* 12-30-2019
* 12:00pm
*
*41.408385, 2.130064
* */
