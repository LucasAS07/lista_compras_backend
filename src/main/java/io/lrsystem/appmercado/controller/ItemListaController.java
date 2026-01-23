package io.lrsystem.appmercado.controller;

import io.lrsystem.appmercado.model.ItemLista;
import io.lrsystem.appmercado.service.ItemListaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/itenslista")
public class ItemListaController {

    @Autowired
    private ItemListaService itemListaService;

    @PostMapping
    public ResponseEntity<ItemLista> inserir(@RequestBody ItemLista item) {
        ItemLista itemNovo = itemListaService.inserirItem(item);
        if (itemNovo != null) {
            return ResponseEntity.ok(itemNovo);
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping({"numSeq"})
    public ResponseEntity<ItemLista> alterar(@RequestBody ItemLista item, @PathVariable Long numSeq) {
        item.setSequencia(numSeq);
        ItemLista itemLista = itemListaService.alterarItem(item);

        if (itemLista != null) {
            return ResponseEntity.ok(itemLista);
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        itemListaService.removerItem(id);
        return ResponseEntity.noContent().build();
    }
}
