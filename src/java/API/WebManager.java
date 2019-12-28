package API;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

// app_id : 151d4902 , app_key : 771e0a32ea2b2631b0ad21f66a4ea564
public class WebManager {

    public static String callAllStations(){
        String jsonData = null;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.tmb.cat/v1/transit/linies/metro/estacions?app_id=151d4902&app_key=771e0a32ea2b2631b0ad21f66a4ea564")
                .build();
        Response response;

        try {
            response = client.newCall(request).execute();

            if (response.body() != null){
                jsonData = response.body().string();
            }

            //System.out.println(jsonData);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonData;
    }
}
