package Managers.Location;

import DataModel.LocationData.Location;

import java.util.ArrayList;

public class LocationManager {
    private static ArrayList<Location> locations;


    public LocationManager() {
        locations = new ArrayList<>();
    }

    public void add(Location location){
        locations.add(location);
    }

    public static boolean checkCoordinates(float latitude, float longitude){
        return (latitude >= -180 && latitude <= 180) && (longitude >= -90 &&  longitude <= 90);

    }

    public static boolean checkLocationExists(float latitude, float longitude){
        for(Location location : locations){
            if(location.getLatitude() == latitude && location.getLongitude() == longitude){
                return true;
            }
        }
        return false;
    }


}
