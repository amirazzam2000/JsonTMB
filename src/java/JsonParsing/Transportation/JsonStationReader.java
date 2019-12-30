package JsonParsing.Transportation;

import DataModel.TransportationData.Station;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;

public class JsonStationReader {

    /**
     * Parse the information from the Station json String that the API returns and store them in the Station manger
     *
     * @return   an array of all the Stations contained in the Station String returned by the API
     * */
    public static ArrayList<Station> readFavStations(String input, double lat, double lon){
        ArrayList<Station> stations = new ArrayList<>();
        Station auxStation = new Station();
        JsonElement json = JsonParser.parseString(input);
        JsonObject jsonStations = json.getAsJsonObject();

        // a sample of how each station object is relived
        /*
        *
        *   {"type":"Feature",
        *      "id":"ESTACIONS_LINIA.fid--2262e815_16f41282d9c_-286",
        *      "geometry":{"type":"Point","coordinates":[2.099749,41.36409]},
        *      "geometry_name":"GEOMETRY",
        *      "properties":{
        *           "ID_ESTACIO_LINIA":168,
        *           "CODI_ESTACIO_LINIA":114,
        *           "CODI_GRUP_ESTACIO":6660114,
        *           "ID_ESTACIO":82,"CODI_ESTACIO":114,
        *           "NOM_ESTACIO":"Rambla Just Oliveras",
        *           "ORDRE_ESTACIO":4,
        *           "ID_LINIA":4,
        *           "CODI_LINIA":1,
        *           "NOM_LINIA":"L1",
        *           "ORDRE_LINIA":1,
        *           "ID_TIPUS_SERVEI":1,
        *           "DESC_SERVEI":"Hospital de Bellvitge - Fondo",
        *           "ORIGEN_SERVEI":"Hospital de Bellvitge",
        *           "DESTI_SERVEI":"Fondo",
        *           "ID_TIPUS_ACCESSIBILITAT":1,
        *           "NOM_TIPUS_ACCESSIBILITAT":"Accessible",
        *           "DATA_INAUGURACIO":"1987-04-23Z",
        *           "DATA":"2019-12-25Z",
        *           "COLOR_LINIA":"CE1126",
        *           "PICTO":"L1","PICTO_GRUP":"L1",
        *           "ID_TIPUS_ESTAT":1,
        *           "NOM_TIPUS_ESTAT":"Operatiu"}}
        * ***********************************************************
        * coordinates = geometry.coordinates
        * stationName = properties.NOM_ESTACIO
        * stationId = id
        * Date = properties.DATA_INAUGURACIO
        * lineName = properties.PICTO
        *
        * */



        for (JsonElement jStation: jsonStations.getAsJsonArray("features")) {
            float[] coordinates = new float[2];
            if (jStation.getAsJsonObject().has("geometry")){
                coordinates[1] = jStation.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray().get(0).getAsFloat();
                coordinates[0] = jStation.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray().get(1).getAsFloat();
            }
            if (calculateDifference(lat , lon ,  coordinates[0], coordinates[1]) <= 0.5) {
                auxStation.setCoordinates(coordinates);
                auxStation.setDistance(calculateDifference(lat , lon ,  coordinates[0], coordinates[1]));
                if (jStation.getAsJsonObject().get("properties").getAsJsonObject().has("NOM_ESTACIO")) {
                    auxStation.setStationName(jStation.getAsJsonObject().get("properties").getAsJsonObject().get("NOM_ESTACIO").getAsString());
                }
                if (jStation.getAsJsonObject().has("id")) {
                    auxStation.setStationId(jStation.getAsJsonObject().get("id").getAsString());
                }
                if (jStation.getAsJsonObject().get("properties").getAsJsonObject().has("DATA_INAUGURACIO")) {
                    auxStation.setDate(jStation.getAsJsonObject().get("properties").getAsJsonObject().get("DATA_INAUGURACIO").getAsString());
                }
                if (jStation.getAsJsonObject().get("properties").getAsJsonObject().has("PICTO")) {
                    auxStation.setLineName(jStation.getAsJsonObject().get("properties").getAsJsonObject().get("PICTO").getAsString());
                }
                stations.add(auxStation);
            }
        }


        return stations;
    }
    public static double calculateDifference(double lat1, double lon1, double lat2 , double lon2){

        double R = 6371;
        double dLat =  (Math.PI / 180) * (lat2 - lat1);
        double dLon =  (Math.PI / 180) * (lon2 - lon1);

        double aux = Math.sin(dLat/2) * Math.sin(dLat/2) +
                        Math.cos((Math.PI / 180) * lat1) * Math.cos((Math.PI / 180) * lat2) *
                            Math.sin(dLon/2) * Math.sin(dLon/2);

        double aux2 = 2 * Math.atan2(Math.sqrt(aux), Math.sqrt(1-aux));
        return R * aux2;
    }
}
