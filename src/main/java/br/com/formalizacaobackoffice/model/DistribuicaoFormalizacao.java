package br.com.formalizacaobackoffice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DistribuicaoFormalizacao {
    private long codigoDistribuicaoFormalizacao;
    private TipoFormalizacao tipoFormalizacao;
    private Formalizador formalizador;
    private double porcentagemDeDistribuicao;
    private long contadorDeDistribuicao;

    public void incrementarNoContadorDeDistribuicao() {
        this.contadorDeDistribuicao++;
    }
}
