package Managers.Location;

import DataModel.LocationData.Location;

import java.util.ArrayList;

public class LocationManager {
    private static ArrayList<Location> locations;


    public LocationManager() {
        locations = new ArrayList<>();
    }

    public static void add(Location location){
        locations.add(location);
    }

    public static boolean checkCoordinates(float latitude, float longitude){
        return (latitude >= -180 && latitude <= 180) && (longitude >= -90 &&  longitude <= 90);

    }

    public static boolean checkLocationExists(Location loc){
        for(Location location : locations){
            if(location.getLatitude() == loc.getLatitude() && location.getLongitude() == loc.getLongitude() && loc.getName().compareToIgnoreCase(location.getName()) != 0){
                return true;
            }
        }
        return false;
    }

    public static boolean checkLocationNameExists(String name){
        for(Location location : locations){
            if(name.compareToIgnoreCase(location.getName()) == 0){
                return true;
            }
        }
        return false;
    }



}
