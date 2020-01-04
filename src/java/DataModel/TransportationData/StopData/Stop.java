package DataModel.TransportationData.StopData;

import java.util.Comparator;

/**
 *
 * Class: java.DataModel.TransportationData.StopData.Stop
 *
 * <p>This class stores all the information about a stop and offers the
 * ability to read, change and compare this information with the information
 * of other stop.
 * <p></p>
 * This class stores information when the user selects the option to show all
 * the stops and stations around their favorite locations.
 * <p></p>
 * it stores the the favorite location Coordinates, name,
 * and the distance from that favorite location to relate the station to its
 * favorite location nearby.
 * <p></p>
 * However, it also store the Stop code, Date of creation, and Stop name
 * which are needed to identify the stop and when printing its information.
 * <p></p>
 * The information of this class is filled by {@link JsonParsing.Transportation.JsonStopsReader}
 * class, after filtering the information it receives from the TMB API.
 * <p></p>
 * This class implements the {@link Comparator} interface, so it implements the
 * method <b>compare</b> to be able to compare two stops that share the same
 * near favorite location, and it compares them according to their distance
 * from that common favorite location.
 * <p></p>
 * This feature is then used by the class {@link DataModel.UserData.User} in
 * order to sort the array of stops the user has.
 * <p></p>
 * This class also has two constructing methods, one default constructing
 * method that does not take any parameters and initializes all attributes,
 * and another copy constructor that take another object form the class
 * {@link Stop} and constructs a new {@link Stop} object with the same
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
public class Stop implements Comparator<Stop> {
    private float[] coordinates;
    private String stopName;
    private String stopId;
    private String date;
    private double distance;
    private String locationName;

    /**
     * constructs an empty Stop with all of its attributes initialized
     */
    public Stop(){
        coordinates = new float[2];
        stopName = null;
        stopId = null;
        date = null;
    }

    /**
     * constructs a Stop using the information of another Stop(creates a copy
     * of the stop specified in the parameter )
     * @param that the stop to be copied
     */
    public Stop(Stop that) {
        this.coordinates = that.coordinates;
        this.stopName = that.stopName;
        this.stopId = that.stopId;
        this.date = that.date;
        this.distance = that.distance;
        this.locationName = that.locationName;
    }

    /**
     * compares two stops according to their distance from a specific location
     * @param o1 the first stop to be compared
     * @param o2 the second stop to be compared
     * @return a positive integer if the second stop is closer,
     *         a negative integer if the first stop is closer,
     *         a zero if both distances are equal
     */
    @Override
    public int compare(Stop o1, Stop o2) {
        return (int)(o1.getDistance() * 1000 - o2.getDistance() * 1000);        // we multiply the distance by 1000 in order to have more accurate results
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
}
