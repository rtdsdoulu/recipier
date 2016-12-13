package fi.oulu.smartkitchen.recipier.dao;

import fi.oulu.smartkitchen.recipier.model.RecipeSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Created by Sam on 12/13/2016.
 */
@Component
public interface RecipeSourceDao {

    public void insert(RecipeSource source);

    void setDataSource(DataSource dataSource);
}
