package br.com.movie.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {

    private static final String URL = "jdbc:mysql://localhost:3306/cinema";
    private static final String USER = "root";
    private static final String PASSWORlD = "";

    public static Connection conectar(){

        try {
            return DriverManager.getConnection(URL, USER, PASSWORlD);

        } catch (Exception e){
          //throw  new RuntimeException("Erro ao conectar com o banco de dados");
            e.printStackTrace();
        }
        return null;
    }
}
