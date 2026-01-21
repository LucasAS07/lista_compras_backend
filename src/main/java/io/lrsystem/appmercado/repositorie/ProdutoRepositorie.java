package io.lrsystem.appmercado.repositorie;

import io.lrsystem.appmercado.model.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepositorie extends CrudRepository<Produto,Long> {
}
