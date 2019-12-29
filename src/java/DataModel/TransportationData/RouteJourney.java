package DataModel.TransportationData;

public class RouteJourney {
    String destination;
    float time;
    int distance;
    String mode;



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

    public RouteJourney(){

    }
    public RouteJourney(RouteJourney journey) {
        this.destination = journey.destination;
        this.time = journey.time;
        this.distance = journey.distance;
        this.mode = journey.mode;
    }
}
