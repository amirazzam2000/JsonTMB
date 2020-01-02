package DataModel.LocationData;


/**
 *
 * Class: java.DataModel.LocationData.FavLocation
 *
 * <br/>Stores all the information about the use's favorite locations and offers the
 * ability to read and change its information
 *
 * @author Amir Azzam - amir.azzam@students.salle.url.edu
 * @author <br/>Nicole Alexa leser - nicolealexa.leser@students.salle.url.edu
 * @version 27/12/2019
 *
 */
public class FavLocation {
    private String type;
    private Location location;
    private double latitude;
    private double longitude;

    /**
     * constructs a favorite location (FavLocation)
     * @param type the type of the favorite location
     * @param location contains all the location information
     * @see Location
     */
    public FavLocation(String type, Location location) {
        this.type = type;
        this.location = location;
        this.latitude = location.getLatitude();
        this.longitude = location.getLongitude();
    }

    /**
     * checks if the location specified in the parameter is equal to the
     * favorite location, by checking if they have the same name and
     * coordinates
     * @param location contains all the information of the location to be
     *                 checked.
     * @return true if they are the same, and false if they are not.
     */
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
