
class Klient {
    String Imie, Nazwisko, DataUR, Cena, Miasto ,nrTelefonu, Adres;
    Boolean Platnosc;
    public Klient(String Imie, String Nazwisko, String DataUR, String Cena, String Miasto, String nrTelefonu, String Adres, Boolean Platnosc) {
        this.Imie = Imie;
        this.Nazwisko = Nazwisko;
        this.DataUR = DataUR;
        this.Cena = Cena;
        this.Miasto = Miasto;
        this.nrTelefonu = nrTelefonu;
        this.Adres = Adres;
        this.Platnosc = Platnosc;
    }
    public String getImie() {
        return Imie;
    }

    public void setImie(String imie) {
        Imie = imie;
    }

    public String getNazwisko() {
        return Nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        Nazwisko = nazwisko;
    }

    public String getNrTelefonu() {
        return nrTelefonu;
    }

    public void setNrTelefonu(String nrTelefonu) {
        this.nrTelefonu = nrTelefonu;
    }

    public String getAdres() {
        return Adres;
    }

    public void setAdres(String adres) {
        Adres = adres;
    }

    public String getDataUR() {
        return DataUR;
    }

    public void setDataUR(String dataUR) {
        DataUR = dataUR;
    }

    public String getCena() {
        return Cena;
    }

    public void setCena(String cena) {
        Cena = cena;
    }

    public String getMiasto() {
        return Miasto;
    }

    public void setMiasto(String miasto) {
        Miasto = miasto;
    }

    public Boolean getPlatnosc() {
        return Platnosc;
    }

    public void setPlatnosc(Boolean platnosc) {
        Platnosc = platnosc;
    }
}

