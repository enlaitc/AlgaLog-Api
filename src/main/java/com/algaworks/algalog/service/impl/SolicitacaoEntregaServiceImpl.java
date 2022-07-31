package com.algaworks.algalog.service.impl;

import com.algaworks.algalog.exception.custom.NegocioException;
import com.algaworks.algalog.model.Cliente;
import com.algaworks.algalog.model.Entrega;
import com.algaworks.algalog.model.StatusEntrega;
import com.algaworks.algalog.repository.EntregaRepository;
import com.algaworks.algalog.service.ClientService;
import com.algaworks.algalog.service.EntregaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaServiceImpl implements EntregaService {

    private EntregaRepository repository;
    private ClientService clienteService;

    @Transactional
    @Override
    public Entrega solicitarEntrega(Entrega entrega){
        ResponseEntity<Cliente> cliente = clienteService.buscaCliente(entrega.getCliente().getId());

        entrega.setCliente(cliente.getBody());
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(LocalDateTime.now());

        return repository.save(entrega);
    }
}
