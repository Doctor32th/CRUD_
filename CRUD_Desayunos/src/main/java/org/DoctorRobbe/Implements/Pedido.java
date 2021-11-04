package org.DoctorRobbe.Implements;

import java.util.List;

public interface Pedido<T> {

    List<T> listar();

    void guardar(T t);

    void eliminar(Long id);
}
