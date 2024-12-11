package com.kape142.fagsystem.model;


public class Kunde {
    private String navn;
    private String adresse;
    private String kundenummer;

    public Kunde(String navn, String adresse, String kundenummer) {
        this.navn = navn;
        this.adresse = adresse;
        this.kundenummer = kundenummer;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getKundenummer() {
        return kundenummer;
    }

    public void setKundenummer(String kundenummer) {
        this.kundenummer = kundenummer;
    }

    @Override
    public String toString() {
        return "Kunde[navn=" + navn + ", adresse=" + adresse + ", kundenummer=" + kundenummer + "]";
    }
}
