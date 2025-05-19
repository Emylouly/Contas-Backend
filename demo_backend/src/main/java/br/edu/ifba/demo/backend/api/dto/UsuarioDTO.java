package br.edu.ifba.demo.backend.api.dto;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.demo.backend.api.model.UsuarioModel;
import lombok.Data;

@Data
public class UsuarioDTO {

    private long idusuario;
    private String nome;
    private String cpf;
    private String email;
    private String login;
    private String senha;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private String numero;
    private String cep;
    private String telefonenumero;
    private String tiponumero;

    public static UsuarioDTO converter(UsuarioModel usuarioModel) {
        var usuario = new UsuarioDTO();
        usuario.setIdusuario(usuarioModel.getIdusuario());
        usuario.setNome(usuarioModel.getNome());
        usuario.setCpf(usuarioModel.getCpf());
        usuario.setEmail(usuarioModel.getEmail());
        usuario.setLogin(usuarioModel.getLogin());
        usuario.setSenha(usuarioModel.getSenha());
    
        if (usuarioModel.getIdendereco() != null) {
            usuario.setEstado(usuarioModel.getIdendereco().getEstado());
            usuario.setCidade(usuarioModel.getIdendereco().getCidade());
            usuario.setBairro(usuarioModel.getIdendereco().getBairro());
            usuario.setRua(usuarioModel.getIdendereco().getRua());
            usuario.setNumero(usuarioModel.getIdendereco().getNumero());
            usuario.setCep(usuarioModel.getIdendereco().getCep());
        }
    
        if (usuarioModel.getIdtelefone() != null) {
            usuario.setTelefonenumero(usuarioModel.getIdtelefone().getTelefonenumero());
            usuario.setTiponumero(usuarioModel.getIdtelefone().getTiponumero());
        }
    
        return usuario;
    }
    

    public static List<UsuarioDTO> converter(List<UsuarioModel> usuarios) {
        List<UsuarioDTO> list = new ArrayList<>();
        for (UsuarioModel model : usuarios) {
            list.add(UsuarioDTO.converter(model));
        }
        return list;
    }

    public UsuarioDTO() {
        super();
    }

    public UsuarioDTO(long idusuario, String nome, String cpf, String email, String login, String senha, 
    String estado, String cidade, String bairro, String rua, String numero, String cep,
    String telefonenumero, String tiponumero) {
        super();
        this.idusuario = idusuario;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.telefonenumero = telefonenumero;
        this.tiponumero = tiponumero;

    }

}
