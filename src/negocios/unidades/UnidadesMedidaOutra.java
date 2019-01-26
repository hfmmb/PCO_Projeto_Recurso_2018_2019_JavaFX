package negocios.unidades;

import java.util.Set;

/**
 * Contem as unidades de medida criadas pelo utilizador, nao permite conversoes ao contrario das nativas.
 */
public class UnidadesMedidaOutra extends UnidadesMedida{
    private String valor;

    /**
     * Cria uma unidade de medida "exotica"
     * @param valor
     * @param unidade
     */
    public UnidadesMedidaOutra(String valor, String unidade){
        super(unidade);
        this.valor = valor;
    }

    /**
     * Retorna o valor
     * @return Retorna o valor
     */
    public String getValor() {
        return valor;
    }

    /**
     *
     * @return Retorna a lista de unidades de medida registadas
     */
    public Set<String> getUnidadesMedidaEmRegisto() {
        return UnidadesMedida.getUnidadesMedidaRegistadas();
    }
}
