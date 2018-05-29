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
public class TremEstacaoModelo 
{
    private TremModelo trem;
    private EstacaoModelo estacao;
    private TrajectoSentidoModelo trajectoSentido;

    public TremEstacaoModelo() {
    }

    public TremEstacaoModelo(TremModelo trem, EstacaoModelo estacao, TrajectoSentidoModelo trajectoSentido) {
        this.trem = trem;
        this.estacao = estacao;
        this.trajectoSentido = trajectoSentido;
    }

    public TrajectoSentidoModelo getTrajectoSentido() {
        return trajectoSentido;
    }

    public void setTrajectoSentido(TrajectoSentidoModelo trajectoSentido) {
        this.trajectoSentido = trajectoSentido;
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

    @Override
    public String toString() {
        return "TremEstacaoModelo{" + "trem=" + trem + ", estacao=" + estacao + ", trajectoSentido=" + trajectoSentido + '}';
    }
    
}
