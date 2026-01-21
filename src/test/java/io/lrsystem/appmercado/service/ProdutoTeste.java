package io.lrsystem.appmercado.service;

import io.lrsystem.appmercado.model.Produto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
public class ProdutoTeste {

    @Autowired
    private static ProdutoService service;

    private static Long idFound = 1L;
    private static Long idNotFound = 100L;
    private static Produto newProduct;
    private static Produto createdProduct;

    @BeforeAll
    public static void setup(){
        System.out.println("Configurando parametros de testes");
        newProduct = new Produto();
        newProduct.setNome("Feijão");

        createdProduct = new Produto();
        createdProduct.setNome("Arroz");
        createdProduct.setId(1L);

//        service = Mockito.mock(ProdutoServiceImpl.class);
//        Mockito.when(service.criarNovoProduto(newProduct)).thenReturn(new Produto());
//        Mockito.when(service.buscarPorId(idFound)).thenReturn(createdProduct);
//        Mockito.when(service.buscarPorId(idNotFound)).thenReturn(null);
//        Mockito.when(service.buscarPorPalavraChave("a")).thenReturn(new ArrayList<Produto>());
//        Mockito.when(service.listarTodos()).thenReturn(new ArrayList<Produto>());
//        Mockito.when(service.alterarProduto(createdProduct)).thenReturn(createdProduct);

    }

    @Test
    public void shouldStoreAProduct() {
        assertNotNull(service.criarNovoProduto(newProduct));
    }

}
