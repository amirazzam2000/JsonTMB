package DataModel.LocationData;

public class Hotel extends Location {
    int stars;

    public Hotel(String name, float[] coordinates, String description, int stars) {
        super(name, coordinates, description);
        this.stars = stars;
    }
}
