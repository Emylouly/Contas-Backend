package br.edu.ifba.demo.backend.api.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "contas")
public class ContasModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcontas")
    private long idcontas;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "valor", nullable = false)
    private Float valor;

    @Column(name = "data_vencimento", nullable = false)
    private LocalDate  datavencimento;

    @Column(name = "data_pagamento", nullable = true)
    private LocalDate  datapagamento;

    @Column(name = "tipo_conta", nullable = false)
    private String tipoconta;

    @Column(name = "status_contas", nullable = false)
    private boolean statuscontas;

    @ManyToOne
    @JoinColumn(name = "idusuario", nullable = false)
    private UsuarioModel idusuario;

    @ManyToOne
    @JoinColumn(name = "idcategoria", nullable = false)
    private CategoriaModel idcategoria;

    public ContasModel(){
        super();
    }

    public ContasModel(long idcontas, String descricao, float valor, LocalDate  datavencimento, 
    LocalDate datapagamento, String tipoconta, boolean statuscontas, UsuarioModel idusuario, CategoriaModel idcategoria){
        super();
        this.idcontas = idcontas;
        this.descricao = descricao;
        this.valor = valor;
        this.datavencimento = datavencimento;
        this.datapagamento = datapagamento;
        this.tipoconta = tipoconta;
        this.statuscontas = statuscontas;
        this.idusuario = idusuario;
        this.idcategoria = idcategoria;
    }

}
