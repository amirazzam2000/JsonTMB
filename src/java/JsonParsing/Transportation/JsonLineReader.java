package JsonParsing.Transportation;

import DataModel.TransportationData.StopData.Line;
import DataModel.TransportationData.StopData.Stop;
import JsonParsing.ParsingExceptions.LineExceptions.LineException;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 *
 * Class: java.JsonParsing.Transportation.JsonStopsReader
 *
 * <p>This class reads the response of the TMB API when requested to send the
 * Buses waiting time on a specific stop that is supported by TMB. The
 * response is sent from the API module to this class as a Json String.
 * <p></p>
 * This class has no attributes and only one method, this method checks the
 * Json String it received, if there is any error with requested parameters
 * that resulted in a problem in the response, then this method will throw a
 * {@link LineException}.
 * <p></p>
 * However, if the response is successful, then the
 * method will parse the information in the json string and return an array
 * of type {@link Line} that contains all the buses that stop at the specified
 * stop with the time left for each to arrive at the stop.
 * <p></p>
 *
 * @author Amir Azzam - amir.azzam@students.salle.url.edu
 * @author <p>Nicole Alexa leser - nicolealexa.leser@students.salle.url.edu
 * @version 27/12/2019
 *
 * @see Line
 * @see Stop
 */
public class JsonLineReader {
    /**
     * reads all the information about the bus lines that stop at a specified
     * stop
     * @param input a Json string that contains the information the Bus lines that stop in a specified stations
     * @param stopId the code of the stop we are receiving its information
     * @return an Array of all the Bus lines that stop at the specified stop
     * @throws LineException if the stop code specified did not exist after being sent to the API
     */
    public static ArrayList<Line> readStopLine( String input, String stopId) throws LineException {
        ArrayList<Line> lines = new ArrayList<>();
        Line auxLine = new Line();
        //reading the information in the Json String and putting it in a json
        // element
        JsonElement json = JsonParser.parseString(input);
        JsonObject jsonLines = json.getAsJsonObject();

        // for each line in the station read all of its information and add
        // it to the lines array
        if(jsonLines.has("status") && jsonLines.get("data").getAsJsonObject().get("ibus").getAsJsonArray().size() >= 1){
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
            throw new LineException("Error, stop code not valid!");
        }

        return lines;
    }
}
