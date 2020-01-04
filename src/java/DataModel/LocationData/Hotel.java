package DataModel.LocationData;


/**
 *
 * Class: java.DataModel.LocationData.Hotel
 *
 * <p>this class stores all the information about the hotel locations and offers
 * the ability to read and change this information
 * <p></p>
 * This is a child class that inherits from {@link Location}, it stores the stars
 * count  of the Hotel alongside the information specified in its parent class.
 * <p></p>
 * This class's information will be added using the
 * {@link JsonParsing.Location.JsonLocationReader} class.
 * <p></p>
 * <p></p>
 * The methods this class offers are: one constructor with parameter, which
 * are all the parent class  attributes alongside the <code>Hotel</code>'s
 * attributes, and it uses the <b>Super</b>(<i>parameters</i>) constructor
 * method in order to construct a Hotel that has  the stars count and the
 * information specified in the parent class. it also offers getters and
 * setters for the stars attribute.
 * However, as it inherits from  the Location it also have access to its
 * public methods, so it can access all  the setters and getters from
 * Location in order to read and modify the rest of the parent attributes.
 *
 * @author Amir Azzam - amir.azzam@students.salle.url.edu
 * @author <p>Nicole Alexa leser - nicolealexa.leser@students.salle.url.edu
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
