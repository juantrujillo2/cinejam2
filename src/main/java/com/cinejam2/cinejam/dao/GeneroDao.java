package com.cinejam2.cinejam.dao;

import com.cinejam2.cinejam.models.Genero;
import com.cinejam2.cinejam.models.Socio;

import java.util.List;

public interface GeneroDao {
    List<Genero> getGeneros();

    void eliminar(Integer gen_id);

    void registrar(Genero genero);
}
