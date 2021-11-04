package org.DoctorRobbe.models;

public class ProductoModel {

    private Long id_producto;
    private String nombre;
    private String detalle;
    private Integer precio;

    public ProductoModel() {
    }

    public ProductoModel(Long id_producto, String nombre, String detalle, Integer precio) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.detalle = detalle;
        this.precio = precio;
    }

    public Long getId_producto() {
        return id_producto;
    }

    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return  id_producto +
                " | " + nombre +
                " | " + detalle +
                " | " + precio;
    }
}
