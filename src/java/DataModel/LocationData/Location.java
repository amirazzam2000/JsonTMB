package DataModel.LocationData;

public class Location {
    String name ;
    float[] coordinates;
    String description;

    public Location(){
        name = null;
        coordinates = new float[2];
        description = null;
    }
    public Location(String name, float[] coordinates, String description) {
        this.name = name;
        this.coordinates = coordinates;
        this.description = description;
    }
    public Location(String name, float longitude, float latitude , String description) {
        this.name = name;
        this.coordinates = new  float[2];
        this.coordinates[0] = latitude;
        this.coordinates[1] = longitude;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public float[] getCoordinates() {
        return coordinates;
    }

    public float getLatitude() {
        return coordinates[0];
    }

    public float getLongitude() {
        return coordinates[1];
    }

    public void setLatitude(float latitude) {
        this.coordinates[0] = latitude;
    }

    public void setLongitude(float longitude) {
        this.coordinates[1] = longitude;
    }


    public void setCoordinates(float[] coordinates) {
        this.coordinates = coordinates;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
