package com.api.helpdesk.repositories;

import com.api.helpdesk.domains.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {
}
