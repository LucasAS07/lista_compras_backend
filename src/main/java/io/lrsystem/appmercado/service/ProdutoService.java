package io.lrsystem.appmercado.service;

import io.lrsystem.appmercado.model.Produto;

import java.util.List;

public interface ProdutoService {

    public Produto criarNovoProduto(Produto produto);
    public Produto alterarProduto(Produto produto);
    public List<Produto> listarTodos();
    public List<Produto> buscarPorPalavraChave(String key);
    public Produto buscarPorId(Long id);

}
