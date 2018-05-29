/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author coxe
 */
public class SexoModelo 
{
    private int pk_sexo;
    private String nome; 

    public SexoModelo() {
    }

    public int getPk_sexo() {
        return pk_sexo;
    }

    public void setPk_sexo(int pk_sexo) {
        this.pk_sexo = pk_sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "SexoModelo{" + "pk_sexo=" + pk_sexo + ", nome=" + nome + '}';
    }
        
}
