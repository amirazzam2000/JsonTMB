package API;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import DataModel.TransportationData.*;
import java.io.IOException;

// app_id : 151d4902 , app_key : 771e0a32ea2b2631b0ad21f66a4ea564
public class WebManager implements Webservice{
    private String appId;
    private StringBuilder url;
    public WebManager(){
        appId = "?app_id=151d4902&app_key=771e0a32ea2b2631b0ad21f66a4ea564";
    }

    @Override
    public String callAllStations(){
        String jsonData = null;
        OkHttpClient client = new OkHttpClient();
        url = new StringBuilder();
        url.append("https://api.tmb.cat/v1/transit/linies/metro/estacions");
        url.append(appId);
        Request request = new Request.Builder()
                .url(url.toString())
                .build();
        Response response;

        try {
            response = client.newCall(request).execute();

            if (response.body() != null){
                jsonData = response.body().string();
            }



        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("there was a problem connecting to the API, please check you connection and try again");
        }
        return jsonData;
    }

    @Override
    public String callAllStops(){
        String jsonData = null;
        OkHttpClient client = new OkHttpClient();
        url = new StringBuilder();
        url.append("https://api.tmb.cat/v1/transit/parades");
        url.append(appId);
        Request request = new Request.Builder()
                .url(url.toString())
                .build();
        Response response;

        try {
            response = client.newCall(request).execute();

            if (response.body() != null){
                jsonData = response.body().string();
            }

            //System.out.println(jsonData);

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("there was a problem connecting to the API, please check you connection and try again");
        }
        return jsonData;
    }

    @Override
    public String callRoute(Route route){
        String jsonData = null;
        OkHttpClient client = new OkHttpClient();
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

        Request request = new Request.Builder()
                .url(url.toString())
                .build();
        Response response;

        try {
            response = client.newCall(request).execute();

            if (response.body() != null){
                jsonData = response.body().string();
            }

            //System.out.println(jsonData);

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("there was a problem connecting to the API, please check you connection and try again");
        }
        return jsonData;
    }

    @Override
    public String callLine(String line){
        String jsonData = null;
        OkHttpClient client = new OkHttpClient();
        url = new StringBuilder();
        url.append("https://api.tmb.cat/v1/ibus/stops/");
        url.append(line);
        url.append(appId);

        Request request = new Request.Builder()
                .url(url.toString())
                .build();
        Response response;

        try {
            response = client.newCall(request).execute();

            if (response.body() != null){
                jsonData = response.body().string();
            }

            //System.out.println(jsonData);

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("there was a problem connecting to the API, please check you connection and try again");
        }
        return jsonData;
    }
}
