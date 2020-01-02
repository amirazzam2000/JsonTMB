package DataModel.LocationData;

/**
 *
 * Class: java.DataModel.LocationData.Restaurant
 *
 * <br/>Stores all the information about the Restaurant locations and offers the
 * ability to read and change this information
 *
 * @author Amir Azzam - amir.azzam@students.salle.url.edu
 * @author <br/>Nicole Alexa leser - nicolealexa.leser@students.salle.url.edu
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
