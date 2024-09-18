package com.api.practica.Controller;

import com.api.practica.Modelos.Cuenta;
import com.api.practica.Service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @PostMapping
    public Cuenta crearCuenta(@RequestBody Cuenta cuenta) {
        return cuentaService.crearCuenta(cuenta);
    }

    @GetMapping
    public List<Cuenta> obtenerCuentas() {
        return cuentaService.obtenerCuentas();
    }
}

