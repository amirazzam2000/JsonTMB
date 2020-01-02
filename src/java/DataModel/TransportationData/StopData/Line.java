package DataModel.TransportationData.StopData;

import java.util.Comparator;

/**
 *
 * Class: java.DataModel.TransportationData.StopData.Stop
 *
 * <br/>Stores all the information about a specific Stop and offers the
 * ability to read, change and compare this information with the information
 * of other Stop.<br/>
 * this class implements the {@link Comparator} interface in order to be able
 * to sort objects from this class if needed.<br/>
 *
 * @author Amir Azzam - amir.azzam@students.salle.url.edu
 * @author <br/>Nicole Alexa leser - nicolealexa.leser@students.salle.url.edu
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
     * @param that
     */
    public Line(Line that) {
        this.destination = that.destination;
        this.lineName = that.lineName;
        this.timeLeftMin = that.timeLeftMin;
        this.stopId =  that.stopId;
    }
//TODO: comment this
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
