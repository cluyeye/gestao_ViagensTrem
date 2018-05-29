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
public class PaisModelo
{
    private int pk_pais;
    private String nome;

    public PaisModelo() {
    }

    public PaisModelo(int pk_pais, String nome) {
        this.pk_pais = pk_pais;
        this.nome = nome;
    }

    public int getPk_pais() {
        return pk_pais;
    }

    public void setPk_pais(int pk_pais) {
        this.pk_pais = pk_pais;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "PaisModelo{" + "pk_pais=" + pk_pais + ", nome=" + nome + '}';
    }
        
}
