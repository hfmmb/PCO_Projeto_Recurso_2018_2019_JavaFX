package negocios;

import java.util.Date;

/**
 *
 */
public class Objetivo {
    private Date dataLimite;
    private String valorMinimoDesejado;
    private String valorMaximoDesejado;

    public Objetivo(Date dataLimite, String valorMinimoDesejado, String valorMaximoDesejado){
        this. dataLimite = dataLimite;
        this.valorMinimoDesejado = valorMinimoDesejado;
        this.valorMaximoDesejado = valorMaximoDesejado;

    }
}
