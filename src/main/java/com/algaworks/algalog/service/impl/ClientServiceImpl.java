package com.algaworks.algalog.service.impl;

import com.algaworks.algalog.exception.custom.NegocioException;
import com.algaworks.algalog.model.Cliente;
import com.algaworks.algalog.repository.ClienteRepository;
import com.algaworks.algalog.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {

    private ClienteRepository repository;

    @Transactional
    @Override
    public Cliente salvaCliente(Cliente cliente){
        Optional<Cliente> clienteEmail = repository.findByEmail(cliente.getEmail());
        if(clienteEmail.isPresent()) throw new NegocioException("Já existe um cliente cadastrado com este e-mail.");

        return repository.save(cliente);
    }

    @Transactional
    @Override
    public ResponseEntity<Void> deletaCliente(Long clienteId){
        if(!repository.existsById(clienteId)) return ResponseEntity.notFound().build();

        repository.deleteById(clienteId);

        return ResponseEntity.noContent().build();
    }

    @Override
    public List<Cliente> listaTodosOsClientes() {
        return repository.findAll();
    }

    @Override
    public ResponseEntity<Cliente> buscaCliente(Long clienteId) {
        ResponseEntity<Cliente> cliente = repository.findById(clienteId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
        if (!cliente.hasBody()) throw new NegocioException("Cliente nao encontrado");
        return cliente;
    }

    @Transactional
    @Override
    public ResponseEntity<Cliente> atualizaCliente(Long clienteId, Cliente cliente) {
        if(!repository.existsById(clienteId)) return ResponseEntity.notFound().build();

        cliente.setId(clienteId);
        cliente = salvaCliente(cliente);

        return ResponseEntity.ok(cliente);
    }

}
