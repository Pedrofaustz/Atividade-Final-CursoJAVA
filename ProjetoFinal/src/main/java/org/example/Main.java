package org.example;

import org.example.Class.Produtos;
import org.example.Funcionalidades.Funcoes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Produtos> produtos = new ArrayList<>();
        Funcoes funcoes = new Funcoes();

        int opcao;
        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar produto"); // Requisito Obrigatório
            System.out.println("2 - Listar produtos"); // Requisito Obrigatório
            System.out.println("3 - Atualizar produto");
            System.out.println("4 - Remover produto");
            System.out.println("5 - Calcular valor total do estoque"); // Requisito Obrigatório
            System.out.println("6 - Mostrar produtos com estoque baixo"); // Requisito Obrigatório
            System.out.println("7 - Salvar dados"); // Requisito Obrigatório
            System.out.println("8 - Ler dados"); // Requisito Obrigatório
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = sc.nextInt();

            sc.nextLine(); // limpar buffer

            if (opcao == 0 ) {
                System.out.println("Saindo...");
                break;
            }

            switch (opcao) {

                case 1:
                    funcoes.criarProduto(sc, produtos);
                    break;

                case 2:
                    funcoes.listarProdutos(produtos);
                    break;

                case 3:
                    funcoes.atualizarProdutos(sc, produtos);
                    break;

                case 4:
                    funcoes.removerProduto(sc, produtos);
                    break;

                case 5:
                    funcoes.calcularValorTotal(produtos);
                    break;

                case 6:
                    funcoes.estoqueBaixo(produtos);
                    break;

                case 7:
                    funcoes.salvarArquivo(produtos);
                    break;

                case 8:
                    funcoes.lerArquivo(produtos);
                    break;

                default:
                    System.out.println("Opcao invalida!");
            }
        }

    }
}