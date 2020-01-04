package DataModel.LocationData;

/**
 *
 * Class: java.DataModel.LocationData.Restaurant
 *
 * <p>this class stores all the information about the Restaurant locations
 * and offers the ability to read and change this information
 * <p></p>
 * This is a child class that inherits from {@link Location}, it stores the
 * characteristics of the restaurant alongside the information specified in
 * its parent class.
 * <p></p>
 * This class's information will be added using the
 * {@link JsonParsing.Location.JsonLocationReader} class.
 * <p></p>
 * <p></p>
 * The methods this class offers are: one constructor with parameter, which
 * are all the parent class  attributes alongside the <code>Restaurant</code>'s
 * attributes, and it uses the <b>Super</b>(<i>parameters</i>) constructor
 * method in order to construct a Restaurant that has the characteristics and the
 * information specified in the parent class. it also offers getters and
 * setters for the characteristics.
 * However, as it inherits from  the Location it also have access to its
 * public methods, so it can access all  the setters and getters from
 * Location in order to read and modify the rest of the parent attributes.
 *
 * @author Amir Azzam - amir.azzam@students.salle.url.edu
 * @author <p>Nicole Alexa leser - nicolealexa.leser@students.salle.url.edu
 * @version 27/12/2019
 * @see DataModel.LocationData.Location
 */
public class Restaurant extends Location {
    private String[] characteristics;

    /**
     * constructs a Restaurant with the information specified in the parameters
     * @param name the name of the restaurant to be created
     * @param coordinates the coordinates of the restaurant to be created
     * @param description the description of the restaurant to be created
     * @param characteristics the characteristics of the restaurant to be
     *                        created
     */
    public Restaurant(String name, double[] coordinates, String description, String[] characteristics) {
        super(name, coordinates, description);
        this.characteristics = characteristics;
    }

    public String[] getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String[] characteristics) {
        this.characteristics = characteristics;
    }
}
