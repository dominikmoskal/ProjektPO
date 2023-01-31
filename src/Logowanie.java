import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Logowanie extends JFrame{
    private JPanel panel1;
    private JPasswordField passwordField1;
    private JTextField textField1;
    private JButton zapomnialesHaslaButton;
    private JButton zalogujSieButton;
    private JButton zarejestrujSięButton;

    public static void main(String[] args) {
        Logowanie aplikacja = new Logowanie();
        aplikacja.setVisible(true);
    }

    public Logowanie() {
        super("Logowanie do systemu");
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
                    JOptionPane.showMessageDialog(null, "Zalogowano pomyślnie.");
                    Logowanie.this.setVisible(false);
                    Lista_samochodow listaSamochodow = new Lista_samochodow();
                    listaSamochodow.setVisible(true);
                }
                else JOptionPane.showMessageDialog(null, "Niepoprawny login lub hasło.");
            }
        });

        zapomnialesHaslaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zapomniales_Hasla zapomnialesHasla = new zapomniales_Hasla();
                zapomnialesHasla.setVisible(true);
            }
        });
    }
}
