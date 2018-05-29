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
public class TrajectoSentidoModelo 
{
    private int pk_trajectosentido;
    private String nome;    

    public TrajectoSentidoModelo() {
    }

    public TrajectoSentidoModelo(int pk_trajectosentido, String nome) {
        this.pk_trajectosentido = pk_trajectosentido;
        this.nome = nome;
    }

    public int getPk_trajectosentido() {
        return pk_trajectosentido;
    }

    public void setPk_trajectosentido(int pk_trajectosentido) {
        this.pk_trajectosentido = pk_trajectosentido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "TrajectoSentidoModelo{" + "pk_trajectosentido=" + pk_trajectosentido + ", nome=" + nome + '}';
    }   
    
}
