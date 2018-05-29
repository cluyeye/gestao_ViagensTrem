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
    private TipoEstacaoModelo estacao;
    private EnderecoModelo endereco;

    public EstacaoModelo() {
    }

    public EstacaoModelo(int pk_estacao, String nome, TipoEstacaoModelo estacao, EnderecoModelo endereco) {
        this.pk_estacao = pk_estacao;
        this.nome = nome;
        this.estacao = estacao;
        this.endereco = endereco;
    }

    public EnderecoModelo getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoModelo endereco) {
        this.endereco = endereco;
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

    public TipoEstacaoModelo getEstacao() {
        return estacao;
    }

    public void setEstacao(TipoEstacaoModelo estacao) {
        this.estacao = estacao;
    }

    @Override
    public String toString() {
        return "EstacaoModelo{" + "pk_estacao=" + pk_estacao + ", nome=" + nome + ", estacao=" + estacao + ", endereco=" + endereco + '}';
    }
           
}
