package DataModel.TransportationData.StationData;

import DataModel.TransportationData.StopData.Stop;

import java.util.Comparator;

/**
 *
 * Class: java.DataModel.TransportationData.StationData.Station
 *
 * <p>This class stores all the information about a station and offers the
 * ability to read, change and compare this information with the information
 * of other station.
 * <p></p>
 * This class stores information when the user selects the option to show all
 * the stops and stations around their favorite locations.
 * <p></p>
 * it stores the the favorite location Coordinates, name,
 * and the distance from that favorite location to relate the station to its
 * favorite location nearby.
 * <p></p>
 * However, it also store the Station code, Date of creation, and Station name
 * which are needed to identify the station and when printing its information.
 * <p></p>
 * The information of this class is filled by
 * {@link JsonParsing.Transportation.JsonStationReader}
 * class, after filtering the information it receives from the TMB API.
 * <p></p>
 * This class implements the {@link Comparator} interface, so it implements the
 * method <b>compare</b> to be able to compare two stations that share the same
 * near favorite location, and it compares them according to their distance
 * from that common favorite location.
 * <p></p>
 * This feature is then used by the class {@link DataModel.UserData.User} in
 * order to sort the array of stations the user has.
 * <p></p>
 * This class also has two constructing methods, one default constructing
 * method that does not take any parameters and initializes all attributes,
 * and another copy constructor that take another object form the class
 * {@link Station} and constructs a new {@link Station} object with the same
 * information.
 * <p></p>
 * Moreover, it has getters and setters, for all attributes, that are used
 * when filling the object with the information or while printing it.
 *
 * @author Amir Azzam - amir.azzam@students.salle.url.edu
 * @author <p>Nicole Alexa leser - nicolealexa.leser@students.salle.url.edu
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
