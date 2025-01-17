package br.com.labdna.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Classe que representa o objeto de response para consulta das estatisticas.
 * 
 * @author Danillo
 *
 */
@JsonPropertyOrder({ "countMutantDna", "countHumanDna", "ratio" })
public class LabDnaStatsResponse {

	@JsonProperty(value = "count_mutant_dna")
	private long countMutantDna;
	@JsonProperty(value = "count_human_dna")
	private long countHumanDna;
	private double ratio;

	public long getCountMutantDna() {
		return countMutantDna;
	}

	public void setCountMutantDna(long coutMutantDna) {
		this.countMutantDna = coutMutantDna;
	}

	public long getCountHumanDna() {
		return countHumanDna;
	}

	public void setCountHumanDna(long countHumanDna) {
		this.countHumanDna = countHumanDna;
	}

	public double getRatio() {
		return ratio;
	}

	public void setRatio(double ratio) {
		this.ratio = ratio;
	}

}
