package br.edu.ifba.demo.backend.api.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifba.demo.backend.api.model.ContasModel;


@Repository
public interface ContasRepository
    extends JpaRepository<ContasModel, Long>
{

    List<ContasModel> findByDatavencimento(LocalDate datavencimento);
    List<ContasModel> findByDatapagamento(LocalDate datapagamento);
    List<ContasModel> findByTipoconta(String tipoConta);
    List<ContasModel> findByStatuscontas(Boolean statuscontas);
    List<ContasModel> findByIdusuario_Idusuario(Long idusuario);
    List<ContasModel> findByIdusuario_Nome(String nome);
    List<ContasModel> findByIdcategoriaIdcategoria(Long idcategoria);


}