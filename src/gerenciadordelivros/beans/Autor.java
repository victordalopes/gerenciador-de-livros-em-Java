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
public class Autor {
    
    int id;
    String nome;
    String idade;
    String editora;
    String genero;
    
    // USAR NOS METODOS DE EXCLUIR E BUSCAR
    public Autor(int id) {
        this.id = id;
    }

    // USAR NOS METODO DE LISTAR
    public Autor(String nome) {
        this.nome = nome;
    }
    
    // USAR NO METODO DE INSERIR
    public Autor(String nome, String idade, String editora, String genero) {
        this.nome = nome;
        this.idade = idade;
        this.editora = editora;
        this.genero = genero;
    }

    // USAR NO METODO DE ALTERAR
    public Autor(int id, String nome, String idade, String editora, String genero) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.editora = editora;
        this.genero = genero;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
     @Override
    public String toString() {
        return "Autor{" + "id=" + id + ", nome=" + nome + ", idade=" + idade + ", editora=" + editora + ", gênero=" + genero + '}';
    }
}