package DataModel.TransportationData.RouteData;

import java.util.ArrayList;

/**
 *
 * Class: java.DataModel.TransportationData.RouteData.Itinerary
 *
 * <br/>stores all the information about a route's itinerary. This class also
 * allows us to read and modify the information of the itinerary.
 *
 * @author Amir Azzam - amir.azzam@students.salle.url.edu
 * @author <br/>Nicole Alexa leser - nicolealexa.leser@students.salle.url.edu
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
