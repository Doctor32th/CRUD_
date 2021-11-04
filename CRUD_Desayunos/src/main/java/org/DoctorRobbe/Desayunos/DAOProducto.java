package org.DoctorRobbe.Desayunos;

import org.DoctorRobbe.Desayunos.Conexion;
import org.DoctorRobbe.Implements.Producto;
import org.DoctorRobbe.models.ProductoModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOProducto implements Producto<ProductoModel> {

    private Connection getConnection() throws SQLException {
        return Conexion.getInstance();
    }

    @Override
    public List<ProductoModel> listar() {
        List<ProductoModel> productos = new ArrayList<>();

        try(Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM productos")){
            while (rs.next()){
                ProductoModel pr = new ProductoModel();
                productos.add(pr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }
}
