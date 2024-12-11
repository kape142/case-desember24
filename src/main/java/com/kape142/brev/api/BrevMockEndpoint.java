package com.kape142.brev.api;

import com.kape142.brev.model.Brev;
import com.kape142.brev.model.BrevStatus;

public class BrevMockEndpoint {
    public BrevStatus sendBrev(String navn, String adresse, String innhold) {
        var brev = new Brev(navn, adresse, innhold, BrevStatus.BREV_SENDT);
        System.out.println("Sender brev med brevtjenesten: " + brev);
        return brev.status();
    }
}
