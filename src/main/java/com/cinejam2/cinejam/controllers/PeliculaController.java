package com.cinejam2.cinejam.controllers;

import com.cinejam2.cinejam.dao.PeliculaDao;
import com.cinejam2.cinejam.models.Pelicula;
import com.cinejam2.cinejam.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PeliculaController {
    @Autowired
    private PeliculaDao peliculaDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/pelicula", method = RequestMethod.GET)
    public List<Pelicula> getPeliculas(@RequestHeader(value="Authorization") String token) {
        if (!validarToken(token)) { return null; }

        return peliculaDao.getPeliculas();
    }

    private boolean validarToken(String token) {
        String peliculaId = jwtUtil.getKey(token);
        return peliculaId != null;
    }

    @RequestMapping(value = "api/selicula", method = RequestMethod.POST)
    public void registrarPelicula(@RequestBody Pelicula pelicula) {

        peliculaDao.registrar(pelicula);
    }

    @RequestMapping(value = "api/pelicula/{pel_id}", method = RequestMethod.DELETE)
    public void eliminar(@RequestHeader(value="Authorization") String token,
                         @PathVariable Integer pel_id) {
        if (!validarToken(token)) { return; }

        peliculaDao.eliminar(pel_id);
    }
}
