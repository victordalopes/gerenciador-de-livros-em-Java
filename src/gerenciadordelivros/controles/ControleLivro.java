/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordelivros.controles;

import gerenciadordelivros.beans.Livro;
import java.sql.SQLException;
import gerenciadordelivros.daos.DaoLivro;
import java.util.List;

/**
 *
 * @author Usuario
 */

public class ControleLivro {
    
    static DaoLivro daoLiv;
    
    public ControleLivro () throws SQLException, ClassNotFoundException {
        daoLiv = new DaoLivro();
    }
    
    public List<Livro> listar(Livro lEntrada) throws SQLException {
        return daoLiv.listar(lEntrada);
    }

    public Livro inserir(Livro lEntrada) throws SQLException {
        return daoLiv.inserir(lEntrada);
    }

    public Livro alterar(Livro lEntrada) throws SQLException {
        return daoLiv.alterar(lEntrada);
    }

    public Livro excluir(Livro lEntrada) throws SQLException {
        return daoLiv.excluir(lEntrada);
    }

    public Livro buscar(Livro lEntrada) throws SQLException {
        return daoLiv.buscar(lEntrada);
    }
    
}

