package API;

import DataModel.TransportationData.RouteData.Route;
import DataModel.User.User;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 *
 * Class: java.API.WebManager
 *
 * <p>Makes calls to the TMB API, and sends the required parameters and gets
 * the reply from the API as a Json String
 *
 * @author Amir Azzam - amir.azzam@students.salle.url.edu
 * @author <p>Nicole Alexa leser - nicolealexa.leser@students.salle.url.edu
 * @version 29/12/2019
 *
 * @see API.Webservice
 * @see JsonParsing.Location.JsonLocationReader
 * @see JsonParsing.Transportation.JsonStopsReader
 * @see JsonParsing.Transportation.JsonStationReader
 * @see JsonParsing.Transportation.JsonLineReader
 * @see JsonParsing.Transportation.JsonRouteReader
 */
public class WebManager implements Webservice{
    private String appId;
    private StringBuilder url;

    /**
     * constructs an empty web manager that is ready to be used with it's
     * attributes initialized, and that app ID specified.
     */
    public WebManager(){
        appId = "?app_id=151d4902&app_key=771e0a32ea2b2631b0ad21f66a4ea564";
    }

    /**
     * calls all the stations supported by the TMB API
     * @return a Json String with all the stations that are stored in the TMB
     * API if there was no problem with the connection, or there is no
     * missing parameters, <b>null</b> otherwise
     */
    @Override
    public String callAllStations(){
        String jsonData = null;
        OkHttpClient client = new OkHttpClient();
        //construct the call url
        url = new StringBuilder();
        url.append("https://api.tmb.cat/v1/transit/linies/metro/estacions");
        url.append(appId);

        //request a call
        Request request = new Request.Builder()
                .url(url.toString())
                .build();
        Response response;

        try {
            // receive a response
            response = client.newCall(request).execute();

            //if the response is not null store it as a Json String
            if (response.body() != null){
                jsonData = response.body().string();
            }



        } catch (IOException e) {
            System.out.println("there was a problem connecting to the API, please check you connection and try again");
        }
        return jsonData;
    }

    /**
     * calls all the Bus stops supported by the TMB API
     * @return  a Json String with all the Bus stops stored in the TMB API if
     * there was no problems with the connection or any missing parameter,
     * <b>null</b>> otherwise.
     */
    @Override
    public String callAllStops(){
        String jsonData = null;
        OkHttpClient client = new OkHttpClient();
        //construct the call url
        url = new StringBuilder();
        url.append("https://api.tmb.cat/v1/transit/parades");
        url.append(appId);

        //request a call
        Request request = new Request.Builder()
                .url(url.toString())
                .build();
        Response response;

        try {
            // receive a response
            response = client.newCall(request).execute();

            //if the response is not null store it as a Json String
            if (response.body() != null){
                jsonData = response.body().string();
            }


        } catch (IOException e) {
            System.out.println("there was a problem connecting to the API, please check you connection and try again");
        }
        return jsonData;
    }

    /**
     * calls the TMB API in order to get the route with all the possible
     * itineraries to connect the origin with the destination
     * @param route contains all information and parameters needed by the API
     *             to get the route
     * @return a Json String with the requested route if exists, <b>null</b>
     * otherwise
     */
    @Override
    public String callRoute(Route route){
        String jsonData = null;
        OkHttpClient client = new OkHttpClient();
        //construct the call url
        url = new StringBuilder();
        url.append("https://api.tmb.cat/v1/planner/plan");
        url.append(appId);
        url.append("&fromPlace=").append(route.getOrigin());
        url.append("&toPlace=").append(route.getDestination());
        url.append("&date=").append(route.getDay());
        url.append("&time=").append(route.getHour());
        url.append("&arriveBy=");
        if (route.getDepartureOrArrival() == 'd') {
            url.append("false");
        }else{
            url.append("true");
        }
        url.append("&arriveBy=TRANSIT,WALK");
        url.append("&maxWalkDistance=").append(route.getMaxWalkingDistance());

        //request a call
        Request request = new Request.Builder()
                .url(url.toString())
                .build();
        Response response;

        try {
            // receive a response
            response = client.newCall(request).execute();

            //if the response is not null store it as a Json String
            if (response.body() != null){
                jsonData = response.body().string();
            }


        } catch (IOException e) {
            System.out.println("there was a problem connecting to the API, please check you connection and try again");
        }
        return jsonData;
    }

    /**
     * calls the TMB API to get all the Bus Lines waiting time, considering only
     * the Bus lines that stop at the specified stop.
     * @param StopId the stop id of the requested stop
     * @return a Json String with all the information about the Bus lines at
     * the specified stop, and it returns <b>null</b>> if the stop id is invalid
     * or if something went wrong
     */
    @Override
    public String callLine(String StopId){
        String jsonData = null;
        OkHttpClient client = new OkHttpClient();
        url = new StringBuilder();
        url.append("https://api.tmb.cat/v1/ibus/stops/");
        url.append(StopId);
        url.append(appId);

        //request a call
        Request request = new Request.Builder()
                .url(url.toString())
                .build();
        Response response;

        try {
            // receive a response
            response = client.newCall(request).execute();

            //if the response is not null store it as a Json String
            if (response.body() != null){
                jsonData = response.body().string();
            }


        } catch (IOException e) {
            System.out.println("there was a problem connecting to the API, please check you connection and try again");
        }
        return jsonData;
    }
}
