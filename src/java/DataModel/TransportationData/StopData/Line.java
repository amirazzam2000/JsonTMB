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
public class Line implements Comparator<Line>{
    String destination;
    String lineName;
    int timeLeftMin;
    String stopId;

    /**
     * constructs an empty Line
     */
    public Line(){}

    /**
     * constructs a Line from the information of another Line(creates a copy
     * of the Line specified in the parameter)
     * @param that the Line to be copied
     */
    public Line(Line that) {
        this.destination = that.destination;
        this.lineName = that.lineName;
        this.timeLeftMin = that.timeLeftMin;
        this.stopId =  that.stopId;
    }

    /**
     * compares two Line according to how much time left for the Line to
     * arrive at the station
     * @param o1 the first Line to be compared
     * @param o2 the second Line to be compared
     * @return a positive integer if the second Line will come sooner,
     *         a negative integer if the first Line will come sooner,
     *         a zero if both times are equal
     */
    @Override
    public int compare(Line o1, Line o2) {
        return (o1.timeLeftMin - o2.timeLeftMin);
    }

    public String getStopId() {
        return stopId;
    }

    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public int getTimeLeftMin() {
        return timeLeftMin;
    }

    public void setTimeLeftMin(int timeLeftMin) {
        this.timeLeftMin = timeLeftMin;
    }
}
