package io.lrsystem.appmercado.controller;

import io.lrsystem.appmercado.model.Lista;
import io.lrsystem.appmercado.service.ListaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/listas")
public class ListaController {

    @Autowired
    private ListaService listaService;

    @GetMapping
    public ResponseEntity<List<Lista>> listarTodas() {
        return ResponseEntity.ok().body(listaService.listarListas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lista> bucarLista(@PathVariable Long id) {
        Lista res = listaService.buscarPeloId(id);

        if (res != null) {
            ResponseEntity.ok().body(res);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Lista> criarNova(@RequestBody Lista lista) {
        Lista novaLista = listaService.criarLista(lista);

        if (novaLista != null) {
            return ResponseEntity.status(201).body(novaLista);
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        Lista listaExcluir = listaService.buscarPeloId(id);

        if (listaExcluir != null) {
            listaService.remover(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lista> alteraLista(@PathVariable Long id) {
        Lista res = listaService.fecharLista(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }
}
