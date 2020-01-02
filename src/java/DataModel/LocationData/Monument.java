package DataModel.LocationData;

/**
 *
 * Class: java.DataModel.LocationData.Monument
 *
 * <br/>Stores all the information about the Monument locations and offers the
 * ability to read and change this information
 *
 * @author Amir Azzam - amir.azzam@students.salle.url.edu
 * @author <br/>Nicole Alexa leser - nicolealexa.leser@students.salle.url.edu
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
