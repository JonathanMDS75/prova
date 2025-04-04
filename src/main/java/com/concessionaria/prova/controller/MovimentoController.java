package com.concessionaria.prova.controller;

import com.concessionaria.prova.dtos.MovimentoDTO;
import com.concessionaria.prova.service.MovimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/movimentos")
public class MovimentoController {

    @Autowired
    private MovimentoService movimentoService;
    @GetMapping
    public ResponseEntity<List<MovimentoDTO>> listarMovimentos() {
        return ResponseEntity.ok(movimentoService.listarTodos());
    }
    @PostMapping
    public ResponseEntity<MovimentoDTO> criarMovimento(@RequestBody MovimentoDTO movimentoDTO) {
        return new ResponseEntity<>(movimentoService.salvar(movimentoDTO), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<MovimentoDTO> atualizarMovimento(@PathVariable Long id, @RequestBody MovimentoDTO movimentoDTO) {
        MovimentoDTO updatedMovimento = movimentoService.atualizar(id, movimentoDTO);
        if (updatedMovimento != null) {
            return ResponseEntity.ok(updatedMovimento);
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirMovimento(@PathVariable Long id) {
        if (movimentoService.excluir(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();

    }
}