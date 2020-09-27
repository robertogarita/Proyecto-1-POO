package group1;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

class AppTest {
   public static void main(String[] args) throws UnsupportedEncodingException, UnirestException {
      // Host url
      String host = "https://busca-endereco.p.rapidapi.com/?search=USA";
      String charset = "UTF-8";
      // Headers for a request
      String x_rapidapi_host = "busca-endereco.p.rapidapi.com";
      String x_rapidapi_key = "b99fb4bd09mshb5b49c8945ac9e5p19b783jsnbc6ec45e0f1f";// Type here your key
      // Params
      String i = "tt0110912";
      // Format query for preventing encoding problems
      String query = String.format("i=%s", URLEncoder.encode(i, charset));


      HttpResponse<JsonNode> response = Unirest.get(host)
         .header("x-rapidapi-host", x_rapidapi_host)
         .header("x-rapidapi-key", x_rapidapi_key)
         .asJson();

         //System.out.println(response.getStatus());
         //System.out.println(response.getHeaders().get("Content-Type"));

      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      JsonParser jp = new JsonParser();
      JsonElement je = jp.parse(response.getBody().toString());
      //Object je = jp.parse(response.getBody().toString());

      //System.out.println(objectoClompleto.get("price"));
      //System.out.println(je);
      //System.out.println("\n");

      String prettyJsonString = gson.toJson(je);
      //System.out.println(((Object)prettyJsonString).getClass().getSimpleName());
      System.out.println(prettyJsonString);

   }
}