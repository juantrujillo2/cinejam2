package com.cinejam2.cinejam.dao;

import com.cinejam2.cinejam.models.Director;

import java.util.List;

public interface DirectorDao {
    List<Director> getDirectores();

    void eliminar(Integer dir_id);

    void registrar(Director director);
}
