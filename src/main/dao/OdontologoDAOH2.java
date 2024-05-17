package main.dao;

import main.model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements IDao<Odontologo>{

    private static final Logger logger = Logger.getLogger(OdontologoDAOH2.class);

    private static final String SQL_INSERT = "INSERT INTO ODONTOLOGOS (NUMERO_MATRICULA, NOMBRE, APELLIDO) VALUES (?, ?, ?)";
    private static final String SQL_SELECT_ALL = "SELECT * FROM ODONTOLOGOS";

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        logger.info("::: Guardando odontólogo :::");
        Connection connection = null;
        try {
            connection = H2.getConnection();
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);
            psInsert.setInt(1, odontologo.getNumeroMatricula());
            psInsert.setString(2, odontologo.getNombre());
            psInsert.setString(3, odontologo.getApellido());
            psInsert.execute();

        } catch (Exception e) {
            logger.error("Error al guardar el odontólogo", e);
        }
        logger.info("::: Odontólogo guardado :::");
        return odontologo;
    }

    @Override
    public Odontologo buscarPorId(Integer id) {
        return null;
    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public void actualizar(Odontologo odontologo) {
    }

    @Override
    public List<Odontologo> buscarTodos() {
        logger.info("::: Buscando todos los odontólogos :::");
        Connection connection = null;
        List<Odontologo> odontologos = new ArrayList<>();
        try {
            connection = H2.getConnection();
            Statement statement = connection.createStatement();
            PreparedStatement psSelectAll = connection.prepareStatement(SQL_SELECT_ALL);

            // Guardando el resultado
            ResultSet odontologoQuery = psSelectAll.executeQuery();
            while (odontologoQuery.next()) {
                odontologos.add(new Odontologo(
                        odontologoQuery.getInt(1),
                        odontologoQuery.getInt(2),
                        odontologoQuery.getString(3),
                        odontologoQuery.getString(4)
                ));
            }
        } catch (Exception e) {
            logger.error("Error al buscar todos los odontólogos", e);
        }
        logger.info("::: Odontólogos encontrados :::");
        return odontologos;
    }
}
