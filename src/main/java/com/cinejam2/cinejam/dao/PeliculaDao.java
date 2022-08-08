package com.cinejam2.cinejam.dao;

import com.cinejam2.cinejam.models.Pelicula;
import com.cinejam2.cinejam.models.Socio;

import java.util.List;

public interface PeliculaDao {
    List<Pelicula> getPeliculas();

    void eliminar(Integer pel_id);

    void registrar(Pelicula pelicula);
}
