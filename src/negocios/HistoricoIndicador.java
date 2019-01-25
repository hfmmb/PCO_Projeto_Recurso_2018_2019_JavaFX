package negocios;

import java.sql.Timestamp;
import java.util.Date;

/**
 * A classe HistoricoIndicador tem
 */
public class HistoricoIndicador {
    private Timestamp timestamp;
    private String valor;

    public HistoricoIndicador(String valor){
        Date dateNow = new Date();
        this.timestamp = new Timestamp(dateNow.getTime());
        this.valor = valor;
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
    public String getValor() {
        return valor;
    }

}
