import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;



public class agregarvehiculo {
    private JButton añadir;
    private JTextField insertarmarca;
    private JTextField insertaraño;
    private JTextField insertarcilindraje;
    private JButton verVehiculosButton;
    public JPanel panelagregar;

    public agregarvehiculo() {
        // Agrega un ActionListener al botón "añadir"
        añadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Crea un objeto FileWriter para escribir en el archivo "datos.txt"
                    FileWriter writer = new FileWriter("src/vehiculos.txt", true);

                    // Escribe los datos ingresados en los JTextField en el archivo, separados por comas
                    writer.write(insertarmarca.getText() + "," + insertarcilindraje.getText() + "," + insertaraño.getText() + "\n");

                    // Cierra el objeto FileWriter
                    writer.close();

                    // Borra el contenido de los JTextField
                    insertarmarca.setText("");
                    insertarcilindraje.setText("");
                    insertaraño.setText("");

                    JOptionPane.showMessageDialog(null, "Los datos se han guardado correctamente.");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });


        verVehiculosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame = new JFrame("Vehiculos");
                frame.setContentPane(new vehiculos().panel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Agregar vehículo");
        frame.setContentPane(new agregarvehiculo().panelagregar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }
}
