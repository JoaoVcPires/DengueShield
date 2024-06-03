package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BairroDAO {
  private Connection connection;
  private PreparedStatement preparedStatement;

  public BairroDAO() {
    connection = BD.getConnection();
  }

  public void buscarBairro() {
    String sql = " SELECT * FROM bairro ";
    try {
      preparedStatement = connection.prepareStatement(sql);
      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        int idBairro = resultSet.getInt("idBairro");
        String descricao = resultSet.getString("descricao");
        int casosTotal = resultSet.getInt("casosTotal");
        int idAgente = resultSet.getInt("idAgente");
        int idEndeco = resultSet.getInt("idEndereco");

        System.out.println("ID do Bairro: " + idBairro);
        System.out.println("Descrição: " + descricao);
        System.out.println("Casos Totatais: " + casosTotal);
        System.out.println("ID do Agente: " + idAgente);
        System.out.println("ID do Endereco: " + idEndeco);

      }

      preparedStatement.close();

    } catch (SQLException e) {
      System.out.println((" Error:" + e.getMessage()));
    }

  }
}