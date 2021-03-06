package br.com.formalizacaobackoffice.controller;

import br.com.formalizacaobackoffice.dto.DistribuirFormalizacaoDto;
import br.com.formalizacaobackoffice.dto.EfetivarFormalizacaoDto;
import br.com.formalizacaobackoffice.service.FormalizacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("formalizacao_backoffice")
public class FormalizacaoController {

    @Autowired
    private FormalizacaoService formalizacaoService;

    @PostMapping("/distribuicao")
    public ResponseEntity<?> criarEDistribuirFormalizacao(@RequestBody DistribuirFormalizacaoDto distribuirFormalizacaoDto) {
        formalizacaoService.criarEDistribuirFormalizacao(distribuirFormalizacaoDto);
        return ResponseEntity.ok(null);
    }

    @PostMapping("/efetivacao")
    public ResponseEntity<?> efetivarFormalizacao(@RequestBody EfetivarFormalizacaoDto efetivarFormalizacaoDto) {
        formalizacaoService.efetivarFormalizacao(efetivarFormalizacaoDto);
        return ResponseEntity.ok(null);
    }

    @PostMapping("/devolucao")
    public ResponseEntity<?> devolverFormalizacao(@RequestBody EfetivarFormalizacaoDto efetivarFormalizacaoDto) {
        formalizacaoService.devolverFormalizacao(efetivarFormalizacaoDto);
        return ResponseEntity.ok(null);
    }
}
