package br.com.burguerqueen.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

//    "jdbc:mysql://containers-us-west-99.railway.app:5570/railway"
//    jdbc:mysql://127.0.0.1:3306/burguerqueen

    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final static String URL = "jdbc:mysql://containers-us-west-149.railway.app:7261/railway";
    private final static String USER = "root";
    private final static String PASS = "tuq48hqYkJsr8qVhifGM";

    public static Connection conectaBD() {
        try {
            Class.forName(DRIVER);

            return DriverManager.getConnection(URL, USER, PASS);
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException("Erro: Classe não encontrada.");
        } 
        catch (SQLException e) {
            throw new RuntimeException("Erro: Conexão não pode ser realizada.");
        }
    }
}
