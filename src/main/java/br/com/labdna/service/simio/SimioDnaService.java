package br.com.labdna.service.simio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.labdna.domain.LabDnaDomain;
import br.com.labdna.repository.LaboratorioDnaRepository;
import br.com.labdna.service.AnaliseDnaService;
import br.com.labdna.util.LabDnaUtil;

/**
 * Classe responsável por representar a camada de service com as regras de
 * negocio para o analisa de DNAs de Simios.
 * 
 * @author Danillo
 *
 */
@Service
public class SimioDnaService implements AnaliseDnaService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SimioDnaService.class);
	
	@Autowired
	private transient LaboratorioDnaRepository repository;

	@Override
	public boolean isSimio(final String[] dnas) {
		boolean isSimio = analisaCombinacoesDnas(dnas);
		prepararDnaSalvar(dnas, isSimio);
		return isSimio;
	}

	/**
	 * método privado responsável por fazer a analise de combinacoes de dnas
	 * para simios.
	 * 
	 * @param dnas - base nitrogenada de dnas.
	 * @return {@link Boolean}
	 */
	private boolean analisaCombinacoesDnas(final String[] dnas) {
		final int length = dnas.length;
		int resultVerticalTest = 0, resultPriDiagonal = 0;
		boolean temMutacao = false;

		String[][] matrizDnas = LabDnaUtil.getCharDnaMatriz(dnas, length);
		int resultHorizontalTest = LabDnaUtil.getSequenciaHorizontal(matrizDnas, length);

		if (resultHorizontalTest >= 2) {
			temMutacao = true;
		}

		if (!temMutacao) {
			resultVerticalTest = LabDnaUtil.getSequenciaVertical(matrizDnas, length);
			if (resultHorizontalTest + resultVerticalTest >= 2) {
				temMutacao = true;
			}
		}

		if (!temMutacao) {
			resultPriDiagonal = LabDnaUtil.getSequenciaDiagonal(matrizDnas, length);
			if (resultPriDiagonal + resultHorizontalTest + resultVerticalTest >= 2) {
				temMutacao = true;
			}
		}

		if (!temMutacao) {
			int resultSecDiagonal = LabDnaUtil.getSequenciaDiagonalSecundaria(matrizDnas, length);
			if (resultSecDiagonal + resultPriDiagonal + resultHorizontalTest + resultVerticalTest >= 2) {
				temMutacao = true;
			}
		}
		return temMutacao;
	}
	
	private void prepararDnaSalvar(String[] dnas, boolean isSimio){
		LabDnaDomain dna = new LabDnaDomain();
		dna.setDna(LabDnaUtil.converterBaseDnaParaString(dnas));
		dna.setSimio(isSimio);
		
		try {
			LOGGER.info("salvando DNAs das mutacoes");
			this.repository.save(dna);
		} catch (Exception e) {
			LOGGER.error("Erro ao salvar os DNAs das mutacoes", e);
			throw e;
		}
	}

}
