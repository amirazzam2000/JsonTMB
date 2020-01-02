package DataModel.LocationData;


/**
 *
 * Class: java.DataModel.LocationData.Hotel
 *
 * <br/>Stores all the information about the hotel locations and offers the
 * ability to read and change this information
 *
 * @author Amir Azzam - amir.azzam@students.salle.url.edu
 * @author <br/>Nicole Alexa leser - nicolealexa.leser@students.salle.url.edu
 * @version 27/12/2019
 * @see DataModel.LocationData.Location
 */
public class Hotel extends Location {
    private int stars;

    /**
     * constructs a hotel with the information specified in the parameters
     * @param name the name of the hotel to be created
     * @param coordinates the coordinates of the hotel to be created
     * @param description the description of the hotel to be created
     * @param stars the star rating count of the hotel to be created
     */
    public Hotel(String name, double[] coordinates, String description, int stars) {
        super(name, coordinates, description);
        this.stars = stars;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
