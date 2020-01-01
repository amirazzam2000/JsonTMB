package API;

import DataModel.TransportationData.Route;

public interface Webservice {

    String callAllStations();

    String callAllStops();

    String callRoute(Route route);

    String callLine(String line);
}
