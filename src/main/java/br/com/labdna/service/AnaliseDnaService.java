package br.com.labdna.service;

/**
 * Interface responsável por encapsular as assinaturas de métodos necessárias para analise de dnas.
 * @author Danillo
 *
 */
public interface AnaliseDnaService {

	/**
	 * Método responsável por analisar o DNA e verificar se é um simio ou não.
	 * @param dnas - String array com dnas
	 * @return {@link Boolean}
	 */
	public boolean isSimio(final String[] dnas);
	
}
