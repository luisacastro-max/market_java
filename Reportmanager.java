package market;
import market.product;
import java.util.List;

public class Reportmanager {
	  public void gerarRelatorioVencimento(List<product> produtos, int dias) {
	        System.out.println("Produtos a vencer em até " + dias + " dias:");
	        for (product produto : produtos) {
	            if (produto instanceof FoodUtensils) {
	                FoodUtensils alimento = (FoodUtensils) produto;
	                if (alimento.getValidade() <= dias) {
	                    alimento.exibirDetalhes();
	                }
	            }
	        }

	
}
	  }
