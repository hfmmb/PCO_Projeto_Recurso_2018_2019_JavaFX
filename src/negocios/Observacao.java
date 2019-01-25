package negocios;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 */
public class Observacao {
    private Timestamp timestamp;
    private String observacao;
    private String usernameSupervisor;

    public Observacao(String observacao, String usernameSupervisor){
        Date dateNow = new Date();
        this.timestamp = new Timestamp(dateNow.getTime());
        this.observacao = observacao;
        this.usernameSupervisor = usernameSupervisor;
    }

    /**
     *
     * @return
     */
    public String getObservacao() {
        return observacao;
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
}
