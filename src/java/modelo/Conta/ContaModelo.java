/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.Conta;

import modelo.PessoaModelo;

/**
 *
 * @author coxe
 */
public class ContaModelo 
{
    private int pk_conta;
    private PessoaModelo pessoa;
    private PrivilegioModelo privilegio;
    private String username;
    private String password;

    public ContaModelo() {
    }

    public ContaModelo(int pk_conta, PessoaModelo pessoa, PrivilegioModelo privilegio, String username, String password) {
        this.pk_conta = pk_conta;
        this.pessoa = pessoa;
        this.privilegio = privilegio;
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPk_conta() {
        return pk_conta;
    }

    public void setPk_conta(int pk_conta) {
        this.pk_conta = pk_conta;
    }

    public PessoaModelo getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaModelo pessoa) {
        this.pessoa = pessoa;
    }

    public PrivilegioModelo getPrivilegio() {
        return privilegio;
    }

    public void setPrivilegio(PrivilegioModelo privilegio) {
        this.privilegio = privilegio;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "ContaModelo{" + "pk_conta=" + pk_conta + ", pessoa=" + pessoa + ", privilegio=" + privilegio + ", username=" + username + ", password=" + password + '}';
    }
}
