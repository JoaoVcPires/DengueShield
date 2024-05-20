package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
