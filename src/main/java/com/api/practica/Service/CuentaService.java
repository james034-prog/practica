package com.api.practica.Service;

import com.api.practica.Exception.ResourceNotFoundException;
import com.api.practica.Modelos.Cuenta;
import com.api.practica.Repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaService {
    @Autowired
    private CuentaRepository cuentaRepository;

    public Cuenta crearCuenta(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    public List<Cuenta> obtenerCuentas() {
        return cuentaRepository.findAll();
    }

    public Cuenta actualizarSaldo(Long id, Double saldo) {
        Cuenta cuenta = cuentaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cuenta no encontrada"));
        cuenta.setSaldo(saldo);
        return cuentaRepository.save(cuenta);
    }
}
