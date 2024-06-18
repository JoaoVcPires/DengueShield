package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.BD;
import model.Agente;

public class AgenteDAO {
  private Connection connection;
  private PreparedStatement preparedStatement;

  public AgenteDAO() {
    connection = BD.getConnection();
  }

  public void buscarAgentes() {
    String sql = "SELECT * FROM agente";

    try {
      preparedStatement = connection.prepareStatement(sql);
      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        int id = resultSet.getInt("idAgente");
        String usuario = resultSet.getString("nomeUsuario");
        String nome = resultSet.getString("nomePessoa");
        String senha = resultSet.getString("senha");
        String CPF = resultSet.getString("CPF");

        System.out.println("id: " + id);
        System.out.println("usuario: " + usuario);
        System.out.println("nome: " + nome);
        System.out.println("senha: " + senha);
        System.out.println("CPF: " + CPF);
      }

      preparedStatement.close();

    } catch (SQLException e) {
      System.out.println("Error query select agente: " + e.getMessage());
    }
  }

  public Agente buscarAgenteParaValidarLogin(String nomeUsuario, String senhaUsuario) {
    Agente agente = null;
    String sql = "SELECT * FROM agente WHERE nomeUsuario = ? AND senha = ?";

    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, nomeUsuario);
      preparedStatement.setString(2, senhaUsuario);

      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        int id = resultSet.getInt("idAgente");
        String usuario = resultSet.getString("nomeUsuario");
        String nome = resultSet.getString("nomePessoa");
        String senha = resultSet.getString("senha");
        String CPF = resultSet.getString("CPF");

        agente = new Agente(nome, CPF, usuario, senha, id);
      }

      preparedStatement.close();

    } catch (SQLException e) {
      System.out.println("Error query select agente: " + e.getMessage());
    }

    return agente;
  }

  public void inserirAgente(Agente agente) {
    String sql = "INSERT INTO agente (nomeUsuario, nomePessoa, senha, CPF) VALUES (?, ?, ?, ?)";
    try {
      preparedStatement = connection.prepareStatement(sql);

      preparedStatement.setString(1, agente.getNomeUsuario());
      preparedStatement.setString(2, agente.getNome());
      preparedStatement.setString(3, agente.getSenha());
      preparedStatement.setString(4, agente.getCpf());

      preparedStatement.execute();

      preparedStatement.close();

      System.out.println("Agente salvo com sucesso!");
    } catch (SQLException error) {
      System.out.println("Erro: " + error.getMessage());
    }
  }

}
