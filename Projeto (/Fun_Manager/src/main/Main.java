package main;
import dao.FuncionarioDAO;
import model.Funcionario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        FuncionarioDAO dao = new FuncionarioDAO();
        Scanner sc = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\n1. Adicionar Funcionário\n2. Listar\n0. Sair");
            opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {
                System.out.print("Nome: ");
                String nome = sc.nextLine();
                System.out.print("Cargo: ");
                String cargo = sc.nextLine();
                System.out.print("Salário: ");
                double salario = sc.nextDouble();
                dao.adicionar(new Funcionario(nome, cargo, salario));
                System.out.println("Funcionário adicionado!");
            } else if (opcao == 2) {
                for (Funcionario f : dao.listar()) {
                    System.out.printf("ID: %d | Nome: %s | Cargo: %s | Salário: %.2f\n",
                            f.getId(), f.getNome(), f.getCargo(), f.getSalario());
                }
            }
        } while (opcao != 0);
        sc.close();
    }
}