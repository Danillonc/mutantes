package br.com.labdna.validator;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.labdna.dto.LabDnaRequest;

/**
 * Classe responsável por implementar testes para o validador da base de dna.
 * 
 * @author Danillo
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class BaseNitrogenadaValidatorTest {

	@Autowired
	private Validator validator;

	/**
	 * método responsável por testar o caso de sucesso do método.
	 */
	@Test
	public void deveTestarValidorSucesso() {
		String[] dnas = new String[] { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		LabDnaRequest requisicao = new LabDnaRequest();
		requisicao.setDna(dnas);
		Set<ConstraintViolation<LabDnaRequest>> violations = validator.validate(requisicao);
		Assert.assertEquals(0, violations.size());
	}

	/**
	 * Método responsável por testar o erro do validador, passando uma letra na
	 * base de dna fora do padrão.
	 */
	@Test
	public void deveTestarValidorErro() {
		String[] dnas = new String[] { "ATGCGA", "CAGTGC", "TTATGD", "AGAAGG", "CCCCTA", "TCACTG" };
		LabDnaRequest requisicao = new LabDnaRequest();
		requisicao.setDna(dnas);
		Set<ConstraintViolation<LabDnaRequest>> violations = validator.validate(requisicao);
		Assert.assertEquals(1, violations.size());
	}

	/**
	 * método responsável por testar o validador quando valida o tamanho da
	 * matriz de dnas.
	 */
	@Test
	public void deveTestarTamanhoDaMatrizErro() {
		String[] dnas = new String[] { "ATGCGA", "CAGTGC", "TTATGD" };
		LabDnaRequest requisicao = new LabDnaRequest();
		requisicao.setDna(dnas);
		Set<ConstraintViolation<LabDnaRequest>> violations = validator.validate(requisicao);
		Assert.assertEquals(1, violations.size());
	}

}
