import API.WebManager;
import DataModel.TransportationData.Route;
import JsonParsing.Location.JsonLocationReader;
import JsonParsing.Transportation.JsonStationReader;

public class Test {
    public static void main(String[] args) {
        Route route = new Route();
        route.setOrigin("41.3755204,2.1498870");
        route.setDestination("41.422520,2.187824");
        route.setDay("12-29-2019");
        route.setHour("11:58am");
        route.setDepartureOrArrival('d');
        route.setMaxWalkingDistance((float) 300);

        String JsonString;
        JsonString = WebManager.callRoute(route);
        System.out.println(JsonString);
    }
}
