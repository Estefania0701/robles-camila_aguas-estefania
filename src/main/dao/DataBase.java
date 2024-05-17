package main.dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DataBase {

    private static final Logger logger = Logger.getLogger(DataBase.class);

    private static final String SQL_DROP_CREATE_PACIENTES= "DROP TABLE IF EXISTS PACIENTES; " +
            "CREATE TABLE PACIENTES (" +
            "ID INT AUTO_INCREMENT PRIMARY KEY, " +
            "NOMBRE VARCHAR(100) NOT NULL, " +
            "APELLIDO VARCHAR(100) NOT NULL, " +
            "CEDULA VARCHAR(100) NOT NULL, " +
            "FECHA_INGRESO DATE NOT NULL, " +
            "DOMICILIO_ID INT NOT NULL)";

    private static final String SQL_DROP_CREATE_DOMICILIOS= "DROP TABLE IF EXISTS DOMICILIOS; " +
            "CREATE TABLE DOMICILIOS (" +
            "ID INT AUTO_INCREMENT PRIMARY KEY, " +
            "CALLE VARCHAR(100) NOT NULL, " +
            "NUMERO INT NOT NULL, " +
            "LOCALIDAD VARCHAR(100) NOT NULL, " +
            "PROVINCIA VARCHAR(100) NOT NULL)";

    private static final String SQL_PRUEBA = "INSERT INTO PACIENTES (NOMBRE, APELLIDO, CEDULA, FECHA_INGRESO, DOMICILIO_ID) VALUES " +
            "('Juan', 'Perez', '12345678', '2021-01-01', 1), " +
            "('Maria', 'Gomez', '87654321', '2021-01-01', 2); " +
            "INSERT INTO DOMICILIOS (CALLE, NUMERO, LOCALIDAD, PROVINCIA) VALUES " +
            "('CL Falsa', 123, 'Alabama', 'Springfield'), " +
            "('KR Falsa', 456, 'Springfield', 'Springfield');";

    public static void crearTablas() {
        Connection connection = null;
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_DROP_CREATE_DOMICILIOS);
            statement.execute(SQL_DROP_CREATE_PACIENTES);
            statement.execute(SQL_PRUEBA);
            logger.info("Tablas creadas correctamente");
        } catch (Exception e) {
            logger.error("Error al crear las tablas", e);
        }
    }

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:mem:~/c11ClinicaDental", "sa", "sa");
    }

}
