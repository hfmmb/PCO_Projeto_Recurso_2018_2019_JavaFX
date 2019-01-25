package negocios.unidades;

import java.util.Set;

/**
 * Contem as unidades de medida criadas pelo utilizador, nao permite conversoes ao contrario das nativas.
 */
public class UnidadesMedidaOutra extends UnidadesMedida{
    private String valor;

    /**
     *
     * @param valor
     * @param unidade
     */
    public UnidadesMedidaOutra(String valor, String unidade){
        super(unidade);
        this.valor = valor;
    }

    /**
     *
     * @return
     */
    public String getValor() {
        return valor;
    }

    /**
     *
     * @return
     */
    public Set<String> getUnidadesMedidaEmRegisto() {
        return UnidadesMedida.getUnidadesMedidaRegistadas();
    }
}
