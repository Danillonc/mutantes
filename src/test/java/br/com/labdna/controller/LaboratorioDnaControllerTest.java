package br.com.labdna.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.labdna.dto.LabDnaRequest;
import br.com.labdna.service.estatistica.LaboratorioDnaEstatisticasService;
import br.com.labdna.service.simio.SimioDnaService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.awt.print.Printable;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")	
public class LaboratorioDnaControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private SimioDnaService simioService;
	
	@MockBean
	private LaboratorioDnaEstatisticasService labService; 
	
	@Test
	public void deveTestarChamadaEndpointSimioSucesso() throws JsonProcessingException, Exception{
		mockMvc.perform(post("/simian")
				.content(mockLabDnaRequestJson())
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
		        .andDo(print())
		        .andExpect(status().isOk());		
	}
	
	private String mockLabDnaRequestJson() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String[] dnas = new String[] { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		LabDnaRequest dnaReq = new LabDnaRequest();
		dnaReq.setDna(dnas);
		return mapper.writeValueAsString(dnaReq);
	}

}
