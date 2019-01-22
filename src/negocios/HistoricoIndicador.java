package negocios;

import java.sql.Timestamp;
import java.util.Date;

public class HistoricoIndicador {
    private Timestamp timestamp;
    private String value;
    public HistoricoIndicador(String value){
        Date dateNow = new Date();
        this.timestamp = new Timestamp(dateNow.getTime());
        this.value = value;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public String getValue() {
        return value;
    }

}
