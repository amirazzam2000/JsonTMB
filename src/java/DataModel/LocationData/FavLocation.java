package DataModel.LocationData;


/**
 *
 * Class: java.DataModel.LocationData.FavLocation
 *
 *
 * This class stores a location that the user has assigned as one of their
 * favorite locations, a favorite location consists of a location and a type.
 * The location will be from the datatype {@link Location}, whereas the type is a
 * {@link String} that specifies the type of the location stored.
 *  <p></p>
 *  the information of this class will be filled in the MainSystem.
 * The FavLocation class has only one constructor that takes a {@link Location}
 * and a {@link String}, representing the type of the location, and creates a
 * FavLocation with that location and that type. Moreover, this class also
 * offers a method called <b>containLocation</b> which takes a
 * {@link Location} in its parameter and compare it to the location stored
 * in the FavLocation that called this method, it returns a {@link Boolean}
 * that will be <code>true</code> if the two locations are the same, and
 * <code>false</code> if not.
 * <p></p>
 * However, this class offers setters and getters to access and modify its
 * attributes which we use in the MainSystem in order to give the user the
 * possibility to edit their favorite location's type. In other words, if the
 * user assign a location as their favorite location, then they try to assign
 * the same place as their favorite location again, the will not be able to,
 * but they will be able to change the <code>type</code> of their already
 * assigned favorite location
 *
 * @author Amir Azzam - amir.azzam@students.salle.url.edu
 * @author <p>Nicole Alexa leser - nicolealexa.leser@students.salle.url.edu
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
