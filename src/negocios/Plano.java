package negocios;

import negocios.unidades.UnidadesMedidaImperial;
import negocios.unidades.UnidadesMedidaMetrico;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Plano {
    private String valorMinimoDesejado;
    private String valorMaximoDesejado;
    private Indicador indicador;
    private Set<HistoricoIndicador> historicoIndicadorSet = new HashSet<>();
    private Timestamp timestamp;
    private String usernameSupervisor;
    public Plano( String valorMinimoDesejado,String valorMaximoDesejado, Indicador indicador, String usernameSupervisor){
        this.valorMinimoDesejado = valorMinimoDesejado;
        this.valorMaximoDesejado = valorMaximoDesejado;
        this.indicador = indicador;
        Date datenow = new Date();
        this.usernameSupervisor = usernameSupervisor;
        this.timestamp = new Timestamp(datenow.getTime());
    }

    public String getValorMaximoDesejado() {
        return valorMaximoDesejado;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public String getValorMinimoDesejado() {
        return valorMinimoDesejado;
    }

    public void setValorMaximoDesejado(String valorMaximoDesejado) {
        this.valorMaximoDesejado = valorMaximoDesejado;
    }

    public void setValorMinimoDesejado(String valorMinimoDesejado) {
        this.valorMinimoDesejado = valorMinimoDesejado;
    }
    public void updateValorIndicador(){
        if (indicador.getUnidadeMedida() instanceof UnidadesMedidaMetrico){
            Double valor = ((UnidadesMedidaMetrico) indicador.getUnidadeMedida()).getValor();
            HistoricoIndicador historicoIndicador = new HistoricoIndicador(valor.toString());
            historicoIndicadorSet.add(historicoIndicador);
        }
        else if (indicador.getUnidadeMedida() instanceof UnidadesMedidaImperial){
            Double valor = ((UnidadesMedidaImperial) indicador.getUnidadeMedida()).getValor();
            HistoricoIndicador historicoIndicador = new HistoricoIndicador(valor.toString());
            historicoIndicadorSet.add(historicoIndicador);
        }
        else {

        }
    }

    public Indicador getIndicador() {
        return indicador;
    }
}

