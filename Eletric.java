package market;

public class Eletric extends product {
	private int garantiaMeses;

    public Eletric(String codigo, String nome, double precoUnitario, int quantidadeEstoque, int garantiaMeses) {
        super(codigo, nome, precoUnitario, quantidadeEstoque);
        this.garantiaMeses = garantiaMeses;
    }

    public int getGarantiaMeses() {
        return garantiaMeses;
    }
    
    @Override
    public void exibirDetalhes() {
        System.out.println("Código: " + getCodigo() + ", Nome: " + getNome() + 
                           ", Preço: R$" + getPrecoUnitario() + 
                           ", Estoque: " + getQuantidadeEstoque() + 
                           ", Garantia: " + garantiaMeses + " meses");
    }
}
