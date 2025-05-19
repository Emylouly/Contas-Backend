package br.edu.ifba.demo.backend.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifba.demo.backend.api.model.TelefoneModel;

@Repository
public interface TelefoneRepository 
    extends JpaRepository<TelefoneModel, Long> 
{
    
    Optional<TelefoneModel> findByTelefonenumero(String telefonenumero);
    List<TelefoneModel> findByTiponumero(String tiponumero);

}
