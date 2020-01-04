package DataModel.LocationData;


/**
 *
 * Class: java.DataModel.LocationData.Location
 *
 * <p>
 * This class stores the information of a general location, and offers the
 * ability to read and change this information.
 * <p>
 * the information in this class is filled using the {@link JsonParsing.Location.JsonLocationReader} class,
 * or the {@link DataModel.UserData.User} class when a user create a new
 * location. Moreover, this is the generic location there is
 * subclasses, that inherit from this class, that have more attributes to
 * store  more specific information about the location.
 * <p>
 * <p></p>
 * The methods this class offers are basically three constructors  (one
 * default constructor, two constructors with parameters; one with
 * coordinates as an array of two numbers of type double, the other one is
 * with  latitude and longitude separated ), this class also offers setters
 * and  getters to all the attributes it has as we want to be able to read,
 * and  modify this information in the future.
 *
 * @author Amir Azzam - amir.azzam@students.salle.url.edu
 * @author <p>Nicole Alexa leser - nicolealexa.leser@students.salle.url.edu
 * @version 27/12/2019
 *
 * @see Managers.Location.LocationManager
 */
public class Location {
    private String name ;
    private double[] coordinates;
    private String description;


    /**
     * Default constructor in order to initialize all the locations's
     * attributes before starting to use them
     */
    public Location(){
        name = null;
        coordinates = new double[2];
        description = null;
    }

    /**
     * constructs a location with the information specified in the parameters
     * @param name the name of the location to be created
     * @param coordinates the coordinates of the location to be created
     * @param description the discription of the location to be created
     */
    public Location(String name, double[] coordinates, String description) {
        this.name = name;
        this.coordinates = coordinates;
        this.description = description;
    }

    /**
     * construct a location with the information specified in the parameters
     * (the coordinates are introduced separately )
     * @param name the name of the location to be created
     * @param longitude the longitude of the location to be created
     * @param latitude the lataitude of the location to be created
     * @param description the description of the location to be created
     */
    public Location(String name, float longitude, float latitude , String description) {
        this.name = name;
        this.coordinates = new double[2];
        this.coordinates[0] = latitude;
        this.coordinates[1] = longitude;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public double getLatitude() {
        return coordinates[0];
    }

    public double getLongitude() {
        return coordinates[1];
    }

    public void setLatitude(float latitude) {
        this.coordinates[0] = latitude;
    }

    public void setLongitude(float longitude) {
        this.coordinates[1] = longitude;
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
