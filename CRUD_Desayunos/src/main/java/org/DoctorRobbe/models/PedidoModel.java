package org.DoctorRobbe.models;

import java.util.Date;

public class PedidoModel {

    private Long id_pedido;
    private Date fecha;
    private ProductoModel producto;

    public PedidoModel() {
    }

    public PedidoModel(ProductoModel producto) {
        this.producto = producto;
    }

    public PedidoModel(Long id_pedido, Date fecha) {
        this.id_pedido = id_pedido;
        this.fecha = fecha;
    }

    public Long getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Long id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ProductoModel getProducto() {
        return producto;
    }

    public void setProducto(ProductoModel producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return id_pedido +
                " | " + fecha +
                " | " + producto;
    }
}
