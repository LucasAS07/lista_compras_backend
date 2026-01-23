package io.lrsystem.appmercado.service;

import io.lrsystem.appmercado.model.ItemLista;
import io.lrsystem.appmercado.repositorie.ItemListaRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemListaServiceImpl implements ItemListaService{

    @Autowired
    private ItemListaRepositorie repositorie;

    @Override
    public ItemLista inserirItem(ItemLista novo) {
        return repositorie.save(novo);
    }

    @Override
    public ItemLista alterarItem(ItemLista item) {
        return repositorie.save(item);
    }

    @Override
    public void removerItem(Long id) {
        repositorie.deleteById(id);
    }
}
