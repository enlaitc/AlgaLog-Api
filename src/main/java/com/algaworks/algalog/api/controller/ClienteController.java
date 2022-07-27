package com.algaworks.algalog.api.controller;

import com.algaworks.algalog.model.Cliente;
import com.algaworks.algalog.repository.ClienteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ClienteController {

//    @Autowired
    private ClienteRepository repository;

//    não precisa do autowired
    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/clientes")
    public List<Cliente> listar(){
        return repository.findAll();
    }

    @PostMapping("/clientes")
    public Cliente salvarCliente(@RequestBody Cliente body){
        return repository.save(body);
    }
}
