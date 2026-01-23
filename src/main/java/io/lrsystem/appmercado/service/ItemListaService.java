package io.lrsystem.appmercado.service;

import io.lrsystem.appmercado.model.ItemLista;

public interface ItemListaService {
    public ItemLista inserirItem(ItemLista novo);
    public ItemLista alterarItem(ItemLista item);
    public void removerItem(Long id);
}
