import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Sprzedaj_samochod extends JFrame {
    private JPanel panel1;
    private JTextField markaTextField;
    private JTextField modelTextField;
    private JTextField rocznikTextField;
    private JTextField numerVINTextField;
    private JCheckBox kartaCheckBox;
    private JCheckBox gotówkaCheckBox;
    private JTextField cenaTextField;
    private JButton sprzedajSamochodButton;
    private JList listaSamochodow;
    private JTextField kolorTextField;
    private JTextField miastoTextField;

    public Sprzedaj_samochod(){
        super("Sprzedaż samochodu");
        ImageIcon logo = new ImageIcon("ico_32px.png");
        this.setIconImage(logo.getImage());
        this.setContentPane(this.panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 600);
        listaSamochodow.setModel(Lista_samochodow.tymczasowaListaSamochodow);
        sprzedajSamochodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Imie = markaTextField.getText();
                String Nazwisko = modelTextField.getText();
                String DataUR = rocznikTextField.getText();
                String Numer = numerVINTextField.getText();
                String Adres = kolorTextField.getText();
                String Miasto = miastoTextField.getText();
                String Cena = cenaTextField.getText();
                boolean Platnosc = kartaCheckBox.isSelected();
                Klient klient = new Klient(Imie,Nazwisko,DataUR,Cena,Miasto,Numer,Adres,Platnosc);
                int index = listaSamochodow.getSelectedIndex();
                Lista_samochodow.tymczasowaListaSprzedanychSamochodow.addElement(Lista_samochodow.tymczasowaListaSamochodow.getElementAt(index));
                Lista_samochodow.lSprzedanychSamochodow.add(Lista_samochodow.lSamochodow.get(index));
                Lista_samochodow.lSamochodow.remove(index);
                Lista_samochodow.tymczasowaListaSamochodow.remove(index);
                dispose();
            }
        });
    }
    public static void main(String[] args) {
        Sprzedaj_samochod aplikacja = new Sprzedaj_samochod();
        aplikacja.setLocationRelativeTo(null);
        aplikacja.setVisible(true);
    }
}
