package com.kape142.integrasjon.kunde;

import com.kape142.fagsystem.model.Kunde;
import com.kape142.integrasjon.fagsystem.KundeFagService;
import org.springframework.stereotype.Service;

@Service
public class KundeService {
    private final KundeFagService kundeFagService;

    public KundeService(KundeFagService kundeFagService) {
        this.kundeFagService = kundeFagService;
    }

    public Kunde createKunde(String navn, String adresse){
        return this.kundeFagService.createKunde(navn, adresse);
    }

}
