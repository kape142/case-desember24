package com.kape142.integrasjon.fagsystem;

import com.kape142.fagsystem.api.AvtaleMockEndpoint;
import com.kape142.fagsystem.model.Avtale;
import com.kape142.fagsystem.model.AvtaleStatus;
import com.kape142.fagsystem.model.Kunde;
import org.springframework.stereotype.Service;

@Service
public class AvtaleFagService {
    private final AvtaleMockEndpoint avtaleEndpoint = new AvtaleMockEndpoint();

    public Avtale createAvtale(Kunde kunde, String forsikring) throws IllegalArgumentException {
        if(kunde == null || forsikring == null){
            throw new IllegalArgumentException(); // Ikke kalle på fagsystem unødvendig
        }
        return this.avtaleEndpoint.createAvtale(kunde, forsikring);
    }

    public Avtale updateStatus(Avtale avtale, AvtaleStatus status) throws IllegalArgumentException {
        if(avtale == null || status == null){
            throw new IllegalArgumentException();
        }
        return this.avtaleEndpoint.updateStatus(avtale, status);
    }
}
