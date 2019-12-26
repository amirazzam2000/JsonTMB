package JsonParsing.Transportation;

import DataModel.TransportationData.Station;
import Managers.Transportation.StationManger;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonStationReader {

    /**
     * Parse the information from the Station json String that the API returns and store them in the Station manger
     *
     * @return   an array of all the Stations contained in the Station String returned by the API
     * */
    public static StationManger readStations(String input){
        StationManger stations = new StationManger();
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

            if (jStation.getAsJsonObject().has("geometry")){
                float[] coordinates = new float[2];
                coordinates[0] = jStation.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray().get(0).getAsFloat();
                coordinates[1] = jStation.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray().get(1).getAsFloat();
                auxStation.setCoordinates(coordinates);
            }
            if (jStation.getAsJsonObject().get("properties").getAsJsonObject().has("NOM_ESTACIO")){
                auxStation.setStationName(jStation.getAsJsonObject().get("properties").getAsJsonObject().get("NOM_ESTACIO").getAsString());
            }
            if(jStation.getAsJsonObject().has("id")){
                auxStation.setStationId(jStation.getAsJsonObject().get("id").getAsString());
            }
            if(jStation.getAsJsonObject().get("properties").getAsJsonObject().has("DATA_INAUGURACIO")){
                auxStation.setDate(jStation.getAsJsonObject().get("properties").getAsJsonObject().get("DATA_INAUGURACIO").getAsString());
            }
            if(jStation.getAsJsonObject().get("properties").getAsJsonObject().has("PICTO")){
                auxStation.setLineName(jStation.getAsJsonObject().get("properties").getAsJsonObject().get("PICTO").getAsString());
            }
            stations.add(auxStation);
        }


        return stations;
    }
}
