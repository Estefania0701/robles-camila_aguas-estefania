package main;


import main.dao.DataBase;
import main.model.Paciente;
import main.service.PacienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class PacienteServiceTest {

    @Test
    public void buscarPorIdPaciente() {
        DataBase.crearTablas();
        PacienteService pacienteService = new PacienteService();
        Integer id = 2;
        Paciente paciente = pacienteService.buscarPorId(id);
        Assertions.assertTrue(paciente != null);
    }

}