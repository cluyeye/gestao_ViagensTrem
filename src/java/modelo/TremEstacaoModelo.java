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
    private Calendar dataviagem;

    public TremEstacaoModelo() {
    }

    public TremEstacaoModelo(TremModelo trem, EstacaoModelo estacao, TipoViagemModelo tipoviagem, Calendar dataviagem) {
        this.trem = trem;
        this.estacao = estacao;
        this.tipoviagem = tipoviagem;
        this.dataviagem = dataviagem;
    }

    public Calendar getDataViagem() {
        return dataviagem;
    }

    public void setDataViagem(Calendar dataviagem) {
        this.dataviagem = dataviagem;
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

    @Override
    public String toString() {
        return "TremEstacaoModelo{" + "trem=" + trem + ", estacao=" + estacao + ", tipoviagem=" + tipoviagem + ", dataviagem=" + dataviagem + '}';
    }
       

}
