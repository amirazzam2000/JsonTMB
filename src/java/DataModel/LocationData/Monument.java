package DataModel.LocationData;

import DataModel.LocationData.Location;

public class Monument extends Location {
    String architect;
    int inauguration;

    public Monument(String name, float[] coordinates, String description, String architect, int inauguration) {
        super(name, coordinates, description);
        this.architect = architect;
        this.inauguration = inauguration;
    }
}
