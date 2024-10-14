package com.api.helpdesk.services;

import com.api.helpdesk.domain.Tecnico;
import com.api.helpdesk.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository tecnicoRepository;


    public void createTecnico(Tecnico tecnico) {
        tecnicoRepository.save(tecnico);
    }







}
