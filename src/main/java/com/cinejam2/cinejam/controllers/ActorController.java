package com.cinejam2.cinejam.controllers;

import com.cinejam2.cinejam.dao.ActorDao;
import com.cinejam2.cinejam.models.Actor;
import com.cinejam2.cinejam.models.Socio;
import com.cinejam2.cinejam.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActorController {
    @Autowired
    private ActorDao actorDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/actor", method = RequestMethod.GET)
    public List<Actor> getActores(@RequestHeader(value="Authorization") String token) {
        if (!validarToken(token)) { return null; }

        return actorDao.getActores();
    }

    private boolean validarToken(String token) {
        String actorId = jwtUtil.getKey(token);
        return actorId != null;
    }

    @RequestMapping(value = "api/actor", method = RequestMethod.POST)
    public void registrarActor(@RequestBody Actor actor) {

        actorDao.registrar(actor);
    }

    @RequestMapping(value = "api/actor/{act_id}", method = RequestMethod.DELETE)
    public void eliminar(@RequestHeader(value="Authorization") String token,
                         @PathVariable Integer act_id) {
        if (!validarToken(token)) { return; }

        actorDao.eliminar(act_id);
    }
}
