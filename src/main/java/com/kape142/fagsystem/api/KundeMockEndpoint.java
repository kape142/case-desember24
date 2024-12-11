package com.kape142.fagsystem.api;

import com.kape142.fagsystem.model.Kunde;
import com.kape142.fagsystem.util.NumberGenerator;

public class KundeMockEndpoint {
    public Kunde createKunde(String navn, String adresse){
        var kunde = new Kunde(navn, adresse, NumberGenerator.generateNumber(10));
        System.out.println("Oppretter kunde i fagsystem: " + kunde);
        return kunde;
    }
}
