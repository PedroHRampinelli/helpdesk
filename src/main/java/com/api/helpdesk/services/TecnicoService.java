package com.api.helpdesk.services;

import com.api.helpdesk.domains.Tecnico;
import com.api.helpdesk.domains.dto.TecnicoDTO;
import com.api.helpdesk.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    public Tecnico createTecnico(TecnicoDTO tecnicoDTO) {
        Tecnico tecnico = new Tecnico(tecnicoDTO);
        return tecnicoRepository.save(tecnico);
    }


    public List<Tecnico> findAll() {
        return tecnicoRepository.findAll();
    }


    public Tecnico findById(Integer id) {
        Optional<Tecnico> tecnico = tecnicoRepository.findById(id);
        return tecnico.orElseThrow(() -> new IllegalArgumentException("n funcionou"));
    }
}
