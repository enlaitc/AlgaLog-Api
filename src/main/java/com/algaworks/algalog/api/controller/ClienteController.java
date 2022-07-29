package com.algaworks.algalog.api.controller;

import com.algaworks.algalog.model.Cliente;
import com.algaworks.algalog.repository.ClienteRepository;
import com.algaworks.algalog.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private ClientService service;
    private ClienteRepository repository;

    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Cliente> listaTodosOsClientes(){
        return repository.findAll();
    }
    @GetMapping("/{clienteId}")
    public ResponseEntity<Cliente> buscaCliente(@PathVariable long clienteId){
        return repository.findById(clienteId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionaCliente(@Valid @RequestBody Cliente cliente){
        return service.salvaCliente(cliente);
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<Cliente> atualizaCliente(@Valid @PathVariable long clienteId,@RequestBody Cliente cliente){
        if(!repository.existsById(clienteId)) return ResponseEntity.notFound().build();

        cliente.setId(clienteId);
        cliente = repository.save(cliente);

        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> excluirCliente(@PathVariable Long clienteId){
        if(!repository.existsById(clienteId)) return ResponseEntity.notFound().build();

        repository.deleteById(clienteId);

        return ResponseEntity.noContent().build();
    }
}
