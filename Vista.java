/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Vista extends JFrame {
    
    private JTextField campoA, campoB, campoC;
    private JLabel etiquetaResultado;

    public Vista() {
 
        setTitle("Calculadora: Formula general");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel etiquetaA = new JLabel("A:");
        JLabel etiquetaB = new JLabel("B:");
        JLabel etiquetaC = new JLabel("C:");

        campoA = new JTextField(5);
        campoB = new JTextField(5);
        campoC = new JTextField(5);

        etiquetaResultado = new JLabel("Resultado:");

        JButton botonCalcular = new JButton("Calcular");
        JButton botonLimpiar = new JButton("Limpiar");

        setLayout(new GridLayout(8, 5));

        add(etiquetaA);
        add(campoA);
        add(etiquetaB);
        add(campoB);
        add(etiquetaC);
        add(campoC);
        add(etiquetaResultado);
        add(new JLabel()); // Espacio en blanco para la etiqueta de resultado

        add(botonCalcular);
        add(botonLimpiar);
        
        botonCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularResultado();
            }
        });

        botonLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });
    }

    private void calcularResultado() {
        try {
            double a = Double.parseDouble(campoA.getText());
            double b = Double.parseDouble(campoB.getText());
            double c = Double.parseDouble(campoC.getText());

            // Formula general
            double discriminante = b * b - 4 * a * c;

            if (discriminante < 0) {
                etiquetaResultado.setText("No hay soluciones reales");
            } else if (discriminante == 0) {
                double solucionUnica = -b / (2 * a);
                etiquetaResultado.setText("Solución unica: " + solucionUnica);
            } else {
                double raiz1 = (-b + Math.sqrt(discriminante)) / (2 * a);
                double raiz2 = (-b - Math.sqrt(discriminante)) / (2 * a);
                etiquetaResultado.setText("Raiz 1: " + raiz1 + ", Raiz 2: " + raiz2);
            }
        } catch (NumberFormatException ex) {
            etiquetaResultado.setText("Ingrese valores numericos en A, B y C");
        }
    }

    private void limpiarCampos() {
        campoA.setText("");
        campoB.setText("");
        campoC.setText("");
        etiquetaResultado.setText("Resultado:");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }
}
