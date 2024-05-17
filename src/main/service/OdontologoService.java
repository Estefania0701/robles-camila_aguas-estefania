package main.service;

import main.dao.IDao;
import main.dao.OdontologoDAOCache;
import main.dao.OdontologoDAOH2;
import main.model.Odontologo;

import java.util.List;

public class OdontologoService {

    private IDao<Odontologo> odontologoDAOH2;

    private IDao<Odontologo> odontologoDAOCache;

    public OdontologoService() {
        this.odontologoDAOH2 = new OdontologoDAOH2();
        this.odontologoDAOCache = new OdontologoDAOCache();
    }

    public Odontologo guardarOdontologoEnH2(Odontologo odontologo) {
        odontologoDAOH2.guardar(odontologo);
        return odontologo;
    }

    public Odontologo guardarOdontologoEnCache(Odontologo odontologo) {
        odontologoDAOCache.guardar(odontologo);
        return odontologo;
    }

    public List<Odontologo> buscarTodosEnH2() {
        return odontologoDAOH2.buscarTodos();
    }

    public List<Odontologo> buscarTodosEnCache() {
        return odontologoDAOCache.buscarTodos();
    }

}
