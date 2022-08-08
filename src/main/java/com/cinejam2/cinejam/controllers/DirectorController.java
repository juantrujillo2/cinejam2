package com.cinejam2.cinejam.controllers;

import com.cinejam2.cinejam.dao.DirectorDao;
import com.cinejam2.cinejam.dao.SocioDao;
import com.cinejam2.cinejam.models.Director;
import com.cinejam2.cinejam.models.Socio;
import com.cinejam2.cinejam.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DirectorController {
    @Autowired
    private DirectorDao directorDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/director", method = RequestMethod.GET)
    public List<Director> getDirectores(@RequestHeader(value="Authorization") String token) {
        if (!validarToken(token)) { return null; }

        return directorDao.getDirectores();
    }

    private boolean validarToken(String token) {
        String directorId = jwtUtil.getKey(token);
        return directorId != null;
    }

    @RequestMapping(value = "api/director", method = RequestMethod.POST)
    public void registrarDirector(@RequestBody Director director) {

        directorDao.registrar(director);
    }

    @RequestMapping(value = "api/director/{dir_id}", method = RequestMethod.DELETE)
    public void eliminar(@RequestHeader(value="Authorization") String token,
                         @PathVariable Integer dir_id) {
        if (!validarToken(token)) { return; }

        directorDao.eliminar(dir_id);
    }
}
