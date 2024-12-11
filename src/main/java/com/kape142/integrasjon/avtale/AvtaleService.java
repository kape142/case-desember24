package com.kape142.integrasjon.avtale;

import com.kape142.brev.model.BrevStatus;
import com.kape142.integrasjon.brev.BrevMal;
import com.kape142.fagsystem.model.AvtaleStatus;
import com.kape142.integrasjon.avtale.dto.CreateAvtaleDto;
import com.kape142.integrasjon.avtale.dto.CreateAvtaleResponse;
import com.kape142.integrasjon.brev.BrevService;
import com.kape142.integrasjon.fagsystem.AvtaleFagService;
import com.kape142.integrasjon.kunde.KundeService;
import org.springframework.stereotype.Service;

@Service
public class AvtaleService {

    private final KundeService kundeService;
    private final AvtaleFagService avtaleFagService;
    private final BrevService brevService;

    public AvtaleService(KundeService kundeService, AvtaleFagService avtaleFagService, BrevService brevService) {
        this.kundeService = kundeService;
        this.avtaleFagService = avtaleFagService;
        this.brevService = brevService;
    }

    public CreateAvtaleResponse createAvtale(CreateAvtaleDto input) {
        var kunde = kundeService.createKunde(input.navn(), input.adresse());
        var avtale = avtaleFagService.createAvtale(kunde, input.forsikring());
        var brevStatus = brevService.sendAvtaleBrev(kunde.getNavn(), kunde.getAdresse(), avtale, BrevMal.AVTALE_OPPRETTET);
        if(brevStatus == BrevStatus.SENDING_FEILET){
            throw new RuntimeException("Sending av brev feilet");
        }
        var updatedAvtale = avtaleFagService.updateStatus(avtale, AvtaleStatus.AVTALE_SENDT);
        return new CreateAvtaleResponse(updatedAvtale.getAvtalenummer(), updatedAvtale.getStatus());
    }
}
