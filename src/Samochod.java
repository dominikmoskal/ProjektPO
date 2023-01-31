public class Samochod {

    String Marka, Model, Rocznik, numerVIN, kolor, cena;
    Boolean czyWypadkowy;

    public Samochod(String Marka, String Model, String Rocznik, String numerVIN, String kolor, String cena, Boolean czyWypadkowy){
        this.Marka = Marka;
        this.Model = Model;
        this.Rocznik = Rocznik;
        this.numerVIN = numerVIN;
        this.kolor = kolor;
        this.cena = cena;
        this.czyWypadkowy = czyWypadkowy;
    }

    public String getMarka() {
        return Marka;
    }

    public void setMarka(String marka) {
        Marka = marka;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getRocznik() {
        return Rocznik;
    }

    public void setRocznik(String rocznik) {
        Rocznik = rocznik;
    }

    public String getNumerVIN() {
        return numerVIN;
    }

    public void setNumerVIN(String numerVIN) {
        this.numerVIN = numerVIN;
    }

    public String getKolor() {
        return kolor;
    }

    public void setKolor(String kolor) {
        this.kolor = kolor;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public Boolean getCzyWypadkowy() {
        return czyWypadkowy;
    }

    public void setCzyWypadkowy(Boolean czyWypadkowy) {
        this.czyWypadkowy = czyWypadkowy;
    }
}
