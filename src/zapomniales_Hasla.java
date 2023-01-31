import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class zapomniales_Hasla extends JFrame {

    private JPanel panel1;
    private JTextField loginTextField;
    private JPasswordField kodPasswordField;
    private JButton odzyskajHasloButton;

    public static void main(String[] args) {
        zapomniales_Hasla aplikacja = new zapomniales_Hasla();
        aplikacja.setVisible(true);
    }

    public zapomniales_Hasla() {
        super("Zapomniałeś Hasła");
        this.setContentPane(this.panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 150);

        odzyskajHasloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String poprawnyLogin = "admin";
                String poprawnyKod = "0000";

                String login = loginTextField.getText();
                String kod = new String(kodPasswordField.getPassword());  //Arrays.toString(kodPasswordField.getPassword());

                if (login.equals(poprawnyLogin) && kod.equals(poprawnyKod)) {
                    JOptionPane.showMessageDialog(zapomniales_Hasla.this, "Twoje hasło to: admin", "Informacja", JOptionPane.INFORMATION_MESSAGE);
                    zapomniales_Hasla.this.setVisible(false);
                }
                else JOptionPane.showMessageDialog(zapomniales_Hasla.this, "Błędne dane", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}