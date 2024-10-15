package com.api.helpdesk.repositories;

import com.api.helpdesk.domains.Tecnico;
import com.api.helpdesk.domains.dto.TecnicoDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {
}
