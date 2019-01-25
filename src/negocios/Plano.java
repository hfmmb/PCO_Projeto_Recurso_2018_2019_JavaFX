package negocios;

import negocios.unidades.UnidadesMedidaImperial;
import negocios.unidades.UnidadesMedidaMetrico;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class Plano {
    private Indicador indicador;
    private Objetivo objetivo;
    private Timestamp timestamp;
    private String usernameSupervisor;

    public Plano(Date dataLimite, String valorMinimoDesejado,String valorMaximoDesejado, Indicador indicador, String usernameSupervisor){
        this.objetivo = new Objetivo(dataLimite,valorMinimoDesejado,valorMaximoDesejado);
        this.indicador = indicador;
        Date datenow = new Date();
        this.usernameSupervisor = usernameSupervisor;
        this.timestamp = new Timestamp(datenow.getTime());
        indicador.updateHistoricoIndicadorSet();
        Indicador.addIndicadorMap(indicador);
    }

    /**
     *
     * @return
     */
    public Timestamp getTimestamp() {
        return timestamp;
    }



    /**
     *
     * @return
     */
    public String getUsernameSupervisor() {
        return usernameSupervisor;
    }

    /**
     *
     * @return
     */
    public Objetivo getObjetivo() {
        return objetivo;
    }

    /**
     *
     * @return
     */
    public Indicador getIndicador() {
        return indicador;
    }
}

