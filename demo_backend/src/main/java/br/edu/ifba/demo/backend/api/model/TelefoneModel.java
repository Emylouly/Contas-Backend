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
@Table(name = "telefone")
public class TelefoneModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtelefone")
    private Long idtelefone;

    @Column(name = "numero", nullable = false)
    private String telefonenumero;

    @Column(name = "tipo_numero", nullable = false)
    private String tiponumero;

    public TelefoneModel(){
        super();
    }

    public TelefoneModel(long idtelefone, String telefonenumero, String tiponumero){
        super();
        this.idtelefone = idtelefone;
        this.telefonenumero = telefonenumero;
        this.tiponumero = tiponumero;
    }
    
}
