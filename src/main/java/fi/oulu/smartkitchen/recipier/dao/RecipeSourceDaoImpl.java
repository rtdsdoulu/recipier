package fi.oulu.smartkitchen.recipier.dao;

import fi.oulu.smartkitchen.recipier.model.RecipeSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Sam on 12/13/2016.
 */
public class RecipeSourceDaoImpl implements RecipeSourceDao {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public void insert(RecipeSource source) {

        String sql = "INSERT INTO RECIPES (url, original_text) VALUES (?,?)";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, source.getUrlAddress());
            ps.setString(2, source.getRecipeText());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }

    }
}
