package DataModel.User;

import DataModel.LocationData.FavLocation;
import DataModel.LocationData.Location;
import DataModel.TransportationData.Route;
import DataModel.TransportationData.Station;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class User {
    String name;
    String email;
    int year;
    ArrayList<Station> stations;
    ArrayList<Location> myLocations;

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

    ArrayList<Location> locationHistory;
    ArrayList<FavLocation> favLocations;
    ArrayList<Route> routes;



    public User(String name, String email, int year, ArrayList<Station> stations) {
        this.name = name;
        this.email = email;
        this.year = year;
        this.stations = stations;
    }

    public User() {
        this.name = null;
        this.email = null;
        this.year = 0;
        this.stations = new ArrayList<>();
        this.myLocations = new ArrayList<>();
        this.locationHistory = new ArrayList<>();
        this.favLocations = new ArrayList<>();
        this.routes = new ArrayList<>();
    }

    public void addRoute(Route route){
        routes.add(route);
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

    public void addLocation(Location location){
        myLocations.add(location);
    }

    public void addLocationHistory(Location location) {
        if (!locationHistory.contains(location))
                locationHistory.add(location);
    }

    public void addFavLocation(Location location, String type){
        FavLocation aux = new FavLocation(type, location);
        favLocations.add(aux);
    }

    public ArrayList<Location> getMyLocations() {
        return myLocations;
    }
}
