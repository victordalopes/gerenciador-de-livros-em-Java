/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordelivros.telas;

import gerenciadordelivros.beans.Livro;
import gerenciadordelivros.controles.ControleLivro;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class ManterLivro {
    
    static int id;
    static String titulo;
    static String autor;
    static String editora;
    
    static ControleLivro contL;
    
    public static void listar() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null,"TELA DE LISTAR");
        titulo = JOptionPane.showInputDialog("TÍTULO");
        Livro lEntrada = new Livro(titulo);
        contL = new ControleLivro();
        List<Livro> lsSaida = contL.listar(lEntrada);
        lsSaida.forEach((livL) -> {
            JOptionPane.showMessageDialog(null,livL.toString());
        });
    }
    
    public static void inserir() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null,"TELA DE INSERIR");
        titulo = JOptionPane.showInputDialog("TÍTULO");
        autor = JOptionPane.showInputDialog("AUTOR");
        editora = JOptionPane.showInputDialog("EDITORA");
        Livro lEntrada = new Livro(titulo,autor,editora);
        contL = new ControleLivro();
        Livro lSaida = contL.inserir(lEntrada);
        JOptionPane.showMessageDialog(null,lSaida.toString());
    }
        
    public static void alterar() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null,"TELA DE ALTERAR");
        id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        titulo = JOptionPane.showInputDialog("TITULO");
        autor = JOptionPane.showInputDialog("AUTOR");
        editora = JOptionPane.showInputDialog("EDITORA");
        Livro lEntrada = new Livro(id,titulo,autor,editora);
        contL = new ControleLivro();
        Livro lSaida = contL.alterar(lEntrada);
        JOptionPane.showMessageDialog(null,lSaida.toString());
    }
    
    public static void buscar() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null,"TELA DE BUSCAR");
        id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Livro lEntrada = new Livro(id);
        contL = new ControleLivro();
        Livro lSaida = contL.buscar(lEntrada);
        System.out.println(lSaida.toString());
        JOptionPane.showMessageDialog(null,lSaida.toString());
    }
        
    public static void excluir() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null,"TELA DE EXCLUIR");
        id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Livro lEntrada = new Livro(id);
        contL = new ControleLivro();
        Livro lSaida = contL.excluir(lEntrada);
        JOptionPane.showMessageDialog(null,lSaida.toString());
    }
}









