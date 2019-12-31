package DataModel.TransportationData;

import java.util.Comparator;

public class Stop implements Comparator<Stop> {
    float[] coordinates;
    String stopName;
    String stopId;
    String date;
    double distance;
    String locationName;

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Stop(Stop that) {
        this.coordinates = that.coordinates;
        this.stopName = that.stopName;
        this.stopId = that.stopId;
        this.date = that.date;
        this.distance = that.distance;
        this.locationName = that.locationName;
    }

    public Stop(){
        coordinates = new float[2];
        stopName = null;
        stopId = null;
        date = null;
    }
    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public float[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(float[] coordinates) {
        this.coordinates = coordinates;
    }

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    public String getStopId() {
        return stopId;
    }

    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int compare(Stop o1, Stop o2) {
        return (int)(o1.getDistance() * 1000 - o2.getDistance() * 1000);
    }
}
