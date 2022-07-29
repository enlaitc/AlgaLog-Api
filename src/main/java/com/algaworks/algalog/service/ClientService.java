package com.algaworks.algalog.service;

import com.algaworks.algalog.model.Cliente;

public interface ClientService {

    Cliente salvaCliente(Cliente cliente);
    void deletaCliente(Long clienteId);
}
