package DataModel.TransportationData.StopData;

import java.util.Comparator;

/**
 *
 * Class: java.DataModel.TransportationData.StopData.Line
 *
 * <p>This class store the information of a bus line that stops at a specific
 * stop, offering the ability to compare it with other bus lines that stop at
 * the same stop.
 * <p></p>
 * Furthermore, it allows us to read and modify the information of each line.
 * <p></p>
 * This class is used to know the bus wait time at a specific stop, so each
 * object of this class will store the id of the stop and the name of the bus
 * line, then it will have the time left for this this bus to arrive at the
 * stop in minutes.
 * <p></p>
 * This class fills its attributes with information using the class
 * {@link JsonParsing.Transportation.JsonLineReader} .
 * This class implements the {@link Comparator} interface in order to be able
 * to sort the different bus lines that stop at the specified station
 * according to their time left to arrive at the stop.
 * <p>
 * In order to do that the class implements the method <b>compare</b> that
 * compares two bus lines according to their TimeLeftMin.
 * <p></p>
 * This class also has two constructing methods, one default constructing
 * method that does not take any parameters and initializes all attributes,
 * and another copy constructor that take another object form the class
 * {@link Line} and constructs a new {@link Line} object with the same
 * information.
 * <p></p>
 * Additionally, this class has getters and setters for all attributes so it
 * would be possible to fill the attributes with information, and print it
 * when needed
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
