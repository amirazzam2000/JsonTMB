package DataModel.User;

import DataModel.LocationData.FavLocation;
import DataModel.LocationData.Location;
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
    ArrayList<Location> locationHistory;
    ArrayList<FavLocation> favLocations;



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
        locationHistory.add(location);
    }


}
