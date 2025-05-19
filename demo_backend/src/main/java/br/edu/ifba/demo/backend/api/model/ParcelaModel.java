package br.edu.ifba.demo.backend.api.model;

import java.time.LocalDate;

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
@Table(name = "parcela")
public class ParcelaModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idparcela")
    private Long idparcela;

    @Column(name = "data_vencimento", nullable = false)
    private LocalDate  parceladatavencimento;

    @Column(name = "numero_parcela", nullable = false)
    private int numeroparcela;

    @Column(name = "valor_parcela", nullable = false)
    private double valorparcela;

    @ManyToOne
    @JoinColumn(name = "idcontas", nullable = false)
    private ContasModel idcontas;

    public ParcelaModel(){
        super();
    }

    public ParcelaModel(long idparcela, LocalDate parceladatavencimento, int numeroparcela, double valorparcela, ContasModel idcontas){
        super();
        this.idparcela = idparcela;
        this.parceladatavencimento = parceladatavencimento;
        this.numeroparcela = numeroparcela;
        this.valorparcela = valorparcela;
        this.idcontas = idcontas;
    }

}

