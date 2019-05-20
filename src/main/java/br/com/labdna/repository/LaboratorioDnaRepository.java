package br.com.labdna.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.labdna.domain.LabDnaDomain;

/**
 * Interface responsável por representar a camada de repositório do laboratório
 * de analisa de DNAs.
 * 
 * @author Danillo
 *
 */
@Repository
public interface LaboratorioDnaRepository extends MongoRepository<LabDnaDomain, String>{
	
	/**
	 * Método responsável por buscar a quantidade de simios de acordo com o parametro informado.
	 * @param isSimio
	 * @return
	 */
    public long countByIsSimio(boolean isSimio);
}
