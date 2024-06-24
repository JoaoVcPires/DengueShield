package dao;

import java.sql.*;
import java.util.ArrayList;

import connection.BD;
import jdk.jshell.execution.Util;
import model.Vistoria;

public class VistoriaDAO {
  private Connection connection;
  private PreparedStatement preparedStatement;

  public VistoriaDAO() {
    connection = BD.getConnection();
  }

  public void buscarVistoria() {
    String sql = "SELECT * FROM vistoria";

    try {
      preparedStatement = connection.prepareStatement(sql);
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
    String sql = "INSERT INTO vistoria(dataVisita, descricaoVist, idAgente, idEndereco) VALUES (?, ?, ?, ?)";

    try {
      preparedStatement = connection.prepareStatement(sql);

      preparedStatement.setDate(1, new Date(vistoria.getDataDaVisita().getTime()));
      preparedStatement.setString(2, vistoria.getDescricao());
      preparedStatement.setInt(3, vistoria.getIdAgente());
      preparedStatement.setInt(4, vistoria.getIdEndereco());

      preparedStatement.execute();

      preparedStatement.close();

      System.out.println("Vistoria cadastrada com sucesso!");
    } catch (SQLException error) {
      System.out.println("Erro: " + error.getMessage());
    }
  }

  public ArrayList<Vistoria> buscarListaDeVistoriasPorIdAgente(int idAgenteLogado) {
    ArrayList<Vistoria> listaDeVistoriaPorAgente = new ArrayList<>();
    String sql = "SELECT * FROM vistoria WHERE idAgente = ? ORDER BY dataVisita DESC";

    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setInt(1, idAgenteLogado);

      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        int idVistoria = resultSet.getInt("idVistoria");
        java.util.Date dataVistoria = new java.util.Date(resultSet.getDate("dataVisita").getTime());
        String descricaoVistoria = resultSet.getString("descricaoVist");
        int idAgente = resultSet.getInt("idAgente");
        int idEndereco = resultSet.getInt("idEndereco");

        Vistoria vistoria = new Vistoria(idVistoria, idAgente, idEndereco, dataVistoria, descricaoVistoria);
        listaDeVistoriaPorAgente.add(vistoria);
      }
      preparedStatement.close();

    } catch (SQLException e) {
      System.out.println("Erro: " + e.getMessage());
    }

    return listaDeVistoriaPorAgente;
  }
}