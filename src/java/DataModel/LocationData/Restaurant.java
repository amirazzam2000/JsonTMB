package DataModel.LocationData;

import DataModel.LocationData.Location;

public class Restaurant extends Location {
    String[] characteristics;

    public Restaurant(String name, float[] coordinates, String description, String[] characteristics) {
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
