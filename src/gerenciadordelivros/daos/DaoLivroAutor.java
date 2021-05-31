/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordelivros.daos;

import java.util.List;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import gerenciadordelivros.beans.LivroAutor;
import gerenciadordelivros.util.ConexaoDb;

/**
 *
 * @author Usuario
 */
public class DaoLivroAutor {
    
    private final Connection c;
    
    public DaoLivroAutor() throws SQLException, ClassNotFoundException{
        this.c = new ConexaoDb().getConnection();
    }

    public LivroAutor buscar (LivroAutor livaut) throws SQLException {
        String sql = "select * from livro_autor WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,livaut.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            LivroAutor retorno = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                retorno = new LivroAutor(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getString(4));
            // adiciona o usu à lista de usus
            }
            stmt.close();
            c.close();
        return retorno;
    }

    public LivroAutor inserir (LivroAutor livaut) throws SQLException {
        String sql = "insert into livro_autor" + " (idLivro, idAutor, observacao)" + " values (?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setInt(1,livaut.getIdL());
        stmt.setInt(2,livaut.getIdA());
        stmt.setString(3,livaut.getObs());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            livaut.setId(id);
        }
        stmt.close();
        c.close();
        return livaut;
    }

    public LivroAutor alterar (LivroAutor livaut) throws SQLException {
        String sql = "UPDATE livro_autor SET idLivro = ?, idAutor = ?, observacao = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,livaut.getIdL());
        stmt.setInt(2,livaut.getIdA());
        stmt.setString(3,livaut.getObs());
        stmt.setInt(4,livaut.getId());

        // executa
        stmt.execute();
        stmt.close();
        return livaut;

    }

    public LivroAutor excluir (LivroAutor livaut) throws SQLException {
         String sql = "delete from livro_autor WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,livaut.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return livaut;
    }

    public List<LivroAutor> listar (LivroAutor livaut) throws SQLException {
         // usus: array armazena a lista de registros
        List<LivroAutor> livrAut = new ArrayList<>();
        
        String sql = "select * from livro_autor where observacao like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + livaut.getObs()+ "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            LivroAutor livAutSaida = new LivroAutor(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getString(4)
            );
            // adiciona o usu à lista de usus
            livrAut.add(livAutSaida);
        }
        
        rs.close();
        stmt.close();
        return livrAut;
    }
}
