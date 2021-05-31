/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordelivros.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class ConexaoDb {
    
    public Connection getConnection() throws ClassNotFoundException {
        try {
            // Carregando o JDBC Driver padrão
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Configurando a nossa conexão com um banco de dados//
            String serverName = "localhost:3306";    //caminho do servidor do BD
            String mydatabase ="gerenciadordelivros";        //nome do seu banco de dados
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase + "?useTimezone=true&serverTimezone=UTC";
            String username = "adm";        //nome de um usuário de seu BD
            String password = "adm2021";      //sua senha de acesso
            Connection c = DriverManager.getConnection(url, username, password);
            if (c != null) System.out.println("STATUS--->Conectado com sucesso!");
            return c;
        } catch (SQLException e) {
           //Não conseguindo se conectar ao banco
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            System.out.println("STATUS---> Erro " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
