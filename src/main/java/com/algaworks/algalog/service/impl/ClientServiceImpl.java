package com.algaworks.algalog.service.impl;

import com.algaworks.algalog.model.Cliente;
import com.algaworks.algalog.repository.ClienteRepository;
import com.algaworks.algalog.service.ClientService;
import org.springframework.transaction.annotation.Transactional;

public class ClientServiceImpl implements ClientService {

    private ClienteRepository repository;

    @Transactional
    public Cliente salvaCliente(Cliente cliente){
        return repository.save(cliente);
    }

    public void deletaCliente(Long clienteId){
        repository.deleteById(clienteId);
    }

}
