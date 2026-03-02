import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProdutoPerecivel extends Produto {
    private static final double DESCONTO = 0.25;
    private static final int PRAZO_DESCONTO = 7;
    private LocalDate dataDeValidade;

    protected ProdutoPerecivel(String desc, double precoCusto) {
        super(desc, precoCusto);
    }

    public ProdutoPerecivel(String desc, double precoCusto, double margemLucro, LocalDate validade) {
        super(desc, precoCusto);
        if(validade.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("Este produto não pode ser cadastrado com uma data de validade anterior ao dia atual");
        }
        dataDeValidade = validade;
        this.margemLucro = margemLucro;
    }

    /**
     * Verifica se o produto está fora da validade.
     * @return true se a data de validade for anterior a hoje.
     */
    private boolean foraValidade(){
        return dataDeValidade.isBefore(LocalDate.now());
    }

    private boolean temDesconto(){
        // se a data de validade é depois da data de HJ + 7 dias
        return !(dataDeValidade.isAfter(LocalDate.now().plusDays(PRAZO_DESCONTO)));
    }

    @Override
    public double valorVenda(){
        if(foraValidade())
            throw new IllegalArgumentException("Este produto não pode ser cadastrado com uma data de validade anterior ao dia atual");
        
        double preco = precoCusto * (1.0 + margemLucro);

        if(temDesconto()){
            double desc = preco * DESCONTO;
            preco -= desc;
        }

		return preco;
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        s.append(super.toString());
        s.append("\n Data de validade: " + dataDeValidade.format(formatador));
    
        return s.toString();
    }
    
}
