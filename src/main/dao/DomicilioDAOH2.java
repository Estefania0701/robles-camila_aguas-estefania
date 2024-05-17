package main.dao;

import main.model.Domicilio;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class DomicilioDAOH2 implements IDao<Domicilio> {

    private static final Logger logger = Logger.getLogger(DomicilioDAOH2.class);

    private static final String SQL_SELECT_ONE = "SELECT * FROM DOMICILIOS WHERE ID = ?";

    @Override
    public Domicilio guardar(Domicilio domicilio) {
        return null;
    }

    @Override
    public Domicilio buscarPorId(Integer id) {
        logger.info("::: Buscando domicilio por ID :::");
        Connection connection = null;
        Domicilio domicilio = null;

        try {
            connection = H2.getConnection();
            Statement statement = connection.createStatement();
            PreparedStatement psSelectOne = connection.prepareStatement(SQL_SELECT_ONE);
            psSelectOne.setInt(1, id);

            // guardar el resultado
            ResultSet domicilioQuery = psSelectOne.executeQuery();

            while (domicilioQuery.next()) {
                domicilio = new Domicilio(
                        domicilioQuery.getInt(1),
                        domicilioQuery.getString(2),
                        domicilioQuery.getInt(3),
                        domicilioQuery.getString(4),
                        domicilioQuery.getString(5)
                );
            }
        } catch (Exception e) {
            logger.error("Error al buscar el domicilio por ID", e);
        }
        return domicilio;
    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public void actualizar(Domicilio domicilio) {

    }

    @Override
    public List<Domicilio> buscarTodos() {
        return null;
    }
}
