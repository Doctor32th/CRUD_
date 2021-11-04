package org.DoctorRobbe.Desayunos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static String url = "jdbc:mysql://localhost3306/crud_jdbc?serverTimeZone=Europe/Madrid";
    private static String usuario = "root";
    private static String clave = "root";
    private static Connection conexion;

    public static Connection getInstance() throws SQLException {
        if (conexion == null){
            conexion = DriverManager.getConnection(url, usuario, clave);
        }
        return conexion;
    }
}
