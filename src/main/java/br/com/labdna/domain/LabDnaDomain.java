package br.com.labdna.domain;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Classe que representa o modelo que será persistido os dados de dnas.
 * 
 * @author Danillo
 *
 */
@Document
public class LabDnaDomain {

	@Indexed
	private String id;

	@Indexed(name = "idx_dna", unique = true)
	private String dna;

	private boolean isSimio;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDna() {
		return dna;
	}

	public void setDna(String dna) {
		this.dna = dna;
	}
	
	public boolean isSimio() {
		return isSimio;
	}
	
	public void setSimio(boolean isSimio) {
		this.isSimio = isSimio;
	}

	
}
