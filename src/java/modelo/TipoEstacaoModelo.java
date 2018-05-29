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
public class TipoEstacaoModelo 
{
    private int pk_tipoestacao;
    private String nome;

    public TipoEstacaoModelo() {
    }

    public TipoEstacaoModelo(int pk_tipoestacao, String nome) {
        this.pk_tipoestacao = pk_tipoestacao;
        this.nome = nome;
    }

    public int getPk_tipoestacao() {
        return pk_tipoestacao;
    }

    public void setPk_tipoestacao(int pk_tipoestacao) {
        this.pk_tipoestacao = pk_tipoestacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "TipoEstacaoModelo{" + "pk_tipoestacao=" + pk_tipoestacao + ", nome=" + nome + '}';
    }    
}
