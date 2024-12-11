package com.kape142.fagsystem.model;

public class Avtale {
    private Kunde kunde;
    private String forsikring; // referanse til en forsikringstype i fagsystemet
    private String avtalenummer;
    private AvtaleStatus status;

    public Avtale(Kunde kunde, String forsikring, String avtalenummer, AvtaleStatus status) {
        this.kunde = kunde;
        this.forsikring = forsikring;
        this.avtalenummer = avtalenummer;
        this.status = status;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public String getForsikring() {
        return forsikring;
    }

    public void setForsikring(String forsikring) {
        this.forsikring = forsikring;
    }

    public String getAvtalenummer() {
        return avtalenummer;
    }

    public void setAvtalenummer(String avtalenummer) {
        this.avtalenummer = avtalenummer;
    }

    public AvtaleStatus getStatus() {
        return status;
    }

    public void setStatus(AvtaleStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Avtale[kunde=" + kunde + ", forsikring=" + forsikring+ ", avtalenummer=" + avtalenummer+ ", status=" + status + "]";
    }
}
