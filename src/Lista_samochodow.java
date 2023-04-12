import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Lista_samochodow extends JFrame {
    private JTextField markaTextField;
    private JTextField modelTextField;
    private JTextField rocznikTextField;
    private JTextField numerVINTextField;
    private JTextField kolorTextField;
    private JCheckBox TAKCheckBox;
    private JCheckBox NIECheckBox;
    private JTextField cenaTextField;
    private JButton dodajSamochodButton;
    private JButton zapiszZmianyButton;
    private JPanel panel1;
    private JButton usunSamochodButton;
    private JList<String> listaSamochodow;
    private JButton sprzedajSamochodButton;
    private JList sprzedaneSamochody;
    private JList<String> listaDostepnychSamochodow;
    public static ArrayList<Samochod> lSamochodow = new ArrayList<Samochod>();
    public static DefaultListModel tymczasowaListaSamochodow = new DefaultListModel();
    public static ArrayList<Samochod> lSprzedanychSamochodow = new ArrayList<Samochod>();
    public static DefaultListModel tymczasowaListaSprzedanychSamochodow = new DefaultListModel();
    public static ArrayList<Samochod> lDostepnychSamochodow = new ArrayList<Samochod>();
    public static int index;

    public static void main(String[] args) {
        Lista_samochodow aplikacja = new Lista_samochodow();
        aplikacja.setLocationRelativeTo(null);
        aplikacja.setVisible(true);
    }

    public JList<String> getListaSamochodow() {
        return listaSamochodow;
    }

    public static DefaultListModel getTymczasowaListaSamochodow() {
        return tymczasowaListaSamochodow;
    }

    public static void setTymczasowaListaSamochodow(DefaultListModel tymczasowaListaSamochodow) {
        Lista_samochodow.tymczasowaListaSamochodow = tymczasowaListaSamochodow;
    }

    public JList<String> getSprzedaneSamochody() {
        return sprzedaneSamochody;
    }

    public void setSprzedaneSamochody(JList<String> sprzedaneSamochody) {
        this.sprzedaneSamochody = sprzedaneSamochody;
    }

    public static int getIndex() {
        return index;
    }

    public void setListaSamochodow(JList<String> listaSamochodow) {
        this.listaSamochodow = listaSamochodow;
    }

    public Lista_samochodow() {
        super("Komis samochodowy");
        ImageIcon logo = new ImageIcon("ico_32px.png");
        this.setIconImage(logo.getImage());
        this.setContentPane(this.panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        Samochod s1 = new Samochod("Audi", "A3", "2002", "JH4KA3263KC011910", "Niebieski", "23045 zł", true, false);
        Samochod s2 = new Samochod("Suzuki", "Verona", "2004", "KL5VM52L54B110914", "Srebrny", "21370 zł", false, false);
        Samochod s3 = new Samochod("Honda", "Odyssey", "2009", "5FNRL38739B001353", "Czerwony", "14590 zł", true, false);
        Samochod s4 = new Samochod("Audi", "A4", "2002", "JH4KA3263KC023456", "Biały", "33045 zł", true, true);

        lDostepnychSamochodow.add(s1);
        lDostepnychSamochodow.add(s2);
        lDostepnychSamochodow.add(s3);
        lDostepnychSamochodow.add(s4);

        tymczasowaListaSamochodow.addElement(s1.getMarka()+" "+s1.getModel());
        tymczasowaListaSamochodow.addElement(s2.getMarka()+" "+s2.getModel());
        tymczasowaListaSamochodow.addElement(s3.getMarka()+" "+s3.getModel());
        listaSamochodow.setModel(tymczasowaListaSamochodow);
        sprzedaneSamochody.setModel(tymczasowaListaSprzedanychSamochodow);
        JList<String> listaDostepnychSamochodow = new JList<String>();
        DefaultListModel<String> tymczasowaListaDostepnychSamochodow = new DefaultListModel<String>();
        for (Samochod samochod : lDostepnychSamochodow) {
            if (samochod.getCzySprzedany() == false) {
                lSamochodow.add(samochod);
                tymczasowaListaDostepnychSamochodow.addElement(samochod.getMarka()+" "+samochod.getModel());
            } else {
                lSprzedanychSamochodow.add(samochod);
                tymczasowaListaSprzedanychSamochodow.addElement(samochod.getMarka()+" "+samochod.getModel());
            }
        }

        listaDostepnychSamochodow.setModel(tymczasowaListaDostepnychSamochodow);
        listaSamochodow.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    sprzedaneSamochody.clearSelection();
                    index = listaSamochodow.getSelectedIndex();
                    markaTextField.setText(lSamochodow.get(index).getMarka());
                    modelTextField.setText(lSamochodow.get(index).getModel());
                    rocznikTextField.setText(lSamochodow.get(index).getRocznik());
                    numerVINTextField.setText(lSamochodow.get(index).getNumerVIN());
                    kolorTextField.setText(lSamochodow.get(index).getKolor());
                    cenaTextField.setText(lSamochodow.get(index).getCena());
                    TAKCheckBox.setSelected(lSamochodow.get(index).getCzyWypadkowy());
                    NIECheckBox.setSelected(!lSamochodow.get(index).getCzyWypadkowy());
                } catch (IndexOutOfBoundsException indexException) {
                    listaSamochodow.invalidate();
                    listaSamochodow.validate();
                    listaSamochodow.repaint();
                }
            }
        });

        sprzedaneSamochody.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    listaSamochodow.clearSelection();
                    index = sprzedaneSamochody.getSelectedIndex();
                    markaTextField.setText(lSprzedanychSamochodow.get(index).getMarka());
                    modelTextField.setText(lSprzedanychSamochodow.get(index).getModel());
                    rocznikTextField.setText(lSprzedanychSamochodow.get(index).getRocznik());
                    numerVINTextField.setText(lSprzedanychSamochodow.get(index).getNumerVIN());
                    kolorTextField.setText(lSprzedanychSamochodow.get(index).getKolor());
                    cenaTextField.setText(lSprzedanychSamochodow.get(index).getCena());
                    TAKCheckBox.setSelected(lSprzedanychSamochodow.get(index).getCzyWypadkowy());
                    NIECheckBox.setSelected(!lSprzedanychSamochodow.get(index).getCzyWypadkowy());
                } catch (IndexOutOfBoundsException indexException) {
                    sprzedaneSamochody.invalidate();
                    sprzedaneSamochody.validate();
                    sprzedaneSamochody.repaint();
                }
            }
        });

        dodajSamochodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dodaj_samochod dodajSamochod = new Dodaj_samochod();
                dodajSamochod.setLocationRelativeTo(null);
                dodajSamochod.setVisible(true);
                dodajSamochod.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
        usunSamochodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = listaSamochodow.getSelectedIndex();
                if (selectedIndex >= 0) {
                    tymczasowaListaSamochodow.remove(selectedIndex);
                    lSamochodow.remove(selectedIndex);
                    listaSamochodow.repaint();
                }
                markaTextField.setText("");
                modelTextField.setText("");
                rocznikTextField.setText("");
                numerVINTextField.setText("");
                kolorTextField.setText("");
                cenaTextField.setText("");
                TAKCheckBox.isSelected();
            }
        });
        zapiszZmianyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String marka = markaTextField.getText();
                String model = modelTextField.getText();
                String rocznik = rocznikTextField.getText();
                String numerVIN = numerVINTextField.getText();
                String kolor = kolorTextField.getText();
                String cena = cenaTextField.getText();
                boolean czyWypadkowy = TAKCheckBox.isSelected();
                if (!listaSamochodow.isSelectionEmpty()) {
                    lSamochodow.set(index, new Samochod(marka, model, rocznik, numerVIN, kolor, cena, czyWypadkowy, false));
                    tymczasowaListaSamochodow.setElementAt(marka+" "+model, index);
                } else {
                    lSprzedanychSamochodow.set(index, new Samochod(marka, model, rocznik, numerVIN, kolor, cena, czyWypadkowy, true));
                    tymczasowaListaSprzedanychSamochodow.setElementAt(marka+" "+model, index);
                }

            }
        });
        sprzedajSamochodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sprzedaj_samochod sprzedanySamochod = new Sprzedaj_samochod();
                sprzedanySamochod.setLocationRelativeTo(null);
                sprzedanySamochod.setVisible(true);
                sprzedanySamochod.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
    }
}
