package test;

import main.dao.Cache;
import main.dao.H2;
import main.model.Odontologo;
import main.service.OdontologoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OdontologoServiceTest {

    @Test
    public void guardarOdonotologoEnH2() {
        Odontologo odontologo = new Odontologo(
                123456,
            "Juan",
            "Perez"
        );

        H2.crearTablas();
        OdontologoService odontologoService = new OdontologoService();
        Odontologo odontologoGuardado = odontologoService.guardarOdontologoEnH2(odontologo);

        Assertions.assertTrue(odontologoGuardado != null);
    }

    @Test
    public void guardarOdontologoEnCache() {
        Odontologo odontologo = new Odontologo(
                453543,
            "Juana",
            "López"
        );

        Cache.iniciarCache();

        OdontologoService odontologoService = new OdontologoService();
        Odontologo odontologoGuardado = odontologoService.guardarOdontologoEnCache(odontologo);

        Assertions.assertTrue(odontologoGuardado != null);
    }

    @Test
    public void buscarTodosEnH2() {
        H2.crearTablas();
        OdontologoService odontologoService = new OdontologoService();
        Assertions.assertTrue(odontologoService.buscarTodosEnH2().size() == 2);
    }

    @Test
    public void buscarTodosEnCache() {
        Odontologo odontologo1 = new Odontologo(
                453543,
                "Juana",
                "López"
        );
        Odontologo odontologo2 = new Odontologo(
                6766,
                "Andrés",
                "Salazar"
        );

        Cache.iniciarCache();
        OdontologoService odontologoService = new OdontologoService();
        odontologoService.guardarOdontologoEnCache(odontologo1);
        odontologoService.guardarOdontologoEnCache(odontologo2);
        Assertions.assertTrue(odontologoService.buscarTodosEnCache().size() == 2);

        // Validando que funcione el ID autoincremental
        Assertions.assertTrue(odontologoService.buscarTodosEnCache().get(0).getId() == 1);
        Assertions.assertTrue(odontologoService.buscarTodosEnCache().get(1).getId() == 2);
    }

}
