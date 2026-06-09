package org.example.Funcionalidades;

import org.example.Class.Produtos;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Funcoes {

    public void criarProduto(Scanner sc, ArrayList<Produtos> produtos) {

        System.out.println("Digite o nome do produto: ");
        String nome = sc.nextLine();

        System.out.println("Digite o valor do produto: ");
        double valor = sc.nextDouble();

        System.out.println("Digite a quantidade do produto: ");
        int quantidade = sc.nextInt();
        sc.nextLine(); // limpar buffer

        if (quantidade < 0 || valor < 0) {
            System.out.println("ERRO: valores invalidos!");
            return;
        }

        Produtos newProduto = new Produtos();
        newProduto.setnome(nome);
        newProduto.setquantidade(quantidade);
        newProduto.setPreco(valor);

        produtos.add(newProduto);

        System.out.println("Produto criado com sucesso!");
    }

    public void listarProdutos(ArrayList<Produtos> produtos) {

        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        for (Produtos p : produtos) {
            System.out.println("----------------------");
            System.out.println("Nome: " + p.getnome());
            System.out.println("Quantidade: " + p.getquantidade());
            System.out.println("Preço: " + p.getPreco());
        }
    }

    public void atualizarProdutos(Scanner sc, ArrayList<Produtos> produtos) {

        System.out.println("Digite o nome do produto que deseja atualizar: ");
        String nome = sc.nextLine();

        boolean encontrou = false;

        for (Produtos p : produtos) {
            if (p.getnome().equalsIgnoreCase(nome)) {

                System.out.println("Novo nome: ");
                p.setnome(sc.nextLine());

                System.out.println("Novo valor: ");
                p.setPreco(sc.nextDouble());

                System.out.println("Nova quantidade: ");
                p.setquantidade(sc.nextInt());
                sc.nextLine();

                System.out.println("Produto atualizado!");
                encontrou = true;
                break;
            }
        }

        if (!encontrou) {
            System.out.println("Produto nao encontrado!");
        }
    }

    public void removerProduto(Scanner sc, ArrayList<Produtos> produtos) {

        System.out.println("Digite o nome do produto que deseja remover: ");
        String nome = sc.nextLine();

        boolean encontrou = false;

        for (int i = 0; i < produtos.size(); i++) {

            if (produtos.get(i).getnome().equalsIgnoreCase(nome)) {

                produtos.remove(i);
                System.out.println("Produto removido!");
                encontrou = true;
                break;
            }
        }

        if (encontrou == false) {
            System.out.println("ERRO: Produto nao encontrado!");
        }
    }

    public void calcularValorTotal(ArrayList<Produtos> produtos) {

        double total = 0;

        for (Produtos p : produtos) {
            total += p.getquantidade() * p.getPreco();
        }

        System.out.println("Valor total do estoque: R$ " + total);
    }

    public void estoqueBaixo(ArrayList<Produtos> produtos) {

        boolean encontrou = false;

        for (Produtos p : produtos) {
            if (p.getquantidade() < 5) {
                System.out.println("Produto com estoque baixo: " + p.getnome());
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum produto com estoque baixo.");
        }
    }

    public void salvarArquivo(ArrayList<Produtos> produtos) throws IOException {
        FileWriter writer = new FileWriter("produtos.txt");

            for (Produtos p : produtos) {
                writer.write(
                        p.getnome() + "," +
                                p.getquantidade() + "," +
                                p.getPreco() +
                                "\n"
                );
            }

            writer.close();
            System.out.println("Dados salvos!");


    }

    public void lerArquivo(ArrayList<Produtos> produtos) throws FileNotFoundException {
        File arquivo = new File("produtos.txt");
            Scanner leitor = new Scanner(arquivo);

            produtos.clear(); // limpa antes de carregar

            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] partes = linha.split(",");

                Produtos p = new Produtos();
                p.setnome(partes[0]);
                p.setquantidade(Integer.parseInt(partes[1]));
                p.setPreco(Double.parseDouble(partes[2]));

                produtos.add(p);
            }

            leitor.close();
            System.out.println("Dados carregados!");
    }
}