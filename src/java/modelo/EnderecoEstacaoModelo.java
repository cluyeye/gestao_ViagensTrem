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
public class EnderecoEstacaoModelo 
{
    private int pk_enderecoestacao;
    private MunicipioModelo municipio;
    private String cidade;
    private String numero;

    public EnderecoEstacaoModelo() {
    }

    public EnderecoEstacaoModelo(int pk_enderecoestacao, MunicipioModelo municipio, String cidade, String numero) {
        this.pk_enderecoestacao = pk_enderecoestacao;
        this.municipio = municipio;
        this.cidade = cidade;
        this.numero = numero;
    }

    public int getPk_enderecoestacao() {
        return pk_enderecoestacao;
    }

    public void setPk_enderecoestacao(int pk_enderecoestacao) {
        this.pk_enderecoestacao = pk_enderecoestacao;
    }

    public MunicipioModelo getMunicipio() {
        return municipio;
    }

    public void setMunicipio(MunicipioModelo municipio) {
        this.municipio = municipio;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "EnderecoEstacaoModelo{" + "pk_enderecoestacao=" + pk_enderecoestacao + ", municipio=" + municipio + ", cidade=" + cidade + ", numero=" + numero + '}';
    }

    
    
}
