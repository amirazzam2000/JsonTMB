package DataModel.TransportationData;

import java.util.ArrayList;

public class Route {
    private String origin;
    private String destination;
    private char DepartureOrArrival;
    private String day;
    private String hour;
    private float maxWalkingDistance;
    private ArrayList<Itinerary> itineraries;

    public Route(String origin, String destination, char departureOrArrival, String day, String hour, float maxWalkingDistance, ArrayList<Itinerary> itineraries) {
        this.origin = origin;
        this.destination = destination;
        DepartureOrArrival = departureOrArrival;
        this.day = day;
        this.hour = hour;
        this.maxWalkingDistance = maxWalkingDistance;
        this.itineraries = itineraries;
    }

    public Route() {
        this.origin = null;
        this.destination = null;
        this.day = null;
        this.hour = null;
        this.maxWalkingDistance = 0;
        itineraries = new ArrayList<>();
    }

    public void addItineraries(Itinerary itinerary){
        itineraries.add(itinerary);
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
        return DepartureOrArrival;
    }

    public void setDepartureOrArrival(char departureOrArrival) {
        DepartureOrArrival = departureOrArrival;
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
