package com.cinejam2.cinejam.controllers;

import com.cinejam2.cinejam.dao.GeneroDao;
import com.cinejam2.cinejam.models.Genero;
import com.cinejam2.cinejam.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class GeneroController {
    @Autowired
    private GeneroDao generoDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/genero", method = RequestMethod.GET)
    public List<Genero> getGeneros(@RequestHeader(value="Authorization") String token) {
        if (!validarToken(token)) { return null; }

        return generoDao.getGeneros();
    }

    private boolean validarToken(String token) {
        String generoId = jwtUtil.getKey(token);
        return generoId != null;
    }

    @RequestMapping(value = "api/genero", method = RequestMethod.POST)
    public void registrarGenero(@RequestBody Genero genero) {

        generoDao.registrar(genero);
    }

    @RequestMapping(value = "api/genero/{gen_id}", method = RequestMethod.DELETE)
    public void eliminar(@RequestHeader(value="Authorization") String token,
                         @PathVariable Integer gen_id) {
        if (!validarToken(token)) { return; }

        generoDao.eliminar(gen_id);
    }
}
