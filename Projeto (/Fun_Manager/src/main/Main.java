package main;

import dao.FuncionarioDAO;
import model.Funcionario;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FuncionarioDAO dao = new FuncionarioDAO();

        // 1. Adicionando funcionários
        Funcionario f1 = new Funcionario(1, "Ana", "Gerente", 5000.00);
        Funcionario f2 = new Funcionario(2, "João", "Analista", 3500.00);

        dao.adicionarFuncionario(f1);
        dao.adicionarFuncionario(f2);

        // 2. Listando funcionários
        System.out.println("📋 Lista de funcionários:");
        listarTodos(dao);

        // 3. Buscando por ID
        System.out.println("\n🔎 Buscando funcionário com ID 1:");
        Funcionario buscado = dao.buscarPorId(1);
        if (buscado != null) {
            System.out.println(buscado);
        } else {
            System.out.println("Funcionário não encontrado.");
        }

        // 4. Atualizando funcionário
        Funcionario fAtualizado = new Funcionario(1, "Ana Maria", "Gerente", 5500.00);
        dao.atualizarFuncionario(fAtualizado);

        System.out.println("\n✏️ Após atualização:");
        listarTodos(dao);

        // 5. Removendo funcionário
        dao.removerFuncionario(2);
        System.out.println("\n❌ Após remoção:");
        listarTodos(dao);
    }

    private static void listarTodos(FuncionarioDAO dao) {
        List<Funcionario> lista = dao.listarFuncionarios();
        for (Funcionario f : lista) {
            System.out.println(f);
        }
    }
}
