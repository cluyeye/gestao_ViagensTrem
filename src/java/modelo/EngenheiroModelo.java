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
public class EngenheiroModelo 
{
    int pk_engenheiro;
    PessoaModelo pessoa;

    public EngenheiroModelo() {
    }

    public EngenheiroModelo(int pk_engenheiro, PessoaModelo pessoa) {
        this.pk_engenheiro = pk_engenheiro;
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        return "EngenheiroModelo{" + "pk_engenheiro=" + pk_engenheiro + ", pessoa=" + pessoa + '}';
    }
       
    
}
