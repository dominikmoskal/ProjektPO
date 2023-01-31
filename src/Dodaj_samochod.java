import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dodaj_samochod extends JFrame{
    private JTextField markaTextField;
    private JTextField modelTextField;
    private JTextField rocznikTextField;
    private JTextField numerVINTextField;
    private JTextField kolorTextField;
    private JCheckBox TAKCheckBox;
    private JCheckBox NIECheckBox;
    private JTextField cenaTextField;
    private JButton dodajSamochodButton;
    private JPanel panel1;

    public static void main(String[] args) {
        Dodaj_samochod aplikacja = new Dodaj_samochod();
        aplikacja.setLocationRelativeTo(null);
        aplikacja.setVisible(true);
    }
    public Dodaj_samochod(){
        super("Informacje o dodawanym pojeździe");
        ImageIcon logo = new ImageIcon("ico_32px.png");
        this.setIconImage(logo.getImage());
        this.setContentPane(this.panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 500);

        dodajSamochodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String marka = markaTextField.getText();
                String model = modelTextField.getText();
                String rocznik = rocznikTextField.getText();
                String numerVIN = numerVINTextField.getText();
                String kolor = kolorTextField.getText();
                String cena = cenaTextField.getText();
                boolean czyWypadkowy = TAKCheckBox.isSelected();

                Samochod samochod = new Samochod(marka, model, rocznik, numerVIN, kolor, cena, czyWypadkowy);
                Lista_samochodow.dane.add(samochod);
               // Lista_samochodow.tymczasowaListaSamochodow.addElement(model);
                Lista_samochodow.getTymczasowaListaSamochodow().addElement(samochod.Model);

                JOptionPane.showMessageDialog(null, "Samochód dodany pomyślnie");
                dispose();
            }
        });
    }
}
