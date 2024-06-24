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
  }

  public ArrayList<Bairro> buscarListaDeBairros() {
    String sql = "SELECT * FROM bairro";
    listaDeBairro = new ArrayList<>();

    try {
      preparedStatement = connection.prepareStatement(sql);
      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        int idBairro = resultSet.getInt("idBairro");
        String descricao = resultSet.getString("descricao");
        int casosTotal = resultSet.getInt("casosTotal");

        Bairro bairro = new Bairro(idBairro, descricao, casosTotal);
        listaDeBairro.add(bairro);
      }

      preparedStatement.close();

    } catch (SQLException e) {
      System.out.println((" Error:" + e.getMessage()));
    }

    return listaDeBairro;
  }
}