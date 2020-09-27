package Primera_Prueba;

import javax.swing.*;
import java.awt.event.*;

public class Prueba1 extends JFrame implements ActionListener
{
    private static final long serialVersionUID = 1L;

    private JButton boton1, boton2;

    public Prueba1()
    {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        boton1 = new JButton("Comerciar");
        boton1.setBounds(20,70,100,30);
        boton1.addActionListener(this);
        add(boton1);

        boton2 = new JButton("Salir");
        boton2.setBounds(140,70,100,30);
        boton2.addActionListener(this);
        add(boton2);
    }

    public void actionPerformed(ActionEvent E)
    {
        if (E.getSource() == boton1)
        {
        }
        if (E.getSource() == boton2)
        {
            System.exit(0);
        }
    }
    public static void main(String args[])
    {
        Prueba1 ventanaInicio = new Prueba1();

        ventanaInicio.setBounds(0,0,277,200);
        ventanaInicio.setLocationRelativeTo(null);
        ventanaInicio.setVisible(true);
        ventanaInicio.setResizable(false);
    }
}