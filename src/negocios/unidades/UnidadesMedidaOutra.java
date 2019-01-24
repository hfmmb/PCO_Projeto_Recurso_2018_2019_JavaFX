package negocios.unidades;

import java.util.Set;

/**
 * Contem as unidades de medida criadas pelo utilizador, nao permite conversoes ao contrario das nativas.
 */
public class UnidadesMedidaOutra extends UnidadesMedida{
    private String valor;
    public UnidadesMedidaOutra(String valor, String unidade){
        super(unidade);
        this.valor = valor;

    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Set<String> getUnidadesMedidaEmRegisto() {
        return UnidadesMedida.getUnidadesMedidaRegistadas();
    }
}
