package DataModel.LocationData;

public class Location {
    String name ;
    float[] coordinates;
    String description;

    public Location(String name, float[] coordinates, String description) {
        this.name = name;
        this.coordinates = coordinates;
        this.description = description;
    }

}
