package com.kape142.integrasjon.avtale;


import com.kape142.integrasjon.avtale.dto.CreateAvtaleDto;
import com.kape142.integrasjon.avtale.dto.CreateAvtaleResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/avtale")
public class AvtaleController {

    private final AvtaleService avtaleService;

    public AvtaleController(AvtaleService avtaleService) {
        this.avtaleService = avtaleService;
    }

    @PostMapping()
    public ResponseEntity<CreateAvtaleResponse> createAvtale(@RequestBody CreateAvtaleDto input) {
        if(input.navn() == null || input.forsikring() == null || input.adresse() == null) {
            return ResponseEntity.badRequest().build();
        }
        CreateAvtaleResponse response = avtaleService.createAvtale(input);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
