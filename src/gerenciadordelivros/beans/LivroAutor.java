/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordelivros.beans;

/**
 *
 * @author Livro
 */
public class LivroAutor {
    
// tABELA
int id;
int idL;
int idA;
String obs;
// TABLE
Livro liv;
Autor aut;

 public LivroAutor(int id) {
this.id = id;
}
 public LivroAutor(String obs) {
this.obs = obs;
}
 public LivroAutor(int id, int idL, int idA, String obs) {
this.id = id;
this.idL = idL;
this.idA = idA;
this.obs = obs;
}
 
  public LivroAutor(int idL, int idA, String obs) {
this.idL = idL;
this.idA = idA;
this.obs = obs;
}
 
 public int getId() {
return id;
}
 public void setId(int id) {
this.id = id;
}
 public int getIdL() {
return idL;
}
 public void setIdL(int idL) {
this.idL = idL;
}
 public int getIdA() {
return idA;
}
 public void setIdA(int idA) {
this.idA = idA;
}
 public String getObs() {
return obs;
}
 public void setObs(String obs) {
this.obs = obs;
}
 public Livro getLiv() {
return liv;
}
 public void setLiv(Livro liv) {
this.liv = liv;
}
 public Autor getAut() {
return aut;
}
 public void setAut(Autor aut) {
this.aut = aut;
}

@Override
    public String toString() {
    return "LivroAutor{" + "id=" + id + ", idL=" + idL + ", idA=" + idA + ", obs=" + obs + '}';
    }
}
