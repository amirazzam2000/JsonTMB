package DataModel.TransportationData;

public class Station {
    float[] coordinates;
    String stationName;
    long stationId;
    String Date;
    String lineName;

    public Station(float[] coordinates, String stationName, long stationId, String date, String lineName) {
        this.coordinates = coordinates;
        this.stationName = stationName;
        this.stationId = stationId;
        Date = date;
        this.lineName = lineName;
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

    public long getStationId() {
        return stationId;
    }

    public void setStationId(long stationId) {
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
