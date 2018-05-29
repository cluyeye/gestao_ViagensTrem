/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.Conta;

/**
 *
 * @author coxe
 */
public class PrivilegioModelo 
{
    private int pk_privilegio;
    private String nome;

    public PrivilegioModelo() {
    }

    public PrivilegioModelo(int pk_privilegio, String nome) {
        this.pk_privilegio = pk_privilegio;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPk_privilegio() {
        return pk_privilegio;
    }

    public void setPk_privilegio(int pk_privilegio) {
        this.pk_privilegio = pk_privilegio;
    }

    @Override
    public String toString() {
        return "PrivilegioModelo{" + "pk_privilegio=" + pk_privilegio + ", nome=" + nome + '}';
    }
    
}
