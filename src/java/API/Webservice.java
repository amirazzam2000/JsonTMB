package API;

import DataModel.TransportationData.RouteData.Route;

/**
 *
 * Class: java.API.WebManager
 *
 * <p>Structure the way the communication with the TMB API should be done.
 * <p>Defines the main methods that should be implemented in order to get the
 * information needed for this project.
 *
 * @author Amir Azzam - amir.azzam@students.salle.url.edu
 * @author <p>Nicole Alexa leser - nicolealexa.leser@students.salle.url.edu
 * @version 29/12/2019
 *
 */
public interface Webservice {

    /**
     * calls all the stations supported by the TMB API
     * @return a Json String with all the information the API returns
     */
    String callAllStations();

    /**
     * calls all the Bus stops supported by the TMB API
     * @return a Json String with all the information the API returns
     */
    String callAllStops();

    /**
     * calls the TMB API in order to get the route with all the possible
     * itineraries to connect the origin with the destination
     * @param route contains all the parameters needed to make the call to
     *              the API
     * @return a Json String with all the information the API returns
     */
    String callRoute(Route route);

    /**
     * calls the TMB API to get all the Bus Lines waiting time, considering only
     * the Bus lines that stop at the specified stop.
     * @param line the stop id of the requested stop
     * @return a Json String with all the information the API returns
     */
    String callLine(String line);
}
