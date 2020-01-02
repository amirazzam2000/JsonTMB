package DataModel.LocationData;

public class FavLocation {
    String type;
    Location location;
    double latitude;
    double longitude;

    public FavLocation(String type, Location location) {
        this.type = type;
        this.location = location;
        this.latitude = location.getLatitude();
        this.longitude = location.getLongitude();
    }

    public boolean containLocation(Location location){
        return location.getName().compareToIgnoreCase(this.location.getName()) == 0 && location.getLatitude() == this.latitude && location.getLongitude() == this.longitude ;
    }
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }



}
