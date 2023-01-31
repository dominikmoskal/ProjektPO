import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Zapomniales_hasla extends JFrame {

    private JPanel panel1;
    private JTextField loginTextField;
    private JPasswordField kodPasswordField;
    private JButton odzyskajHasloButton;
    private JButton powrotButton;

    public static void main(String[] args) {
        Zapomniales_hasla aplikacja = new Zapomniales_hasla();
        aplikacja.setLocationRelativeTo(null);
        aplikacja.setVisible(true);
    }

    public Zapomniales_hasla() {
        super("Zapomniałeś Hasła");
        ImageIcon logo = new ImageIcon("ico_32px.png");
        this.setIconImage(logo.getImage());
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
                    JOptionPane.showMessageDialog(Zapomniales_hasla.this, "Twoje hasło to: admin", "Informacja", JOptionPane.INFORMATION_MESSAGE);
                    Zapomniales_hasla.this.setVisible(false);
                }
                else JOptionPane.showMessageDialog(Zapomniales_hasla.this, "Błędne dane", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        });

        powrotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
            }
        });
    }
}