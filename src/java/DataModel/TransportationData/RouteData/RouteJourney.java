package DataModel.TransportationData.RouteData;

import JsonParsing.Transportation.JsonRouteReader;

/**
 *
 * Class: java.DataModel.TransportationData.RouteData.Route
 *
 * <p>This class stores all the information about one Journey (the origin and
 * destination, alongside other secondary information that is important to
 * define a journey and make it specific).
 * <p></p>
 * A Journey is a part of one itinerary, so it’s a sub-Route that connects
 * two points.
 * <p></p>
 * this class stores the id of the station or the stop if the
 * origin is one, and it stores if the way to get from the origin to the
 * destination is Walking or Transit (by metro or bus) …etc.
 * <p></p>
 * Moreover,it stores the bus/metro line code if exist, or null otherwise.
 * <p></p>
 * The information of this class is filled by {@link JsonRouteReader}, with the
 * response of the TMB API after requesting a Route with valid parameters.
 *
 * This class have two constructors one is the default constructor with no
 * attributes, the other one is a copy constructor that takes a
 * {@link RouteJourney} as a parameter and creates a copy of it.
 * <p></p>
 * It also offers setters and getters for all attributes in order to add the
 * information into the class and to read them when needed.
 *
 * @author Amir Azzam - amir.azzam@students.salle.url.edu
 * @author <p>Nicole Alexa leser - nicolealexa.leser@students.salle.url.edu
 * @version 27/12/2019
 *
 * @see Itinerary
 */
public class RouteJourney {
    private String origin;
    private String stopCode;
    private String destination;
    private float time;
    private int distance;
    private String mode;
    private String lineOrStreet;

    /**
     * constructs an empty journey
     */
    public RouteJourney(){
    }

    /**
     * constructs a journey using the information of another journey(creates
     * a copy of the Journey specified in the parameter)
     * @param journey the journey to be copied
     */
    public RouteJourney(RouteJourney journey) {
        this.origin = journey.origin;
        this.stopCode = journey.stopCode;
        this.destination = journey.destination;
        this.time = journey.time;
        this.distance = journey.distance;
        this.mode = journey.mode;
        this.lineOrStreet = journey.lineOrStreet;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getLineOrStreet() {
        return lineOrStreet;
    }

    public void setLineOrStreet(String lineOrStreet) {
        this.lineOrStreet = lineOrStreet;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }


    public String getStopCode() {
        return stopCode;
    }

    public void setStopCode(String stopCode) {
        this.stopCode = stopCode;
    }
}
