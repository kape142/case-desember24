package com.kape142.fagsystem.api;

import com.kape142.fagsystem.model.Avtale;
import com.kape142.fagsystem.model.AvtaleStatus;
import com.kape142.fagsystem.model.Kunde;
import com.kape142.fagsystem.util.NumberGenerator;

public class AvtaleMockEndpoint {
    public Avtale createAvtale(Kunde kunde, String forsikring) {
        var avtale =  new Avtale(kunde, forsikring, NumberGenerator.generateNumber(10), AvtaleStatus.AVTALE_OPPRETTET);
        System.out.println("Oppretter avtale i fagsystem: "+avtale);
        return avtale;

    }

    public Avtale updateStatus(Avtale avtale, AvtaleStatus status) {
        var updatedAvtale = new Avtale(avtale.getKunde(), avtale.getForsikring(), avtale.getAvtalenummer(), status);
        System.out.println("Oppdaterer avtalestatus i fagsystem: " + updatedAvtale);
        return updatedAvtale;
    }
}
