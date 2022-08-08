package com.cinejam2.cinejam.controllers;

import com.cinejam2.cinejam.dao.SocioDao;
import com.cinejam2.cinejam.models.Socio;
import com.cinejam2.cinejam.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SocioController {
    @Autowired
    private SocioDao socioDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/socio", method = RequestMethod.GET)
    public List<Socio> getUsuarios(@RequestHeader(value="Authorization") String token) {
        if (!validarToken(token)) { return null; }

        return socioDao.getSocios();
        //return usuarioDao.getUsuarios();
    }

    private boolean validarToken(String token) {
        String socioId = jwtUtil.getKey(token);
        return socioId != null;
    }

    @RequestMapping(value = "api/socio", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Socio socio) {

        socioDao.registrar(socio);
    }

    @RequestMapping(value = "api/socio/{soc_id}", method = RequestMethod.DELETE)
    public void eliminar(@RequestHeader(value="Authorization") String token,
                         @PathVariable Integer soc_id) {
        if (!validarToken(token)) { return; }

        socioDao.eliminar(soc_id);
    }
}
