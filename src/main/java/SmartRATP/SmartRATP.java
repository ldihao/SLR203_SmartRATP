package SmartRATP;


import java.net.URLEncoder;

public class SmartRATP {
    private static String line_id = "810:B";
    private static String stop_point_id = "8775864:810:B";
    private static String apikey = "93c68fe8772dc1a311988b7532821405da0837f5cbcf99bf8471f0f8";


    public static void main(String[] args) throws Exception {

        HttpURLConnection http = new HttpURLConnection();

        System.out.println("Testing 1 - Send Http GET request");
        http.sendGet("https://api-lab-trone-stif.opendata.stif.info/service/tr-vianavigo/departures"
                + "?apikey=" + apikey
                + "&line_id=" + URLEncoder.encode(line_id, "UTF-8")
                + "&stop_point_id=" + URLEncoder.encode(stop_point_id, "UTF-8"));

    }


}
