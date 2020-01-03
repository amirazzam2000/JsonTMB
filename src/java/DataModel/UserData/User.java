package DataModel.UserData;

import DataModel.LocationData.FavLocation;
import DataModel.LocationData.Location;
import DataModel.TransportationData.RouteData.Route;
import DataModel.TransportationData.StationData.Station;
import DataModel.TransportationData.StopData.Stop;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Class: java.DataModel.User.User
 *
 * <p>Stores all the information about one user, it also stores the user's
 * favorite locations, stops, stations and routes.<p>This class also allows
 * modifying and reading the information of the user.
 *
 * @author Amir Azzam - amir.azzam@students.salle.url.edu
 * @author <p>Nicole Alexa leser - nicolealexa.leser@students.salle.url.edu
 * @version 27/12/2019
 *
 * @see Managers.UserManager.UserManager
 */
public class User {
    private String name;
    private String email;
    private int year;
    private ArrayList<Station> stations;
    private ArrayList<Location> myLocations;
    private ArrayList<Location> locationHistory;
    private ArrayList<FavLocation> favLocations;
    private ArrayList<Route> routes;
    private ArrayList<Stop> stops;

    /**
     * constructs an empty user with all the attributes initialized
     */
    public User() {
        this.name = null;
        this.email = null;
        this.year = 0;
        this.stations = new ArrayList<>();
        this.myLocations = new ArrayList<>();
        this.locationHistory = new ArrayList<>();
        this.favLocations = new ArrayList<>();
        this.routes = new ArrayList<>();
        this.stops = new ArrayList<>();
    }

    /**
     * adds a route to the user's planned route, as each user will have to
     * store all the routes that they planned before
     * @param route the route to be added
     * @see Route
     */
    public void addRoute(Route route){
        routes.add(route);
    }

    /**
     * adds a location to the use's created locations, as each time a user
     * creates a new location it should be stored in the user's profile.
     * @param location the location to be added
     * @see Location
     */
    public void addLocation(Location location){
        myLocations.add(location);
    }

    /**
     * adds a location to the user's location search history, as each time a
     * user search fo a new location it should be saved in the search history
     * in the user's profile.
     * <p>Moreover, the location history list functions like a stack, so
     * every time a new location is added it has to be added at the end of
     * the list.
     * <p>However, this method takes care of repeated elements, which means
     * that adding a location twice doesn't duplicate the location but instead,
     * the second time it's added it will just move it to the end of the list.
     *
     * @param location the location to be added
     * @see Location
     */
    public void addLocationHistory(Location location) {
        if (!locationHistory.contains(location))
            locationHistory.add(location);
        else {
            locationHistory.remove(location);
            locationHistory.add(location);
        }
    }

    /**
     * adds a new favorite location to the user's favorite locations.
     * @apiNote this method constructs the favorite location as
     * well before it adds it.
     *
     * @param location the location to be added
     * @param type the type of the favorite location to be added
     *
     * @see FavLocation
     */
    public void addFavLocation(Location location, String type){
        FavLocation aux = new FavLocation(type, location);
        if (!favLocations.contains(aux))
            favLocations.add(aux);
    }

    /**
     *  adds an array of stops to the user's Favorite stops and stations
     * @param stops an array list that contains all the favorite stops to be
     *              added
     */
    public void addStops(ArrayList<Stop> stops){
        this.stops.addAll(stops);
    }

    /**
     *  adds an array of stations to the user's Favorite stops and stations
     * @param stations an array list that contains all the favorite stations to be
     *              added
     */
    public void addStations(ArrayList<Station> stations){
        this.stations.addAll(stations);
    }

    /**
     * sorts al the user's favorite stations according to their distance from
     * the favorite location they are close to.
     */
    public void sortStations(){
        Station s = new Station();
        stations.sort(s);
    }

    /**
     * sorts al the user's favorite stops according to their distance from
     * the favorite location they are close to.
     */
    public void sortStops(){
        Stop s = new Stop();
        stops.sort(s);
    }

    public void setStations(ArrayList<Station> stations) {
        this.stations = stations;
    }

    public void setMyLocations(ArrayList<Location> myLocations) {
        this.myLocations = myLocations;
    }

    public ArrayList<Location> getLocationHistory() {
        return locationHistory;
    }

    public void setLocationHistory(ArrayList<Location> locationHistory) {
        this.locationHistory = locationHistory;
    }

    public ArrayList<FavLocation> getFavLocations() {
        return favLocations;
    }

    public void setFavLocations(ArrayList<FavLocation> favLocations) {
        this.favLocations = favLocations;
    }

    public ArrayList<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(ArrayList<Route> routes) {
        this.routes = routes;
    }


    public ArrayList<Stop> getStops() {
        return stops;
    }

    public void setStops(ArrayList<Stop> stops) {
        this.stops = stops;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(Station station) {
        this.stations.add(new Station(station));
    }

    public ArrayList<Location> getMyLocations() {
        return myLocations;
    }


}
