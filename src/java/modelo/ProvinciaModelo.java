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
public class ProvinciaModelo
{
    private int pk_provincia;
    private String nome;
    private PaisModelo pais;

    
    public ProvinciaModelo()
    { }
    
    public ProvinciaModelo(int pk_provincia, String nome, PaisModelo pais) {
        this.pk_provincia = pk_provincia;
        this.nome = nome;
        this.pais = pais;
    }

    public int getPk_provincia() {
        return pk_provincia;
    }

    public void setPk_provincia(int pk_provincia) {
        this.pk_provincia = pk_provincia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public PaisModelo getPais() {
        return pais;
    }

    public void setPais(PaisModelo pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "ProvinciaModelo{" + "pk_provincia=" + pk_provincia + ", nome=" + nome + ", pais=" + pais + '}';
    }
    
    
}
