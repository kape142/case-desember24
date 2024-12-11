package com.kape142.integrasjon.avtale;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kape142.integrasjon.avtale.dto.CreateAvtaleDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AvtaleControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;


	@Test
	void avtaleControllerTest() throws Exception {
		var input = new CreateAvtaleDto("Karl Peter", "Dronningens Gate 16", "Bil-2024-12");
		var inputJson = objectMapper.writeValueAsString(input);

		mockMvc.perform(post("/api/avtale")
				.contentType(MediaType.APPLICATION_JSON)
				.content(inputJson))
				.andExpect(status().is2xxSuccessful())
				.andExpect(jsonPath("$.avtalenummer").isString())
				.andExpect(jsonPath("$.status").value("AVTALE_SENDT"));
	}

}
