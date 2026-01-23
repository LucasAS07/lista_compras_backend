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
        if(produto.getNome() == null || produto.getNome().length() == 0) {
            return null;
        }
        return produtoRepositorie.save(produto);
    }

    @Override
    public List<Produto> listarTodos() {
        return (List<Produto>)produtoRepositorie.findAll() ;
    }

    @Override
    public List<Produto> buscarPorPalavraChave(String key) {
        return produtoRepositorie.findAllByNomeContaining(key);
    }

    @Override
    public Produto buscarPorId(Long id) {
        return produtoRepositorie.findById(id).orElse(null);
    }


}
