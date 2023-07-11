import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class vehiculos {
    private JLabel marca;
    private JLabel año;
    private JLabel cilindro;
    public JPanel panel;
    private JButton atrasButton;
    private JButton siguienteButton;
    private JLabel salidaAño;
    private JLabel salidaMarca;
    private JLabel salidaCilindro;
    private JButton agregar;

    private int lineaActual = 1;

    public vehiculos() {
        try {
            // Crea un objeto Scanner para leer el archivo de texto
            Scanner scanner = new Scanner(new File("datos.txt"));

            // Lee la primera línea del archivo y separa los valores por comas
            String[] valores = scanner.nextLine().split(",");

            // Asigna los valores correspondientes a cada JLabel
            salidaMarca.setText(valores[0]);
            salidaCilindro.setText(valores[1]);
            salidaAño.setText(valores[2]);

            // Cierra el objeto Scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Agrega un ActionListener al botón "siguiente"
        siguienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Crea un objeto Scanner para leer el archivo de texto
                    Scanner scanner = new Scanner(new File("src/vehiculos.txt"));

                    // Lee las líneas del archivo hasta llegar a la línea actual
                    for (int i = 1; i < lineaActual; i++) {
                        if (scanner.hasNextLine()) {
                            scanner.nextLine();
                        } else {
                            // Si no hay más líneas en el archivo, volver al inicio
                            scanner = new Scanner(new File("datos.txt"));
                            lineaActual = 1;
                            break;
                        }
                    }

                    // Lee la siguiente línea del archivo y separa los valores por comas
                    if (scanner.hasNextLine()) {
                        String[] valores = scanner.nextLine().split(",");

                        // Asigna los valores correspondientes a cada JLabel
                        salidaMarca.setText(valores[0]);
                        salidaCilindro.setText(valores[1]);
                        salidaAño.setText(valores[2]);

                        // Aumenta el número de línea actual en uno
                        lineaActual++;
                    }

                    // Cierra el objeto Scanner
                    scanner.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Agrega un ActionListener al botón "atras"
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Si la línea actual es mayor que uno, disminuir su valor en uno
                    if (lineaActual > 1) {
                        lineaActual--;
                    }

                    // Crea un objeto Scanner para leer el archivo de texto
                    Scanner scanner = new Scanner(new File("src/vehiculos.txt"));

                    // Lee las líneas del archivo hasta llegar a la línea actual
                    for (int i = 1; i < lineaActual; i++) {
                        scanner.nextLine();
                    }

                    // Lee la línea correspondiente del archivo y separa los valores por comas
                    String[] valores = scanner.nextLine().split(",");

                    // Asigna los valores correspondientes a cada JLabel
                    salidaMarca.setText(valores[0]);
                    salidaCilindro.setText(valores[1]);
                    salidaAño.setText(valores[2]);

                    // Cierra el objeto Scanner
                    scanner.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });

        //agregar


        agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Agregar");
                frame.setContentPane(new agregarvehiculo().panelagregar);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Vehiculos");
        frame.setContentPane(new vehiculos().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }
}
