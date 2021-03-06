package br.com.formalizacaobackoffice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
//Alterar o noem para detalhe objeto analise formalizacao
public class ObjetoAnaliseFormalizacao {
    private long codigoObjetoAnaliseFormalizacao;
    private String codigoFormalizacao;
    private ObjetoAnalise objetoAnalise;
    private String statusAnalise;
    private List<MotivoDevolucaoFormalizacao> motivoDevolucaoFormalizacaoLista;
    private String codigoImagem;

    public ObjetoAnaliseFormalizacao(String codigoFormalizacao, ObjetoAnalise objetoAnalise, String codigoImagem) {
        this.codigoFormalizacao = codigoFormalizacao;
        this.objetoAnalise = objetoAnalise;
        this.statusAnalise = "CRIADO";
        this.codigoImagem = codigoImagem;
    }

    public ObjetoAnaliseFormalizacao(long codigoObjetoAnaliseFormalizacao, String codigoFormalizacao, ObjetoAnalise objetoAnalise, String statusAnalise, String codigoImagem) {
        this.codigoObjetoAnaliseFormalizacao = codigoObjetoAnaliseFormalizacao;
        this.codigoFormalizacao = codigoFormalizacao;
        this.objetoAnalise = objetoAnalise;
        this.statusAnalise = statusAnalise;
        this.codigoImagem = codigoImagem;
    }

    public void alterarStatus(String statusAnalise) {
        this.statusAnalise = statusAnalise;
    }

    public void adicionarMotivoDevolucaoFormalizacao(MotivoDevolucaoFormalizacao motivoDevolucaoFormalizacao) {
        if (this.motivoDevolucaoFormalizacaoLista == null) {
            this.motivoDevolucaoFormalizacaoLista = new ArrayList<>();
            this.motivoDevolucaoFormalizacaoLista.add(motivoDevolucaoFormalizacao);
            return;
        }
        this.motivoDevolucaoFormalizacaoLista.add(motivoDevolucaoFormalizacao);
    }
}
