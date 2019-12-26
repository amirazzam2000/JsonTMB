package Managers.Transportation;

import DataModel.TransportationData.Station;

import java.util.ArrayList;

public class StationManger {
    ArrayList<Station> stations;

    public StationManger() {
        stations = new ArrayList<>();
    }

    public void add(Station station){

        stations.add(new Station(station));
    }
}
