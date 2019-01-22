package negocios;

import java.util.Date;

public class Plano {
    private String valor;
    private Date data;
    public Plano(String valor, Date data){
        this.valor = valor;
        this.data = data;
    }

    public String getValor() {
        return valor;
    }

    public Date getData() {
        return data;
    }
}
