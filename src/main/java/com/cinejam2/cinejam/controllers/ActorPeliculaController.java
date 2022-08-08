package com.cinejam2.cinejam.controllers;

import com.cinejam2.cinejam.dao.ActorPeliculaDao;
import com.cinejam2.cinejam.models.ActorPelicula;
import com.cinejam2.cinejam.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActorPeliculaController {
    @Autowired
    private ActorPeliculaDao actorPeliculaDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/actorPelicula", method = RequestMethod.GET)
    public List<ActorPelicula> getActorPeliculas(@RequestHeader(value="Authorization") String token) {
        if (!validarToken(token)) { return null; }

        return actorPeliculaDao.getActorPeliculas();
    }

    private boolean validarToken(String token) {
        String actorPeliculaId = jwtUtil.getKey(token);
        return actorPeliculaId != null;
    }

    @RequestMapping(value = "api/actorPelicula", method = RequestMethod.POST)
    public void registrarActorPelicula(@RequestBody ActorPelicula actorPelicula) {

        actorPeliculaDao.registrar(actorPelicula);
    }

    @RequestMapping(value = "api/actorPelicula/{apl_id}", method = RequestMethod.DELETE)
    public void eliminar(@RequestHeader(value="Authorization") String token,
                         @PathVariable Integer apl_id) {
        if (!validarToken(token)) { return; }

        actorPeliculaDao.eliminar(apl_id);
    }
}
