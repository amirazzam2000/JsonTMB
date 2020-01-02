package DataModel.TransportationData.StopData;

import java.util.Comparator;

/**
 *
 * Class: java.DataModel.TransportationData.StopData.Stop
 *
 * <p>Stores all the information about a specific Stop and offers the
 * ability to read, change and compare this information with the information
 * of other Stop.<p>
 * this class implements the {@link Comparator} interface in order to be able
 * to sort objects from this class if needed.<p>
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
