package Managers.UserManager;

import DataModel.LocationData.Location;
import DataModel.TransportationData.Station;
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

    public boolean createNewLocation(float latitude, float longitude, String description, String name ){
        if (LocationManager.checkCoordinates(latitude, longitude)){
            Location aux = new Location(name, longitude, latitude, description);
            if(LocationManager.checkLocationExists(aux)){
                users.get(0).addLocation(aux);
                LocationManager.add(aux);
            }
        }
        return false;
    }

}
