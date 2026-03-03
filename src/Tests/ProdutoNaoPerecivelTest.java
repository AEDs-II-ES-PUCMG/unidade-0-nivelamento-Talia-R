import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Produto;
import modelo.ProdutoNaoPerecivel;

public class ProdutoNaoPerecivelTest {

    Produto produto;
        
    
    @BeforeEach
    public void prepare(){
        produto = new ProdutoNaoPerecivel("Produto teste", 100, 0.1);
    }
    
    @Test
    public void calculaPrecoCorretamente(){
        assertEquals(110.0, produto.valorVenda(), 0.01);
    }

    @Test
    public void stringComDescricaoEValor(){
        String desc = produto.toString();
        assertTrue(desc.contains("Produto teste") && desc.contains("R$ 110,00"));
    }

    @Test
    public void naoCriaProdutoComPrecoNegativo(){
        assertThrows(IllegalArgumentException.class, () -> new ProdutoNaoPerecivel("teste", -5, 0.5));
    }
    
    @Test
    public void naoCriaProdutoComMargemNegativa(){
        assertThrows(IllegalArgumentException.class, () -> new ProdutoNaoPerecivel("teste", 5, -1));
    }

    @Test
    public void criarCorretamenteAPartirDeTexto(){
        String linhaDados = "1;Produto do arquivo;10.0;0.1";
        produto = Produto.criarDoTexto(linhaDados);
        String desc = produto.toString();
        assertTrue(desc.contains("Produto do arquivo") && desc.contains("R$ 11,00"));
    }

    @Test
    public void criaDadosEmTextoCorretamente(){
        assertEquals("1;Produto teste;100.00;0.10", produto.gerarDadosTexto());
        
    }
}
