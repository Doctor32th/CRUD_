package com.doctor.crudhibernate.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author Doctor32
 * La relación entre Pedido y Producto es bidireccional
 * Clase Pedido. Es la parte del muchos, dando a entender que muchos pedidos
 * tienen un solo producto de la carta.
 */
@Entity
@Table(name="pedidos")
public class Pedido implements Serializable{
    
    @ManyToOne()
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Producto p;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpe;
    
    //Realmente no hace falta, pero por seguridad adjuntamos el nombre
    //de cada atributo al nombre que tiene en la base de datos
    @Column(name="estado")
    private String estado;
    
    @Column(name="fecha")
    private String fecha;

    public Pedido() {
    }

    public Pedido(Long idpe, String estado, String fecha) {
        this.idpe = idpe;
        this.estado = estado;
        this.fecha = fecha;
    }

    public Long getIdpe() {
        return idpe;
    }

    public void setIdpe(Long idpe) {
        this.idpe = idpe;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Producto getP() {
        return p;
    }

    public void setP(Producto p) {
        this.p = p;
    }

    @Override
    public String toString() {
        return p + " | " + idpe + " | " + estado + " | " + fecha + " | ";
    }
    
 
}
