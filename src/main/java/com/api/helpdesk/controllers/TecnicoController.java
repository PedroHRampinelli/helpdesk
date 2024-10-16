package com.api.helpdesk.controllers;

import com.api.helpdesk.domains.Tecnico;
import com.api.helpdesk.domains.dto.TecnicoDTO;
import com.api.helpdesk.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("tecnico")
public class TecnicoController {

    @Autowired
    private TecnicoService tecnicoService;

    @GetMapping("/findById/{id}")
    public ResponseEntity<TecnicoDTO> findById(@PathVariable Integer id) {
        Tecnico tecnico = tecnicoService.findById(id);

        return ResponseEntity.ok().body(new TecnicoDTO(tecnico));
    }

    @GetMapping("/getAllTecnico")
    public ResponseEntity<List<TecnicoDTO>> getAllTecnico() {
        List<Tecnico> tecnicoList = tecnicoService.findAll();
        List<TecnicoDTO> tecnicoDTOList = tecnicoList.stream().map(x -> new TecnicoDTO(x)).collect(Collectors.toList());

        return ResponseEntity.ok().body(tecnicoDTOList);
    }

    @PostMapping("/createTecnico")
    public ResponseEntity<TecnicoDTO> createTecnico(@RequestBody TecnicoDTO tecnicoDTO) {
        tecnicoService.createTecnico(tecnicoDTO);
        return new ResponseEntity<>(tecnicoDTO, HttpStatus.CREATED);
    }

    @PostMapping("update/{id}")
    public ResponseEntity<TecnicoDTO> updateTecnico(@PathVariable Integer id, @RequestBody TecnicoDTO tecnicoDTO){
        tecnicoService.update(id, tecnicoDTO);

        return new ResponseEntity<>(tecnicoDTO, HttpStatus.CREATED);
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<TecnicoDTO> deleteTecnico(@PathVariable Integer id) {
        tecnicoService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
