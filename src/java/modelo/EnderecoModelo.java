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
public class EnderecoModelo 
{
    private int pk_endereco;
    private MunicipioModelo municipio;
    private String bairro;
    private String rua;
    private String numeroCasa;

    public EnderecoModelo() {
    }

    public EnderecoModelo(int pk_endereco, MunicipioModelo municipio, String bairro, String rua, String numeroCasa) {
        this.pk_endereco = pk_endereco;
        this.municipio = municipio;
        this.bairro = bairro;
        this.rua = rua;
        this.numeroCasa = numeroCasa;
    }

    public String getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public int getPk_endereco() {
        return pk_endereco;
    }

    public void setPk_endereco(int pk_endereco) {
        this.pk_endereco = pk_endereco;
    }

    public MunicipioModelo getMunicipio() {
        return municipio;
    }

    public void setMunicipio(MunicipioModelo municipio) {
        this.municipio = municipio;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    @Override
    public String toString() {
        return "EnderecoModelo{" + "pk_endereco=" + pk_endereco + ", municipio=" + municipio + ", bairro=" + bairro + ", rua=" + rua + ", numeroCasa=" + numeroCasa + '}';
    }
        
}
