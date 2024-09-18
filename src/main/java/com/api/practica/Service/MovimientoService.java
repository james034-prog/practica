package com.api.practica.Service;

import com.api.practica.Exception.ResourceNotFoundException;
import com.api.practica.Exception.SaldoInsuficienteException;
import com.api.practica.Modelos.Cuenta;
import com.api.practica.Modelos.Movimiento;
import com.api.practica.Repository.CuentaRepository;
import com.api.practica.Repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class MovimientoService {

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    public Movimiento registrarMovimiento(Long cuentaId, Double monto) {
        Cuenta cuenta = cuentaRepository.findById(cuentaId)
                .orElseThrow(() -> new ResourceNotFoundException("Cuenta no encontrada"));

        if (cuenta.getSaldo() + monto < 0) {
            throw new SaldoInsuficienteException("Saldo no disponible");
        }

        cuenta.setSaldo(cuenta.getSaldo() + monto);
        cuentaRepository.save(cuenta);

        Movimiento movimiento = new Movimiento();
        movimiento.setCuenta(cuenta);
        movimiento.setMonto(monto);
        movimiento.setFecha(LocalDate.now());
        return movimientoRepository.save(movimiento);
    }
}
