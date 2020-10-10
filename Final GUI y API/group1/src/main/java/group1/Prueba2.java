package group1;

import javax.swing.*;
import java.awt.event.*;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Hashtable;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Prueba2 extends JFrame implements ActionListener, ItemListener
{
    String ListaPrincipal[][];

    private static final long serialVersionUID = 1L;

    private JLabel armasLabel, armaduraLabel, posionesLabel, PrecioTotal, Monedas1, Monedas2, Advertencia1, Advertencia2, Cuanto,
        MosAta, MosDef, MosSal;
    private JButton boton1, boton2, boton3, boton4, boton5, boton6, botonEquipar, botonDesequipar;
    private JTextArea textArea1, textArea2;
    private JComboBox comboArmas, comboArmadura, comboPociones, comboVentas, comboEquipo;
    private JScrollPane scrollbar1, scrollbar2;

    public String Inventario[] = new String[5];
    public int salud=50, defensa=50, ataque=25, costo=0, presupuesto = 2000;
    int Actual1 = 0, Actual2 = 0, Actual3 = 0;

    Hashtable<String, Integer> KeyAndValue = new Hashtable<String, Integer>();
    Hashtable<String, String> EquipoColocado = new Hashtable<String, String>();


    public Prueba2()
    {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ArrayList<String> Nombres = new ArrayList<String>();
        ArrayList<String> Valores = new ArrayList<String>();

        //Obtener los nombres y valores de Prueba1
        Nombres = Prueba1.NombresAlpha;
        Valores = Prueba1.ValoresAlpha;

        //Declarar cuadros de texto
        textArea1 = new JTextArea("Inventario\n");
        scrollbar1 = new JScrollPane(textArea1);
        scrollbar1.setBounds(250,65,200,100);
        add(scrollbar1);
        textArea1.setEditable(false);

        textArea2 = new JTextArea("Stats\n\nSalud: " + salud + "\nDefensa: " + defensa + "\nAtaque: " + ataque);
        scrollbar2 = new JScrollPane(textArea2);
        scrollbar2.setBounds(250,175,200,100);
        add(scrollbar2);
        textArea2.setEditable(false);

        //Declarar botones

        boton1 = new JButton("Buy");
        boton1.setBounds(10,25,100,30);
        boton1.addActionListener(this);
        add(boton1);

        boton2 = new JButton("Sell");
        boton2.setBounds(115,25,100,30);
        boton2.addActionListener(this);
        add(boton2);

        boton3 = new JButton("Salir");
        boton3.setBounds(350,285,100,30);
        boton3.addActionListener(this);
        add(boton3);

        boton4 = new JButton("Comprar");
        boton4.setBounds(10,170,100,30);
        boton4.addActionListener(this);
        add(boton4);
        boton4.setVisible(false);

        boton5 = new JButton("Vender");
        boton5.setBounds(10,170,100,30);
        boton5.addActionListener(this);
        add(boton5);
        boton5.setVisible(false);

        boton6 = new JButton("Equipamiento");
        boton6.setBounds(220,25,130,30);
        boton6.addActionListener(this);
        add(boton6);

        botonEquipar = new JButton("Equipar");
        botonEquipar.setBounds(10,170,100,30);
        botonEquipar.addActionListener(this);
        add(botonEquipar);
        botonEquipar.setVisible(false);

        botonDesequipar = new JButton("Desquipar");
        botonDesequipar.setBounds(10,210,100,30);
        botonDesequipar.addActionListener(this);
        add(botonDesequipar);
        botonDesequipar.setVisible(false);

        //Zona de Labels
        Advertencia1 = new JLabel("Nota: Al vender un objeto, se le");
        Advertencia1.setBounds(10,210,300,30);
        add(Advertencia1);
        Advertencia1.setVisible(false);
        Advertencia2 = new JLabel("restara 5 monedas a su precio original");
        Advertencia2.setBounds(10,225,300,30);
        add(Advertencia2);
        Advertencia2.setVisible(false);

        MosAta = new JLabel("");
        MosAta.setBounds(125,190,100,30);
        add(MosAta);
        MosAta.setVisible(false);
        MosDef = new JLabel("");
        MosDef.setBounds(125,205,100,30);
        add(MosDef);
        MosDef.setVisible(false);
        MosSal = new JLabel("");
        MosSal.setBounds(125,220,100,30);
        add(MosSal);
        MosSal.setVisible(false);

        Cuanto = new JLabel("");
        Cuanto.setBounds(125,170,100,30);
        add(Cuanto);
        Cuanto.setVisible(false);

        armasLabel = new JLabel("Armas");
        armasLabel.setBounds(10,70,100,20);
        add(armasLabel);
        armasLabel.setVisible(false);

        armaduraLabel = new JLabel("Armaduras");
        armaduraLabel.setBounds(10,100,100,20);
        add(armaduraLabel);
        armaduraLabel.setVisible(false);

        posionesLabel = new JLabel("Posiones");
        posionesLabel.setBounds(10,130,100,20);
        add(posionesLabel);
        posionesLabel.setVisible(false);

        PrecioTotal = new JLabel("Costo total: " + costo);
        PrecioTotal.setBounds(125,170,100,30);
        add(PrecioTotal);
        PrecioTotal.setVisible(false);
        
        Monedas1 = new JLabel("Monedas:");
        Monedas1.setBounds(355,15,100,30);
        add(Monedas1);
        Monedas2 = new JLabel(String.valueOf(presupuesto));
        Monedas2.setBounds(355,30,100,30);
        add(Monedas2);

        //Zona de comboBoxes
        comboArmas = new JComboBox();
        comboArmas.setBounds(115,70,125,20);
        comboArmas.addItem("");
        comboArmas.addItemListener(this);
        add(comboArmas);
        comboArmas.setVisible(false);

        comboArmadura = new JComboBox();
        comboArmadura.setBounds(115,100,125,20);
        comboArmadura.addItem("");
        comboArmadura.addItemListener(this);
        add(comboArmadura);
        comboArmadura.setVisible(false);

        comboPociones = new JComboBox();
        comboPociones.setBounds(115,130,125,20);
        comboPociones.addItem("");
        comboPociones.addItemListener(this);
        add(comboPociones);
        comboPociones.setVisible(false);

        int Verificador=0;
        while(Verificador < Nombres.size()){
            if(Verificador < Nombres.size()){
                comboArmas.addItem("Espada " + Nombres.get(Verificador));
                KeyAndValue.put("Espada " + Nombres.get(Verificador), Integer.parseInt(Valores.get(Verificador)));
            }
            if(Verificador+1 < Nombres.size()){
                comboArmadura.addItem("Armadura de " + Nombres.get(Verificador+1));
                KeyAndValue.put("Armadura de " + Nombres.get(Verificador+1), Integer.parseInt(Valores.get(Verificador+1)));
            }
            if(Verificador+2 < Nombres.size()){
                comboPociones.addItem("Hechizo " + Nombres.get(Verificador+2));
                KeyAndValue.put("Hechizo " + Nombres.get(Verificador+2), Integer.parseInt(Valores.get(Verificador+2)));
            }
            Verificador += 3;
        }

        comboVentas = new JComboBox();
        comboVentas.setBounds(10,70,175,20);
        comboVentas.addItem("");
        comboVentas.addItemListener(this);
        add(comboVentas);
        comboVentas.setVisible(false);

        comboEquipo = new JComboBox();
        comboEquipo.setBounds(10,70,175,20);
        comboEquipo.addItem("");
        comboEquipo.addItemListener(this);
        add(comboEquipo);
        comboEquipo.setVisible(false);

    }
    public String Reestablecer(){
        return "Hola";
    }
    public void actionPerformed(ActionEvent E)
    {
        //Boton BUY
        if (E.getSource() == boton1)
        {
            comboArmas.setVisible(true);
            //comboArmas.setSelectedIndex(0);
            comboArmadura.setVisible(true);
            //comboArmadura.setSelectedIndex(0);
            comboPociones.setVisible(true);
            //comboPociones.setSelectedIndex(0);
            comboVentas.setVisible(false);
            comboEquipo.setVisible(false);
            boton4.setVisible(true);
            boton5.setVisible(false);
            boton2.setEnabled(true);
            boton1.setEnabled(false);
            boton6.setEnabled(true);
            botonEquipar.setVisible(false);
            botonDesequipar.setVisible(false);
            armasLabel.setVisible(true);
            armaduraLabel.setVisible(true);
            posionesLabel.setVisible(true);
            PrecioTotal.setVisible(true);
            Advertencia1.setVisible(false);
            Advertencia2.setVisible(false);
            Cuanto.setVisible(false);
            MosAta.setVisible(true);
            MosDef.setVisible(true);
            MosSal.setVisible(true);
        }

        //Boton Sell
        if (E.getSource() == boton2)
        {
            comboArmas.setVisible(false);
            comboArmadura.setVisible(false);
            comboPociones.setVisible(false);
            comboVentas.setVisible(true);
            comboEquipo.setVisible(false);
            boton4.setVisible(false);
            boton5.setVisible(true);
            boton1.setEnabled(true);
            boton2.setEnabled(false);
            boton6.setEnabled(true);
            botonEquipar.setVisible(false);
            botonDesequipar.setVisible(false);
            armasLabel.setVisible(false);
            armaduraLabel.setVisible(false);
            posionesLabel.setVisible(false);
            PrecioTotal.setVisible(false);
            Advertencia1.setVisible(true);
            Advertencia2.setVisible(true);
            Cuanto.setVisible(false);
            MosAta.setVisible(false);
            MosDef.setVisible(false);
            MosSal.setVisible(false);

            comboVentas.removeAllItems();
            comboVentas.addItem("");
            for (int i=0 ; i<Inventario.length ; i++)
            {
                if (Inventario[i] != null)
                {
                    if(EquipoColocado.get(Inventario[i]) == "Desequipado"){
                        comboVentas.addItem(Inventario[i]);
                    }
                }
                else{
                    break;
                }
            }
        }

        //Boton EQUIPAMIENTO
        if (E.getSource() == boton6){
            comboArmas.setVisible(false);
            comboArmadura.setVisible(false);
            comboPociones.setVisible(false);
            comboVentas.setVisible(false);
            comboEquipo.setVisible(true);
            boton4.setVisible(false);
            boton5.setVisible(false);
            boton6.setEnabled(false);
            boton1.setEnabled(true);
            boton2.setEnabled(true);
            botonEquipar.setVisible(true);
            botonDesequipar.setVisible(true);
            armasLabel.setVisible(false);
            armaduraLabel.setVisible(false);
            posionesLabel.setVisible(false);
            PrecioTotal.setVisible(false);
            Advertencia1.setVisible(false);
            Advertencia2.setVisible(false);
            Cuanto.setVisible(true);
            MosAta.setVisible(false);
            MosDef.setVisible(false);
            MosSal.setVisible(false);

            comboEquipo.removeAllItems();
            comboEquipo.addItem("");
            for (int i=0 ; i<Inventario.length ; i++){
                if (Inventario[i] != null){
                    comboEquipo.addItem(Inventario[i]);
                }else{
                    break;
                }
            }
        }

        //Boton SALIR
        if (E.getSource() == boton3)
        {
            System.exit(0);
        }

        //Boton EQUIPAR y DESEQUIPAR
        if (E.getSource() == botonEquipar || E.getSource() == botonDesequipar){
            Boolean Pertenece = true;
            String Objeto = comboEquipo.getSelectedItem().toString();
            for(int i=0 ; i<comboArmas.getItemCount() ; i++){
                if(Objeto.equals(comboArmas.getItemAt(i))){
                    Pertenece = false;
                    break;
                }
            }
            if(Pertenece == false){
                if(E.getSource() == botonEquipar){
                    ataque = 25 + (KeyAndValue.get(Objeto)/2);
                    for(int i=0 ; i < comboArmas.getItemCount() ; i++){
                        String ABC = comboArmas.getItemAt(i).toString();
                        if(ABC != ""){
                            EquipoColocado.replace(ABC, "Desequipado");
                        }
                    }
                    EquipoColocado.replace(Objeto, "Equipado");
                    botonEquipar.setEnabled(false);
                    botonDesequipar.setEnabled(true);
                }else{
                    ataque = 25;
                    EquipoColocado.replace(Objeto, "Desequipado");
                    botonEquipar.setEnabled(true);
                    botonDesequipar.setEnabled(false);
                }
            }else{
                if(E.getSource() == botonEquipar){
                    defensa = 50 + (KeyAndValue.get(Objeto)/2);
                    for(int i=0 ; i < comboArmadura.getItemCount() ; i++){
                        String ABC = comboArmadura.getItemAt(i).toString();
                        if(ABC != ""){
                            EquipoColocado.replace(ABC, "Desequipado");
                        }
                    }
                    EquipoColocado.replace(Objeto, "Equipado");
                    botonEquipar.setEnabled(false);
                    botonDesequipar.setEnabled(true);
                }else{
                    defensa = 50;
                    EquipoColocado.replace(Objeto, "Desequipado");
                    botonEquipar.setEnabled(true);
                    botonDesequipar.setEnabled(false);
                }
            }
            textArea2.setText("Stats\n\nSalud: " + salud + "\nDefensa: " + defensa + "\nAtaque: " + ataque);
        }
        
        //Boton VENDER
        if (E.getSource() == boton5){
            String objeto = comboVentas.getSelectedItem().toString();
            String cloneInv[] = new String[5];
            int Comp = 0;
            for (int Cont=0 ; Cont<Inventario.length ; Cont++){
                if(Inventario[Cont] != objeto){
                    cloneInv[Comp] = Inventario[Cont];
                    Comp += 1;
                }
            }
            Inventario = cloneInv;
            textArea1.setText("Inventario\n");
            for (int Cont=0 ; Cont<Inventario.length ; Cont++){
                if (Inventario[Cont] != null){
                    if (Inventario[Cont+1] == null){
                        textArea1.setText(textArea1.getText() + "-" + Inventario[Cont]);
                        break;
                    }else{
                        textArea1.setText(textArea1.getText() + "-" + Inventario[Cont]+ "\n");
                    }
                }
            }
            comboVentas.removeAllItems();
            comboVentas.addItem("");
            for (int i=0 ; i<Inventario.length ; i++)
            {
                if (Inventario[i] != null)
                {
                    comboVentas.addItem(Inventario[i]);
                }
                else{
                    break;
                }
            }
            int Devolucion = KeyAndValue.get(objeto);
            presupuesto = presupuesto + (Devolucion-5);
            Monedas2.setText(String.valueOf(presupuesto));
        }

        //Boton COMPRAR
        if (E.getSource() == boton4)
        {
            if(presupuesto > (Actual1 + Actual2 + Actual3)){
                String BuyArma = comboArmas.getSelectedItem().toString();
                String BuyArmadura = comboArmadura.getSelectedItem().toString();
                String BuyPocion = comboPociones.getSelectedItem().toString();

                boolean Valor1=true, Valor2=true, Valor3=true;

                if (Inventario[Inventario.length - 1] == null){
                    for (int i = 0; i < Inventario.length; i++)
                    {
                        if (BuyArma == Inventario[i] || BuyArma.equals(""))
                        {
                            Valor1 = false;
                        }
                        if (BuyArmadura == Inventario[i] || BuyArmadura.equals(""))
                        {
                            Valor2 = false;
                        }
                        if (BuyPocion == Inventario[i] || BuyPocion.equals(""))
                        {
                            Valor3 = false;
                        }
                    }
                    for(int i=0 ; i<Inventario.length ; i++)
                    {
                        if (Inventario[i] == null)
                        {
                            int SlimB = i;

                            if (Valor1 == true)
                            {
                                if (SlimB < Inventario.length){
                                    Inventario[SlimB] = BuyArma;
                                    textArea1.setText(textArea1.getText() + "\n-"+BuyArma);
                                    EquipoColocado.put(Inventario[SlimB] , "Desequipado");
                                    SlimB += 1;
                                }
                            }
                            if (Valor2 == true)
                            {
                                if (SlimB < Inventario.length){
                                    Inventario[SlimB] = BuyArmadura;
                                    textArea1.setText(textArea1.getText() + "\n-"+BuyArmadura);
                                    EquipoColocado.put(Inventario[SlimB] , "Desequipado");
                                    SlimB += 1;
                                }
                            }
                            if (Valor3 == true)
                            {
                                int Aumento = KeyAndValue.get(BuyPocion);
                                if(BuyPocion.equals(comboPociones.getItemAt(comboPociones.getItemCount()-1))){
                                    if(salud<20 || (salud-Aumento)<0){
                                        JOptionPane.showMessageDialog(null, "Salud muy baja");
                                        Actual3 = 0;
                                    }else{
                                        salud = salud - Aumento;
                                        textArea2.setText("Stats\n\nSalud: " + salud + "\nDefensa: " + defensa + "\nAtaque: " + ataque);
                                    }
                                }else{
                                    if(salud < 100){
                                        salud = salud + Aumento;
                                        if(salud >= 100){
                                            salud = 100;
                                        }
                                        textArea2.setText("Stats\n\nSalud: " + salud + "\nDefensa: " + defensa + "\nAtaque: " + ataque);
                                    }else{
                                        JOptionPane.showMessageDialog(null, "Salud completa");
                                        Actual3 = 0;
                                    }
                                }
                            }
                            if (Valor1 == true || Valor2 == true || Valor3 == true){
                                presupuesto = presupuesto - (Actual1 + Actual2 + Actual3);
                                Monedas2.setText(String.valueOf(presupuesto));
                            }
                            if (Valor1 == false && Valor2 == false && Valor3 == false)
                            {
                                if (BuyArma.equals("") && BuyArmadura.equals("") && BuyPocion.equals(""))
                                {
                                    JOptionPane.showMessageDialog(null, "Debe seleccionar al menos un item");
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null, "Ya adquiriste los objetos");
                                }
                            }
                            break;
                        }
                    }
                    comboArmas.setSelectedIndex(0);
                    comboArmadura.setSelectedIndex(0);
                    comboPociones.setSelectedIndex(0);
                }else{
                    JOptionPane.showMessageDialog(null, "Inventario lleno");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Dinero insuficiente");
            }
        }
    }

    public void itemStateChanged(ItemEvent E){
        String opcion1 = comboArmas.getSelectedItem().toString();
        String opcion2 = comboArmadura.getSelectedItem().toString();
        String opcion3 = comboPociones.getSelectedItem().toString();

        if(E.getSource() == comboArmas){
            if (opcion1 != ""){
                Actual1 = KeyAndValue.get(opcion1);
                PrecioTotal.setText("Costo total: " + (Actual1 + Actual2 + Actual3));
                MosAta.setText("Ataque: +" + Actual1/2);
            }else{
                Actual1 = 0;
                PrecioTotal.setText("Costo total: " + (Actual1 + Actual2 + Actual3));
                MosAta.setText("");
            }
        }
        if(E.getSource() == comboArmadura){
            if(opcion2 != ""){
                Actual2 = KeyAndValue.get(opcion2);
                PrecioTotal.setText("Costo total: " + (Actual1 + Actual2 + Actual3));
                MosDef.setText("Defensa: +" + Actual2/2);
            }else{
                Actual2 = 0;
                PrecioTotal.setText("Costo total: " + (Actual1 + Actual2 + Actual3));
                MosDef.setText("");
            }
        }
        if(E.getSource() == comboPociones){
            if(opcion3 != ""){
                Actual3 = KeyAndValue.get(opcion3);
                PrecioTotal.setText("Costo total: " + (Actual1 + Actual2 + Actual3));
                if(opcion3 == comboPociones.getItemAt(comboPociones.getItemCount()-1)){
                    MosSal.setText("Salud: -" + Actual3);
                }else{
                    MosSal.setText("Salud: +" + Actual3);
                }
            }else{
                Actual3 = 0;
                PrecioTotal.setText("Costo total: " + (Actual1 + Actual2 + Actual3));
                MosSal.setText("");
            }
        }
        if(E.getSource() == comboEquipo){
            Boolean Disponible = false;
            if(comboEquipo.getSelectedItem() != null){
                Cuanto.setVisible(true);
                String ToF = comboEquipo.getSelectedItem().toString();
                if(ToF != ""){
                    if (EquipoColocado.get(ToF) == "Desequipado"){
                        botonEquipar.setEnabled(true);
                        botonDesequipar.setEnabled(false);
                    }else{
                        botonEquipar.setEnabled(false);
                        botonDesequipar.setEnabled(true);
                    }
                }else{
                    botonEquipar.setEnabled(false);
                    botonDesequipar.setEnabled(false);
                    Cuanto.setVisible(false);
                }
                for(int i=0 ; i<comboArmas.getItemCount() ; i++){
                    if(comboArmas.getItemAt(i) != null){
                        if(ToF.equals(comboArmas.getItemAt(i))){
                            Cuanto.setText("Ataque: ");
                            Disponible = true;
                            break;
                        }else{
                            Cuanto.setText("Defensa: ");
                        }
                    }
                }
                if(ToF != ""){
                    int Resultado = 0;
                    if (Disponible == true){
                        Resultado = (((KeyAndValue.get(ToF)/2)+25))-ataque;
                        if(Resultado < 0){
                            Cuanto.setText(Cuanto.getText() + Resultado);
                        }else{
                            Cuanto.setText(Cuanto.getText() + "+" + Resultado);
                        }
                    }else{
                        Resultado = (((KeyAndValue.get(ToF)/2)+50))-defensa;
                        if(Resultado < 0){
                            Cuanto.setText(Cuanto.getText() + Resultado);
                        }else{
                            Cuanto.setText(Cuanto.getText() + "+" + Resultado);
                        }
                    }
                }
            }
        }
        if(E.getSource() == comboVentas){
            if(comboVentas.getSelectedItem() == null){
                boton5.setEnabled(false);
            }else{
                if((comboVentas.getSelectedItem().toString()).equals("")){
                    boton5.setEnabled(false);
                }else{
                    boton5.setEnabled(true);
                }
            }
        }
    }
    public static void main(String args[]) throws UnsupportedEncodingException, UnirestException
    {
        //Crear la ventana de Ventas
        Prueba2 ventanaVentas = new Prueba2();

        ventanaVentas.setBounds(0,0,475,350);
        ventanaVentas.setLocationRelativeTo(null);
        ventanaVentas.setVisible(true);
        ventanaVentas.setResizable(false);
    }
}
