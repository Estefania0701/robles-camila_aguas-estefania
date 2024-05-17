package main.dao;

import main.model.Domicilio;
import main.model.Paciente;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class PacienteDAOH2 implements IDao<Paciente> {

    private static final Logger logger = Logger.getLogger(PacienteDAOH2.class);

    private static final String SQL_SELECT_ONE = "SELECT * FROM PACIENTES WHERE ID = ?";


    @Override
    public Paciente guardar(Paciente paciente) {
        return null;
    }

    @Override
    public Paciente buscarPorId(Integer id) {
        logger.info("::: Buscando paciente por ID :::");
        Connection connection = null;
        Paciente paciente = null;
        Domicilio domicilio = null;
        try {
            connection = DataBase.getConnection();
            Statement statement = connection.createStatement();
            PreparedStatement psSelectOne = connection.prepareStatement(SQL_SELECT_ONE);
            psSelectOne.setInt(1, id);

            // guardar el resultado
            ResultSet pacienteQuery = psSelectOne.executeQuery();

            DomicilioDAOH2 domicilioDAOH2 = new DomicilioDAOH2();
            while (pacienteQuery.next()) {
                domicilio = domicilioDAOH2.buscarPorId(pacienteQuery.getInt(6));
                paciente = new Paciente(
                        pacienteQuery.getInt(1),
                        pacienteQuery.getString(2),
                        pacienteQuery.getString(3),
                        pacienteQuery.getString(4),
                        pacienteQuery.getDate(5).toLocalDate(),
                        domicilio
                );
            }
        } catch (Exception e) {
            logger.error("Error al buscar el paciente por ID", e);
        }
        return paciente;
    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public void actualizar(Paciente paciente) {

    }

    @Override
    public List<Paciente> buscarTodos() {
        return null;
    }
}
