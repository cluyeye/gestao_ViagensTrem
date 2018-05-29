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
public class EstadoCivilModelo 
{
    private int pk_estadocivil;
    private String nome;

    public EstadoCivilModelo() {
    }

    public EstadoCivilModelo(int pk_estadocivil, String nome) {
        this.pk_estadocivil = pk_estadocivil;
        this.nome = nome;
    }

    public int getPk_estadocivil() {
        return pk_estadocivil;
    }

    public void setPk_estadocivil(int pk_estadocivil) {
        this.pk_estadocivil = pk_estadocivil;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "EstadoCivilModelo{" + "pk_estadocivil=" + pk_estadocivil + ", nome=" + nome + '}';
    }
    
}
