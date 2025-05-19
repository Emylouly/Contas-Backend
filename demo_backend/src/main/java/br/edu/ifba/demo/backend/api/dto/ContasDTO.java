package br.edu.ifba.demo.backend.api.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.demo.backend.api.model.ContasModel;
import lombok.Data;

@Data
public class ContasDTO {

    private long idcontas;
    private String descricao;
    private float valor;
    private LocalDate  datavencimento;
    private LocalDate datapagamento;
    private String tipoconta;
    private boolean statuscontas;
    private Long idusuario;
    private Long idcategoria;
    private String categoriadescricao;
    private String tipo;

    public static ContasDTO converter(ContasModel contasModel){
        var contas = new ContasDTO();
        contas.setIdcontas(contasModel.getIdcontas());
        contas.setDescricao(contasModel.getDescricao());
        contas.setValor(contasModel.getValor());
        contas.setDatapagamento(contasModel.getDatapagamento());
        contas.setDatavencimento(contasModel.getDatavencimento());
        contas.setTipoconta(contasModel.getTipoconta());
        contas.setStatuscontas(contasModel.isStatuscontas());
        contas.setIdusuario(contasModel.getIdusuario().getIdusuario());

        if(contasModel.getIdcategoria()!=null){
        contas.setIdcategoria(contasModel.getIdcategoria().getIdcategoria());
        contas.setCategoriadescricao(contasModel.getIdcategoria().getCategoriadescricao());
        contas.setTipo(contasModel.getIdcategoria().getTipo());
        }

        return contas;
    }

    public static List<ContasDTO> converter(List <ContasModel> contas){
        List<ContasDTO> list = new ArrayList<>();
        for(ContasModel model : contas){
            list.add(ContasDTO.converter(model));
        }
        return list;
    }

    public ContasDTO(){
        super();
    }

    public ContasDTO(long idcontas, String descricao, float valor, LocalDate  datavencimento, LocalDate  datapagamento, String tipoconta, boolean statuscontas, Long idusuario, 
    Long idcategoria, String categoriadescricao, String tipo){
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
        this.categoriadescricao = categoriadescricao;
        this.tipo = tipo;
    }
    
}
