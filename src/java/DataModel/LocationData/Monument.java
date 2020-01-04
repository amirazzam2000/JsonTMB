package DataModel.LocationData;

/**
 *
 * Class: java.DataModel.LocationData.Monument
 *
 * <p>this class stores all the information about the Monument locations
 * and offers the ability to read and change this information
 * <p></p>
 * This is a child class that inherits from {@link Location}, it stores the
 * architecture of the monument and the year it was inaugurated alongside
 * the information specified in its parent class.
 * <p></p>
 * This class's information will be added using the
 * {@link JsonParsing.Location.JsonLocationReader} class.
 * <p></p>
 * <p></p>
 * The methods this class offers are: one constructor with parameter, which
 * are all the parent class  attributes alongside the <code>Monument</code>'s
 * attributes, and it uses the <b>Super</b>(<i>parameters</i>) constructor
 * method in order to construct a Monument that has the characteristics and the
 * information specified in the parent class. it also offers getters and
 * setters for the architect and the year in which the monument was inaugurated.
 * However, as it inherits from  the Location it also have access to its
 * public methods, so it can access all  the setters and getters from
 * Location in order to read and modify the rest of the parent attributes.
 *
 * @author Amir Azzam - amir.azzam@students.salle.url.edu
 * @author <p>Nicole Alexa leser - nicolealexa.leser@students.salle.url.edu
 * @version 27/12/2019
 * @see DataModel.LocationData.Location
 */
public class Monument extends Location {
    private String architect;
    private int inauguration;


    /**
     * constructs a Monument with the information specified in the parameters
     * @param name the name of the monument to be created
     * @param coordinates the coordinates of the monument to be created
     * @param description the description of the monument to be created
     * @param architect the name of the architecture who build the monument
     * @param inauguration the year in which the monument was opened
     */
    public Monument(String name, double[] coordinates, String description, String architect, int inauguration) {
        super(name, coordinates, description);
        this.architect = architect;
        this.inauguration = inauguration;
    }

    public String getArchitect() {
        return architect;
    }

    public void setArchitect(String architect) {
        this.architect = architect;
    }

    public int getInauguration() {
        return inauguration;
    }

    public void setInauguration(int inauguration) {
        this.inauguration = inauguration;
    }
}
