package com.cinejam2.cinejam.dao;

import com.cinejam2.cinejam.models.ActorPelicula;
import com.cinejam2.cinejam.models.Socio;

import java.util.List;

public interface ActorPeliculaDao {
    List<ActorPelicula> getActorPeliculas();

    void eliminar(Integer apl_id);

    void registrar(ActorPelicula actorPelicula);
}
