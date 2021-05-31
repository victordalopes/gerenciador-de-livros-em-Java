/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordelivros.beans;

/**
 *
 * @author Usuario
 */
public class Livro {
    
    int id;
    String titulo;
    String autor;
    String editora;
    
    // USAR NOS METODOS DE EXCLUIR E BUSCAR
    public Livro(int id) {
        this.id = id;
    }

    // USAR NOS METODO DE LISTAR
    public Livro(String titulo) {
        this.titulo = titulo;
    }
    
    // USAR NO METODO DE INSERIR
    public Livro(String titulo, String autor, String editora) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
    }
    
    // USAR NO METODO DE ALTERAR
    public Livro(int id, String titulo, String autor, String editora) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }
    
    @Override
    public String toString() {
        return "Livro{" + "id=" + id + ", título=" + titulo + ", autor=" + autor + ", editora=" + editora + '}';
    }
    
}


