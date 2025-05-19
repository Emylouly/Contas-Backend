package br.edu.ifba.demo.backend.api.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifba.demo.backend.api.model.EnderecoModel;



public interface EnderecoRepository extends JpaRepository<EnderecoModel, Long>{

    Optional<EnderecoModel> findByEstado(String estado);
    Optional<EnderecoModel> findByCidade(String cidade);
    Optional<EnderecoModel> findByBairro(String bairro);
    Optional<EnderecoModel> findByRua(String rua);
    Optional<EnderecoModel> findByNumero(String numero);
    Optional<EnderecoModel> findByCep(String cep);

}