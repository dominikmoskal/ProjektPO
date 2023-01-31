import javax.swing.*;

public class Lista_samochodow extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JCheckBox TAKCheckBox;
    private JCheckBox NIECheckBox;
    private JTextField textField6;
    private JButton edytujDanePojazuButton;
    private JButton zapiszZmianyButton;
    private JPanel panel1;
    private JList list1;
    private JButton usunSamochodButton;

    public static void main(String[] args)
    {
        Lista_samochodow aplikacja = new Lista_samochodow();
        aplikacja.setVisible(true);
    }

    public Lista_samochodow() {
        super("Komis samochodowy");
        this.setContentPane(this.panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,600);
    }
}
