package DAO;

import java.sql.*;

public class CasoDAO {
  private Connection connection;
  private PreparedStatement preparedStatement;

  public CasoDAO() {
    connection = BD.getConnection();
  }

  public void BuscarCasos() {
    String sql = "SELECT * FROM caso";

    try { // preparando conecção
      preparedStatement = connection.prepareStatement(sql);
      ResultSet resultSet = preparedStatement.executeQuery();
      // buscando no banco de dados
      while (resultSet.next()) {
        int idCaso = resultSet.getInt("idcaso");
        String descricao = resultSet.getString("descricao");
        int idEndereco = resultSet.getInt("idendereco");

        System.out.println("ID do Caso" + idCaso);
        System.out.println("Descricao do caso" + descricao);
        System.out.println("ID do Endereco" + idEndereco);

      }
      preparedStatement.close();
    } catch (SQLException e) {
      System.out.println((" Error:" + e.getMessage()));
    }

  }

  public void inserirCaso(String descricao, int idEndereco) {
    String sql = "INSERT INTO caso (descricao, idEndereco) VALUES (?, ?)";
    try {
      preparedStatement = connection.prepareStatement(sql);

      preparedStatement.setString(1, descricao);
      preparedStatement.setInt(2, idEndereco);

      preparedStatement.execute();

      preparedStatement.close();

      System.out.println("Agente salvo com sucesso!");
    } catch (SQLException error) {
      System.out.println("Erro: " + error.getMessage());
    }
  }

}