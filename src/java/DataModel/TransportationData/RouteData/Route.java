package DataModel.TransportationData.RouteData;

import java.util.ArrayList;

/**
 *
 * Class: java.DataModel.TransportationData.RouteData.Route
 *
 * <br/>Stores all the information about a specific route, with all the different
 * possible itineraries. <br/>This class also offers the ability to Modify,
 * and read the information of a route.
 *
 * @author Amir Azzam - amir.azzam@students.salle.url.edu
 * @author <br/>Nicole Alexa leser - nicolealexa.leser@students.salle.url.edu
 * @version 27/12/2019
 *
 * @see Itinerary
 */
public class Route {
    private String origin;
    private String originName;
    private String destination;
    private String destinationName;
    private char departureOrArrival;
    private String day;
    private String hour;
    private float maxWalkingDistance;
    private ArrayList<Itinerary> itineraries;


    /**
     * construct a rout out of the information of another route(creates a
     * copy of the other route)
     * @param route the route to be copied
     */
    public Route(Route route) {
        this.origin = route.origin;
        this.originName = route.originName;
        this.destination = route.destination;
        this.destinationName = route.destinationName;
        this.departureOrArrival = route.departureOrArrival;
        this.day = route.day;
        this.hour = route.hour;
        this.maxWalkingDistance = route.maxWalkingDistance;
        this.itineraries = route.itineraries;
    }

    /**
     * constructs an empty route with all the attributes initialized
     */
    public Route() {
        this.origin = null;
        this.originName = null;
        this.destination = null;
        this.destinationName = null;
        this.day = null;
        this.hour = null;
        this.maxWalkingDistance = 0;
        itineraries = new ArrayList<>();
    }

    /**
     * adds an itinerary to the route's itineraries
     * @param itinerary the itinerary be added
     */
    public void addItineraries(Itinerary itinerary){
        itineraries.add(itinerary);
    }

    public int getShortestRoute(float maxWalkingDistance){
        int i = 0;
        int shortest = Integer.MAX_VALUE;
        int time ;
        for (int j = 0; j < itineraries.size() ; j++) {
            time = 0;
            for (RouteJourney journey: itineraries.get(j).getJourneys()) {
                time += journey.getTime();
            }
            if (time < shortest && itineraries.get(j).getMaxWalkDistance() <= maxWalkingDistance){
                shortest = time;
                i = j;
            }
        }

        return i;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public ArrayList<Itinerary> getItineraries() {
        return itineraries;
    }

    public void setItineraries(ArrayList<Itinerary> itineraries) {
        this.itineraries = itineraries;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public char getDepartureOrArrival() {
        return departureOrArrival;
    }

    public void setDepartureOrArrival(char departureOrArrival) {
        this.departureOrArrival = departureOrArrival;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public float getMaxWalkingDistance() {
        return maxWalkingDistance;
    }

    public void setMaxWalkingDistance(float maxWalkingDistance) {
        this.maxWalkingDistance = maxWalkingDistance;
    }
}
