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
public class TipoViagemModelo 
{
    private int pk_tipoviagem;
    private String nome;    

    public TipoViagemModelo() {
    }

    public TipoViagemModelo(int pk_tipoviagem, String nome) {
        this.pk_tipoviagem = pk_tipoviagem;
        this.nome = nome;
    }

    public int getPk_tipoviagem() {
        return pk_tipoviagem;
    }

    public void setPk_tipoviagem(int pk_tipoviagem) {
        this.pk_tipoviagem = pk_tipoviagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "tipoviagemModelo{" + "pk_tipoviagem=" + pk_tipoviagem + ", nome=" + nome + '}';
    }   
    
}
