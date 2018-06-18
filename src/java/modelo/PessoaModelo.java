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
public class PessoaModelo
{
    private int pk_pessoa;
    private String nome;
    private String sobrenome;
    private String telefone;
    private SexoModelo sexo;
    private EstadoCivilModelo estadoCivil;
    private String dataNascimento;
    private EnderecoModelo endereco;
    private String dataCriacao;

    public PessoaModelo()
    {
    }

    public PessoaModelo(int pk_pessoa, String nome, String sobrenome, String telefone, SexoModelo sexo, EstadoCivilModelo estadoCivil, String dataNascimento, EnderecoModelo endereco, String dataCriacao) {
        this.pk_pessoa = pk_pessoa;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.dataCriacao = dataCriacao;
    }

    public int getPk_pessoa() {
        return pk_pessoa;
    }

    public void setPk_pessoa(int pk_pessoa) {
        this.pk_pessoa = pk_pessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public SexoModelo getSexo() {
        return sexo;
    }

    public void setSexo(SexoModelo sexo) {
        this.sexo = sexo;
    }

    public EstadoCivilModelo getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivilModelo estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public EnderecoModelo getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoModelo endereco) {
        this.endereco = endereco;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public String toString() {
        return "PessoaModelo{" + "pk_pessoa=" + pk_pessoa + ", nome=" + nome + ", sobrenome=" + sobrenome + ", telefone=" + telefone + ", sexo=" + sexo + ", estadoCivil=" + estadoCivil + ", dataNascimento=" + dataNascimento + ", endereco=" + endereco + ", dataCriacao=" + dataCriacao + '}';
    }
    
    

    
}