package com.algaworks.algalog.api.controller;

import com.algaworks.algalog.model.Cliente;
import com.algaworks.algalog.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private ClientService service;

    @GetMapping
    public List<Cliente> listaTodosOsClientes(){
        return service.listaTodosOsClientes();
    }
    @GetMapping("/{clienteId}")
    public ResponseEntity<Cliente> buscaCliente(@PathVariable long clienteId){
        return service.buscaCliente(clienteId);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionaCliente(@Valid @RequestBody Cliente cliente){
        return service.salvaCliente(cliente);
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<Cliente> atualizaCliente(@Valid @PathVariable long clienteId,@RequestBody Cliente cliente){
        return service.atualizaCliente(clienteId,cliente);
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> excluirCliente(@PathVariable Long clienteId){
        return service.deletaCliente(clienteId);
    }
}
