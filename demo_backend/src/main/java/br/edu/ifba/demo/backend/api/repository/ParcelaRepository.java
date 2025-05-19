package br.edu.ifba.demo.backend.api.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifba.demo.backend.api.model.ParcelaModel;

@Repository
public interface ParcelaRepository 
    extends JpaRepository<ParcelaModel, Long>
{

    List<ParcelaModel> findByParceladatavencimento(LocalDate parceladatavencimento);
    List<ParcelaModel> findByIdcontas_Idcontas(Long idcontas);
    
}
