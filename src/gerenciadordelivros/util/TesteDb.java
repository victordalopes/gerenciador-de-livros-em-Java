/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordelivros.util;

import java.sql.Connection;

/**
 *
 * @author Usuario
 */
public class TesteDb {
    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws ClassNotFoundException {
        Connection c = new ConexaoDb().getConnection();
    }
}
