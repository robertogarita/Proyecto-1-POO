package group1;

import java.io.UnsupportedEncodingException;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Inicio {
    public static void main(String args[]) throws UnsupportedEncodingException, UnirestException
    {
        String Lista1[][];

        App mensaje = new App();

        Lista1 = mensaje.getNombre1();

        for (int i=0; i<Lista1.length ;i++)
        {
            String LL[] = Lista1[i];
            for (int a=0 ; a<LL.length ; a++)
            {
                System.out.println(LL[a]);
            }
            System.out.println("");
        }
    }
}
