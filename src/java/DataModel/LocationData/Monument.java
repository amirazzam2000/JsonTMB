package DataModel.LocationData;

public class Monument extends Location {
    String architect;
    int inauguration;

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
