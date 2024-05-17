package main.dao;

import main.model.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOCache implements IDao<Odontologo> {

    private static final Logger logger = Logger.getLogger(OdontologoDAOCache.class);

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        logger.info("::: Guardando odontólogo en la cache :::");
        Cache.guardar(odontologo);
        logger.info("::: Odontólogo guardado en la cache :::");
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
        List<Odontologo> odontologos = new ArrayList<>();
        logger.info("::: Buscando todos los odontólogos en la cache :::");
        odontologos = Cache.buscarTodos();
        logger.info("::: Odontólogos encontrados en la cache :::");
        return odontologos;
    }
}
