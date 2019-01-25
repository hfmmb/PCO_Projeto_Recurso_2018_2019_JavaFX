package negocios;

import negocios.unidades.UnidadesMedidaImperial;
import negocios.unidades.UnidadesMedidaMetrico;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Plano {
    private Indicador indicador;
    private Objetivo objetivo;
    private Set<HistoricoIndicador> historicoIndicadorSet = new HashSet<>();
    private Timestamp timestamp;
    private String usernameSupervisor;
    public Plano(Date dataLimite, String valorMinimoDesejado,String valorMaximoDesejado, Indicador indicador, String usernameSupervisor){
        this.objetivo = new Objetivo(dataLimite,valorMinimoDesejado,valorMaximoDesejado);
        this.indicador = indicador;
        Date datenow = new Date();
        this.usernameSupervisor = usernameSupervisor;
        this.timestamp = new Timestamp(datenow.getTime());
    }

    public Timestamp getTimestamp() {
        return timestamp;
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

    public String getUsernameSupervisor() {
        return usernameSupervisor;
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }

    public Set<HistoricoIndicador> getHistoricoIndicadorSet() {
        return historicoIndicadorSet;
    }

    public Indicador getIndicador() {
        return indicador;
    }
}

