package DataModel.TransportationData.RouteData;

/**
 *
 * Class: java.DataModel.TransportationData.RouteData.Route
 *
 * <br/>Stores all the information about one Journey, the origin and
 * destination, along side other secondary information that is important to
 * define a journey and make it specific.
 * <br/>This class allows us to modify and read the information stored in a
 * journey
 *
 * @author Amir Azzam - amir.azzam@students.salle.url.edu
 * @author <br/>Nicole Alexa leser - nicolealexa.leser@students.salle.url.edu
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
        this.destination = journey.destination;
        this.time = journey.time;
        this.distance = journey.distance;
        this.mode = journey.mode;
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
