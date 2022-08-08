package com.cinejam2.cinejam.dao;

import com.cinejam2.cinejam.models.Formato;
import com.cinejam2.cinejam.models.Socio;

import java.util.List;

public interface FormatoDao {
    List<Formato> getFormatos();

    void eliminar(Integer for_id);

    void registrar(Formato formato);
}
