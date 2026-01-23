package io.lrsystem.appmercado.repositorie;

import io.lrsystem.appmercado.model.Produto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProdutoRepositorie extends CrudRepository<Produto,Long> {

    public List<Produto> findAllByNomeContaining(String palavraChave);

}
