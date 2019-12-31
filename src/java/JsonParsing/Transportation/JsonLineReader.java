package JsonParsing.Transportation;

import DataModel.LocationData.FavLocation;
import DataModel.TransportationData.Line;
import DataModel.TransportationData.Stop;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;

public class JsonLineReader {
    public static ArrayList<Line> readStopLine(String input, String stopId){
        ArrayList<Line> lines = new ArrayList<>();
        Line auxLine = new Line();

        JsonElement json = JsonParser.parseString(input);
        JsonObject jsonLines = json.getAsJsonObject();

        if(jsonLines.has("status")){
            for (JsonElement line: jsonLines.get("data").getAsJsonObject().get("ibus").getAsJsonArray()) {
                auxLine.setStopId(stopId);
                if (line.getAsJsonObject().has("destination"))
                    auxLine.setDestination(line.getAsJsonObject().get("destination").getAsString());
                if (line.getAsJsonObject().has("line"))
                    auxLine.setLineName(line.getAsJsonObject().get("line").getAsString());
                if (line.getAsJsonObject().has("t-in-min"))
                    auxLine.setTimeLeftMin(line.getAsJsonObject().get("t-in-min").getAsInt());

                lines.add(new Line(auxLine));
            }
        }
        else{
            // through exception
            return null;
        }

        return lines;
    }
}
