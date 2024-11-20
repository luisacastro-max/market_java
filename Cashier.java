package market;

public class Cashier {

	private double valorInicial;
    private double valorAtual;
    private double totalVendas;
    
    public void abrirCaixa(double valorInicial) {
        this.valorInicial = valorInicial;
        this.valorAtual = valorInicial;
        this.totalVendas = 0;
    }
    public void registrarVenda(double valorVenda) {
        this.valorAtual += valorVenda;
        this.totalVendas += valorVenda;
    }

    public void fecharCaixa() {
        System.out.println("Valor Inicial: R$" + valorInicial);
        System.out.println("Total de Vendas: R$" + totalVendas);
        System.out.println("Valor Final em Caixa: R$" + valorAtual);
    }
}


