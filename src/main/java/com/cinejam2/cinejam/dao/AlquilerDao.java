package com.cinejam2.cinejam.dao;

import com.cinejam2.cinejam.models.Alquiler;

import java.util.List;

public interface AlquilerDao {
    List<Alquiler> getAlquileres();

    void eliminar(Integer alq_id);

    void registrar(Alquiler alquiler);
}
