import javax.swing.*;


public class vehiculos {
    private JLabel marca;
    private JLabel año;
    private JLabel cilindro;
    private JPanel panel;
    private JButton atrasButton;
    private JButton siguienteButton;
    private JLabel salidaAño;
    private JLabel salidaMarca;
    private JLabel salidaCilindro;

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
