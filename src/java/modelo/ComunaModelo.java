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
public class ComunaModelo 
{
    private int pk_comuna;
    private String nome;
    private MunicipioModelo municipio;

    public ComunaModelo() {
    }

    public ComunaModelo(int pk_comuna, String nome, MunicipioModelo municipio) {
        this.pk_comuna = pk_comuna;
        this.nome = nome;
        this.municipio = municipio;
    }

    public int getPk_comuna() {
        return pk_comuna;
    }

    public void setPk_comuna(int pk_comuna) {
        this.pk_comuna = pk_comuna;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public MunicipioModelo getMunicipio() {
        return municipio;
    }

    public void setMunicipio(MunicipioModelo municipio) {
        this.municipio = municipio;
    }

    @Override
    public String toString() {
        return "ComunaModelo{" + "pk_comuna=" + pk_comuna + ", nome=" + nome + ", municipio=" + municipio + '}';
    }
     
}
