package modelo;

public class ItemDePedido {

    // Atributos encapsulados
    private Produto produto;
    private int quantidade;
    private double precoVenda;
    private final double precoBase;
	static double DESCONTO = 0.05;


    /**
     * Construtor da classe ItemDePedido.
     * O precoVenda deve ser capturado do produto no momento da criação do item,
     * garantindo que alterações futuras no preço do produto não afetem este pedido.
     */
    public ItemDePedido(Produto produto, int quantidade, double precoVenda) {
        if(produto == null) throw new IllegalArgumentException("Produto não deve ser nulo");
        this.produto = produto;

        this.quantidade = quantidade;

        this.precoVenda = precoBase = precoVenda;
        
    }

    public double calcularSubtotal() {
        return quantidade * precoVenda;
    }

    /**
     * Preço base do produto
     * @return
     */
    public double precoOriginal(){
        return precoBase;
    }

    public int getQuantidadeProduto(){
        return quantidade;
    }

    public int alterarQuantidade(int qntNova){
        return quantidade = qntNova;
    }

    public double menorPreco(){
        return precoVenda < precoBase ? precoVenda : precoBase;
    }

    public double getPrecoVenda(){
        return precoVenda;
    }

    public double setarPrecoVenda(double novoPreco){
        return novoPreco;
    }

    public double aplicarDesconto(){
        return precoVenda*DESCONTO;
    }



    // --- Sobrescrita do método equals ---

    /**
     * Compara a igualdade entre dois itens de pedido.
     * A regra de negócio define que dois itens são iguais se possuírem o mesmo Produto.
     */
    @Override
    public boolean equals(Object obj) {
        ItemDePedido outro = (ItemDePedido) obj;
        return this.produto.equals(outro.produto);
    }

    @Override
    public String toString(){
        //  Nome do Produto, Quantidade, Preço Unitário e o Subtotal do item
        return String.format("%s,%d, %.2f,%.2f", produto.descricao, quantidade, precoVenda, calcularSubtotal());
    }
}
