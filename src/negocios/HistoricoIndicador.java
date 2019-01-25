package negocios;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Classe HistoricoIndicador tem pares
 */
public class HistoricoIndicador {
    private Timestamp timestamp;
    private String valor;
    public HistoricoIndicador(String valor){
        Date dateNow = new Date();
        this.timestamp = new Timestamp(dateNow.getTime());
        this.valor = valor;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public String getValor() {
        return valor;
    }

}
