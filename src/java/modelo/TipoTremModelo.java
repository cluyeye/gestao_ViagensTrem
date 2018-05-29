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
public class TipoTremModelo 
{
    private int pk_tipotrem;
    private String nome;    

    public TipoTremModelo() {
    }

    public TipoTremModelo(int pk_tipotrem, String nome) {
        this.pk_tipotrem = pk_tipotrem;
        this.nome = nome;
    }

    public int getPk_tipotrem() {
        return pk_tipotrem;
    }

    public void setPk_tipotrem(int pk_tipotrem) {
        this.pk_tipotrem = pk_tipotrem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "TipoTremModelo{" + "pk_tipotrem=" + pk_tipotrem + ", nome=" + nome + '}';
    }   
    
}
