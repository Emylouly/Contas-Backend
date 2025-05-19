package br.edu.ifba.demo.backend.api.dto;


import br.edu.ifba.demo.backend.api.model.EnderecoModel;
import lombok.Data;


@Data
public class EnderecoDTO {
    private Long idendereco;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private String numero;
    private String cep;


    public static EnderecoDTO converter(EnderecoModel generoModel) {
        EnderecoDTO genero = new EnderecoDTO();
        genero.setIdendereco(generoModel.getIdendereco());
        genero.setEstado(generoModel.getEstado());
        genero.setCidade(generoModel.getCidade());
        genero.setBairro(generoModel.getBairro());
        genero.setRua(generoModel.getRua());
        genero.setNumero(generoModel.getNumero());
        genero.setCep(generoModel.getCep());
        return genero;
    }
}