package DataModel.TransportationData.RouteData;

import JsonParsing.Transportation.JsonRouteReader;

import java.util.ArrayList;

/**
 *
 * Class: java.DataModel.TransportationData.RouteData.Itinerary
 *
 * <p>This class stores the information of one itinerary with all of its
 * journeys.
 * <p></p>
 * it stores the total duration of the itinerary (to get from the origin to the
 * destination) and its maximum walking distance as we will need them to
 * decide on the best itinerary in a specific {@link Route}.
 * <p></p>
 * However, it also have an array of Journeys of type {@link RouteJourney}
 * and it stores the information about a full journey, including the metro
 * lines and buses you have to take …etc.
 * <p></p>
 * The information of this class is filled by {@link JsonRouteReader}, with the
 * response of the TMB API after requesting a Route with valid parameters.
 * <p></p>
 * Furthermore, this class offers only the default constructor with no
 * parameters, this constructor initializes all the attributes.
 * Also, it offers a method called <b>add</b> that adds objects from type
 * {@link RouteJourney} to the journeys array. Moreover, this class has
 * getters and setters to insert information into the attributes and to get
 * it when needed.
 * <p></p>
 *
 * @author Amir Azzam - amir.azzam@students.salle.url.edu
 * @author <p>Nicole Alexa leser - nicolealexa.leser@students.salle.url.edu
 * @version 27/12/2019
 *
 * @see Route
 * @see RouteJourney
 */
public class Itinerary {
    private ArrayList<RouteJourney> journeys;
    private int duration;
    private float maxWalkDistance;

    /**
     * constructs an empty itinerary with all of it's attributes initialized
     */
    public Itinerary(){
        journeys = new ArrayList<>();
    }

    /**
     * adds one journey to the itinerary, as one itinerary is made up of
     * multiple journeys.
     * @param journey the journey to be added
     */
    public void add(RouteJourney journey){
        journeys.add(journey);
    }

    public float getMaxWalkDistance() {
        return maxWalkDistance;
    }

    public void setMaxWalkDistance(float maxWalkDistance) {
        this.maxWalkDistance = maxWalkDistance;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public ArrayList<RouteJourney> getJourneys() {
        return journeys;
    }

    public void setJourneys(ArrayList<RouteJourney> journeys) {
        this.journeys = journeys;
    }
}
