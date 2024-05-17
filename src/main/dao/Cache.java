package main.dao;

import main.model.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Cache {

    private static final Logger logger = Logger.getLogger(Cache.class);

    private static List<Odontologo> odontologos = new ArrayList<>();

    private static Integer id = 1;

    public static void iniciarCache() {
        odontologos = new ArrayList<>();
        id = 1;
    }

    public static void guardar(Odontologo odontologo) {
        logger.info("Guardando odontólogo en la cache");
        odontologo.setId(id++);
        odontologos.add(odontologo);
    }

    public static List<Odontologo> buscarTodos() {
        logger.info("Buscando todos los odontólogos en la cache");
        return odontologos;
    }
}
