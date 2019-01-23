package negocios;

import java.util.Date;

public class Plano {
    private String valorMinimoDesejado;
    private String valorMaximoDesejado;
    private Date data;
    public Plano(String valorMaximoDesejado, Date data){
        this.valorMaximoDesejado = valorMaximoDesejado;
        this.data = data;
    }

    public String getValorMaximoDesejado() {
        return valorMaximoDesejado;
    }

    public Date getData() {
        return data;
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

    public void setData(Date data) {
        this.data = data;
    }

}

