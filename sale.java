package market;

public class sale {

	 private product produto;
	    private int quantidade;

	    public sale(product produto, int quantidade) {
	        this.produto = produto;
	        this.quantidade = quantidade;
	    }

	    public product getProduto() {
	        return produto;
	    }

	    public int getQuantidade() {
	        return quantidade;
	    }

	    public void incrementarQuantidade(int quantidade) {
	        this.quantidade += quantidade;
	    }
	    
	    public double calcularSubtotal() {
	        return produto.getPrecoUnitario() * quantidade;
	    }
	}


