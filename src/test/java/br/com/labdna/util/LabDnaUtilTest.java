package br.com.labdna.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Classe responsável por implementar os testes da classe utilitaria de analise
 * de matrizes.
 * 
 * @author Danillo
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class LabDnaUtilTest {

	/**
	 * Método responsável por testar a lógica do getCharDnaMatriz e retornar uma
	 * matriz montada.
	 */
	@Test
	public void deveTestarCharDnaMatrizSucesso() {
		String[] dnas = new String[] { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		int length = dnas.length;
		String[][] retorno = LabDnaUtil.getCharDnaMatriz(dnas, length);
		Assert.assertNotNull(retorno);
	}

	/**
	 * Método responsável por testar a busca de sequencoa de dnas na posicao
	 * horizontal.
	 */
	@Test
	public void deveTestarBuscaSequenciaHorizontalSucesso() {
		String[] dnas = new String[] { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		int length = dnas.length;
		String[][] matrizDnas = LabDnaUtil.getCharDnaMatriz(dnas, length);
		int achouSequencia = LabDnaUtil.getSequenciaHorizontal(matrizDnas, matrizDnas.length);
		Assert.assertTrue(achouSequencia == 1);
	}

	/**
	 * Método responsável por testar a busca de sequencias de dnas na posicao
	 * horizontal.
	 */
	@Test
	public void deveTestarBuscaSequenciasHorizontaisSucesso() {
		String[] dnas = new String[] { "ATGCGA", "CAGTGC", "TTTTGT", "AGAAGG", "CCCCTA", "TCACTG" };
		int length = dnas.length;
		String[][] matrizDnas = LabDnaUtil.getCharDnaMatriz(dnas, length);
		int achouSequencia = LabDnaUtil.getSequenciaHorizontal(matrizDnas, matrizDnas.length);
		Assert.assertTrue(achouSequencia == 2);
	}

	/**
	 * Método responsável por testar a busca de sequencia de dna na posicao
	 * vertical.
	 */
	@Test
	public void deveTestarBuscaSequenciasVerticalSucesso() {
		String[] dnas = new String[] { "ATGCGA", "CAGTGC", "TTTTGT", "AGAAGG", "CCCCTA", "TCACTG" };
		int length = dnas.length;
		String[][] matrizDnas = LabDnaUtil.getCharDnaMatriz(dnas, length);
		int achouSequencia = LabDnaUtil.getSequenciaVertical(matrizDnas, matrizDnas.length);
		Assert.assertTrue(achouSequencia == 1);
	}

	/**
	 * Método responsável por testar a busca de sequencia de dna na posicao
	 * diagonal primaria.
	 */
	@Test
	public void deveTestarBuscaSequenciasDiagonalSucesso() {
		String[] dnas = new String[] { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCGT", "TCACTG" };
		int length = dnas.length;
		String[][] matrizDnas = LabDnaUtil.getCharDnaMatriz(dnas, length);
		int achouSequencia = LabDnaUtil.getSequenciaDiagonal(matrizDnas, matrizDnas.length);
		Assert.assertTrue(achouSequencia == 1);
	}

	/**
	 * Método responsável por testar a busca de sequencia de dna na posicao
	 * diagonal secundaria.
	 */
	@Test
	public void deveTestarBuscaSequenciasDiagonalSecundariaErro() {
		String[] dnas = new String[] { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCGT", "TCACTG" };
		int length = dnas.length;
		String[][] matrizDnas = LabDnaUtil.getCharDnaMatriz(dnas, length);
		int achouSequencia = LabDnaUtil.getSequenciaDiagonalSecundaria(matrizDnas, matrizDnas.length);
		Assert.assertTrue(achouSequencia == 0);
	}

	/**
	 * Método responsável por testar a busca de sequencia de dna na posicao
	 * diagonal secundaria.
	 */
	@Test
	public void deveTestarBuscaSequenciasDiagonalSecundariaSucesso() {
		String[] dnas = new String[] { "CTGAGA", "CTGAAC", "TATAGT", "AGAGGG", "CCCCTA", "TCACTG" };
		int length = dnas.length;
		String[][] matrizDnas = LabDnaUtil.getCharDnaMatriz(dnas, length);
		int achouSequencia = LabDnaUtil.getSequenciaDiagonalSecundaria(matrizDnas, matrizDnas.length);
		Assert.assertTrue(achouSequencia == 1);
	}
	
	/**
	 * método responsável por realizar o teste na conversao de dnas em strings.
	 */
	@Test
	public void deveTestarConversorDnasSucesso(){
		String[] dnas = new String[] { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		final String dnasString = LabDnaUtil.converterBaseDnaParaString(dnas);
		System.out.println(dnasString);
	}

}
