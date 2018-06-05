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
    private int pk_engenheiro;
    private PessoaModelo pessoa;

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

    public int getPk_engenheiro() {
        return pk_engenheiro;
    }

    public void setPk_engenheiro(int pk_engenheiro) {
        this.pk_engenheiro = pk_engenheiro;
    }

    public PessoaModelo getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaModelo pessoa) {
        this.pessoa = pessoa;
    }
       
    
}
