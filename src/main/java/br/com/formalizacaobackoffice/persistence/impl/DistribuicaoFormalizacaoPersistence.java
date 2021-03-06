package br.com.formalizacaobackoffice.persistence.impl;

import br.com.formalizacaobackoffice.mapper.DistribuicaoFormalizacaoMapper;
import br.com.formalizacaobackoffice.mapper.TipoFormalizacaoMapper;
import br.com.formalizacaobackoffice.model.DistribuicaoFormalizacao;
import br.com.formalizacaobackoffice.model.TipoFormalizacao;
import br.com.formalizacaobackoffice.persistence.adapter.DistribuicaoFormalizacaoPersistenceAdapter;
import br.com.formalizacaobackoffice.persistence.entity.DistribuicaoFormalizacaoEntity;
import br.com.formalizacaobackoffice.persistence.entity.TipoFormalizacaoEntity;
import br.com.formalizacaobackoffice.persistence.repository.DistribuicaoFormalizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DistribuicaoFormalizacaoPersistence implements DistribuicaoFormalizacaoPersistenceAdapter {
    @Autowired
    private DistribuicaoFormalizacaoRepository distribuicaoFormalizacaoRepository;
    @Autowired
    private DistribuicaoFormalizacaoMapper distribuicaoFormalizacaoMapper;
    @Autowired
    private TipoFormalizacaoMapper tipoFormalizacaoMapper;

    @Override
    public List<DistribuicaoFormalizacao> buscarDistribuicaoFormalizacaoPorTipoFormalizacaoEPorcentagemMaiorQueZero(TipoFormalizacao tipoFormalizacao) {
        TipoFormalizacaoEntity tipoFormalizacaoEntity = tipoFormalizacaoMapper.converterParaEntity(tipoFormalizacao);
        List<DistribuicaoFormalizacaoEntity> distribuicaoFormalizacaoEntityLista =
                distribuicaoFormalizacaoRepository.findAllByTipoFormalizacaoEntityAndPorcentagemDeDistribuicaoGreaterThan(tipoFormalizacaoEntity, 0.0);
        return distribuicaoFormalizacaoMapper.converterParaModel(distribuicaoFormalizacaoEntityLista);
    }

    @Override
    public void salvarDistribuicao(DistribuicaoFormalizacao distribuicaoSelecionada) {
        DistribuicaoFormalizacaoEntity entity = distribuicaoFormalizacaoMapper.converterParaEntity(distribuicaoSelecionada);
        distribuicaoFormalizacaoRepository.save(entity);
    }

    @Override
    public List<DistribuicaoFormalizacao> buscarDistribuicaoFormalizacaoPorTipoFormalizacao(TipoFormalizacao tipoFormalizacao) {
        TipoFormalizacaoEntity tipoFormalizacaoEntity = tipoFormalizacaoMapper.converterParaEntity(tipoFormalizacao);
        List<DistribuicaoFormalizacaoEntity> distribuicaoFormalizacaoEntityLista = distribuicaoFormalizacaoRepository.buscarDistribuicaoPorTipoFormalizacao(tipoFormalizacaoEntity);
        return distribuicaoFormalizacaoMapper.converterParaModel(distribuicaoFormalizacaoEntityLista);
    }

    @Override
    public List<DistribuicaoFormalizacao> buscarDistribuicaoFormalizacaoPorListaDeTipoFormalizacao(List<TipoFormalizacao> tipoFormalizacaoLista) {
        List<TipoFormalizacaoEntity> tipoFormalizacaoEntityLista = tipoFormalizacaoMapper.converterParaEntity(tipoFormalizacaoLista);
        List<DistribuicaoFormalizacaoEntity> distribuicaoFormalizacaoEntityLista = distribuicaoFormalizacaoRepository.findAllByTipoFormalizacaoEntityIn(tipoFormalizacaoEntityLista);
        return distribuicaoFormalizacaoMapper.converterParaModel(distribuicaoFormalizacaoEntityLista);
    }

    @Override
    public void salvarListaDistribuicao(List<DistribuicaoFormalizacao> distribuicaoFormalizacaoLista) {
        List<DistribuicaoFormalizacaoEntity> distribuicaoFormalizacaoEntityLista = distribuicaoFormalizacaoMapper.converterParaEntity(distribuicaoFormalizacaoLista);
        distribuicaoFormalizacaoRepository.saveAll(distribuicaoFormalizacaoEntityLista);
    }
}
