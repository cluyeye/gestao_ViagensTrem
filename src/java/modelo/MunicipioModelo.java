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
public class MunicipioModelo
{
    private int pk_municipio;
    private String nome;    
    private ProvinciaModelo provincia;

    public MunicipioModelo()
    {
    }

    public MunicipioModelo(int pk_municipio, String nome, ProvinciaModelo provincia) {
        this.pk_municipio = pk_municipio;
        this.nome = nome;
        this.provincia = provincia;
    }

    public int getPk_municipio() {
        return pk_municipio;
    }

    public void setPk_municipio(int pk_municipio) {
        this.pk_municipio = pk_municipio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ProvinciaModelo getProvincia() {
        return provincia;
    }

    public void setProvincia(ProvinciaModelo provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "MunicipioModelo{" + "pk_municipio=" + pk_municipio + ", nome=" + nome + ", provincia=" + provincia + '}';
    }
    
}
