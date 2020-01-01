package Managers.UserManager;

import DataModel.LocationData.FavLocation;
import DataModel.LocationData.Location;
import DataModel.TransportationData.Route;
import DataModel.TransportationData.Station;
import DataModel.TransportationData.Stop;
import DataModel.User.User;
import Managers.Location.LocationManager;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    ArrayList<User> users;
    public UserManager() {
        this.users = new ArrayList<>();
        this.users.add(new User());
    }

    public User getUser(){
        return users.get(0);
    }
    public ArrayList<Location> getMyLocation(){
        return users.get(0).getMyLocations();
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

    public List<Station> getStations() {
        return users.get(0).getStations();
    }

    public void setStations(Station station) {
        users.get(0).setStations(station);
    }

    public void createNewMyLocation(Location location){
        users.get(0).addLocation(location);
        LocationManager.add(location);
    }

    public void addRoute(Route route){
        users.get(0).addRoute(route);
    }

    public ArrayList<Route> getMyRoutes(){
        return users.get(0).getRoutes();
    }

    public void addLocationHistory(Location location){
        users.get(0).addLocationHistory(location);
    }

    public void addFavLocation (Location location, String type ) {
        users.get(0).addFavLocation(location ,type);
    }

    public ArrayList<Location> getLocationHistory(){
        return users.get(0).getLocationHistory();
    }

    public boolean getFavStationsAndStops(FavLocation location, ArrayList<Station> stations, ArrayList<Stop> stops){
        boolean flag =false;

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
        if (!flag) {

            users.get(0).addStations(stations);
            users.get(0).addStops(stops);
            users.get(0).sortStations();
            users.get(0).sortStops();
            if (stations == null || stations.size() == 0 || stops == null || stops.size() == 0 )
                return false;
        }
        return true;
    }

    public ArrayList<FavLocation> getFavLocations(){
        return users.get(0).getFavLocations();
    }

}
