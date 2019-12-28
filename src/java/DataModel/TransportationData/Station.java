package DataModel.TransportationData;

public class Station {
    float[] coordinates;
    String stationName;
    String stationId;
    String Date;
    String lineName;

    public Station(Station that) {
        this.coordinates = that.coordinates;
        this.stationName = that.stationName;
        this.stationId = that.stationId;
        this.Date = that.Date;
        this.lineName = that.lineName;
    }
    public Station(){
        coordinates = new float[2];
        stationName = null;
        stationId = null;
        Date = null;
        lineName = null;
    }

    public float[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(float[] coordinates) {
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
