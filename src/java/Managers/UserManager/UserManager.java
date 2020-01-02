package Managers.UserManager;

import DataModel.LocationData.FavLocation;
import DataModel.LocationData.Location;
import DataModel.TransportationData.RouteData.Route;
import DataModel.TransportationData.StationData.Station;
import DataModel.TransportationData.StopData.Stop;
import DataModel.User.User;
import Managers.Location.LocationManager;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Class: java.Managers.UserManager.UserManager
 *
 * <p>Manages the data of all the user objects, and stores all the
 * users registered in the system.
 * <p>In a nutshell, This class allows to modify, read and analyze the data
 * of all the users in the system.
 *
 * @apiNote the system can only have one user as we did not implement the
 * optional that allows more than ne user in the system.
 *
 * @implNote as we mentioned there can only be one user in the system which
 * explains why we always get the user at position 0
 *
 * @author Amir Azzam - amir.azzam@students.salle.url.edu
 * @author <p>Nicole Alexa leser - nicolealexa.leser@students.salle.url.edu
 * @version 27/12/2019
 *
 * @see User
 */
public class UserManager {
    private ArrayList<User> users;

    /**
     * constructs a user manager with one user, and all the attributes
     * initialized
     */
    public UserManager() {
        this.users = new ArrayList<>();
        this.users.add(new User());
    }

    /**
     * adds a location that the currently-registered user has created
     * to the user's locations list
     * @param location the location created by the user that will be added
     */
    public void createNewMyLocation(Location location){
        users.get(0).addLocation(location);
        LocationManager.add(location);
    }

    /**
     * adds a route that has been planned by the user to the
     * currently-registered user's routes
     * @param route that route planned by the user that will be added
     */
    public void addRoute(Route route){
        users.get(0).addRoute(route);
    }

    /**
     * adds a location that the currently-registered user has searched for
     * to the user's location history list
     * @param location the location searched by the user that will be added
     */
    public void addLocationHistory(Location location){
        users.get(0).addLocationHistory(location);
    }

    /**
     * adds a favorite location that the currently-registered user choose
     * to add it to their list of favorite locations
     * @param location the location of the favorite location to be added
     * @param type the type of the favorite location to be added
     */
    public void addFavLocation (Location location, String type ) {
        users.get(0).addFavLocation(location ,type);
    }

    /**
     * deletes a favorite location from the currently-registered user's
     * favorite locations list
     * @param location the location of the favorite location to be deleted
     */
    public void deleteFavLocation(Location location) {
        for (int i = 0; i < users.get(0).getFavLocations().size(); i++) {
            if (location.getName().compareToIgnoreCase(users.get(0).getFavLocations().get(i).getLocation().getName()) == 0 && location.getLatitude() == users.get(0).getFavLocations().get(i).getLatitude() && location.getLongitude() == users.get(0).getFavLocations().get(i).getLongitude()) {
                users.get(0).getFavLocations().remove(i);
                break;
            }
        }
    }

    /**
     * @return the currently-registered user
     */
    public User getUser(){
        return users.get(0);
    }

    /**
     * @return all the currently-registered user's favorite locations
     */
    public ArrayList<FavLocation> getFavLocations(){
        return users.get(0).getFavLocations();
    }

    /**
     * adds all the favorite stations and stops specified in the parameter that
     * are close to the specified favorite location
     * @param location the favorite location to be referenced in the search
     * @param stations an array of all stations around the referenced
     *                 favorite location
     * @param stops an array of all the stops around the referenced favorite
     *              location
     * @return true if the location has been added successfully, and false
     * otherwise
     */
    public boolean addFavStationsAndStops(FavLocation location, ArrayList<Station> stations, ArrayList<Stop> stops){
        boolean flag =false;

        /*
         * check if the favorite stations and stops around this specified
         * favorite location has already been registered before
         */
        for (Station station: users.get(0).getStations()) {
            if (location.getLocation().getName().compareToIgnoreCase(station.getLocationName()) == 0){
                flag = true;
                break;
            }
        }
        for (Stop stop: users.get(0).getStops()) {
            if (location.getLocation().getName().compareToIgnoreCase(stop.getLocationName()) == 0){
                flag = true;
                break;
            }
        }

        if (!flag) {                                                            //if the stations and the stops haven't been added already
            users.get(0).addStations(stations);                                 // then add them and sort them according to
            users.get(0).addStops(stops);                                       // distance from the location specified
            users.get(0).sortStations();
            users.get(0).sortStops();
            if (stations == null || stations.size() == 0 || stops == null || stops.size() == 0 )
                return false;
        }
        return true;
    }


    /**
     * gets all locations in the currently-registered user's loaction serach
     * history
     * @return array list of locations
     */
    public ArrayList<Location> getLocationHistory(){
        return users.get(0).getLocationHistory();
    }

    /**
     * gets all the route that the currently-registered user has planned
     * already
     * @return array list of routes
     */
    public ArrayList<Route> getMyRoutes(){
        return users.get(0).getRoutes();
    }

    /**
     * gets all the locations the currently-registered user has created
     * @return array list of locations
     */
    public ArrayList<Location> getMyLocation(){
        return users.get(0).getMyLocations();
    }


    public List<Station> getStations() {
        return users.get(0).getStations();
    }

    public void setStations(Station station) {
        users.get(0).setStations(station);
    }

    public String getName() {
        return users.get(0).getName();
    }

    public void setName(String name) {
        users.get(0).setName(name);
    }

    public String getEmail() {
        return users.get(0).getEmail();
    }

    public void setEmail(String email) {
        users.get(0).setEmail(email);
    }

    public int getYear() {
        return users.get(0).getYear();
    }

    public void setYear(int year) {
        users.get(0).setYear(year);
    }
}
