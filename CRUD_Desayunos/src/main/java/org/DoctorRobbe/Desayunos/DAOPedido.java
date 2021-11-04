package org.DoctorRobbe.Desayunos;

import org.DoctorRobbe.Desayunos.Conexion;
import org.DoctorRobbe.Implements.Pedido;
import org.DoctorRobbe.models.PedidoModel;
import org.DoctorRobbe.models.ProductoModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOPedido implements Pedido<PedidoModel> {

    private Connection getConnection() throws SQLException {
        return Conexion.getInstance();
    }

    @Override
    public List<PedidoModel> listar() {
        List<PedidoModel> pedidos = new ArrayList<>();

        try(Statement stmt = getConnection().createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM pedidos as pe " +
                "inner join productos as pr ON (pe.prod_id=pr.id_producto)")){
            while (rs.next()){
                PedidoModel p = new PedidoModel();
                pedidos.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedidos;
    }

    public List<PedidoModel> listarPedidosActuales() {
        List<PedidoModel> listadeHoy = new ArrayList<PedidoModel>();

        try(Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM pedidos as pe " +
                    "inner join productos as pr ON (pe.prod_id=pr.id_producto)" +
                    "WHERE fecha='2021-11-03'")){
            while (rs.next()){
                PedidoModel p = new PedidoModel();
                listadeHoy.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listadeHoy;
    }

    @Override
    public void guardar(PedidoModel pedidoModel) {
        String sql;
        if (pedidoModel.getId_pedido() != null && pedidoModel.getId_pedido() > 0){
            sql = "UPDATE pedidos SET prod_id=? WHERE id=?";
        } else {
            sql = "INSERT INTRO pedidos (fecha, prod_id) VALUES(?, ?, ?)";
        }
        try(PreparedStatement stmt = getConnection().prepareStatement(sql)){
            stmt.setLong(1, pedidoModel.getProducto().getId_producto());

            if (pedidoModel.getId_pedido() != null && pedidoModel.getId_pedido() > 0){
                stmt.setLong(2, pedidoModel.getId_pedido());
            } else {
                stmt.setDate(1, new Date(pedidoModel.getFecha().getTime()));
            }

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Long id) {
        try(PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM pedidos WHERE id=?")){
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PedidoModel crearPedido(ResultSet rs) throws SQLException{
        PedidoModel p = new PedidoModel();
        p.setId_pedido(rs.getLong("id_pedido"));
        p.setFecha(rs.getDate("fecha"));
        ProductoModel pr = new ProductoModel();
        pr.setId_producto(rs.getLong("id_producto"));
        pr.setNombre(rs.getString("nombre"));
        p.setProducto(pr);
        return p;

    }

}
