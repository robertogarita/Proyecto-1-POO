package group1;

import javax.swing.*;
import java.util.ArrayList;

import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.event.*;
import java.io.UnsupportedEncodingException;

public class Prueba1 extends JFrame implements ActionListener {
    public static String Lista1[][];
    public static String NombreRep[];
    public static String ValoresRep[];

    private static final long serialVersionUID = 1L;

    private JButton boton1, boton2;

    static ArrayList<String> NombresAlpha = new ArrayList<String>();
    static ArrayList<String> ValoresAlpha = new ArrayList<String>();

    public Prueba1() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        boton1 = new JButton("Comerciar");
        boton1.setBounds(20, 70, 100, 30);
        boton1.addActionListener(this);
        add(boton1);

        boton2 = new JButton("Salir");
        boton2.setBounds(140, 70, 100, 30);
        boton2.addActionListener(this);
        add(boton2);
    }

    public void actionPerformed(ActionEvent E) {
        if (E.getSource() == boton1) {
            Prueba2 ventanaVentas = new Prueba2();

            ventanaVentas.setBounds(0, 0, 475, 375);
            ventanaVentas.setLocationRelativeTo(null);
            ventanaVentas.setVisible(true);
            ventanaVentas.setResizable(false);
        }
        if (E.getSource() == boton2) {
            System.exit(0);
        }
    }

    public static void main(String args[]) throws UnsupportedEncodingException, UnirestException {
        App mensaje = new App();
        Lista1 = mensaje.getNombre1();

        // Imprimir los elementos del API

         //for (int i=0; i<Lista1.length ;i++)
         //{
         //   String LL[] = Lista1[i];
         //   for (int a=0 ; a<LL.length ; a++)
         //   {
         //       System.out.println(LL[a]);
         //   }
         //   System.out.println("");
         //}

        NombreRep = Lista1[0];
        ValoresRep = Lista1[2];
        for (int i = 0; i < NombreRep.length; i++) {
            Boolean Val1 = true, Val2 = true;
            for (int a = 0; a < NombresAlpha.size(); a++) {
                if(NombreRep[i].equals(NombresAlpha.get(a))){
                    Val1 = false;
                    break;
                }
            }
            for(int a=0 ; a<ValoresAlpha.size() ; a++){
                if(ValoresRep[i].equals(ValoresAlpha.get(a))){
                    Val2 = false;
                    break;
                }
            }
            if(Val1 == true){
                NombresAlpha.add(NombreRep[i]);
            }
            if(Val2 == true){
                ValoresAlpha.add(ValoresRep[i]);
            }
        }

        Prueba1 ventanaInicio = new Prueba1();

        ventanaInicio.setBounds(0,0,277,200);
        ventanaInicio.setLocationRelativeTo(null);
        ventanaInicio.setVisible(true);
        ventanaInicio.setResizable(false);
    }
}