package br.edu.ifba.demo.backend.api.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifba.demo.backend.api.model.EventosModel;

public interface EventosRepository extends JpaRepository<EventosModel, Long> {

    
}
