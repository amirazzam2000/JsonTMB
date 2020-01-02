package DataModel.LocationData;


/**
 *
 * Class: java.DataModel.LocationData.Location
 *
 * <br/>Stores all the information about a specific location and offers the
 * ability to read and change this information
 *
 * @author Amir Azzam - amir.azzam@students.salle.url.edu
 * @author <br/>Nicole Alexa leser - nicolealexa.leser@students.salle.url.edu
 * @version 27/12/2019
 *
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
