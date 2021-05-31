/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordelivros.telas;

import gerenciadordelivros.beans.LivroAutor;
import gerenciadordelivros.controles.ControleLivroAutor;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ManterLivroAutor {
    
    static int id;
    static int idL;
    static int idA;
    static String obs;
    static ControleLivroAutor contLA;
    
    public static void buscar() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null,"TELA DE BUSCAR");
        id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        LivroAutor laEntrada = new LivroAutor(id);
        contLA = new ControleLivroAutor();
        LivroAutor laSaida = contLA.buscar(laEntrada);
        System.out.println(laSaida.toString());
        JOptionPane.showMessageDialog(null,laSaida.toString());
    }
    
    public static void listar() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null,"TELA DE LISTAR");
        obs = JOptionPane.showInputDialog("Observação");
        LivroAutor laEntrada = new LivroAutor(obs);
        contLA = new ControleLivroAutor();
        List<LivroAutor> livAutSaida = contLA.listar(laEntrada);
        livAutSaida.forEach((livrAutL) -> {
            JOptionPane.showMessageDialog(null,livrAutL.toString());
        });
    }
    
    public static void inserir() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null,"TELA DE INSERIR");
        idL = Integer.parseInt(JOptionPane.showInputDialog("ID livro"));
        idA = Integer.parseInt(JOptionPane.showInputDialog("ID autor"));
        obs = JOptionPane.showInputDialog("Observação");
        LivroAutor laEntrada = new LivroAutor(idA,idL,obs);
        contLA = new ControleLivroAutor();
        LivroAutor laSaida = contLA.inserir(laEntrada);
        JOptionPane.showMessageDialog(null,laSaida.toString());
    }
    
    public static void alterar() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null,"TELA DE ALTERAR");
        id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        idL = Integer.parseInt(JOptionPane.showInputDialog("ID livro"));
        idA = Integer.parseInt(JOptionPane.showInputDialog("ID autor"));
        obs = JOptionPane.showInputDialog("Observação");
        LivroAutor laEntrada = new LivroAutor(id,idA,idL,obs);
        contLA = new ControleLivroAutor();
        LivroAutor laSaida = contLA.alterar(laEntrada);
        JOptionPane.showMessageDialog(null,laSaida.toString());
    }

    public static void excluir() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null,"TELA DE EXCLUIR");
        id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        LivroAutor laEntrada = new LivroAutor(id);
        contLA = new ControleLivroAutor();
        LivroAutor laSaida = contLA.excluir(laEntrada);
        JOptionPane.showMessageDialog(null,laSaida.toString());
    } 
}
