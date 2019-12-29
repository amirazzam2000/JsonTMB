package DataModel.TransportationData;

public class RouteJourney {
    String origin;
    String stopCode;


    String destination;
    float time;
    int distance;
    String mode;
    String lineOrStreet;

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

    public RouteJourney(){

    }
    public RouteJourney(RouteJourney journey) {
        this.destination = journey.destination;
        this.time = journey.time;
        this.distance = journey.distance;
        this.mode = journey.mode;
    }
}
