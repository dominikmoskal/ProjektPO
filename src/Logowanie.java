import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Logowanie extends JFrame {
    private JPanel panel1;
    private JPasswordField passwordField1;
    private JTextField textField1;
    private JButton zapomnialesHaslaButton;
    private JButton zalogujSieButton;

    public static void main(String[] args) {
        Logowanie aplikacja = new Logowanie();
        aplikacja.setLocationRelativeTo(null);
        aplikacja.setVisible(true);
    }

    public Logowanie() {
        super("Logowanie do systemu");
        ImageIcon logo = new ImageIcon("ico_32px.png");
        this.setIconImage(logo.getImage());
        this.setContentPane(this.panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);

        zalogujSieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = textField1.getText();
                String password = new String(passwordField1.getPassword());

                String correctLogin = "admin";
                String correctPassword = "admin";

                if (login.equals(correctLogin) && password.equals(correctPassword)) {
                    //JOptionPane.showMessageDialog(null, "Zalogowano pomyślnie.");
                    Logowanie.this.setVisible(false);
                    Lista_samochodow listaSamochodow = new Lista_samochodow();
                    listaSamochodow.setLocationRelativeTo(null);
                    listaSamochodow.setVisible(true);
                }
                else JOptionPane.showMessageDialog(null, "Niepoprawny login lub hasło.");
            }
        });

        zapomnialesHaslaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Zapomniales_hasla zapomnialesHasla = new Zapomniales_hasla();
                zapomnialesHasla.setLocationRelativeTo(null);
                zapomnialesHasla.setVisible(true);
            }
        });
    }
}
