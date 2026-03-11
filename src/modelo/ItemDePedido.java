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

    //#region getters
        public int getQuantidadeProduto(){
            return quantidade;
        }

        public double getPrecoVenda(){
        return precoVenda;
        }

        public double getPrecoBase(){
            return precoBase;
        }
    //#endregion

    //#region setters
        /**
         * Altera o preço de venda do item.
         * @param novoPreco novo preço do item.
         * @return novo preço do item.
         */
        public double setPrecoVenda(double novoPreco){
            return novoPreco;
        }

        /**
         * Altera a quantidade de produto atual.
         * @param qntNova nova quantidade do item
         * @return nova quantidade do item
         */
        public int setQuantidade(int qntNova){
            return quantidade = qntNova;
        }

    //#endregion

    /**
     * Calcula o subtotal do item de acordo com a quantidade do item vendido.
     * @return double com o valor do item a depender da sua quantidade.
     */
    public double calcularSubtotal() {
        return quantidade * precoVenda;
    }


    /**
     * Encontra o menor preço do item entre seu preço base e o preço de venda.
     * @return double contendo o menor valor do produto.
     */
    public double menorPreco(){
        return precoVenda < precoBase ? precoVenda : precoBase;
    }

    /**
     * Aplica um desconto no subtotal do produto.
     * @return double contendo o valor do desconto.
     */
    public double aplicarDesconto(){
        return calcularSubtotal()*DESCONTO;
    }

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
