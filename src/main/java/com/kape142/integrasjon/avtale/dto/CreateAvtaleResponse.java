package com.kape142.integrasjon.avtale.dto;

import com.kape142.fagsystem.model.AvtaleStatus;

public record CreateAvtaleResponse(String avtalenummer, AvtaleStatus status) { }
