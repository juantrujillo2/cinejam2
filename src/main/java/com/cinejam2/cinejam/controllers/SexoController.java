package com.cinejam2.cinejam.controllers;

import com.cinejam2.cinejam.dao.SexoDao;
import com.cinejam2.cinejam.models.Sexo;
import com.cinejam2.cinejam.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SexoController {
    @Autowired
    private SexoDao sexoDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/sexo", method = RequestMethod.GET)
    public List<Sexo> getSexos(@RequestHeader(value="Authorization") String token) {
        if (!validarToken(token)) { return null; }

        return sexoDao.getSexos();
    }

    private boolean validarToken(String token) {
        String sexoId = jwtUtil.getKey(token);
        return sexoId != null;
    }

    @RequestMapping(value = "api/sexo", method = RequestMethod.POST)
    public void registrarSexo(@RequestBody Sexo sexo) {

        sexoDao.registrar(sexo);
    }

    @RequestMapping(value = "api/sexo/{sex_id}", method = RequestMethod.DELETE)
    public void eliminar(@RequestHeader(value="Authorization") String token,
                         @PathVariable Integer sex_id) {
        if (!validarToken(token)) { return; }

        sexoDao.eliminar(sex_id);
    }
}
