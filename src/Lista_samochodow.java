import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class Lista_samochodow extends JFrame{
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
    public static ArrayList<Samochod> dane = new ArrayList<Samochod>();
    public static DefaultListModel tymczasowaListaSamochodow = new DefaultListModel();
    public static int index ;
    public static void main(String[] args)
    {
        Lista_samochodow aplikacja = new Lista_samochodow();
        aplikacja.setLocationRelativeTo(null);
        aplikacja.setVisible(true);
    }
    public  JList<String> getListaSamochodow() {
        return listaSamochodow;
    }
    public static DefaultListModel getTymczasowaListaSamochodow() {
        return tymczasowaListaSamochodow;
    }
    public static void setTymczasowaListaSamochodow(DefaultListModel tymczasowaListaSamochodow) {
        Lista_samochodow.tymczasowaListaSamochodow = tymczasowaListaSamochodow;
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
        this.setSize(600,600);
        Samochod s1 = new Samochod("Audi","A3","2002","JH4KA3263KC011910","Niebieski","23045 zł",true);
        Samochod s2 = new Samochod("Suzuki","Verona","2004","KL5VM52L54B110914","Srebrny","21370 zł",false);
        Samochod s3 = new Samochod("Honda","Odyssey","2009","5FNRL38739B001353","Czerwony","14590 zł",true);
        dane.add(s1);
        dane.add(s2);
        dane.add(s3);
        tymczasowaListaSamochodow.addElement(s1.getModel());
        tymczasowaListaSamochodow.addElement(s2.getModel());
        tymczasowaListaSamochodow.addElement(s3.getModel());
        listaSamochodow.setModel(tymczasowaListaSamochodow);
        listaSamochodow.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    index = listaSamochodow.getSelectedIndex();
                    markaTextField.setText(dane.get(index).getMarka());
                    modelTextField.setText(dane.get(index).getModel());
                    rocznikTextField.setText(dane.get(index).getRocznik());
                    numerVINTextField.setText(dane.get(index).getNumerVIN());
                    kolorTextField.setText(dane.get(index).getKolor());
                    cenaTextField.setText(dane.get(index).getCena());
                    TAKCheckBox.setSelected(dane.get(index).getCzyWypadkowy());
                    NIECheckBox.setSelected(!dane.get(index).getCzyWypadkowy());
                }
                catch (IndexOutOfBoundsException indexException){
                    listaSamochodow.invalidate();
                    listaSamochodow.validate();
                    listaSamochodow.repaint();
                }
            }
        });

        dodajSamochodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dodaj_samochod edycjaDanych = new Dodaj_samochod();
                edycjaDanych.setLocationRelativeTo(null);
                edycjaDanych.setVisible(true);
                edycjaDanych.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
        usunSamochodButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedIndex = listaSamochodow.getSelectedIndex();
                    if (selectedIndex >= 0) {
                        tymczasowaListaSamochodow.remove(selectedIndex);
                        dane.remove(selectedIndex);
                        listaSamochodow.repaint();
                    }
                    markaTextField.setText("") ;
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
                dane.set(index, new Samochod(marka, model, rocznik, numerVIN, kolor, cena, czyWypadkowy));
                tymczasowaListaSamochodow.setElementAt(model, index);
            }
        });
    }
}
