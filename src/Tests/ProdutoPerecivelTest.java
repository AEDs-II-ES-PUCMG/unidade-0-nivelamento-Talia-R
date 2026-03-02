package Tests;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Produto;
import modelo.ProdutoPerecivel;

public class ProdutoPerecivelTest {
    

    Produto produto;
    
    @BeforeEach
    public void prepare(){
        produto = new ProdutoPerecivel("Perecível teste", 100, 0.1, LocalDate.now().plusDays(10));
    }
    
    @Test
    public void calculaPrecoSemDescontoCorretamente(){
        assertEquals(110.0, produto.valorVenda(), 0.01);
    }
    
    @Test
    public void calculaPrecoComDescontoCorretamente(){
        produto = new ProdutoPerecivel("Perecível teste", 100, 0.1, LocalDate.now().plusDays(2));
        assertEquals(110.0 * 0.75, produto.valorVenda(), 0.01);
    }
    
    @Test
    public void naoCriaProdutoForaDaValidade(){
        assertThrows(IllegalArgumentException.class, () -> new ProdutoPerecivel("teste", 5, 1, LocalDate.now().minusDays(2)));
    }
}


