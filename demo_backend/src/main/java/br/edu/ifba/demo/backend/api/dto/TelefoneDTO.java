package br.edu.ifba.demo.backend.api.dto;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.demo.backend.api.model.TelefoneModel;
import lombok.Data;

@Data
public class TelefoneDTO {

    private long idtelefone;
    private String telefonenumero;
    private String tiponumero;

    public static TelefoneDTO converter(TelefoneModel telefoneModel){
        var telefone = new TelefoneDTO();
        telefone.setIdtelefone(telefoneModel.getIdtelefone());
        telefone.setTelefonenumero(telefoneModel.getTelefonenumero());
        telefone.setTiponumero(telefoneModel.getTiponumero());
        return telefone;
    }

    public static List<TelefoneDTO> converter(List<TelefoneModel> telefone){
        List<TelefoneDTO> list = new ArrayList<>();
        for(TelefoneModel model : telefone){
            list.add(TelefoneDTO.converter(model));
        }

        return list;
    }

    public TelefoneDTO(){
        super();
    }

    public TelefoneDTO(long idtelefone, String telefonenumero, String tiponumero) {
        super();
        this.idtelefone = idtelefone;
        this.telefonenumero = telefonenumero;
        this.tiponumero = tiponumero;
    }
}
