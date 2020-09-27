package Primera_Prueba;

import javax.swing.*;
import javax.swing.event.ChangeListener;

import java.awt.event.*;
import java.awt.*;


public class Prueba2 extends JFrame implements ActionListener
{

    private static final long serialVersionUID = 1L;
    private JButton boton1, boton2, boton3, boton4;

    private JTextArea textArea1, textArea2;
    private JScrollBar scrollBar;
    private JComboBox comboArmas, comboArmadura, comboPociones;

    public String Inventario[] = new String[5];
    public int salud=50, defensa=50, ataque=25;

    public Prueba2()
    {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Declarar cuadros de texto

        textArea1 = new JTextArea("Inventario\n");
        textArea1.setBounds(130,65,100,200);
        add(textArea1);
        textArea1.setVisible(false);

        textArea2 = new JTextArea("Stats\n\nSalud: " + salud + "\nDefensa: " + defensa + "\nAtaque: " + ataque);
        textArea2.setBounds(240,65,100,200);
        add(textArea2);
        textArea2.setVisible(false);

        //Declarar botones

        boton1 = new JButton("Buy");
        boton1.setBounds(10,25,100,30);
        boton1.addActionListener(this);
        add(boton1);

        boton2 = new JButton("Sell");
        boton2.setBounds(115,25,100,30);
        boton2.addActionListener(this);
        add(boton2);

        boton4 = new JButton("Comprar");
        boton4.setBounds(10,170,100,30);
        boton4.addActionListener(this);
        add(boton4);
        boton4.setVisible(false);

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

    }

    public void actionPerformed(ActionEvent E)
    {
        if (E.getSource() == boton1)
        {
            comboArmas.setVisible(true);
            comboArmadura.setVisible(true);
            comboPociones.setVisible(true);
            boton4.setVisible(true);
            textArea1.setVisible(true);
            textArea2.setBounds(240,65,100,200);
            textArea2.setVisible(true);
        }

        if (E.getSource() == boton2)
        {
            comboArmas.setVisible(false);
            comboArmadura.setVisible(false);
            comboPociones.setVisible(false);
            boton4.setVisible(false);
            textArea1.setVisible(true);
            textArea2.setVisible(true);
        }
        if (E.getSource() == boton4)
        {
            String BuyArma = comboArmas.getSelectedItem().toString();
            String BuyArmadura = comboArmadura.getSelectedItem().toString();
            String BuyPocion = comboPociones.getSelectedItem().toString();
            boolean Valor1=true, Valor2=true, Valor3=true;

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
            
            if (Valor1 == true)
            {
                Inventario[0] = BuyArma;
                textArea1.setText(textArea1.getText() + "\n-"+BuyArma);
            }
            if (Valor2 == true)
            {
                Inventario[1] = BuyArmadura;
                textArea1.setText(textArea1.getText() + "\n-"+BuyArmadura);
            }
            if (Valor3 == true)
            {
                Inventario[2] = BuyPocion;
                textArea1.setText(textArea1.getText() + "\n-"+BuyPocion);
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
        }
    }

    public static void main(String args[])
    {
        Prueba2 ventanaVentas = new Prueba2();

        ventanaVentas.setBounds(0,0,500,500);
        ventanaVentas.setLocationRelativeTo(null);
        ventanaVentas.setVisible(true);
        ventanaVentas.setResizable(false);
    }
}
