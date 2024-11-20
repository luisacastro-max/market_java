package market;

public class FoodUtensils extends product {
	private int Validade;
	
	public FoodUtensils(String codigo, String nome, double precoUnitario, int quantidadeEstoque, int Validade) {
        super(codigo, nome, precoUnitario, quantidadeEstoque);
        this.Validade = Validade;
    }
	
	
 
    public int getValidade() {
		return Validade;
	}





	@Override
    public void exibirDetalhes() {
        System.out.println("Código: " + getCodigo() + ", Nome: " + getNome() + 
                           ", Preço: R$" + getPrecoUnitario() + 
                           ", Estoque: " + getQuantidadeEstoque() + 
                           ", Validade: " + Validade + " dias");
    }
}



