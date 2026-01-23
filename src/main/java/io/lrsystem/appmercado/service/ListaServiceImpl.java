package io.lrsystem.appmercado.service;

import io.lrsystem.appmercado.model.ItemLista;
import io.lrsystem.appmercado.model.Lista;
import io.lrsystem.appmercado.repositorie.ListaRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListaServiceImpl implements ListaService{

    @Autowired
    private ListaRepositorie listaRepositorie;

    @Override
    public Lista criarLista(Lista nova) {
        return listaRepositorie.save(nova);
    }

    @Override
    public void remover(Long id) {
        listaRepositorie.deleteById(id);
    }

    @Override
    public Lista fecharLista(Long id) {
        Lista l = listaRepositorie.findById(id).get();
        double total = 0.0;
        for (ItemLista item : l.getItens()) {
            total += (double)l.getValorTotal();
        }
        l.setValorTotal(total);
        l.setStatus(1); // LISTA CONCLUIDA
        return listaRepositorie.save(l);
    }

    @Override
    public Lista buscarPeloId(Long id) {
        return listaRepositorie.findById(id).orElse(null);
    }

    @Override
    public List<Lista> listarListas() {
        return (List<Lista>) listaRepositorie.findAll();
    }


}
