package br.edu.ifba.demo.backend.api.dto;

import br.edu.ifba.demo.backend.api.model.CategoriaModel;
import lombok.Data;

@Data
public class CategoriaDTO {
    private Long idcategoria;
    private String categoriadescricao;
    private String tipo;

    public static CategoriaDTO converter(CategoriaModel categoriaModel){
        CategoriaDTO categoria = new CategoriaDTO();
        categoria.setIdcategoria(categoriaModel.getIdcategoria());
        categoria.setCategoriadescricao(categoriaModel.getCategoriadescricao());
        categoria.setTipo(categoriaModel.getTipo());
        return categoria;
    }
}
