package DataModel.User;

import DataModel.TransportationData.Station;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class User {
    String name;
    String email;
    int year;
    List<Station> stations;

    public User(String name, String email, int year, List<Station> stations) {
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
}
