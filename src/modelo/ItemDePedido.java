package modelo;

public class ItemDePedido {

    // Atributos encapsulados
    private Produto produto;
    private int quantidade;
    private double precoVenda;
    private final double precoBase;

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
        return 0;
    }

    // --- Sobrescrita do método equals ---

    /**
     * Compara a igualdade entre dois itens de pedido.
     * A regra de negócio define que dois itens são iguais se possuírem o mesmo Produto.
     */
    @Override
    public boolean equals(Object obj) {

        return false;
    }
}
