package dao;

import model.Funcionario;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    // CREATE
    public void adicionar(Funcionario f) throws SQLException {
        String sql = "INSERT INTO funcionarios (nome, cargo, salario) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getCargo());
            stmt.setDouble(3, f.getSalario());

            stmt.executeUpdate();
        }
    }

    // READ
    public List<Funcionario> listar() throws SQLException {
        List<Funcionario> lista = new ArrayList<>();
        String sql = "SELECT * FROM funcionarios";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Funcionario f = new Funcionario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cargo"),
                        rs.getDouble("salario")
                );
                lista.add(f);
            }
        }

        return lista;
    }

    // UPDATE
    public void atualizar(Funcionario f) throws SQLException {
        String sql = "UPDATE funcionarios SET nome = ?, cargo = ?, salario = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getCargo());
            stmt.setDouble(3, f.getSalario());
            stmt.setInt(4, f.getId());

            stmt.executeUpdate();
        }
    }

    // DELETE
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM funcionarios WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    // BUSCAR POR ID (opcional, útil no atualizar)
    public Funcionario buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM funcionarios WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Funcionario(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("cargo"),
                            rs.getDouble("salario")
                    );
                } else {
                    return null;
                }
            }
        }
    }
}