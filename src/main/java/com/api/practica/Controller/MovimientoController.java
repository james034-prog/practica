package com.api.practica.Controller;

import com.api.practica.Modelos.Movimiento;
import com.api.practica.Service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movimientos")
public class MovimientoController {

    @Autowired
    private MovimientoService movimientoService;

    @PostMapping
    public Movimiento registrarMovimiento(@RequestParam Long cuentaId, @RequestParam Double monto) {
        return movimientoService.registrarMovimiento(cuentaId, monto);
    }
}

