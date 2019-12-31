package DataModel.TransportationData;

import java.util.ArrayList;

public class Itinerary {
    private ArrayList<RouteJourney> journeys;
    private int duration;
    private float maxWalkDistance;

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

    public Itinerary(ArrayList<RouteJourney> journeys) {
        this.journeys = journeys;
    }
    public Itinerary(){
        journeys = new ArrayList<>();
    }

    public void add(RouteJourney journey){
        journeys.add(journey);
    }

    public ArrayList<RouteJourney> getJourneys() {
        return journeys;
    }

    public void setJourneys(ArrayList<RouteJourney> journeys) {
        this.journeys = journeys;
    }
}
