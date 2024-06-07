package DAO;

import java.sql.*;

public class VistoriaDAO {
  private Connection connection;
  private PreparedStatement preparedStatement;

  public VistoriaDAO() {
    connection = BD.getConnection();
  }// conexao com o banco

  public void buscarVistoria() {
    try {
      preparedStatement = connection.prepareStatement("SELECT * FROM vistoria");
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {

        int idVistoria = resultSet.getInt("idVistoria");
        Date dataVistoria = resultSet.getDate("dataVistoria");
        String descricaoVistoria = resultSet.getString("descricaoVistoria");
        int idAgente = resultSet.getInt("idAgente");
        int idEndereco = resultSet.getInt("idEndereco");

        System.out.println("Codigo Vistoria: " + idVistoria);
        System.out.println("Data Vistoria: " + dataVistoria);
        System.out.println("Descricao Vistoria: " + descricaoVistoria);
        System.out.println("Codigo Agente: " + idAgente);
        System.out.println("Codigo Endereco: " + idEndereco);

      }
      preparedStatement.close();

    } catch (SQLException e) {
      System.out.println("Erro: " + e.getMessage());
    }
  }

  public void inserirVistoria(Date dataVistoria, String descricaoVistoria, int idAgente, int idEndereco) {
    String sql = "INSERT INTO proprietario(dataVistoria, descricaoVistoria, idAgente, idEndereco) VALUES (?, ?, ?, ?)";

    try {
      preparedStatement = connection.prepareStatement(sql);

      preparedStatement.setDate(1, dataVistoria);
      preparedStatement.setString(2, descricaoVistoria);
      preparedStatement.setInt(3, idAgente);
      preparedStatement.setInt(4, idEndereco);

      preparedStatement.execute();

      preparedStatement.close();

    } catch (SQLException error) {
      System.out.println("Erro: " + error.getMessage());
    }
  }
}