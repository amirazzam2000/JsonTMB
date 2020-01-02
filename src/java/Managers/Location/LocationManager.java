package Managers.Location;

import DataModel.LocationData.Location;

import java.util.ArrayList;

/**
 *
 * Class: java.Managers.Location.LocationManager
 *
 * <p>Manages the data of all the location objects, and stores all the
 * locations registered in the system.
 * <p>In a nutshell, This class allows to modify, read and analyze the data
 * of all the locations in the system.
 *
 * @author Amir Azzam - amir.azzam@students.salle.url.edu
 * @author <p>Nicole Alexa leser - nicolealexa.leser@students.salle.url.edu
 * @version 29/12/2019
 *
 * @see Location
 */

public class LocationManager {
    private static ArrayList<Location> locations;

    /**
     * construct an empty location manager with all attributes initialized
     */
    public LocationManager() {
        locations = new ArrayList<>();
    }

    /**
     * adds a new location to the system
     * @param location location to be added
     */
    public static void add(Location location){
        locations.add(location);
    }

    /**
     * checks if the coordinate (latitude, longitude) are valid according to
     * the <i> system of coordinates in EPSG: 4326</i>.
     * @param latitude the latitude of the coordinate to be checked
     * @param longitude the longitude of the coordinate to be checked
     * @return true or false according to wither the coordinate is valid or not
     */
    public static boolean checkCoordinates(double latitude, double longitude){
        return (latitude >= -180 && latitude <= 180) && (longitude >= -90 &&  longitude <= 90);

    }

    /**
     * checks if there is any location registered in the system that has the
     * same name as the name specified in the parameter
     * @param name the name to be checked
     * @return true if the name exists, and false otherwise
     */
    public static boolean checkLocationNameExists(String name){
        for(Location location : locations){
            if(name.compareToIgnoreCase(location.getName()) == 0){
                return true;
            }
        }
        return false;
    }

    /**
     * searches for a location based on the location's name.
     * @param name the name of the location to be found
     * @return  the location if found, <b>null</b> otherwise.
     */
    public static Location searchLocations(String name){

        for(Location location : locations){
            if(name.compareToIgnoreCase(location.getName()) == 0 ){
                return location;
            }
        }
        return null;
    }

    /**
     * transforms the coordinates of the location to a string that has the
     * format <i>"latitude,longitude"</i>
     * @param location the location that has the coordinates that be translated
     *                into a string
     * @return a string with the location's coordinates.
     */
    public static String  lanLogToString(Location location){
        StringBuilder output = new StringBuilder();
        output.append(location.getLatitude()).append(",").append(location.getLongitude());
        return output.toString() ;
    }


}
