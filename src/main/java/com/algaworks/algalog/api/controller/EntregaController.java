package com.algaworks.algalog.api.controller;

import com.algaworks.algalog.model.Entrega;
import com.algaworks.algalog.service.EntregaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

    private EntregaService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entrega solicitarEntrega(@RequestBody Entrega entrega){
        return service.solicitarEntrega(entrega);
    }

}
