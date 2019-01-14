package SmartRATP;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class SmartRATP {
    private static String line_id = "810:B";
    private static String stop_point_id = "8775864:810:B";
    private static String apikey = "93c68fe8772dc1a311988b7532821405da0837f5cbcf99bf8471f0f8";
//    https://www.vianavigo.com/fiches-horaires/train
//    https://api-lab-trone-stif.opendata.stif.info/explore/dataset/tr-vianavigo/information/



    public static void main(String[] args) throws Exception {

        HttpURLConnection http = new HttpURLConnection();
        List<Prochain_passage> prochains_passages;
        String url = "https://api-lab-trone-stif.opendata.stif.info/service/tr-vianavigo/departures";
        String response = http.sendGet(url
                + "?apikey=" + apikey
                + "&line_id=" + URLEncoder.encode(line_id, "UTF-8")
                + "&stop_point_id=" + URLEncoder.encode(stop_point_id, "UTF-8"));
        try {
            Type listType = new TypeToken<ArrayList<Prochain_passage>>(){}.getType();
            prochains_passages = new Gson().fromJson(response, listType);
            for (Prochain_passage prochain_passage:prochains_passages){
                System.out.println(prochain_passage.getLineDirection()
                        + ": "
                        + prochain_passage.getSchedule()
                        + " minute(s).");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
