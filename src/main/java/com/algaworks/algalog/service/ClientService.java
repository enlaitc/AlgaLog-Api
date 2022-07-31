package com.algaworks.algalog.service;

import com.algaworks.algalog.model.Cliente;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClientService {

    Cliente salvaCliente(Cliente cliente);
    ResponseEntity<Void> deletaCliente(Long clienteId);
    List<Cliente> listaTodosOsClientes();
    ResponseEntity<Cliente> buscaCliente(Long clienteId);
    ResponseEntity<Cliente> atualizaCliente(Long clienteId, Cliente cliente);

}
