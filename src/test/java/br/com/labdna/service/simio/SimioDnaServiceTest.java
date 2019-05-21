package br.com.labdna.service.simio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.mongodb.DuplicateKeyException;

import br.com.labdna.domain.LabDnaDomain;
import br.com.labdna.repository.LaboratorioDnaRepository;

/**
 * Classe de teste responsável por testar a camada de service SimioDnaService.
 * 
 * @author Danillo
 *
 */
@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
public class SimioDnaServiceTest {
	
	@InjectMocks
	private SimioDnaService simioService;
	
	@Mock
	private LaboratorioDnaRepository repository;
	
	/**
	 * Método responsável por testar a analise contendo DNAs simios.
	 */
	@Test
	public void deveTestarAnaliseSimiosTrue() {
		String[] dnas = new String[] { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		Mockito.when(this.repository.save(Matchers.any())).thenReturn(new LabDnaDomain());
		boolean ret = this.simioService.isSimio(dnas);
		Assert.assertTrue(ret);
	}
	
	/**
	 * Método responsável por testar a analise sem DNAs simios.
	 */
	@Test
	public void deveTestarAnaliseSimiosFalse() {
		String[] dnas = new String[] { "TTGCAG", "ATCGTC", "CTGCAT", "AGTATG", "TTCGCA", "AGCCTT" };
		Mockito.when(this.repository.save(Matchers.any())).thenReturn(new LabDnaDomain());
		boolean ret = this.simioService.isSimio(dnas);
		Assert.assertFalse(ret);
	}
	
	/**
	 * Método responsável por testar a a persistencia de DNAs retornando exceção.
	 */
	@Test(expected = DuplicateKeyException.class)
	public void deveTestarPersistenciaDnasErro() {
		String[] dnas = new String[] { "TTGCAG", "ATCGTC", "CTGCAT", "AGTATG", "TTCGCA", "AGCCTT" };
		Mockito.doThrow(DuplicateKeyException.class).when(this.repository).save(Matchers.any());
		this.simioService.isSimio(dnas);
	}

}
