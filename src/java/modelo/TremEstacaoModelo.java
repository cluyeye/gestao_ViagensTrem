/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.util.Calendar;

/**
 *
 * @author coxe
 */
public class TremEstacaoModelo 
{
    private TremModelo trem;
    private EstacaoModelo estacao;
    private TipoViagemModelo tipoviagem;
    private String dataviagem;
    private String horaviagem;

    public TremEstacaoModelo() {
    }

    public TremEstacaoModelo(TremModelo trem, EstacaoModelo estacao, TipoViagemModelo tipoviagem, String dataviagem, String horaviagem) {
        this.trem = trem;
        this.estacao = estacao;
        this.tipoviagem = tipoviagem;
        this.dataviagem = dataviagem;
        this.horaviagem = horaviagem;
    }

    public TremModelo getTrem() {
        return trem;
    }

    public void setTrem(TremModelo trem) {
        this.trem = trem;
    }

    public EstacaoModelo getEstacao() {
        return estacao;
    }

    public void setEstacao(EstacaoModelo estacao) {
        this.estacao = estacao;
    }

    public TipoViagemModelo getTipoViagem() {
        return tipoviagem;
    }

    public void setTipoViagem(TipoViagemModelo tipoviagem) {
        this.tipoviagem = tipoviagem;
    }

    public String getDataViagem() {
        return dataviagem;
    }

    public void setDataViagem(String dataviagem) {
        this.dataviagem = dataviagem;
    }

    public String getHoraViagem() {
        return horaviagem;
    }

    public void setHoraViagem(String horaviagem) {
        this.horaviagem = horaviagem;
    }

    @Override
    public String toString() {
        return "TremEstacaoModelo{" + "trem=" + trem + ", estacao=" + estacao + ", tipoviagem=" + tipoviagem + ", dataviagem=" + dataviagem + ", horaviagem=" + horaviagem + '}';
    }


}
