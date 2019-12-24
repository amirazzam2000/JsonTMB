import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        // app_id : 151d4902 , app_key : 771e0a32ea2b2631b0ad21f66a4ea564
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                //.url("https://api.tmb.cat/v1/transit/parades/2775?app_id=151d4902&app_key=771e0a32ea2b2631b0ad21f66a4ea564")
                .url("https://api.tmb.cat/v1/transit/parades?app_id=151d4902&app_key=771e0a32ea2b2631b0ad21f66a4ea564")
                .build();
        Response response;

        try {
            response = client.newCall(request).execute();
            String jsonData = null;

            if (response.body() != null){
                jsonData = response.body().string();
            }

            System.out.println(jsonData);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
