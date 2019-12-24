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
}
