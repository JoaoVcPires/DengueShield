package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.BD;
import model.Bairro;

public class BairroDAO {
  private Connection connection;
  private PreparedStatement preparedStatement;
  private ArrayList<Bairro> listaDeBairro;

  public BairroDAO() {
    connection = BD.getConnection();
    listaDeBairro = new ArrayList<>();
  }

  public ArrayList<Bairro> buscarBairros() {
    String sql = "SELECT * FROM bairro";

    try {
      preparedStatement = connection.prepareStatement(sql);
      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        int idBairro = resultSet.getInt("idBairro");
        String descricao = resultSet.getString("descricao");
        int casosTotal = resultSet.getInt("casosTotal");
        int idAgente = resultSet.getInt("idAgente");

        Bairro bairro = new Bairro(idBairro, descricao, casosTotal, idAgente);
        listaDeBairro.add(bairro);

        // System.out.println("ID do Bairro: " + idBairro);
        // System.out.println("Descrição: " + descricao);
        // System.out.println("Casos Totatais: " + casosTotal);
        // System.out.println("ID do Agente: " + idAgente);

      }

      preparedStatement.close();

    } catch (SQLException e) {
      System.out.println((" Error:" + e.getMessage()));
    }

    return listaDeBairro;
  }
}