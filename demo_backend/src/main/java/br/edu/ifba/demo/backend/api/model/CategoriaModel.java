package br.edu.ifba.demo.backend.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "categoria")
public class CategoriaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcategoria")
    private long idcategoria;

    @Column(name = "descricao", nullable = false)
    private String categoriadescricao;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    public CategoriaModel(){
        super();
    }

    public CategoriaModel(long idcategoria, String categoriadescricao, String tipo){
        super();
        this.idcategoria = idcategoria;
        this.categoriadescricao = categoriadescricao;
        this.tipo = tipo;
    }
}
