package br.com.labdna.service.estatistica;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.labdna.dto.LabDnaStatsResponse;
import br.com.labdna.repository.LaboratorioDnaRepository;

/**
 * Classe responsável por testar a camada de service de estatisticas.
 * @author Danillo
 *
 */
@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
public class LaboratorioDnaEstatisticasServiceTest {

	@InjectMocks
	private LaboratorioDnaEstatisticasService labService;

	@Mock
	private LaboratorioDnaRepository repository;

	/**
	 * Método responsável por testar a busca das estatisticas de DNAs
	 * analisadas.
	 */
	@Test
	public void deveTestarRecuperarEstatisticaSucesso() {
		Mockito.when(this.repository.countByIsSimio(Matchers.anyBoolean())).thenReturn(2L).thenReturn(1L);
		LabDnaStatsResponse ret = this.labService.getEstatisticas();
		Assert.assertEquals(2, ret.getCountMutantDna());
		Assert.assertEquals(1, ret.getCountHumanDna());
	}

}
