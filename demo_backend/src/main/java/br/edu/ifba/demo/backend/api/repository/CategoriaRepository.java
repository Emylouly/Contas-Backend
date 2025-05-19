package br.edu.ifba.demo.backend.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifba.demo.backend.api.model.CategoriaModel;


public interface CategoriaRepository 
    extends JpaRepository<CategoriaModel, Long>
{

    List<CategoriaModel> findByCategoriadescricao(String categoriadescricao);
    List <CategoriaModel> findByTipo(String tipo);
    
}
