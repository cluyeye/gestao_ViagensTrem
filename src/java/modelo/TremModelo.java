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
public class TremModelo 
{
    private int pk_trem;
    private String matricula;
    private TipoTremModelo tipoTrem;
    private EngenheiroModelo engenheiro;

    public TremModelo() {
    }

    public TremModelo(int pk_trem, String matricula, TipoTremModelo tipoTrem, EngenheiroModelo engenheiro) {
        this.pk_trem = pk_trem;
        this.matricula = matricula;
        this.tipoTrem = tipoTrem;
        this.engenheiro = engenheiro;
    }

    public int getPk_trem() {
        return pk_trem;
    }

    public void setPk_trem(int pk_trem) {
        this.pk_trem = pk_trem;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public TipoTremModelo getTipoTrem() {
        return tipoTrem;
    }

    public void setTipoTrem(TipoTremModelo tipoTrem) {
        this.tipoTrem = tipoTrem;
    }

    public EngenheiroModelo getEngenheiro() {
        return engenheiro;
    }

    public void setEngenheiro(EngenheiroModelo engenheiro) {
        this.engenheiro = engenheiro;
    }

    @Override
    public String toString() {
        return "TremModelo{" + "pk_trem=" + pk_trem + ", matricula=" + matricula + ", tipoTrem=" + tipoTrem + ", engenheiro=" + engenheiro + '}';
    }


}
