package com.kape142.integrasjon.brev;

import com.kape142.brev.api.BrevMockEndpoint;
import com.kape142.brev.model.BrevStatus;
import com.kape142.fagsystem.model.Avtale;
import org.springframework.stereotype.Service;

@Service
public class BrevService {
    private final BrevMockEndpoint brevEndpoint = new BrevMockEndpoint();

    public BrevStatus sendAvtaleBrev(String navn, String adresse, Avtale avtale, BrevMal mal) {
        return brevEndpoint.sendBrev(navn, adresse, createAvtaleBrevFromMal(avtale, mal));
    }

    private String createAvtaleBrevFromMal(Avtale avtale, BrevMal mal) {
        return switch (mal){
            case AVTALE_OPPRETTET -> "Forsikringsavtalen din er opprettet: " + avtale;
            case AVTALE_AVSLUTTET -> "Forsikringsavtalen din er avsluttet: " + avtale;
        };
    }
}
