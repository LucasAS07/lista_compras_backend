package io.lrsystem.appmercado.service;

import io.lrsystem.appmercado.model.Produto;
import io.lrsystem.appmercado.repositorie.ProdutoRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoServiceImpl implements ProdutoService{

    @Autowired
    private ProdutoRepositorie produtoRepositorie;

    @Override
    public Produto criarNovoProduto(Produto produto) {
        return produtoRepositorie.save(produto);
    }

    @Override
    public Produto alterarProduto(Produto produto) {
        return null;
    }

    @Override
    public List<Produto> listarTodos() {
        return List.of();
    }

    @Override
    public List<Produto> buscarPorPalavraChave(String key) {
        return List.of();
    }

    @Override
    public Produto buscarPorId(Long id) {
        return null;
    }


}
