package br.com.labdna.service.estatistica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.labdna.dto.LabDnaStatsResponse;
import br.com.labdna.repository.LaboratorioDnaRepository;

/**
 * Classe que representa a camada de service para tratamento das estatisticas de
 * DNAs analisadas.
 * 
 * @author Danillo
 *
 */
@Service
public class LaboratorioDnaEstatisticasService {
	
	@Autowired
	private transient LaboratorioDnaRepository repository;
	
	/**
	 * Método responsável por obter as estatisticas de dnas analisadas.
	 * @return
	 */
	public LabDnaStatsResponse getEstatisticas(){
		LabDnaStatsResponse stats = new LabDnaStatsResponse();
        stats.setCountMutantDna(repository.countByIsSimio(true));
        stats.setCountHumanDna(repository.countByIsSimio(false));
        stats.setRatio(stats.getCountMutantDna() / stats.getCountHumanDna());
        return   stats;
    }

}
