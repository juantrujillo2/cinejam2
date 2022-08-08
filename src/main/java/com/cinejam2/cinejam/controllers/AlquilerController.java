package com.cinejam2.cinejam.controllers;

import com.cinejam2.cinejam.dao.AlquilerDao;
import com.cinejam2.cinejam.dao.SocioDao;
import com.cinejam2.cinejam.models.Alquiler;
import com.cinejam2.cinejam.models.Socio;
import com.cinejam2.cinejam.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlquilerController {
    @Autowired
    private AlquilerDao alquilerDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/alquiler", method = RequestMethod.GET)
    public List<Alquiler> getAlquileres(@RequestHeader(value="Authorization") String token) {
        if (!validarToken(token)) { return null; }

        return alquilerDao.getAlquileres();
    }

    private boolean validarToken(String token) {
        String alquilerId = jwtUtil.getKey(token);
        return alquilerId != null;
    }

    @RequestMapping(value = "api/alquiler", method = RequestMethod.POST)
    public void registrarAlquiler(@RequestBody Alquiler alquiler) {

        alquilerDao.registrar(alquiler);
    }

    @RequestMapping(value = "api/alquiler/{alq_id}", method = RequestMethod.DELETE)
    public void eliminar(@RequestHeader(value="Authorization") String token,
                         @PathVariable Integer alq_id) {
        if (!validarToken(token)) { return; }

        alquilerDao.eliminar(alq_id);
    }
}
