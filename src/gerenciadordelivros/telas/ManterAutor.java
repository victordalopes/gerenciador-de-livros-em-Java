/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordelivros.telas;

import gerenciadordelivros.beans.Autor;
import gerenciadordelivros.controles.ControleAutor;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ManterAutor {
    
    static int id;
    static String nome;
    static String idade;
    static String editora;
    static String genero;
    
    static ControleAutor contA;
    
    public static void listar() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null,"TELA DE LISTAR");
        nome = JOptionPane.showInputDialog("NOME");
        Autor aEntrada = new Autor(nome);
        contA = new ControleAutor();
        List<Autor> csSaida = contA.listar(aEntrada);
        csSaida.forEach((autA) -> {
            JOptionPane.showMessageDialog(null,autA.toString());
        });
    }
    
    public static void inserir() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null,"TELA DE INSERIR");
        nome = JOptionPane.showInputDialog("NOME");
        idade = JOptionPane.showInputDialog("IDADE");
        editora = JOptionPane.showInputDialog("EDITORA");
        genero = JOptionPane.showInputDialog("GÊNERO");
        Autor aEntrada = new Autor(nome,idade,editora,genero);
        contA = new ControleAutor();
        Autor aSaida = contA.inserir(aEntrada);
        JOptionPane.showMessageDialog(null,aSaida.toString());
    }
        
    public static void alterar() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null,"TELA DE ALTERAR");
        id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        nome = JOptionPane.showInputDialog("NOME");
        idade = JOptionPane.showInputDialog("IDADE");
        editora = JOptionPane.showInputDialog("EDITORA");
        genero = JOptionPane.showInputDialog("GÊNERO");
        Autor aEntrada = new Autor(id,nome,idade,editora,genero);
        contA = new ControleAutor();
        Autor aSaida = contA.alterar(aEntrada);
        JOptionPane.showMessageDialog(null,aSaida.toString());
    }
        
    public static void buscar() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null,"TELA DE BUSCAR");
        id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Autor aEntrada = new Autor(id);
        contA = new ControleAutor();
        Autor aSaida = contA.buscar(aEntrada);
        JOptionPane.showMessageDialog(null,aSaida.toString());
    }
        
    public static void excluir() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null,"TELA DE EXCLUIR");
        id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Autor aEntrada = new Autor(id);
        contA = new ControleAutor();
        Autor aSaida = contA.excluir(aEntrada);
        JOptionPane.showMessageDialog(null,aSaida.toString());
    }
}
