package com.api.helpdesk.controllers;

import com.api.helpdesk.domain.Tecnico;
import com.api.helpdesk.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tecnico")
public class TecnicoController {

    @Autowired
    private TecnicoService tecnicoService;


    @PostMapping("/createTecnico")
    public ResponseEntity<Tecnico> createTecnico(@RequestBody Tecnico tecnico) {
        tecnicoService.createTecnico(tecnico);
        return new ResponseEntity<>(tecnico, HttpStatus.CREATED);
    }

}
