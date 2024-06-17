package dao;

import java.sql.*;

import connection.BD;
import model.Vistoria;

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

  public void inserirVistoria(Vistoria vistoria) {
    String sql = "INSERT INTO proprietario(dataVistoria, descricaoVistoria, idAgente, idEndereco) VALUES (?, ?, ?, ?)";

    try {
      preparedStatement = connection.prepareStatement(sql);

      preparedStatement.setDate(1, new Date(vistoria.getDataDaVisita().getTime()));
      preparedStatement.setString(2, vistoria.getDescricao());
      preparedStatement.setInt(3, vistoria.getIdAgente());
      preparedStatement.setInt(4, vistoria.getIdEndereco());

      preparedStatement.execute();

      preparedStatement.close();

    } catch (SQLException error) {
      System.out.println("Erro: " + error.getMessage());
    }
  }
}