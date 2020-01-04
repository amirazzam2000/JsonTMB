package DataModel.TransportationData.RouteData;

import JsonParsing.Transportation.JsonRouteReader;
import System.MainSystem;
import java.util.ArrayList;

/**
 *
 * Class: java.DataModel.TransportationData.RouteData.Route
 *
 * <p>This class stores the information of one route with all its different
 * itineraries. This class has two types of data, ones that required by
 * the TMB API in order to request a route, and the rest are what we store
 * form the API’s response which is a list of all the itineraries that
 * connects the origin with the destination.
 * <p></p>
 * The information of this class will be filled both by the
 * {@link JsonRouteReader} class, and by the user’s input in the
 * {@link MainSystem} class.
 * <p></p>
 * This class offers one default constructor with no attributes that will
 * create an empty Route with all its attributes initialized, and another
 * copy constructor that takes a Route in its parameter and create a copy of
 * it.
 * <p></p>
 * Moreover, this class offers setters and getters to all the attributes
 * which allows us to save the user’s input in the {@link MainSystem}, and it
 * has method called <b>addItineraries</b> (which takes an {@link Itinerary}
 * as a parameter, and adds it to the list of itineraries this route can
 * have) and this method will allow us to save the API’s response in
 * {@link JsonRouteReader}.
 * <p></p>
 * <p></p>
 * Moreover, this class has one more method which is used to choose which
 * itinerary should be picked as the best itinerary in the itineraries list.
 * this method picks the itinerary that takes the least amount of time, and its
 * walking distance is within the max walking limit distance assigned by the
 * user.
 *
 * @author Amir Azzam - amir.azzam@students.salle.url.edu
 * @author <p>Nicole Alexa leser - nicolealexa.leser@students.salle.url.edu
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

    /**
     * gets the position of the itinerary that takes the least amount of time
     * to connect origin with destination and is within the max walking
     * distance
     * @param maxWalkingDistance the makes walking distance specified by the
     *                           user
     * @return an integer representing the position of the chosen itinerary
     * form the itineraries array
     */
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
