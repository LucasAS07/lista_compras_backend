package io.lrsystem.appmercado.service;

import io.lrsystem.appmercado.model.Produto;
import io.lrsystem.appmercado.repositorie.ProdutoRepositorie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.Optional;

@SpringBootTest
@ActiveProfiles("test")
public class ProdutoTeste {

    @InjectMocks
    private ProdutoServiceImpl produtoService;

    @Mock
    private ProdutoRepositorie produtoRepositorie;

    private Long existingId = 1L;
    private Long nonExistingId = 100L;
    private String keyword = "bolacha";
    private Produto newProduct;
    private Produto createdProduct;
    private ArrayList<Produto> listaVariosProdutos;

    @BeforeEach
    public void setup() throws Exception {
        newProduct = new Produto();
        newProduct.setNome("bolacha");

        createdProduct = new Produto();
        createdProduct.setId(1L);
        createdProduct.setNome("bolacha");

        listaVariosProdutos = new ArrayList<Produto>();
        Produto p1, p2;
        p1 = new Produto();
        p1.setId(1L);
        p1.setNome("bolacha recheada");
        p2 = new Produto();
        p2.setId(3L);
        p2.setNome("bolacha agua e sal");
        listaVariosProdutos.add(p1);
        listaVariosProdutos.add(p2);


        Mockito.when(produtoRepositorie.save(newProduct)).thenReturn(createdProduct);
        Mockito.when(produtoRepositorie.findById(existingId)).thenReturn(Optional.of(new Produto()));
        Mockito.when(produtoRepositorie.findById(nonExistingId)).thenReturn(Optional.ofNullable(null));
        Mockito.when(produtoRepositorie.findAllByNomeContaining("biscoito"))
                .thenReturn(new ArrayList<Produto>());
        Mockito.when(produtoRepositorie.findAllByNomeContaining(keyword)).thenReturn(listaVariosProdutos);
    }

   @Test
    public void deveriaCadastrarProduto() {
       Assertions.assertNotNull(produtoService.criarNovoProduto(newProduct));
   }

   @Test
    public void deveriaRetornarPeloId() {
       Assertions.assertNotNull(produtoService.buscarPorId(existingId));
   }

   @Test
    public void deveriaNaoEncontrarId() {
       Assertions.assertNull(produtoService.buscarPorId(nonExistingId));
   }

   @Test
    public void deveriaRetornarListaComPalavraChave() {
        Assertions.assertTrue(produtoService.buscarPorPalavraChave(keyword).size() > 0);
   }

   @Test
    public void deceriaRetornarListaVazia() {
        Assertions.assertTrue(produtoService.buscarPorPalavraChave("biscoito").size() == 0);
   }

}
