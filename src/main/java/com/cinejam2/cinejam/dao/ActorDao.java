package com.cinejam2.cinejam.dao;

import com.cinejam2.cinejam.models.Actor;

import java.util.List;

public interface ActorDao {
    List<Actor> getActores();

    void eliminar(Integer act_id);

    void registrar(Actor actor);
}
