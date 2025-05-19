package br.edu.ifba.demo.backend.api.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifba.demo.backend.api.dto.EventosDTO;
import br.edu.ifba.demo.backend.api.model.EventosModel;
import br.edu.ifba.demo.backend.api.repository.EventosRepository;


@RestController
@RequestMapping("/eventos")
public class EventosController {

    @Autowired
    private EventosRepository eventosRepository;


    public EventosController(EventosRepository eventosRepository){
        super();
        this.eventosRepository = eventosRepository;
    }


    @GetMapping("/listall")
    public List<EventosModel> listall() {
        var eventos = eventosRepository.findAll();
        return eventos;
    }

    @GetMapping
    public List<EventosModel> listarEventos() {
        return eventosRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<EventosModel> addEventos(@RequestBody EventosModel eventos){
        EventosModel savedEvento = eventosRepository.save(eventos);
        return new ResponseEntity<EventosModel>(savedEvento, HttpStatus.CREATED);
    }
    

}