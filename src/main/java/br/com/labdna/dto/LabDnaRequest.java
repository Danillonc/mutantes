package br.com.labdna.dto;

import javax.validation.constraints.NotNull;

import br.com.labdna.validator.BaseNitrogenadaValida;

/**
 * Classe responsável que representa o DTO de requisicao que irá transferir os
 * dados para as entidades.
 * 
 * @author Danillo
 *
 */
public class LabDnaRequest {

	@NotNull
	@BaseNitrogenadaValida
	private String[] dna;

	
	public String[] getDna() {
		return dna;
	}
	
	public void setDna(String[] dna) {
		this.dna = dna;
	}

}
