package com.cinejam2.cinejam.dao;

import com.cinejam2.cinejam.models.Sexo;
import com.cinejam2.cinejam.models.Socio;

import java.util.List;

public interface SexoDao {
    List<Sexo> getSexos();

    void eliminar(Integer sex_id);

    void registrar(Sexo sexo);
}
