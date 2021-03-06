package br.com.formalizacaobackoffice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
//TODO: Criar um CRUD para os novos fluxos, entoa quando chegar um novo fluxo é só cadastrar na base que o sistema aceitara esse nvoo fluxo facilmente
public class Formalizacao {
    private String codigoFormalizacao;
    private TipoFormalizacao tipoFormalizacao;
    private Pessoa pessoa;
    private DistribuicaoFormalizacao distribuicaoFormalizacao;
    private List<ObjetoAnaliseFormalizacao> objetoAnaliseFormalizacaoLista = new ArrayList<>();
    private String status;
    private LocalDateTime dataHoraFormalizacaoUltimaAtualizacaoDeStatus;

    public void criarFormalizacao(TipoFormalizacao tipoFormalizacao, Pessoa pessoa) {
        this.codigoFormalizacao = UUID.randomUUID().toString();
        this.tipoFormalizacao = tipoFormalizacao;
        this.pessoa = pessoa;
        this.status = "CRIADO";
        this.dataHoraFormalizacaoUltimaAtualizacaoDeStatus = LocalDateTime.now();
    }

    public void adicionarDistribuicao(DistribuicaoFormalizacao distribuicaoFormalizacao) {
        this.distribuicaoFormalizacao = distribuicaoFormalizacao;
    }

    public void adicionarObjetoAnaliseFormalizacao(ObjetoAnaliseFormalizacao objetoAnaliseFormalizacao) {
        if (!this.objetoAnaliseFormalizacaoLista.contains(objetoAnaliseFormalizacao)) {
            this.objetoAnaliseFormalizacaoLista.add(objetoAnaliseFormalizacao);
        }
    }

    public void alterarStatus(String status) {
        this.status = status;
        this.dataHoraFormalizacaoUltimaAtualizacaoDeStatus = LocalDateTime.now();
    }
}
