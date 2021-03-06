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
public class EstacaoModelo 
{
    private int pk_estacao;
    private String nome;
    private TipoEstacaoModelo tipoestacao;
    private EnderecoEstacaoModelo enderecoestacao;

    public EstacaoModelo() {
    }

    public EstacaoModelo(int pk_estacao, String nome, TipoEstacaoModelo tipoestacao, EnderecoEstacaoModelo enderecoestacao) {
        this.pk_estacao = pk_estacao;
        this.nome = nome;
        this.tipoestacao = tipoestacao;
        this.enderecoestacao = enderecoestacao;
    }

    public EnderecoEstacaoModelo getEnderecoEstacao() {
        return enderecoestacao;
    }

    public void setEnderecoEstacao(EnderecoEstacaoModelo enderecoestacao) {
        this.enderecoestacao = enderecoestacao;
    }

    public int getPk_estacao() {
        return pk_estacao;
    }

    public void setPk_estacao(int pk_estacao) {
        this.pk_estacao = pk_estacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoEstacaoModelo getTipoEstacao() {
        return tipoestacao;
    }

    public void setTipoEstacao(TipoEstacaoModelo tipoestacao) {
        this.tipoestacao = tipoestacao;
    }

    @Override
    public String toString() {
        return "EstacaoModelo{" + "pk_estacao=" + pk_estacao + ", nome=" + nome + ", tipoestacao=" + tipoestacao + ", enderecoestacao=" + enderecoestacao + '}';
    }
           
}
