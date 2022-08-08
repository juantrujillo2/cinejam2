package com.cinejam2.cinejam.controllers;

import com.cinejam2.cinejam.dao.FormatoDao;
import com.cinejam2.cinejam.dao.SocioDao;
import com.cinejam2.cinejam.models.Formato;
import com.cinejam2.cinejam.models.Socio;
import com.cinejam2.cinejam.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FormatoController {
    @Autowired
    private FormatoDao formatoDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/formato", method = RequestMethod.GET)
    public List<Formato> getFormatos(@RequestHeader(value="Authorization") String token) {
        if (!validarToken(token)) { return null; }

        return formatoDao.getFormatos();
    }

    private boolean validarToken(String token) {
        String formatoId = jwtUtil.getKey(token);
        return formatoId != null;
    }

    @RequestMapping(value = "api/formato", method = RequestMethod.POST)
    public void registrarFormato(@RequestBody Formato formato) {

        formatoDao.registrar(formato);
    }

    @RequestMapping(value = "api/formato/{for_id}", method = RequestMethod.DELETE)
    public void eliminar(@RequestHeader(value="Authorization") String token,
                         @PathVariable Integer for_id) {
        if (!validarToken(token)) { return; }

        formatoDao.eliminar(for_id);
    }
}
