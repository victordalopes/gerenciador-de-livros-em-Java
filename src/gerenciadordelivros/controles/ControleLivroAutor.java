/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordelivros.controles;

import java.sql.SQLException;
import java.util.List;
import gerenciadordelivros.beans.LivroAutor;
import gerenciadordelivros.beans.Livro;
import gerenciadordelivros.beans.Autor;
import gerenciadordelivros.daos.DaoLivroAutor;

/**
 *
 * @author Usuario
 */
public class ControleLivroAutor {
    
        static DaoLivroAutor daoLivAut;
        ControleLivro contLiv;
        ControleAutor contAut;
    
    public ControleLivroAutor () throws SQLException, ClassNotFoundException {
        daoLivAut = new DaoLivroAutor();
    }
    
    public LivroAutor buscar(LivroAutor livaut) throws SQLException, ClassNotFoundException {
        contLiv = new ControleLivro();
        contAut = new ControleAutor();
        // busca LivroAutor por id
        livaut = daoLivAut.buscar(livaut);
        // construi os beans com os id de retorno de usuPes
        Livro liv = new Livro(livaut.getIdL());
        Autor aut = new Autor(livaut.getIdA());
        //valorizar beans de usuario e pessoa executando seus controles.
        livaut.setLiv(contLiv.buscar(liv));
        livaut.setAut(contAut.buscar(aut));
        
        return livaut;
    }

    public List<LivroAutor> listar (LivroAutor livaut) throws SQLException, ClassNotFoundException {

        List<LivroAutor> livauts;
        livauts = daoLivAut.listar(livaut);
        for (LivroAutor livautL : livauts) {
        contLiv = new ControleLivro();
        contAut = new ControleAutor();
        Livro liv = new Livro(livautL.getIdL());
        Autor aut = new Autor(livautL.getIdA());
        // valorizar os beans de usuario e pessao executando
        // seus controles.
        livautL.setLiv(contLiv.buscar(liv));
        livautL.setAut(contAut.buscar(aut));
        }
        return livauts;
        }

    public LivroAutor inserir(LivroAutor livaut) throws SQLException {
        livaut = daoLivAut.inserir(livaut);
        return livaut;
    }

    public LivroAutor alterar(LivroAutor livaut) throws SQLException {
        livaut = daoLivAut.alterar(livaut);
        return livaut;
    }

    public LivroAutor excluir(LivroAutor livaut) throws SQLException {
        livaut = daoLivAut.excluir(livaut);
        return livaut;
    }
}

