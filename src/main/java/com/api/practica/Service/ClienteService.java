package com.api.practica.Service;

import com.api.practica.Exception.ResourceNotFoundException;
import com.api.practica.Modelos.Cliente;
import com.api.practica.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> obtenerClientes() {
        return clienteRepository.findAll();
    }

    public Cliente actualizarCliente(Long id, Cliente clienteActualizado) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));
        cliente.setNombre(clienteActualizado.getNombre());
        cliente.setDireccion(clienteActualizado.getDireccion());
        cliente.setTelefono(clienteActualizado.getTelefono());
        return clienteRepository.save(cliente);
    }

    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
