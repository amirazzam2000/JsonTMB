package DataModel.TransportationData;

import java.util.Comparator;

public class Station implements Comparator<Station> {
    double[] coordinates;
    String stationName;
    String stationId;
    String Date;
    String lineName;
    double distance;
    String locationName;

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Station(Station that) {
        this.coordinates = that.coordinates;
        this.stationName = that.stationName;
        this.stationId = that.stationId;
        this.Date = that.Date;
        this.lineName = that.lineName;
        this.distance = that.distance;
        this.locationName = that.locationName;
    }
    public Station(){
        coordinates = new double[2];
        stationName = null;
        stationId = null;
        Date = null;
        lineName = null;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    @Override
    public int compare(Station o1, Station o2) {
        return (int) (o1.getDistance() * 1000 - o2.getDistance() * 1000 );
    }
}
