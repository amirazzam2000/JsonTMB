package Managers.Location;

import DataModel.LocationData.Location;

import java.util.ArrayList;

public class LocationManager {
    ArrayList<Location> locations;


    public LocationManager() {
        this.locations = new ArrayList<>();
    }

    public void add(Location location){
        locations.add(location);
    }

    public static boolean checkCoordinates(float latitude, float longitude){
        return (latitude >= -180 && latitude <= 180) && (longitude >= -90 && longitude <= 90);

    }
}
