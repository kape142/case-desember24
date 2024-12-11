package com.kape142.integrasjon.fagsystem;

import com.kape142.fagsystem.api.KundeMockEndpoint;
import com.kape142.fagsystem.model.Kunde;
import org.springframework.stereotype.Service;

@Service
public class KundeFagService {
    private final KundeMockEndpoint kundeEndpoint = new KundeMockEndpoint();

    public Kunde createKunde(String navn, String adresse) throws IllegalArgumentException {
        if(navn == null || adresse == null){
            throw new IllegalArgumentException();
        }
        return this.kundeEndpoint.createKunde(navn, adresse);
    }
}
