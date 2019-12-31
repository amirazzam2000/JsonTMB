package DataModel.TransportationData;

public class Line {
    String destination;
    String lineName;
    int timeLeftMin;
    String stopId;

    public Line(){}
    public Line(Line that) {
        this.destination = that.destination;
        this.lineName = that.lineName;
        this.timeLeftMin = that.timeLeftMin;
        this.stopId =  that.stopId;
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
