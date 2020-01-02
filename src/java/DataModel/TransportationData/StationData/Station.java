package DataModel.TransportationData.StationData;

import java.util.Comparator;

/**
 *
 * Class: java.DataModel.TransportationData.StationData.Station
 *
 * <br/>Stores all the information about a specific Station and offers the
 * ability to read, change and compare this information with the information
 * of other stations.<br/>
 * this class implements the {@link Comparator} interface in order to be able
 * to sort objects from this class if needed.<br/>
 *
 * @author Amir Azzam - amir.azzam@students.salle.url.edu
 * @author <br/>Nicole Alexa leser - nicolealexa.leser@students.salle.url.edu
 * @version 29/12/2019
 *
 *
 */
public class Station implements Comparator<Station> {
    private double[] coordinates;
    private String stationName;
    private String stationId;
    private String Date;
    private String lineName;
    private double distance;
    private String locationName;

    /**
     * construct an empty station with all the attributes initialized
     */
    public Station(){
        coordinates = new double[2];
        stationName = null;
        stationId = null;
        Date = null;
        lineName = null;
    }

    /**
     * constructs a station using the information of another station (creates
     * a copy from the other station)
     * @param that the station to be copied
     */
    public Station(Station that) {
        this.coordinates = that.coordinates;
        this.stationName = that.stationName;
        this.stationId = that.stationId;
        this.Date = that.Date;
        this.lineName = that.lineName;
        this.distance = that.distance;
        this.locationName = that.locationName;
    }

    /**
     * compares two stations according to their distance form a specific
     * location.
     * @param o1 the first station to be compared
     * @param o2 the second station to be compared
     * @return a positive integer if the second station is closer,
     *         a negative integer if the first station is closer,
     *         a zero if both distances are equal
     */
    @Override
    public int compare(Station o1, Station o2) {
        return (int) (o1.getDistance() * 1000 - o2.getDistance() * 1000 );      // we multiply the distance by 1000 in order to have more accurate results
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
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
}
