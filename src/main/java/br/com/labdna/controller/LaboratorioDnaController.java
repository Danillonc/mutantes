package br.com.labdna.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.labdna.dto.LabDnaRequest;
import br.com.labdna.dto.LabDnaStatsResponse;
import br.com.labdna.service.estatistica.LaboratorioDnaEstatisticasService;
import br.com.labdna.service.simio.SimioDnaService;

/**
 * Classe responsável por representar o Controller que irá receber as requisições Rest.
 * @author Danillo
 *
 */
@RestController
public class LaboratorioDnaController {
	
	@Autowired
	private transient SimioDnaService simioService;
	
	@Autowired
	private transient LaboratorioDnaEstatisticasService labService;
	
	@GetMapping("/stats")
	public ResponseEntity<LabDnaStatsResponse> buscaEstatisticasDnas() {
		return new ResponseEntity<>(labService.getEstatisticas(), HttpStatus.OK);
	}
	
	@PostMapping("/simian")
	public ResponseEntity verificaDna(@RequestBody @Valid LabDnaRequest dnaRequisicao){
		try {
			if (simioService.isSimio(dnaRequisicao.getDna())) {
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.FORBIDDEN);
			} 
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
	}

}
