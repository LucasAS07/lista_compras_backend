package io.lrsystem.appmercado.service;

import io.lrsystem.appmercado.model.ItemLista;
import io.lrsystem.appmercado.model.Lista;

import java.util.List;

public interface ListaService {

    public Lista criarLista(Lista nova);
    public void remover(Long id);
    public Lista fecharLista(Long id);
    public Lista buscarPeloId(Long id);
    public List<Lista> listarListas();

}
