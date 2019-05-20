package br.com.labdna.util;

/**
 * Classe responsável por fornecer métodos utilitarios de busca nas matrizes.
 * 
 * @author Danillo
 *
 */
public class LabDnaUtil {

	/**
	 * Método responsável por iterar cada dna informado e montar a matriz com as
	 * bases de dnas.
	 * 
	 * @param dnas
	 *            - String array
	 * @param length
	 *            - Tamanho array
	 * @return Matriz de dnas.
	 */
	public static String[][] getCharDnaMatriz(String[] dnas, int length) {

		String[][] matrizDnas = new String[length][length];
		int i = 0;
		for (String linha : dnas) {
			String[] lineMatrix = linha.split("");
			int j = 0;
			for (String ch : lineMatrix) {
				ch = ch.toUpperCase();
				matrizDnas[i][j] = ch;
				j++;
			}
			i++;
		}
		return matrizDnas;
	}

	/**
	 * Método responsável por analisar a matriz informada por parametro e buscar
	 * sequencia de dnas na poosição horizontal.
	 * 
	 * @param dnas
	 *            - Matriz de de dnas.
	 * @param length
	 *            - Tamanho da matriz.
	 * @return {@link Integer}
	 */
	public static int getSequenciaHorizontal(String[][] dnas, int length) {
		int ocorrencias = 0;
		for (int i = 0; i < length; i++) {
			String ultimoElemento = "", elemento = "";
			int totalSqeuencia = 1;
			for (int j = 0; j < length; j++) {
				if (ultimoElemento.equals(dnas[i][j])) {
					if (totalSqeuencia == 1)
						elemento = dnas[i][j];
					if (ultimoElemento.equals(elemento)) {
						totalSqeuencia++;
						if (totalSqeuencia >= 4) {
							ocorrencias++;
						}
					} else {
						totalSqeuencia = 1;
					}
				}
				ultimoElemento = dnas[i][j];
			}
		}
		return ocorrencias;
	}

	/**
	 * Método responsável por analisar a matriz informada por parametro e buscar
	 * a sequencia de dna na posicao vertical.
	 * 
	 * @param dnas
	 *            - Matriz de dnas.
	 * @param length
	 *            - Tamanho da matriz.
	 * @return {@link Integer}
	 */
	public static int getSequenciaVertical(String[][] dnas, int length) {
		int ocorrencias = 0;
		for (int j = 0; j < length; j++) {
			String ultimoElemento = "", elemento = "";
			int totalSequencia = 1;
			for (int i = 0; i < length; i++) {
				if (ultimoElemento.equals(dnas[i][j])) {
					if (totalSequencia == 1)
						elemento = dnas[i][j];
					if (ultimoElemento.equals(elemento)) {
						totalSequencia++;
						if (totalSequencia >= 4) {
							ocorrencias++;
						}
					} else {
						totalSequencia = 1;
					}
				}
				ultimoElemento = dnas[i][j];
			}
		}
		return ocorrencias;
	}

	/**
	 * Método responsável por analisar a matriz informada por parametro e buscar
	 * a sequencia de dnas na posicao diagonal primaria.
	 * 
	 * @param dnas
	 *            - Matriz de dnas.
	 * @param nlength
	 *            - Tamanho da matriz.
	 * @return {@link Integer}
	 */
	public static int getSequenciaDiagonal(String[][] dnas, int nlength) {
		int ocorrencias = 0;
		String ultimoElemento = "", elemento = "";
		int totalSequencia = 1;
		for (int i = 0; i < nlength; i++) {
			if (ultimoElemento.equals(dnas[i][i])) {
				if (totalSequencia == 1)
					elemento = dnas[i][i];
				if (ultimoElemento.equals(elemento)) {
					totalSequencia++;
					if (totalSequencia >= 4) {
						ocorrencias++;
					}
				} else {
					totalSequencia = 1;
				}
			}
			ultimoElemento = dnas[i][i];
		}
		return ocorrencias;
	}

	/**
	 * Método responsável por analisar a matriz informada por parametro e buscar
	 * a sequencia de dnas na posicao diagonal secundaria.
	 * 
	 * @param dnas
	 *            - Matriz de dnas.
	 * @param length
	 *            - Tamanho da matriz.
	 * @return {@link Integer}
	 */
	public static int getSequenciaDiagonalSecundaria(String[][] dnas, int length) {
		int ocorrencias = 0;
		String ultimoElemento = "", elemento = "";
		int totalSequencia = 1;
		for (int i = 0, j = length - 1; i < length; i++, j--) {
			if (ultimoElemento.equals(dnas[i][j])) {
				if (totalSequencia == 1)
					elemento = dnas[i][j];
				if (ultimoElemento.equals(elemento)) {
					totalSequencia++;
					if (totalSequencia >= 4) {
						ocorrencias++;
					}
				} else {
					totalSequencia = 1;
				}
			}
			ultimoElemento = dnas[i][j];
		}
		return ocorrencias;
	}
	
	/**
	 * método que converte um array de strings em uma unica string.
	 * @param dnas - String array.
	 * @return {@link String}
	 */
	public static String converterBaseDnaParaString(final String[] dnas){
		return String.join("", dnas);
	}

}
