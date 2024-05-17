package main.service;

import main.dao.IDao;
import main.dao.PacienteDAOH2;
import main.model.Paciente;

public class PacienteService {
    private IDao<Paciente> pacienteDAO;

    public PacienteService() {
        this.pacienteDAO = new PacienteDAOH2();
    }

    public Paciente guardarPaciente(Paciente paciente) {
        return pacienteDAO.guardar(paciente);
    }

    public Paciente buscarPorId(Integer id) {
        return pacienteDAO.buscarPorId(id);
    }
}
