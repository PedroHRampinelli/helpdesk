package com.api.helpdesk.services;

import com.api.helpdesk.domains.Pessoa;
import com.api.helpdesk.domains.Tecnico;
import com.api.helpdesk.domains.dto.TecnicoDTO;
import com.api.helpdesk.repositories.PessoaRepository;
import com.api.helpdesk.repositories.TecnicoRepository;
import com.api.helpdesk.services.exception.DataIntegrityViolationException;
import com.api.helpdesk.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Tecnico createTecnico(TecnicoDTO tecnicoDTO) {
        Tecnico tecnico = new Tecnico(tecnicoDTO);
        validaCPFeEmail(tecnicoDTO);

        return tecnicoRepository.save(tecnico);
    }


    public List<Tecnico> findAll() {
        return tecnicoRepository.findAll();
    }


    public Tecnico findById(Integer id) {
        Optional<Tecnico> tecnico = tecnicoRepository.findById(id);
        return tecnico.orElseThrow(() -> new ObjectNotFoundException("ID não encontrado: " + id));
    }

    public Tecnico update(Integer id, TecnicoDTO tecnicoDTO) {
        tecnicoDTO.setId(id);
        Tecnico tecnico = findById(id);

        validaCPFeEmail(tecnicoDTO);

        tecnico = new Tecnico(tecnicoDTO);
        return tecnicoRepository.save(tecnico);
    }

    public void delete(Integer id) {
        Tecnico tecnico = findById(id);

        tecnicoRepository.deleteById(id);
    }


    public void validaCPFeEmail(TecnicoDTO tecnicoDTO) {
        Optional<Pessoa> pessoa = pessoaRepository.findByCpf(tecnicoDTO.getCpf());

        if(pessoa.isPresent() && pessoa.get().getId() != tecnicoDTO.getId()){
            throw new DataIntegrityViolationException("CPF já cadastrado");
        }

        pessoa = pessoaRepository.findByEmail(tecnicoDTO.getEmail());
        if(pessoa.isPresent() && pessoa.get().getId() != tecnicoDTO.getId()) {
            throw new DataIntegrityViolationException("Email ja cadastrado");
        }
    }


}
