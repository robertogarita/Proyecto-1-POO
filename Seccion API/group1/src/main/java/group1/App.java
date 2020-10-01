package group1;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class App 
{
    public static String Nombre1[] = new String[10];
    public static String Nombre2[] = new String[10];
    public static String Anho[] = new String[10];
    

    public String[][] getNombre1() throws UnsupportedEncodingException, UnirestException
    {
        createListas();
        
        String Lista[][] = {Nombre1, Nombre2, Anho};
        return Lista;
    }

    public void createListas() throws UnsupportedEncodingException, UnirestException {

        String host = "https://dawn2k-random-german-profiles-and-names-generator-v1.p.rapidapi.com/?count=10&gender=b&maxage=999&minage=100&cc=0&email=0&pwlen=0&ip=0&phone=0&uuid=false&lic=false&color=false&seed=0&images=false&format=json";
        String charset = "UTF-8";
        String x_rapidapi_host = "dawn2k-random-german-profiles-and-names-generator-v1.p.rapidapi.com";
        String x_rapidapi_key = "b99fb4bd09mshb5b49c8945ac9e5p19b783jsnbc6ec45e0f1f";// Type here your key
        String i = "tt0110912";

        // Format query for preventing encoding problems
        String query = String.format("i=%s", URLEncoder.encode(i, charset));


        HttpResponse<JsonNode> response = Unirest.get(host)
            .header("x-rapidapi-host", x_rapidapi_host)
            .header("x-rapidapi-key", x_rapidapi_key)
            .asJson();

        JsonArray Array = new Gson().fromJson(response.getBody().toString(), JsonArray.class);

        for (int cont=0 ; cont<Array.size() ; cont++)
        {
            JsonObject jsonObject = Array.get(cont).getAsJsonObject();

            String name1 = jsonObject.get("firstname").getAsString();
            String name2 = jsonObject.get("lastname").getAsString();
            String year = jsonObject.get("age").getAsString();

            Nombre1[cont] = name1;
            Nombre2[cont] = name2;
            Anho[cont] = year;
        }

        //Ciclos para imprimir los valores de los arreglos
        
        //for (int a=0; a < Nombre1.length ; a++)
        //{
            //System.out.print(Nombre1[a]+" ");
        //}
        //System.out.println("");
        //for (int a=0; a < Nombre2.length ; a++)
        //{
            //System.out.print(Nombre2[a]+" ");
        //}
        //System.out.println("");
        //for (int a=0; a < Anho.length ; a++)
        //{
            //System.out.print(Anho[a]+" ");
        //}
        
    }
}
