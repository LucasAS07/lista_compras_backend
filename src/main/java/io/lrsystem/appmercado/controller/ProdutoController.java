package io.lrsystem.appmercado.controller;

import io.lrsystem.appmercado.model.Produto;
import io.lrsystem.appmercado.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> listar() {
        List<Produto> produtos = produtoService.listarTodos();
        return ResponseEntity.ok().body(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscar(@PathVariable Long id) {
        Produto produto = produtoService.buscarPorId(id);
        return ResponseEntity.ok().body(produto);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Produto>> buscarPorPalavraChave(@RequestParam(name = "K") String keyword) {
        return ResponseEntity.ok(produtoService.buscarPorPalavraChave(keyword));
    }

    @PostMapping
    public ResponseEntity<Produto> salvar(@RequestBody Produto produto) {
        Produto prod = produtoService.criarNovoProduto(produto);

        if (prod != null) {
            return ResponseEntity.status(201).body(prod);
        }
        return ResponseEntity.badRequest().build();
    }

}
