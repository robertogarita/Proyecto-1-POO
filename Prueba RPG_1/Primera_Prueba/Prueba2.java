package Primera_Prueba;

import javax.swing.*;
import javax.swing.event.ChangeListener;

import java.awt.event.*;
import java.awt.*;


public class Prueba2 extends JFrame implements ActionListener
{

    private static final long serialVersionUID = 1L;
    private JButton boton1, boton2, boton3, boton4, boton5, boton6;

    private JTextArea textArea1, textArea2;
    private JComboBox comboArmas, comboArmadura, comboPociones, comboVentas;

    public String Inventario[] = new String[5];
    public int salud=50, defensa=50, ataque=25;


    public Prueba2()
    {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Declarar cuadros de texto

        textArea1 = new JTextArea("Inventario\n");
        textArea1.setBounds(115,65,100,200);
        add(textArea1);
        textArea1.setEditable(false);

        textArea2 = new JTextArea("Stats\n\nSalud: " + salud + "\nDefensa: " + defensa + "\nAtaque: " + ataque);
        textArea2.setBounds(220,65,100,200);
        add(textArea2);
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
        boton3.setBounds(220,275,100,30);
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
        boton6.setBounds(220,25,100,30);
        boton6.addActionListener(this);
        add(boton6);

        //Zona de comboBoxes

        comboArmas = new JComboBox();
        comboArmas.setBounds(10,70,100,20);
        comboArmas.addItem("Armas");
        comboArmas.addItem("Espada larga");
        comboArmas.addItem("Espada laser");
        comboArmas.addItem("Espada doble");
        add(comboArmas);
        comboArmas.setVisible(false);

        comboArmadura = new JComboBox();
        comboArmadura.setBounds(10,100,100,20);
        comboArmadura.addItem("Armaduras");
        comboArmadura.addItem("Casco de piel");
        comboArmadura.addItem("Pechera de oso");
        comboArmadura.addItem("Zapatos de oro");
        add(comboArmadura);
        comboArmadura.setVisible(false);

        comboPociones = new JComboBox();
        comboPociones.setBounds(10,130,100,20);
        comboPociones.addItem("Pociones");
        comboPociones.addItem("Pocion de salud");
        comboPociones.addItem("Pocion de agilidad");
        comboPociones.addItem("Pocion de experiencia");
        add(comboPociones);
        comboPociones.setVisible(false);

        comboVentas = new JComboBox();
        comboVentas.setBounds(10,70,100,20);
        comboVentas.addItem("");
        add(comboVentas);
        comboVentas.setVisible(false);

    }

    public void actionPerformed(ActionEvent E)
    {
        //Boton BUY
        if (E.getSource() == boton1)
        {
            comboArmas.setVisible(true);
            comboArmadura.setVisible(true);
            comboPociones.setVisible(true);
            comboVentas.setVisible(false);
            boton4.setVisible(true);
            boton5.setVisible(false);
            boton2.setEnabled(true);
            boton1.setEnabled(false);
        }

        //Boton Sell
        if (E.getSource() == boton2)
        {
            comboArmas.setVisible(false);
            comboArmadura.setVisible(false);
            comboPociones.setVisible(false);
            comboVentas.setVisible(true);
            boton4.setVisible(false);
            boton5.setVisible(true);
            boton1.setEnabled(true);
            boton2.setEnabled(false);

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
        }

        //Boton SALIR
        if (E.getSource() == boton3)
        {
            System.exit(0);
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
            textArea1.setText("Inventario\n\n");
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
        }

        //Boton COMPRAR
        if (E.getSource() == boton4)
        {
            String BuyArma = comboArmas.getSelectedItem().toString();
            String BuyArmadura = comboArmadura.getSelectedItem().toString();
            String BuyPocion = comboPociones.getSelectedItem().toString();
            boolean Valor1=true, Valor2=true, Valor3=true;

            if (Inventario[Inventario.length - 1] == null){
                for (int i = 0; i < Inventario.length; i++)
                {
                    if (BuyArma == Inventario[i] || BuyArma.equals("Armas"))
                    {
                        Valor1 = false;
                    }
                    if (BuyArmadura == Inventario[i] || BuyArmadura.equals("Armaduras"))
                    {
                        Valor2 = false;
                    }
                    if (BuyPocion == Inventario[i] || BuyPocion.equals("Pociones"))
                    {
                        Valor3 = false;
                    }
                }
                for(int i=0 ; i<Inventario.length ; i++)
                {
                    if (Inventario[i] == null)
                    {
                        if (Valor1 == true)
                        {
                            if (i < Inventario.length){
                                Inventario[i] = BuyArma;
                                textArea1.setText(textArea1.getText() + "\n-"+BuyArma);
                            }
                        }
                        if (Valor2 == true)
                        {
                            if (i+1 < Inventario.length){
                                Inventario[i+1] = BuyArmadura;
                                textArea1.setText(textArea1.getText() + "\n-"+BuyArmadura);
                            }
                        }
                        if (Valor3 == true)
                        {
                            if (i+2 < Inventario.length){
                                Inventario[i+2] = BuyPocion;
                                textArea1.setText(textArea1.getText() + "\n-"+BuyPocion);
                            }
                        }
                        if (Valor1 == false && Valor2 == false && Valor3 == false)
                        {
                            if (BuyArma.equals("Armas") && BuyArmadura.equals("Armaduras") && BuyPocion.equals("Pociones"))
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
            }
            else{
                JOptionPane.showMessageDialog(null, "Inventario lleno");
            }
        }
    }

    public static void main(String args[])
    {
        Prueba2 ventanaVentas = new Prueba2();

        ventanaVentas.setBounds(0,0,345,370);
        ventanaVentas.setLocationRelativeTo(null);
        ventanaVentas.setVisible(true);
        ventanaVentas.setResizable(false);
    }
}
