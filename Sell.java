package market;
import java.util.ArrayList;
import java.util.List;

public class Sell {
	 private List<sale> itensVenda = new ArrayList<>();
	 private double subtotal;
	 public void adicionarProduto(product produto, int quantidade) {
	        boolean produtoJaAdicionado = false;

	      
	        for (sale item : itensVenda) {
	            if (item.getProduto().equals(produto)) {
	                item.incrementarQuantidade(quantidade);
	                produtoJaAdicionado = true;
	                break;
	            }
	        }
	        if (!produtoJaAdicionado) {
	            itensVenda.add(new sale(produto, quantidade));
	        }

	        subtotal += produto.getPrecoUnitario() * quantidade;
	    }
	 
	 public void removerProduto(product produto) {
	        sale itemParaRemover = null;

	     
	        for (sale item : itensVenda) {
	            if (item.getProduto().equals(produto)) {
	                itemParaRemover = item;
	                subtotal -= item.calcularSubtotal();
	                break;
	            }
	        }

	   
	        if (itemParaRemover != null) {
	            itensVenda.remove(itemParaRemover);
	        }
	    }
	 
	 public double calcularSubtotal() {
	        return subtotal;
	    }

	    public void finalizarVenda() {
	        for (sale item : itensVenda) {
	            product produto = item.getProduto();
	            int quantidadeVendida = item.getQuantidade();
	            produto.atualizarEstoque(-quantidadeVendida);
	        }

	        System.out.println("Venda Finalizada. Total: R$" + subtotal);
	    }
	    
	    
	    public void exibirItensVenda() {
	        System.out.println("Itens na venda:");
	        for (sale item : itensVenda) {
	            product produto = item.getProduto();
	            System.out.println("- " + produto.getNome() + " (Qtd: " + item.getQuantidade() + 
	                               ", Subtotal: R$" + item.calcularSubtotal() + ")");
	        }
	    }

}
	 
	 
