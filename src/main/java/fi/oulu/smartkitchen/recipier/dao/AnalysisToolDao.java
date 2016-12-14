package fi.oulu.smartkitchen.recipier.dao;

import fi.oulu.smartkitchen.recipier.model.AnalysisTool;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by Sam on 12/13/2016.
 */
@Transactional
public interface AnalysisToolDao extends CrudRepository<AnalysisTool, Long>{

    public AnalysisTool findByName(String name);

}
