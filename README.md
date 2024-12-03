<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
    <header>
        <h1>Documentação do Sistema de Gerenciamento de Mercado Familiar</h1>
    </header>
    <main>
        <section class="section">
            <h2>Visão Geral</h2>
            <p>O projeto consiste em um sistema de gerenciamento para um mercado familiar, desenvolvido em Java. Ele permite operações como gerenciamento de vendas, controle de estoque, registro de produtos e geração de relatórios. A aplicação segue uma abordagem modularizada e orientada a objetos.</p>
        </section>
        <section class="section">
            <h2>Estrutura do Projeto</h2>
            <p>O sistema é composto por várias classes organizadas em dois pacotes: <code>market</code> e <code>service</code>.</p>
            <h3>Pacote market</h3>
            <ul>
                <li><strong>App (Classe Principal)</strong><br>
                    Gerencia o ciclo de vida do sistema e oferece um menu interativo para o usuário.
                    <ul>
                        <li>Registrar vendas.</li>
                        <li>Listar produtos.</li>
                        <li>Alterar preços de produtos.</li>
                        <li>Registrar novos produtos.</li>
                        <li>Gerar relatórios.</li>
                        <li>Abrir e fechar o caixa.</li>
                    </ul>
                </li>
                <li><strong>Cashier (Caixa)</strong><br>
                    Gerencia as operações financeiras do caixa.
                    <ul>
                        <li><code>initialAmount</code>: Valor inicial no caixa.</li>
                        <li><code>currentAmount</code>: Valor atual no caixa.</li>
                        <li><code>totalSales</code>: Total de vendas realizadas.</li>
                        <li><code>openCashRegister(double initialAmount)</code>: Inicializa o caixa.</li>
                        <li><code>recordSale(double saleAmount)</code>: Registra uma venda no caixa.</li>
                        <li><code>closeCashRegister()</code>: Exibe o resumo financeiro ao encerrar o caixa.</li>
                    </ul>
                </li>
                <li><strong>Product (Abstrata)</strong><br>
                    Classe base para representar produtos.
                    <ul>
                        <li><code>code</code>: Código do produto.</li>
                        <li><code>name</code>: Nome do produto.</li>
                        <li><code>unitPrice</code>: Preço unitário.</li>
                        <li><code>stockQuantity</code>: Quantidade em estoque.</li>
                        <li><code>displayDetails()</code>: Exibe os detalhes específicos do produto.</li>
                    </ul>
                </li>
                <li><strong>FoodUtensils (Utensílios Alimentícios)</strong><br>
                    Representa produtos perecíveis com prazo de validade.
                    <ul>
                        <li><code>validity</code>: Validade em dias.</li>
                    </ul>
                </li>
                <li><strong>Electric (Eletrônicos)</strong><br>
                    Representa produtos eletrônicos com garantia.
                    <ul>
                        <li><code>warrantyMonths</code>: Garantia em meses.</li>
                    </ul>
                </li>
                <li><strong>Sell (Venda)</strong><br>
                    Gerencia os itens adicionados à venda.
                    <ul>
                        <li><code>saleItems</code>: Lista de itens na venda.</li>
                        <li><code>subtotal</code>: Total parcial da venda.</li>
                        <li><code>addProduct(product, int)</code>: Adiciona um produto à venda.</li>
                        <li><code>completeSale()</code>: Finaliza a venda e atualiza o estoque.</li>
                    </ul>
                </li>
                <li><strong>Sale (Item da Venda)</strong><br>
                    Representa um item específico em uma venda.
                    <ul>
                        <li><code>product</code>: Produto associado ao item.</li>
                        <li><code>quantity</code>: Quantidade vendida.</li>
                    </ul>
                </li>
            </ul>
            <h3>Pacote service</h3>
            <ul>
                <li><strong>ReportManager (Gerenciador de Relatórios)</strong><br>
                    Gera relatórios específicos com base no estado atual dos produtos.
                    <ul>
                        <li><code>generateExpirationReport(List<Product>, int)</code>: Relatório de produtos perecíveis prestes a expirar.</li>
                        <li><code>generateLowStockReport(List<Product>, int)</code>: Relatório de produtos com baixo estoque.</li>
                    </ul>
                </li>
            </ul>
        </section>
        <section class="section">
            <h2>Funcionalidades do Sistema</h2>
            <ul>
                <li><strong>Gerenciamento de Produtos</strong>
                    <ul>
                        <li>Registro de novos produtos.</li>
                        <li>Alteração de preços.</li>
                        <li>Listagem de produtos com informações detalhadas.</li>
                    </ul>
                </li>
                <li><strong>Gerenciamento de Vendas</strong>
                    <ul>
                        <li>Registro de vendas com suporte a múltiplos itens.</li>
                        <li>Atualização automática do estoque ao finalizar uma venda.</li>
                        <li>Cálculo de subtotal durante a venda.</li>
                    </ul>
                </li>
                <li><strong>Relatórios</strong>
                    <ul>
                        <li>Produtos próximos ao vencimento.</li>
                        <li>Produtos com estoque abaixo de um limite especificado.</li>
                    </ul>
                </li>
                <li><strong>Caixa</strong>
                    <ul>
                        <li>Abertura de caixa com valor inicial.</li>
                        <li>Registro do total de vendas.</li>
                        <li>Fechamento de caixa com resumo financeiro.</li>
                    </ul>
                </li>
            </ul>
        </section>
        <section class="section">
            <h2>Exemplo de Uso</h2>
            <h3>Registro de Produto</h3>
            <ol>
                <li>Escolher a opção Registrar Produto.</li>
                <li>Informar o código, nome, preço, quantidade e tipo do produto.</li>
                <li>Adicionar informações adicionais (validade ou garantia).</li>
            </ol>
            <h3>Registro de Venda</h3>
            <ol>
                <li>Escolher a opção Registrar Venda.</li>
                <li>Selecionar produtos pelo código e especificar a quantidade.</li>
                <li>Finalizar a venda, calculando o total e reduzindo o estoque.</li>
            </ol>
        </section>
        <section class="section">
            <h2>Melhorias Futuras</h2>
