package negocios;

import java.sql.Timestamp;
import java.util.Date;

public class Observacao {
    private Timestamp timestamp;
    private String observacao;
    public Observacao(String observacao){
        Date dateNow = new Date();
        this.timestamp = new Timestamp(dateNow.getTime());
        this.observacao = observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
}
