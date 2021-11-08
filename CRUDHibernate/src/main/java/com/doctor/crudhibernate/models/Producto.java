package com.doctor.crudhibernate.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Doctor32
 * Todos los modelos que vayamos creando deben implementar serializable
 */

@Entity
@Table(name="productos")
public class Producto implements Serializable{
    
    /**
     * Esta relación hará que gracias al EAGER, se puedan cargar todas
     * las tareas de una sola vez
     */
    @OneToMany(mappedBy = "productos", fetch = FetchType.EAGER)
    private List<Pedido> ps;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="precio")
    private Integer precio;

    public Producto() {
    }

    public Producto(Long id, String nombre, Integer precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public List<Pedido> getPs() {
        return ps;
    }

    public void setPs(List<Pedido> ps) {
        this.ps = ps;
    }

    @Override
    public String toString() {
        return id + " | " + nombre + " | " + precio;
    }

}
