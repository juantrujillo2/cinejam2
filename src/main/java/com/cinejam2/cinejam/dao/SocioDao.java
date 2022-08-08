package com.cinejam2.cinejam.dao;

import com.cinejam2.cinejam.models.Socio;
import com.cinejam2.cinejam.models.Usuario;

import java.util.List;

public interface SocioDao {
    List<Socio> getSocios();

    void eliminar(Integer soc_id);

    void registrar(Socio socio);
}
